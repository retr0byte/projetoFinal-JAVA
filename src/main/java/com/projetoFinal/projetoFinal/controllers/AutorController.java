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

import com.projetoFinal.projetoFinal.model.Autor;
import com.projetoFinal.projetoFinal.model.AutorService;

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
	
	@GetMapping("/painel/del/autor/{id}")
	public String delAutor( @PathVariable("id") int id ) {
		AutorService as = context.getBean(AutorService.class);
		as.delAutor(id);
		return "redirect:/painel/autores";
	}
	
}
