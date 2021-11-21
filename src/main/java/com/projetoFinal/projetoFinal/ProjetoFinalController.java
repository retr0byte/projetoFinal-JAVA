package com.projetoFinal.projetoFinal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoFinalController {
	

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
	
	@GetMapping("/livro")
	public String livro() {
		return "livro";
	}
	
	@GetMapping("/pcategorias")
	public String pcategorias() {
		return "pcategorias";
	}
	
	@GetMapping("/plivros")
	public String plivros() {
		return "plivros";
	}
	
	@GetMapping("/pcriarcataut")
	public String pcriarcataut() {
		return "pcriarcataut";
	}
	@GetMapping("/pcriarlivros")
	public String pcriarlivros() {
		return "pcriarlivros";
	}
	
}