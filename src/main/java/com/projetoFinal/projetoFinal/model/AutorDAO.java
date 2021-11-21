package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AutorDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public List<Map<String, Object>> getAutoresPainel() {
		String sql = "SELECT * FROM autor";
		List<Map<String, Object>> autores = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return autores;
	}
	
	public void delAutor(int id) {
		String sql = "DELETE FROM autor WHERE cd_autor = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
}
