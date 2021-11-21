package com.projetoFinal.projetoFinal.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void cadCategoria(Categoria cat) {
		String sql = "INSERT INTO categoria (nm_Categoria) VALUES (?)";
		
		jdbc.update(sql, new Object[] { cat.getNm_categoria() });
	}
	
}
