package br.com.ifinance.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.ifinance.dao.ReceitaDAO;

public class MenuPrincipal {

	private Scanner entrada = new Scanner(System.in);
	private int opcao;

	public MenuPrincipal() {

	}

	public void Tela() throws ClassNotFoundException, IOException {

		do {
			System.out.println("+----------------------------------+");
			System.out.println("|      Bem vindo ao iFinance       |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Módulo Pessoa Física         |");
			System.out.println("| 2 - Módulo Pessoa Jurídica       |");
			System.out.println("| 3 - Módulo Receita               |");
			System.out.println("| 4 - Módulo Despesa               |");
			System.out.println("| 5 - Sair                         |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opção escolhida:");
			opcao = lerInteiro();
			switch (opcao) {
			case 1:
				moduloPessoaFisica();
				break;
			case 2:
				moduloPessoaJuridica();
				break;
			case 3:
				moduloReceita();
				break;
			case 4:
				moduloDespesa();
				break;
			case 5:
				System.out.println("iFinance encerrado, obrigado!");
				break;
			default:
				System.err.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
	}

	public void moduloPessoaFisica() {

	}

	public void moduloPessoaJuridica() {

	}

	public void moduloReceita() throws ClassNotFoundException, IOException {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		do {
			System.out.println("+----------------------------------+");
			System.out.println("|          Módulo Receita          |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Cadastrar nova receita       |");
			System.out.println("| 2 - Exibir receitas              |");
			System.out.println("| 3 - Alterar uma receita          |");
			System.out.println("| 4 - Excluir uma receita          |");
			System.out.println("| 5 - Voltar                       |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opção escolhida:");
			opcao = lerInteiro();
			switch (opcao) {
			case 1:
				receitaDAO.addReceita();
				break;
			case 2:
				receitaDAO.lerReceitas();
				break;
			case 3:
				receitaDAO.alteraReceita();
				break;
			case 4:
				receitaDAO.exluiDespesa();
				break;
			case 5:
				Tela();
				break;
			default:
				System.err.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
	}

	public void moduloDespesa() {

	}

	public int lerInteiro() {
		int valor;
		try {
			valor = entrada.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.println(entrada.nextLine() + " nao eh uma opcao valida.");
			System.out.println("Digite um numero valido:");
			valor = lerInteiro();
		}
		return valor;
	}

}
