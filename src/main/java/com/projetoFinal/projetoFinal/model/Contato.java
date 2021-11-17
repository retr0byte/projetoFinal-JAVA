package com.projetoFinal.projetoFinal.model;

public class Contato {
	private int cd_contato;
	private String nm_cliente, ds_emailcliente, cd_telefonecliente, ds_mensagem;
	
	public Contato() {
		
	}

	public Contato(int cd_contato, String nm_cliente, String ds_emailcliente, String cd_telefonecliente,
			String ds_mensagem) {
		super();
		this.cd_contato = cd_contato;
		this.nm_cliente = nm_cliente;
		this.ds_emailcliente = ds_emailcliente;
		this.cd_telefonecliente = cd_telefonecliente;
		this.ds_mensagem = ds_mensagem;
	}

	public int getCd_contato() {
		return cd_contato;
	}

	public void setCd_contato(int cd_contato) {
		this.cd_contato = cd_contato;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getDs_emailcliente() {
		return ds_emailcliente;
	}

	public void setDs_emailcliente(String ds_emailcliente) {
		this.ds_emailcliente = ds_emailcliente;
	}

	public String getCd_telefonecliente() {
		return cd_telefonecliente;
	}

	public void setCd_telefonecliente(String cd_telefonecliente) {
		this.cd_telefonecliente = cd_telefonecliente;
	}

	public String getDs_mensagem() {
		return ds_mensagem;
	}

	public void setDs_mensagem(String ds_mensagem) {
		this.ds_mensagem = ds_mensagem;
	}
	
}
