package com.projetoFinal.projetoFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.projetoFinal.projetoFinal.model.Categoria;
import com.projetoFinal.projetoFinal.model.CategoriaService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class CategoriaController {
	
	@Autowired
	private ApplicationContext context;

}
