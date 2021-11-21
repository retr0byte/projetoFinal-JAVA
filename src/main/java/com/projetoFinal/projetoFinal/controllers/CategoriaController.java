package com.projetoFinal.projetoFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetoFinal.projetoFinal.model.Categoria;
import com.projetoFinal.projetoFinal.model.CategoriaService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class CategoriaController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/painel/categoria")
	public String formCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "pcriarcategoria";
	}
	
	@PostMapping("/painel/categoria")
	public String cadCategoria(
			@ModelAttribute Categoria cat,
			Model model
			) {
		
		CategoriaService cats = context.getBean(CategoriaService.class);
		cats.cadCategoria(cat);
		return "redirect:/painel/categorias";
	}
	
}
