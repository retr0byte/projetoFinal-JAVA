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
	
	public List<Map<String, Object>> getAllLivros(){
		String sql = "SELECT l.cd_livro, l.nm_livro, c.nm_categoria, a.nm_autor "
				+ "FROM livro l, categoria c, autor a "
				+ "WHERE l.cd_categoria = c.cd_categoria AND "
				+ "l.cd_autor = a.cd_autor "
				+ "order by l.cd_livro desc";
		
		List<Map<String, Object>> livros = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return livros;
		
	}
	
		public Map<String, Object> getLivroInfo(int id) { 
			
		String sql = "SELECT l.cd_livro, l.nm_livro, l.ds_livro, c.nm_categoria, a.nm_autor "
				+ "FROM livro l, categoria c, autor a "
				+ "WHERE l.cd_categoria = c.cd_categoria AND "
				+ "l.cd_autor = a.cd_autor AND l.cd_livro = ?";
		
		Object[] obj = new Object[1];
		obj[0] = id;
		
		return jdbc.queryForMap(sql,obj);
	}
	
	public void inserirLivro(Livro livro) {
		String sql = "insert into livro(nm_livro,ds_livro,cd_autor,cd_categoria) "+
					 "VALUES (?,?,?,?)";
		
		Object[] obj = new Object[4];
		obj[0] = livro.getNm_livro();
		obj[1] = livro.getDs_livro();
		obj[2] = livro.getCd_autor();
		obj[3] = livro.getCd_categoria();
		jdbc.update(sql, obj);

	}
	
	public List<Map<String, Object>> getLivrosPainel(){
		String sql = "SELECT l.cd_livro, l.nm_livro, c.nm_categoria, a.nm_autor "
				+ "FROM livro l, categoria c, autor a "
				+ "WHERE l.cd_categoria = c.cd_categoria AND "
				+ "l.cd_autor = a.cd_autor "
				+ "order by l.cd_livro asc";
		
		List<Map<String, Object>> livros = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return livros;
		
	}
	
	/*excluirlivro*/
	public void deleteLivro(int id) {
		String sql = "DELETE FROM livro Where cd_livro = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
	
}
