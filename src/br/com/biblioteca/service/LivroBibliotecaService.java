package br.com.biblioteca.service;

import java.util.ArrayList;

import br.com.biblioteca.model.LivroBiblioteca;

public class LivroBibliotecaService {
	
	private static ArrayList<LivroBiblioteca> listaLivros = new ArrayList<>();
	
	public ArrayList<LivroBiblioteca> getListaLivros(){
		return listaLivros;
	}
	
	public void adicionarLivro(LivroBiblioteca livro) {
		listaLivros.add(livro);
	}
	
	public String listarLivro() {
		String saida ="";
		int i = 1;
		for(LivroBiblioteca livros : listaLivros) {
			saida += "\n ------- Livro nº " +(i++) +" --------\n";
			saida += livros.livroInfo() +"\n";
		}
		return saida;
	}
	
	public int pesquisarPorGenero(String genero) {
		int qtd = 0;
		for(LivroBiblioteca livros: listaLivros) {
			if(livros.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		
		return qtd;
	}
	
	public int pesquisaPorPreco(double vInicial, double vFinal) {
		int qtd = 0;
		for(LivroBiblioteca livros : listaLivros) {
			if(livros.getPreco() >= vInicial && livros.getPreco() <= vFinal) {
				qtd++;
			}
		}
			
		return qtd;
	}
	
	public boolean removerLivro(String titulo) {
		for(LivroBiblioteca livros : listaLivros) {
			if(livros.getTitulo().equalsIgnoreCase(titulo)){
					listaLivros.remove(livros);
					return true;
				}
			}
		return false;
	}
	
	public double precoTotalLivro() {
		double total = 0;
		
		for(LivroBiblioteca livros : listaLivros) {
			total += livros.getPreco();
		}
		
		return total;
	}
}
