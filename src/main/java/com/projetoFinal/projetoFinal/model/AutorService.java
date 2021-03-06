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
	
	public List<Map<String, Object>> listarAutoresMenu(){
		return adao.listarAutoresMenu();
	}
	
	public void delAutor(int id) {
		adao.delAutor(id);
	}
	
	/*criaautor*/
	public void cadAutor(Autor aut) {
		adao.cadAutor(aut);
	}
	
	public void atualizarAutor(int id, Autor aut) {
		adao.atualizarAutor(id, aut);
	}
	
	public Map<String, Object> getAutor(int id){
		return adao.getAutor(id);
	}
	
}
