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

import com.projetoFinal.projetoFinal.model.Autor;
import com.projetoFinal.projetoFinal.model.AutorService;
import com.projetoFinal.projetoFinal.model.Categoria;
import com.projetoFinal.projetoFinal.model.CategoriaService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class AutorController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/painel/autores")
	public String getAutoresPainel (Model model) {
		AutorService as = context.getBean(AutorService.class);
		List<Map<String, Object>> autores = as.getAutoresPainel();
		model.addAttribute("autores", autores);
		return "pautores.html";
	}
	
	@PostMapping("/painel/del/autor/{id}")
	public String delAutor( @PathVariable("id") int id ) {
		AutorService as = context.getBean(AutorService.class);
		as.delAutor(id);
		return "redirect:/painel/autores";
	}
	
	
	@GetMapping("/painel/autor")
	public String formAutor(Model model) {
		model.addAttribute("autor", new Autor());
		return "pcriarautor";
	}
	
	@PostMapping("/painel/autor")
	public String cadAutor(
			@ModelAttribute Autor aut,
			Model model
			) {
		
		AutorService auts = context.getBean(AutorService.class);
		auts.cadAutor(aut);
		return "redirect:/painel/autores";
	}
	
	@GetMapping("/painel/upd/autor/{id}")
	public String formAtualizarAutor(@PathVariable("id") int id, Model model) {
		AutorService auts = context.getBean(AutorService.class);
		Map<String, Object> at = auts.getAutor(id);
		Autor autores = new Autor(id,at.get("nm_Autor").toString());
		model.addAttribute("autor", autores);
		model.addAttribute("id", id);
		return "pupdateautor";
	}
	
	@PostMapping("/painel/upd/autor/{id}")
	public String atualizarAutor(@PathVariable("id") int id, Model model, @ModelAttribute Autor auts) {
		AutorService aut = context.getBean(AutorService.class);
		aut.atualizarAutor(id, auts);
		return "redirect:/painel/autores";
	}
}
