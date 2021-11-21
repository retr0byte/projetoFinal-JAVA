package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaDAO catdao;
	
	public void cadCategoria(Categoria cat) {
		catdao.cadCategoria(cat);
	}
	
	public List<Map<String, Object>> getCategoriasPainel(){
		return catdao.getCategoriasPainel();
	}
	
	public void deleteCategoria(int id) {
		catdao.deleteCategoria(id);
	}
}
