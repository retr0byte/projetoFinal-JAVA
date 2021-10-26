package com.projetoFinal.projetoFinal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoFinalController {
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/catPHP")
	public String pagCatPHP() {
		return "catPHP";
	}
	
	@GetMapping("/catJS")
	public String pagCatJS() {
		return "catJS";
	}
	
	@GetMapping("/catHTML")
	public String pagCatHTML() {
		return "catHTML";
	}
	
	@GetMapping("/catCSS")
	public String pagCatCSS() {
		return "catCSS";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/quemSomos")
	public String quemSomos() {
		return "quemSomos";
	}
	
	@GetMapping("/melhoresTemas")
	public String melhoresTemas() {
		return "melhoresTemas";
	}
	
	@GetMapping("/painel")
	public String painel() {
		return "painel";
	}
	
}