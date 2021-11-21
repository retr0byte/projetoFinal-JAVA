package com.projetoFinal.projetoFinal.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void cadClienteInfo(Contato cont) {
		String sql = "INSERT INTO contato (nm_cliente, ds_emailcliente, cd_telefonecliente, ds_mensagem) VALUES (?,?,?,?)";

		Object[] obj = new Object[4];
		obj[0] = cont.getNm_cliente();
		obj[1] = cont.getDs_emailcliente();
		obj[2] = cont.getCd_telefonecliente();
		obj[3] = cont.getDs_mensagem();
		
		jdbc.update(sql, obj);
	}
	
}
