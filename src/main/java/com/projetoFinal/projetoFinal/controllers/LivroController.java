package com.projetoFinal.projetoFinal.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
