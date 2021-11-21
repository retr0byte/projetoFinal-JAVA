package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

	@Autowired
	AutorDAO adao;
	
	public List<Map<String, Object>> getAutoresPainel(){
		return adao.getAutoresPainel();
	}
	
	public void delAutor(int id) {
		adao.delAutor(id);
	}
	
}
