package br.com.ifinance.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.PessoaJuridica;
import br.com.ifinance.beans.Receita;
import br.com.ifinance.dao.DespesaDAO;
import br.com.ifinance.dao.PessoaFisicaDAO;
import br.com.ifinance.dao.PessoaJuridicaDAO;
import br.com.ifinance.dao.ReceitaDAO;

public class MenuPrincipal {

	private int opcao;
	Scanner entrada;
	Receita r;
	PessoaFisica pf;
	PessoaJuridica pj;
	int id = -1;

	ReceitaDAO receitaDAO;
	DespesaDAO despesaDAO;
	PessoaFisicaDAO pessoaFisicaDAO;
	PessoaJuridicaDAO pessoaJuridicaDAO;

	String resposta = "";
	List<Receita> receitas;
	List<PessoaFisica> pFisicas;
	List<PessoaJuridica> pJuridicas;

	public MenuPrincipal() throws ClassNotFoundException, IOException {
		entrada = new Scanner(System.in);
		r = new Receita();
		receitaDAO = new ReceitaDAO();
		despesaDAO = new DespesaDAO();
		pessoaFisicaDAO = new PessoaFisicaDAO();
		pessoaJuridicaDAO = new PessoaJuridicaDAO();
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

	public void moduloPessoaFisica() throws ClassNotFoundException, IOException {

		do {
			System.out.println("+----------------------------------+");
			System.out.println("|          Modulo PessoaFisica     |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Cadastrar nova pessoa fisica |");
			System.out.println("| 2 - Exibir pessoas fisicas       |");
			System.out.println("| 3 - Alterar uma pessoa fisica    |");
			System.out.println("| 4 - Excluir uma pessoa fisica    |");
			System.out.println("| 6 - Voltar                       |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				entrada.nextLine();

				System.out.println("Qual o CPF da pessoa?");
				PessoaFisica p = new PessoaFisica(entrada.nextLine());

				System.out.println("Qual o nome da pessoa?");
				p.setNome(entrada.nextLine());

				System.out.println("Qual o endereco da pessoa?");
				p.setEndereco(entrada.nextLine());

				System.out.println("Qual o bairro da pessoa?");
				p.setBairro(entrada.nextLine());

				System.out.println("Qual o CEP da pessoa?");
				p.setCep(entrada.nextLine());

				System.out.println("Qual o cidade da pessoa?");
				p.setCidade(entrada.nextLine());

				r.setCliente(p);
				pessoaFisicaDAO.addPessoaFisica(p);
				break;
			case 2:
				pFisicas = pessoaFisicaDAO.listarPessoaFisicas();
				if (pFisicas.isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!");
				} else {
					System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
					for (PessoaFisica pessoa : pFisicas) {
						System.out.println(pessoa.toString());
					}
				}
				break;
			case 3:
				System.out.println("Qual o id da pessoa para alterar?");
				id = entrada.nextInt();
				pf = pessoaFisicaDAO.procurar(id);
				if (pf != null) {
					System.out.println("Nome atual <" + pf.getNome()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual o novo nome?");
						r.setDescricao(entrada.next());
					}
					try {
						pessoaFisicaDAO.alterarPessoaFisica(pf);
					} catch (Exception e) {
						throw e;
					}
				} else {
					System.out
							.println("Pessoa nao encontrada, tente novamente!");
				}
				break;
			case 4:
				if (pessoaFisicaDAO.listarPessoaFisicas().isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!\n");
				} else {
					System.out.println("CPF\t" + "Nome\t" + "Endereco\t"
							+ "Bairro\t\t" + "CEP\t" + "Cidade\t");
					for (PessoaFisica pFis : pFisicas) {
						System.out.println(pFis.toStringFormatada());
					}
				}

				System.out.println("Qual o CPF da pessoa fisica a excluir?");
				String cpf = entrada.nextLine();
				pf = pessoaFisicaDAO.procurar(cpf);
				if (pf != null) {
					try {
						pessoaFisicaDAO.excluirPessoaFisica(pf);
					} catch (Exception e) {
					}
				} else {
					System.out
							.println("Pessoa fisica nao encontrada, tente novamente!");
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

	public void moduloPessoaJuridica() {

	}

	public void moduloReceita() throws ClassNotFoundException, IOException {
		do {
			System.out.println("+----------------------------------+");
			System.out.println("|          Modulo Receita          |");
			System.out.println("|----------------------------------|");
			System.out.println("| 1 - Cadastrar nova receita       |"); // Finalizado
			System.out.println("| 2 - Exibir receitas              |"); // Finalizado
			System.out.println("| 3 - Alterar uma receita          |"); // Finalizado
			System.out.println("| 4 - Remover uma receita          |"); // Finalizado
			System.out.println("| 5 - Buscar uma receita           |"); // Finalizado
			System.out.println("| 6 - Dar baixa em receita         |"); // Finalizado
			System.out.println("| 7 - Voltar                       |"); // Finalizado
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				// Opcao adicionar despesa
				entrada.nextLine(); // para liberar a leitura do teclado
				System.out
						.println("A receita eh de uma PESSOA FÍSICA ou JURÍDICA?");
				System.out.println("Digite 1 para FÍSICA ou 2 para JURÍDICA:");
				opcao = lerInteiro();
				
				pFisicas = pessoaFisicaDAO.listarPessoaFisicas();
				pJuridicas = pessoaJuridicaDAO.listarPessoaJuridicas();
				
				if (opcao == 1 && !pFisicas.isEmpty()) {
					System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
					for (PessoaFisica pessoa : pFisicas) {
						System.out.println(pessoa.toStringFormatada());
					}
					entrada.nextLine(); // Para limpar o buffer do teclado.
					r.setTipoCliente(1);
					System.out.println("Qual o ID da pessoa física?");
					id = entrada.nextInt();
					pf = pessoaFisicaDAO.procurar(id);
					r.setCliente(pf);
					entrada.nextLine(); // Para limpar o buffer do teclado.
					System.out.println("Qual o nome da receita?");
					r.setDescricao(entrada.nextLine());
					System.out.println("Qual data de vencimento (dd/mm/aaaa)?");
					r.setDataVencimento(entrada.nextLine());
					System.out.println("Qual o valor nominal?");
					r.setValorNominal(entrada.nextDouble());
					receitaDAO.addReceita(r);
				} else if (opcao == 2
						&& !pJuridicas.isEmpty()) {
					System.out.println("ID\t" + "CNPJ\t\t\t" + "Nome\t");
					for (PessoaJuridica pessoa : pJuridicas) {
						System.out.println(pessoa.toStringFormatada());
					}
					entrada.nextLine(); // Para limpar o buffer do teclado.
					r.setTipoCliente(2);
					System.out.println("Qual o ID da pessoa jurídica?");
					id = entrada.nextInt();
					pj = pessoaJuridicaDAO.procurar(id);
					r.setCliente(pj);
					entrada.nextLine(); // Para limpar o buffer do teclado.
					System.out.println("Qual o nome da receita?");
					r.setDescricao(entrada.nextLine());
					System.out.println("Qual data de vencimento (dd/mm/aaaa)?");
					r.setDataVencimento(entrada.nextLine());
					System.out.println("Qual o valor nominal?");
					r.setValorNominal(entrada.nextDouble());
					receitaDAO.addReceita(r);
				} else {
					System.out
							.println("Pessoa não encontrada, ou lista vazia!");
				}
				break;
			case 2:
				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!");
				} else {
					for (Receita receita : receitas) {
						System.out.println(receita.toString());
					}
				}
				break;
			case 3:
				if (receitaDAO.listarReceitas() == null) {
					System.out.println("Nao existem receitas cadastradas!\n");
					moduloReceita();
				} else {
					for (Receita receita : receitas) {
						System.out.println(receita.toString());
					}
				}
				entrada.nextLine(); // Para limpar o buffer do teclado.
				System.out.println("Qual o ID da receita para alterar?");
				id = entrada.nextInt();
				if (receitaDAO.procurar(id) != null) {
					entrada.nextLine(); // Para limpar o buffer do teclado.
					System.out.println("Descricao atual <" + r.getDescricao()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual a nova descricao?");
						r.setDescricao(entrada.nextLine());
					}

					System.out.println("Vencimento atual <"
							+ r.getDataVencimento()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual o novo vencimento?");
						r.setDataVencimento(entrada.nextLine());
					}

					System.out.println("Valor atual <" + r.getValorNominal()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						System.out.println("Qual o novo valor?");
						r.setDataVencimento(entrada.nextLine());
					}

					System.out.println("Cliente atual <"
							+ r.getCliente().getNome()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.nextLine();
					if (resposta.equals("S")) {
						entrada.nextLine(); // para liberar a leitura do teclado
						System.out
								.println("O novo cliente será PESSOA FÍSICA ou JURÍDICA?");
						System.out
								.println("Digite 1 para FÍSICA ou 2 para JURÍDICA:");
						opcao = lerInteiro();
						if (opcao == 1
								&& pessoaFisicaDAO.listarPessoaFisicas() != null) {
							System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
							for (PessoaFisica pessoa : pFisicas) {
								System.out.println(pessoa.toStringFormatada());
							}
							entrada.nextLine(); // Para limpar o buffer do teclado.
							r.setTipoCliente(1);
							System.out.println("Qual o ID da pessoa física?");
							id = entrada.nextInt();
							pj = pessoaJuridicaDAO.procurar(id);
							r.setCliente(pj);
						}
						if (opcao == 2
								&& pessoaJuridicaDAO.listarPessoaJuridicas() != null) {
							System.out.println("ID\t" + "CNPJ\t\t\t" + "Nome\t");
							for (PessoaJuridica pessoa : pJuridicas) {
								System.out.println(pessoa.toStringFormatada());
							}
							entrada.nextLine(); // Para limpar o buffer do teclado.
							r.setTipoCliente(1);
							System.out.println("Qual o ID da pessoa jurídica?");
							id = entrada.nextInt();
							pj = pessoaJuridicaDAO.procurar(id);
							r.setCliente(pj);
						}
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
					moduloReceita();
				} else {
					for (Receita receita : receitas) {
						System.out.println(receita.toString());
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