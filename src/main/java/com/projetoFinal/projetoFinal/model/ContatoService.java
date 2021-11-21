package com.projetoFinal.projetoFinal.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

	@Autowired
	ContatoDAO contdao;
	
	public void cadClienteInfo(Contato cont) {
		contdao.cadClienteInfo(cont);
	}
	
}
