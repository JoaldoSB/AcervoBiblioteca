package br.com.biblioteca.model;

public class LivroBiblioteca {
	
	private String titulo;
	private String autor;
	private int isbn;
	private String genero;
	private float preco;
	
	
	public LivroBiblioteca() {
		//construtor defalt (sem nenhum parametro)		
	}
	
	public LivroBiblioteca(String titulo, String autor, int isbn, String genero, float preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.genero = genero;
		this.preco = preco;
	}
	
	
	public String getTitulo() {
	return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String livroInfo() {
		return  "Titulo: " +titulo 
				+"\n Autor: " +autor
				+"\n Isbn: "  +isbn
				+"\n Genero: "+genero
				+String.format("\n Preço R$ %.2f ", preco);
	}
	
}
