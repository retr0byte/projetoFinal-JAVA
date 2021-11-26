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
	
	public Map<String,Object> getLivroInfo(int id){
		return ldao.getLivroInfo(id);
	}
	
	public void inserirLivro(Livro l) {
		ldao.inserirLivro(l);
	}
	
	public List<Map<String, Object>> getLivrosPainel(){
		return ldao.getLivrosPainel();
	}
	
	/*deletelivro*/
	public void deleteLivro(int id) {
		ldao.deleteLivro(id);
	}
	
	public List<Map<String, Object>> buscarLivro(Livro liv){
		return ldao.buscarLivro(liv);
	}
	
	public void atualizarLivro(int id, Livro livro) {
		ldao.atualizarLivro(id, livro);
	}
	
	public Map<String, Object> getLivro(int id){
		return ldao.getLivro(id);
	}
}
