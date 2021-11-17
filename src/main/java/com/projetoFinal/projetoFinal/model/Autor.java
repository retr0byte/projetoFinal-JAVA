package com.projetoFinal.projetoFinal.model;

public class Autor {
	private int cd_autor;
	private String nm_autor;
	
	public Autor() {
		
	}

	public Autor(int cd_autor, String nm_autor) {
		this.cd_autor = cd_autor;
		this.nm_autor = nm_autor;
	}

	public int getCd_autor() {
		return cd_autor;
	}

	public void setCd_autor(int cd_autor) {
		this.cd_autor = cd_autor;
	}

	public String getNm_autor() {
		return nm_autor;
	}

	public void setNm_autor(String nm_autor) {
		this.nm_autor = nm_autor;
	}
	
}
