package com.projetoFinal.projetoFinal.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	CategoriaDAO catdao;
	
	public void cadCategoria(Categoria cat) {
		catdao.cadCategoria(cat);
	}
}
