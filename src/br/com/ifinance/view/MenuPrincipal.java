package br.com.ifinance.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ifinance.beans.Receita;
import br.com.ifinance.dao.ReceitaDAO;

public class MenuPrincipal {

	private int opcao;
	Scanner entrada;
	Receita r = new Receita();
	ReceitaDAO receitaDAO;
	String resposta = "";
	List<Receita> receitas;

	public MenuPrincipal() throws ClassNotFoundException, IOException {
		entrada = new Scanner(System.in);
		r = new Receita();
		receitaDAO = new ReceitaDAO();
	}

	public void Tela() throws ClassNotFoundException, IOException {
		do {
			System.out.println("+----------------------------------+");
			System.out.println("|      Bem vindo ao iFinance       |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Modulo Pessoa Fisica         |");
			System.out.println("| 2 - Modulo Pessoa Juridica       |");
			System.out.println("| 3 - Modulo Receita               |");
			System.out.println("| 4 - Modulo Despesa               |");
			System.out.println("| 5 - Sair                         |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
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
		do {
			System.out.println("+----------------------------------+");
			System.out.println("|          Modulo Receita          |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Cadastrar nova receita       |");
			System.out.println("| 2 - Exibir receitas              |");
			System.out.println("| 3 - Alterar uma receita          |");
			System.out.println("| 4 - Excluir uma receita          |");
			System.out.println("| 5 - Realizar baixa               |");
			System.out.println("| 6 - Voltar                       |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				entrada.nextLine();
				System.out.println("Qual o nome da receita?");
				r.setDescricao(entrada.nextLine());
				System.out.println("Qual data de vencimento (dd/mm/aaaa)?");
				r.setDataVencimento(entrada.nextLine());
				System.out.println("Qual o valor nominal?");
				r.setValorNominal(entrada.nextDouble());
				receitaDAO.addReceita(r);
				break;
			case 2:
				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.err.println("Nao existem receitas cadastradas!");
				} else {
					System.out.println("Id\t" + "Descricao\t" + "Vencimento\t"
							+ "Valor\t\t" + "Status\t" + "Valor recebido\t"
							+ "Data recebimento");
					for (Receita receita : receitas) {
						System.out.println(receita.toStringFormatada());
					}
				}
				break;
			case 3:
/*				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!\n");
				} else {
					System.out.println("Id\t" + "Descricao\t" + "Vencimento\t"
							+ "Valor\t\t" + "Status\t" + "Valor recebido\t"
							+ "Data recebimento");
					for (Receita receita : receitas) {
						System.out.println(receita.toStringFormatada());
					}
				}
*/				System.out.println("Qual o nome da receita para alterar?");
				String nome = entrada.next();
				r = receitaDAO.procurar(nome);
				if (r != null) {
					System.out.println("Descricao atual <" + r.getDescricao()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual a nova descricao?");
						r.setDescricao(entrada.next());
					}
					System.out.println("Vencimento atual <"
							+ r.getDataVencimento()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual o novo vencimento?");
						r.setDataVencimento(entrada.next());
					}
					System.out.println("Valor atual <" + r.getValorNominal()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual o novo vencimento?");
						r.setDataVencimento(entrada.next());
					}
					try {
						receitaDAO.alterarReceita(r);						
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					System.out
							.println("Receita não encontrada, tente novamente!");
				}
				break;
			case 4:
				if (receitaDAO.listarReceitas().isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!\n");
				} else {
					System.out.println("Id\t" + "Descricao\t" + "Vencimento\t"
							+ "Valor\t\t" + "Status\t" + "Valor recebido\t"
							+ "Data recebimento");
					for (Receita receita : receitas) {
						System.out.println(receita.toStringFormatada());
					}
				}
				System.out.println("Qual o id da receita a excluir?");
				int id = entrada.nextInt();
				r = receitaDAO.procurar(id);
				if (r != null) {
					try {
						receitaDAO.excluirReceita(r);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					System.out
							.println("Receita nao encontrada, tente novamente!");
				}
				break;
			case 5:

				break;
			case 6:
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
		entrada.close();
	}

	public void moduloDespesa() throws ClassNotFoundException, IOException {
		do {
			System.out.println("+----------------------------------+");
			System.out.println("|          Modulo Despesa          |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Cadastrar nova despesa       |");
			System.out.println("| 2 - Exibir despesas              |");
			System.out.println("| 3 - Alterar uma despesa          |");
			System.out.println("| 4 - Excluir uma despesa          |");
			System.out.println("| 5 - Realizar baixa               |");
			System.out.println("| 6 - Voltar                       |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				System.out.println("Qual o nome da despesa?");
				r.setDescricao(entrada.next());
				System.out.println("Qual data de vencimento (dd/mm/aaaa)?");
				r.setDataVencimento(entrada.next());
				System.out.println("Qual o valor nominal?");
				r.setValorNominal(entrada.nextDouble());
				receitaDAO.addReceita(r);
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
		entrada.close();
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