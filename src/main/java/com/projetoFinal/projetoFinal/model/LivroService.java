package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroDAO ldao;
	
	public List<Map<String, Object>> getLivros(String tipoListagem, int id){
		return ldao.getLivros(tipoListagem,id);
	}
	
	public List<Map<String, Object>> getAllLivros(){
		return ldao.getAllLivros();
	}
}
