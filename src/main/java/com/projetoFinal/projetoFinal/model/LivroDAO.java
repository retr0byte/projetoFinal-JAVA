package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LivroDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public List<Map<String, Object>> getLivros(String tipoListagem, int id){	
		Object[] obj = new Object[] {id}; 
		
		String sqlComplementar = "";
		
		if(tipoListagem.equals("categorias")) {
			sqlComplementar = " AND l.cd_categoria = ?";
		}else if(tipoListagem.equals("autores")) {
			sqlComplementar = " AND l.cd_autor = ?";
		}
		
		String sql = "SELECT l.cd_livro, l.nm_livro, c.nm_categoria, a.nm_autor "
				+ "FROM livro l, categoria c, autor a "
				+ "WHERE l.cd_categoria = c.cd_categoria AND "
				+ "l.cd_autor = a.cd_autor"+sqlComplementar;
		
		
		List<Map<String, Object>> livros = (List<Map<String, Object>>) jdbc.queryForList(sql, obj);
		return livros;
	}
	
}
