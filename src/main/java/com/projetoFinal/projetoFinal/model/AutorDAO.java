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
	
	public List<Map<String, Object>> listarAutoresMenu() {
		String sql = "SELECT * FROM autor ORDER BY nm_autor";
		List<Map<String, Object>> listaAutores = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return listaAutores;
	}
	
	public void delAutor(int id) {
		String sql = "DELETE FROM autor WHERE cd_autor = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
	/*criaautor*/
	
	public void cadAutor(Autor aut) {
		String sql = "INSERT INTO autor (nm_autor) VALUES (?)";
		
		jdbc.update(sql, new Object[] { aut.getNm_autor() });
	}
	
	public Map<String, Object> getAutor(int id){
		String sql = "SELECT * FROM autor where autor.cd_Autor = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);
	}
	
	public void atualizarAutor(int id, Autor autor) {
		String sql = "UPDATE autor SET nm_Autor = ? WHERE cd_Autor = ?";
		Object[] obj =  new Object[2];
		obj[0] = autor.getNm_autor();
		obj[1] = id;
		jdbc.update(sql, obj);
	}
	
}
