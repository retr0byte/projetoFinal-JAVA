package com.projetoFinal.projetoFinal.model;

public class Categoria {
	private int cd_categoria;
	private String nm_categoria;
	
	public Categoria() {
		
	}

	public Categoria(int cd_categoria, String nm_categoria) {
		this.cd_categoria = cd_categoria;
		this.nm_categoria = nm_categoria;
	}

	public int getCd_categoria() {
		return cd_categoria;
	}

	public void setCd_categoria(int cd_categoria) {
		this.cd_categoria = cd_categoria;
	}

	public String getNm_categoria() {
		return nm_categoria;
	}

	public void setNm_categoria(String nm_categoria) {
		this.nm_categoria = nm_categoria;
	}
	
	
}
