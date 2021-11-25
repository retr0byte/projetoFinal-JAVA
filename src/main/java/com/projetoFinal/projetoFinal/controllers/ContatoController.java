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
import org.springframework.web.bind.annotation.PostMapping;

import com.projetoFinal.projetoFinal.model.AutorService;
import com.projetoFinal.projetoFinal.model.Categoria;
import com.projetoFinal.projetoFinal.model.CategoriaService;
import com.projetoFinal.projetoFinal.model.Contato;
import com.projetoFinal.projetoFinal.model.ContatoService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")

public class ContatoController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/contato")
	public String formCategoria(Model model) {
		CategoriaService cs = context.getBean(CategoriaService.class);
		AutorService as = context.getBean(AutorService.class);
		List<Map<String, Object>> listaCategorias = cs.listarCategoriasMenu();
		List<Map<String, Object>> listaAutores = as.listarAutoresMenu();
		
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("listaAutores", listaAutores);
		model.addAttribute("contato", new Contato());
		return "contato";
	}
	
	@PostMapping("/contato")
	public String cadCategoria(
			@ModelAttribute Contato cont,
			Model model
			) {
		
		ContatoService conts = context.getBean(ContatoService.class);
		conts.cadClienteInfo(cont);
		return "redirect:/contato?s=true";
	}

}
