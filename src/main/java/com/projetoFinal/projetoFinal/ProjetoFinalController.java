package com.projetoFinal.projetoFinal;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projetoFinal.projetoFinal.model.AutorService;
import com.projetoFinal.projetoFinal.model.CategoriaService;

@Controller
public class ProjetoFinalController {
	
	@Autowired
	private ApplicationContext context;
		
	@GetMapping("/quemSomos")
	public String quemSomos(Model model) {
		CategoriaService cs = context.getBean(CategoriaService.class);
		AutorService as = context.getBean(AutorService.class);
		List<Map<String, Object>> listaCategorias = cs.listarCategoriasMenu();
		List<Map<String, Object>> listaAutores = as.listarAutoresMenu();
		
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("listaAutores", listaAutores);
		return "quemSomos";
	}
		
	@GetMapping("/painel")
	public String painel() {
		return "painel";
	}
	

}