package com.projetoFinal.projetoFinal.model;

import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> getCategoriasPainel(){
		String sql = "SELECT * from categoria "	
					 + "order by cd_categoria asc";
		
		List<Map<String, Object>> categorias = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return categorias;
		
	}
	
	public void deleteCategoria(int id) {
		String sql = "DELETE FROM categoria Where cd_Categoria = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
	
	
	public List<Map<String, Object>> listarCategoriasMenu(){
		String sql = "SELECT * from categoria "	
					 + "order by nm_categoria";
		
		List<Map<String, Object>> listaCategorias = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return listaCategorias;
		
	}
	
}
