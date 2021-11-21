package com.projetoFinal.projetoFinal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoFinalController {
		
	@GetMapping("/quemSomos")
	public String quemSomos() {
		return "quemSomos";
	}
		
	@GetMapping("/painel")
	public String painel() {
		return "painel";
	}
	
}