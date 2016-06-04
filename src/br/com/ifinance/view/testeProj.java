package br.com.ifinance.view;

import java.util.Date;

//java.io - leitura/escrita de arquivo
//

import java.util.Scanner;

public class testeProj {

	public static void main(String[] args) {

		Scanner sAutenticar = new Scanner(System.in);

		System.out.print("Login: ");
		String login = sAutenticar.nextLine();

		System.out.print("Senha: ");
		String senha = sAutenticar.nextLine();

		if (!senha.equals("123")) {
			System.out.println("Usuario Não Autenticado! ");
		} else {

			System.out.println();
			System.out.println("Lista de Opcoes");
			System.out.println("================");
			System.out.println("1 - Receita");
			System.out.println("2 - Despesa");
			System.out.println("================");

			Scanner s = new Scanner(System.in);
			System.out.print("Opcao: ");
			int opcao = s.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("opcao 1 digitada!");
				break;
			case 2:
				System.out.println("opcao 2 digitada!");
				break;
			default:
				break;
			}
			s.close();
		}
		
		System.out.println("fim.");
	}

}
