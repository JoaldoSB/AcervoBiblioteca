package br.com.biblioteca;

import java.util.Scanner;

import br.com.biblioteca.model.LivroBiblioteca;
import br.com.biblioteca.service.LivroBibliotecaService;

public class Application {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Scanner entradaString = new Scanner(System.in);
		LivroBibliotecaService livroBibliotecaService = new LivroBibliotecaService();
				
		int menu;
		double vInicial, vFinal;
		LivroBiblioteca objLivro;		
		String titulo, autor, genero;
		int isbn;
		float preco;
		
		do {
			exibirMenu();
			menu = entrada.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("MODULO CADASTRAR:");
				System.out.println("Digite o t�tulo:");
				titulo = entradaString.nextLine();
				System.out.println("Digite o autor:");
				autor = entradaString.nextLine();
				System.out.println("Digite o genero:");
				genero = entradaString.nextLine();
				System.out.println("Digite o  ISBN");
				isbn = entrada.nextInt();
				System.out.println("Digite o pre�o");
				preco = entrada.nextFloat();
				objLivro = new LivroBiblioteca(titulo, autor, isbn, genero, preco);
				livroBibliotecaService.adicionarLivro(objLivro);
				System.out.println("Livro cadastrado com sucesso!\n");
				break;
			
			case 2:
				System.out.println("MODULO LISTAR TODOS OS LIVROS:");
				if(!livroBibliotecaService.listarLivro().isEmpty()) {
					System.out.println(livroBibliotecaService.listarLivro());
				} else {
					System.out.println("O sistema n�o possui livros cadastrados!\n");
				}
				break;
				
			case 3:
				System.out.println("MODULO DE REMOVER");
				System.out.println("Digite o t�tulo:");
				titulo = entradaString.nextLine();
				if(!livroBibliotecaService.listarLivro().isEmpty()) {
					if(livroBibliotecaService.removerLivro(titulo)){
						System.out.println("Livro removido com sucesso!\n");
					} else {
						System.out.println("Titulo n�o encontrado!\n");
					}
				} else
					System.out.println("O sistema n�o possui livros cadastrados!\n");
				
				break;
				
			case 4:
				System.out.println("MODULO DE PESQUISA POR GENERO");
				System.out.println("Digite o genero:");
				genero = entradaString.nextLine();
				System.out.println("Existe(m) " 
						+livroBibliotecaService.pesquisarPorGenero(genero)
						+ " livro(s) com o g�reno "
						+ genero +"\n");

				break;
				
			case 5:
				System.out.println("MODULO DE PESQUISA POR PRE�O");
				System.out.println("Informe o pre�o inicial:");
				vInicial = entrada.nextDouble();
				System.out.println("Informe o pre�o final:");
				vFinal = entrada.nextDouble();
				System.out.println("Foram identificados "
						+livroBibliotecaService.pesquisaPorPreco(vInicial, vFinal)
						+" Livros na faixa de pre�o informado \n");
				break;
				
			case 6:
				System.out.println("MODULO DE BALAN�O FINANCEIRO");
				System.out.println("O valor total do acervo �: "
						+String.format("R$ %.2f", livroBibliotecaService.precoTotalLivro()) +"\n");
				
				break;
			case 7:
				System.out.println("Saindo...at� logo!");
				break;
			default:
				System.out.println("Op��o de menu invalida!");
			}
			
		} while(menu!=7);

	}
	
	static void exibirMenu() {
		System.out.println("====> SISTEMA DE BIBLIOTECA MY HOUSE <====");
		System.out.println("1 - CADASTRAR LIVRO");
		System.out.println("2 - LISTAR TODOS OS LIVROS");
		System.out.println("3 - EXCLUIR LIVRO");
		System.out.println("4 - PESQUISAR POR GENERO");
		System.out.println("5 - PESQUISAR POR PRE�O");
		System.out.println("6 - BALAN�O FINANCEIRO DO ACERVO");
		System.out.println("7 - SAIR");
		System.out.println("====> Informe a op��o desejada:");
	}

}
