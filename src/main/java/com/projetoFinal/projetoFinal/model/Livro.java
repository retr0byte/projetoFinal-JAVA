package com.projetoFinal.projetoFinal.model;

public class Livro {
	private int cd_livro, cd_autor, cd_categoria;
	private String nm_livro, ds_livro;
	
	public Livro() {
		
	}

	public Livro(int cd_livro, int cd_autor, int cd_categoria, String nm_livro, String ds_livro) {
		this.cd_livro = cd_livro;
		this.cd_autor = cd_autor;
		this.cd_categoria = cd_categoria;
		this.nm_livro = nm_livro;
		this.ds_livro = ds_livro;
	}

	public int getCd_livro() {
		return cd_livro;
	}

	public void setCd_livro(int cd_livro) {
		this.cd_livro = cd_livro;
	}

	public int getCd_autor() {
		return cd_autor;
	}

	public void setCd_autor(int cd_autor) {
		this.cd_autor = cd_autor;
	}

	public int getCd_categoria() {
		return cd_categoria;
	}

	public void setCd_categoria(int cd_categoria) {
		this.cd_categoria = cd_categoria;
	}

	public String getNm_livro() {
		return nm_livro;
	}

	public void setNm_livro(String nm_livro) {
		this.nm_livro = nm_livro;
	}

	public String getDs_livro() {
		return ds_livro;
	}

	public void setDs_livro(String ds_livro) {
		this.ds_livro = ds_livro;
	}
	
	
	
	
}
