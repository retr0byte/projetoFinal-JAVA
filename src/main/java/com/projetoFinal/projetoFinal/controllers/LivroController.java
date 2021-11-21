package com.projetoFinal.projetoFinal.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetoFinal.projetoFinal.model.CategoriaService;
import com.projetoFinal.projetoFinal.model.Livro;
import com.projetoFinal.projetoFinal.model.LivroService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class LivroController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/livros/{tipoListagem}/{id}")
	public String listarLivros(
			@PathVariable("tipoListagem") String tipoListagem,
			@PathVariable("id") int id,
			Model model
			) {
		LivroService ls = context.getBean(LivroService.class);
		List<Map<String, Object>> livros = ls.getLivros(tipoListagem, id);
		
		tipoListagem = (tipoListagem != "livro") ? " por: "+tipoListagem : ":";
		
		model.addAttribute("tipoListagem", tipoListagem);
		model.addAttribute("livros",livros);
		return "livros";
	}
	

	@GetMapping("/")
	public String listarTodosLivros(Model model){
		LivroService ls = context.getBean(LivroService.class);
		List<Map<String, Object>> livros = ls.getAllLivros();
		model.addAttribute("livros",livros);
		return "index";
			
	}
	
	@GetMapping("/livro/{id}")
	public String getUnicoLivro(@PathVariable("id") int id,
								Model model){
		LivroService ls = context.getBean(LivroService.class);
		Map<String,Object> mapa = ls.getLivroInfo(id);
		model.addAttribute("nm_livro",mapa.get("nm_livro"));
		model.addAttribute("ds_livro",mapa.get("ds_livro"));
		model.addAttribute("cd_autor",mapa.get("cd_autor"));
		return "livro";
			
	}
	
	@GetMapping("/painel/livro")
	public String formLivro(Model model) {
		model.addAttribute("pcriarlivros",new Livro());
		return "pcriarlivros";
	}
	
	@PostMapping("/painel/livro")
	public String postLivro(@ModelAttribute Livro li,
							Model model) {
		LivroService ls = context.getBean(LivroService.class);
		ls.inserirLivro(li);
		return "redirect:/painel/livros";
	}
	
	/*listar livros no painel*/
	@GetMapping("/painel/livros")
	public String listarLivrosPainel(Model model){
		LivroService ls = context.getBean(LivroService.class);
		List<Map<String, Object>> livros = ls.getLivrosPainel();
		model.addAttribute("livros",livros);
		return "plivros";
			
	}
	
	/*delete Livro*/
	@PostMapping("/painel/del/livro/{id}")
	public String apagarLivro(@PathVariable("id") int id) {
		LivroService ls = context.getBean(LivroService.class);
		ls.deleteLivro(id);
		return "redirect:/painel/livros";
	}
	
}
