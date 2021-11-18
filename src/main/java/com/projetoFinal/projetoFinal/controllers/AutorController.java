package com.projetoFinal.projetoFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.projetoFinal.projetoFinal.model.Autor;
import com.projetoFinal.projetoFinal.model.AutorService;

@Controller
@ComponentScan("com.projetoFinal.projetoFinal.model")
public class AutorController {

	@Autowired
	private ApplicationContext context;
	
}
