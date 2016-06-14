package br.com.ifinance.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.ifinance.beans.Despesa;
import br.com.ifinance.beans.Pessoa;
import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.PessoaJuridica;
import br.com.ifinance.beans.Receita;
import br.com.ifinance.dao.DespesaDAO;
import br.com.ifinance.dao.PessoaFisicaDAO;
import br.com.ifinance.dao.PessoaJuridicaDAO;
import br.com.ifinance.dao.ReceitaDAO;
import br.com.ifinance.utils.Formatacao;

public class MenuPrincipal {

	private int opcao;
	Scanner entrada;
	Receita r;
	Despesa desp = new Despesa();
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

		desp = new Despesa();
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
			System.out.println("| 5 - Voltar                       |");
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

				pessoaFisicaDAO.addPessoaFisica(p);
				break;
			case 2:
				pFisicas = pessoaFisicaDAO.listarPessoaFisicas();
				if (pFisicas.isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!");
				} else {
					// System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
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
						entrada.nextLine();
						System.out.println("Qual o novo nome?");
						pf.setNome(entrada.nextLine());
					}

					System.out.println("Endereco atual <" + pf.getEndereco()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo endereco?");
						pf.setEndereco(entrada.nextLine());
					}

					System.out.println("Birro atual <" + pf.getBairro()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo bairro?");
						pf.setBairro(entrada.nextLine());
					}

					System.out.println("Cidade atual <" + pf.getCidade()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual a nova cidade?");
						pf.setCidade(entrada.nextLine());
					}

					System.out.println("CEP atual <" + pf.getCep()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo CEP?");
						pf.setCep(entrada.nextLine());
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
				pFisicas = pessoaFisicaDAO.listarPessoaFisicas();
				if (pFisicas.isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!\n");
				} else {
					System.out.println("CPF\t" + "Nome\t" + "Endereco\t"
							+ "Bairro\t\t" + "CEP\t" + "Cidade\t");
					for (PessoaFisica pFis : pFisicas) {
						System.out.println(pFis.toStringFormatada());
					}
				}

				entrada.nextLine();
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
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
		entrada.close();

	}

	public void moduloPessoaJuridica() throws ClassNotFoundException,
			IOException {
		do {
			System.out.println("+------------------------------------+");
			System.out.println("|       Modulo Pessoa Juridica       |");
			System.out.println("|------------------------------------|");
			System.out.println("| 1 - Cadastrar nova pessoa juridica |");
			System.out.println("| 2 - Exibir pessoas juridicas       |");
			System.out.println("| 3 - Alterar uma pessoa juridica    |");
			System.out.println("| 4 - Excluir uma pessoa juridica    |");
			System.out.println("| 5 - Voltar                         |");
			System.out.println("+----------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				entrada.nextLine();

				System.out.println("Qual o CNPJ da pessoa?");
				PessoaJuridica p = new PessoaJuridica(entrada.nextLine());

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

				pessoaJuridicaDAO.addPessoaJuridica(p);
				break;
			case 2:
				pJuridicas = pessoaJuridicaDAO.listarPessoaJuridicas();
				if (pJuridicas.isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!");
				} else {
					// System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
					for (PessoaJuridica pessoa : pJuridicas) {
						System.out.println(pessoa.toString());
					}
				}
				break;
			case 3:
				System.out.println("Qual o id da pessoa para alterar?");
				id = entrada.nextInt();
				pj = pessoaJuridicaDAO.procurar(id);
				if (pj != null) {
					System.out.println("Nome atual <" + pj.getNome()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo nome?");
						pj.setNome(entrada.nextLine());
					}

					System.out.println("Endereco atual <" + pj.getEndereco()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo endereco?");
						pj.setEndereco(entrada.nextLine());
					}

					System.out.println("Birro atual <" + pj.getBairro()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo bairro?");
						pj.setBairro(entrada.nextLine());
					}

					System.out.println("Cidade atual <" + pj.getCidade()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual a nova cidade?");
						pj.setCidade(entrada.nextLine());
					}

					System.out.println("CEP atual <" + pj.getCep()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
						System.out.println("Qual o novo CEP?");
						pj.setCep(entrada.nextLine());
					}

					try {
						pessoaJuridicaDAO.alterarPessoaJuridica(pj);
					} catch (Exception e) {
						throw e;
					}
				} else {
					System.out
							.println("Pessoa nao encontrada, tente novamente!");
				}
				break;
			case 4:
				pJuridicas = pessoaJuridicaDAO.listarPessoaJuridicas();
				if (pJuridicas.isEmpty()) {
					System.out.println("Nao existem pessoas cadastradas!\n");
				} else {
					System.out.println("ID\t" + "CNPJ\t\t" + "Nome\t");
					for (PessoaJuridica pJur : pJuridicas) {
						System.out.println(pJur.toStringFormatada());
					}
				}

				entrada.nextLine();
				System.out.println("Qual o CNPJ da pessoa juridica a excluir?");
				String cnpj = entrada.nextLine();
				pj = pessoaJuridicaDAO.procurar(cnpj);
				if (pj != null) {
					try {
						pessoaJuridicaDAO.excluirPessoaJuridica(pj);
					} catch (Exception e) {
					}
				} else {
					System.out
							.println("Pessoa juridica nao encontrada, tente novamente!");
				}
				break;
			case 5:
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 5);
		entrada.close();
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
			case 1: // Cadastrar nova receita
				// Opcao adicionar despesa
				entrada.nextLine(); // para liberar a leitura do teclado
				System.out
						.println("A receita eh de uma PESSOA FISICA ou JURIDICA?");
				System.out.println("Digite 1 para FISICA ou 2 para JURIDICA:");
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
				} else if (opcao == 2 && !pJuridicas.isEmpty()) {
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
			case 2: // Exibir receitas
				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!");
				} else {
					System.out.println("+----------Lista de receitas--------+");
					for (Receita receita : receitas) {
						System.out.println(receita.toString());
					}
					System.out.println("+-----------------------------------+");
				}
				break;
			case 3: // Alterar uma receita
				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!\n");
					moduloReceita();
				} else {
					System.out.println("ID\tDescrição");
					for (Receita receita : receitas) {
						System.out.println(receita.toStringFormatada());
					}
				}
				entrada.nextLine(); // Para limpar o buffer do teclado.
				System.out.println("Qual o ID da receita para alterar?");
				id = entrada.nextInt();
				r = receitaDAO.procurar(id);
				if (r != null) {
					entrada.nextLine(); // Para limpar o buffer do teclado.
					System.out.println("Descricao atual <" + r.getDescricao()
							+ ">, deseja alterar: S ou N?");
					resposta = entrada.next();
					if (resposta.equals("S")) {
						entrada.nextLine();
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
					alterarCliente(resposta);
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
			case 4: // Remover uma receita
				receitas = receitaDAO.listarReceitas();
				if (receitas.isEmpty()) {
					System.out.println("Nao existem receitas cadastradas!\n");
					moduloReceita();
				} else {
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
			case 5: // Buscar uma receita
				entrada.nextLine();
				System.out.println("Qual descricao da receita para procurar:");
				String descricao = entrada.nextLine();
				r = receitaDAO.procurar(descricao);
				if (r != null) {
					System.out.println(r.toString());
				} else {
					System.out
							.println("Receita não encontrada. Tente novamente!");
				}
				break;
			case 6: // Dar baixa em uma receita
				realizarBaixaReceita();
				break;
			case 7: // Sair do modulo receita
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 7);
		entrada.close();
	}

	public void alterarCliente(String resposta) {
		if (resposta.equals("S")) {
			System.out.println("Escolha o tipo de cliente:");
			System.out.println("1 - PESSOA FISICA\n2 - PESSOA JURIDICA:");
			opcao = lerInteiro();
			if (opcao == 1 && pessoaFisicaDAO.listarPessoaFisicas() != null) {
				System.out.println("ID\t" + "CPF\t\t\t" + "Nome\t");
				for (PessoaFisica pessoa : pFisicas) {
					System.out.println(pessoa.toStringFormatada());
				}
				// Para limpar o buffer do teclado.
				entrada.nextLine();
				r.setTipoCliente(1);
				System.out.println("Qual o ID da pessoa física?");
				id = entrada.nextInt();
				r.setCliente(pessoaFisicaDAO.procurar(id));
			}
			if (opcao == 2 && pessoaJuridicaDAO.listarPessoaJuridicas() != null) {
				System.out.println("ID\t" + "CNPJ\t\t\t" + "Nome\t");
				for (PessoaJuridica pessoa : pJuridicas) {
					System.out.println(pessoa.toStringFormatada());
				}
				// Para limpar o buffer do teclado.
				entrada.nextLine();
				r.setTipoCliente(2);
				System.out.println("Qual o ID da pessoa jurídica?");
				id = entrada.nextInt();
				r.setCliente(pessoaJuridicaDAO.procurar(id));
			}
		}
	}

	public void realizarBaixaReceita() {
		double valorBaixa;
		String dataBaixa;
		receitas = receitaDAO.listarReceitas();
		if (receitas.isEmpty()) {
			System.out.println("Nao existem receitas cadastradas!\n");
		} else {
			for (Receita receita : receitas) {
				System.out.println(receita.toStringFormatada());
			}
		}
		System.out.println("Qual o ID da receita para realizar baixa?");
		int id = entrada.nextInt();
		if (receitaDAO.procurar(id) != null) {
			entrada.nextLine();
			System.out.println("Qual data de recebimento (dd/mm/aaaa)?");
			dataBaixa = entrada.nextLine();
			System.out.println("Qual o valor do recebido?");
			valorBaixa = entrada.nextDouble();
			receitaDAO.baixaReceita(id, valorBaixa, dataBaixa);
		} else {
			System.out.println("Não foi possível dar baixa na receita!");
		}
	}

	public void moduloDespesa() throws ClassNotFoundException, IOException {
		do {
			System.out.println("+-------------------------------------+");
			System.out.println("|          Modulo Despesa             |");
			System.out.println("|-------------------------------------|");
			System.out.println("| 1 - Cadastrar nova despesa          |");
			System.out.println("| 2 - Exibir despesas                 |");
			System.out.println("| 3 - Alterar uma despesa             |");
			System.out.println("| 4 - Excluir uma despesa             |");
			System.out.println("| 5 - Realizar baixa                  |");
			System.out.println("| 6 - Exibir despesas por Fornecedor  |");
			System.out.println("| 7 - Voltar                          |");
			System.out.println("+-------------------------------------+");
			System.out.print("Digite a opcao escolhida:");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				inserirDespesa();
				break;
			case 2:
				exibirDespesa();
				break;
			case 3:
				alterarDespesa();
				break;
			case 4:
				excluirDespesa();
				break;
			case 5:
				realizarBaixaDespesa();
				break;
			case 6:
				exibirDepesaFornecedor();
				break;
			case 7:
				Tela();
				break;
			default:
				System.out.println("Opcao invalida. Tente novamente:");
				break;
			}
		} while (opcao != 7);
		entrada.close();
	}

	public void listaPessoaFisica() {
		pFisicas = pessoaFisicaDAO.listarPessoaFisicas();

		if (pFisicas == null) {
			System.out.println("Nao existem pessoas cadastradas!");
		} else {
			// System.out.println("Id\t" + "CPF\t" + "nome\t");
			for (PessoaFisica pessoa : pFisicas) {
				System.out.println(pessoa.toStringFormatada());
			}
		}

	}

	public void listaPessoaJuridica() {
		pJuridicas = pessoaJuridicaDAO.listarPessoaJuridicas();

		if (pJuridicas == null) {
			System.out.println("Nao existem pessoas cadastradas!");
		} else {
			// System.out.println("Id\t" + "CNPJ\t" + "nome\t");
			for (PessoaJuridica pessoa : pJuridicas) {
				System.out.println(pessoa.toStringFormatada());
			}
		}
	}

	public Pessoa selecionaFornecedor() {
		int resposta = 0;
		Pessoa fornecedor;

		entrada.nextLine();
		System.out
				.println("Informe se o fornecedor eh pessoa fisica ou juridica (1 - Juridica , 2 - Fisica): ");
		desp.setTipoFornecedor(lerInteiro());

		// private Pessoa fornecedor;
		if (desp.getTipoFornecedor() == 2) {
			listaPessoaFisica();
			System.out.println("Informe o id do fornecedor?");
			resposta = lerInteiro();
			try {
				fornecedor = pessoaFisicaDAO.procurar(resposta);
			} catch (Exception e) {
				// TODO: handle exception
				fornecedor = null;
			}
		} else {
			listaPessoaJuridica();
			System.out.println("Informe o id do fornecedor?");
			resposta = lerInteiro();
			try {
				fornecedor = pessoaJuridicaDAO.procurar(resposta);
			} catch (Exception e) {
				// TODO: handle exception
				fornecedor = null;
			}
		}
		return fornecedor;
	}

	public void inserirDespesa() {
		Pessoa fornecedor;
		Despesa despesa = new Despesa();

		fornecedor = selecionaFornecedor();

		if (fornecedor == null) {
			System.out
					.println("fornecedor nao encontrado. Nao eh possivel incluir a despesa!");
		} else {
			despesa.setFornecedor(fornecedor);

			entrada.nextLine();
			System.out.println("Informe o documento?");
			despesa.setDocumento(entrada.nextLine());
			System.out.println("Informe uma descricao para a despesa?");
			despesa.setDescricao(entrada.nextLine());
			System.out.println("Qual data de vencimento (dd/mm/aaaa)?");
			despesa.setDataVencimento(entrada.nextLine());
			System.out.println("Qual o valor nominal?");
			despesa.setValorNominal(entrada.nextDouble());

			try {
				despesaDAO.addDespesa(despesa);

				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println(desp.toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void listaDespesas(int status) {
		List<Despesa> lRetorno = new ArrayList<Despesa>();
		StringBuilder cabecalho = new StringBuilder();

		try {
			despesaDAO.listar(status).forEach(obj -> lRetorno.add(obj));
		} catch (Exception e) {
			System.out.println("Nenhuma despesa encontrada!");
		}
		if (!lRetorno.isEmpty()) {
			cabecalho.append(Formatacao.formata("ID", "D", 6)
					+ Formatacao.formata("Documento", "D", 15)
					+ Formatacao.formata("Descricao", "D", 30)
					+ Formatacao.formata("Vencimento", "D", 11)
					+ Formatacao.formata("Valor", "E", 10) + " "
					+ Formatacao.formata("Status", "D", 8)
					+ Formatacao.formata("Data Pgto", "D", 11)
					+ Formatacao.formata("Valor Pago", "E", 10) + " "
					+ Formatacao.formata("Fornecedor", "D", 40));

			System.out.println(cabecalho);
			lRetorno.forEach(obj -> System.out.print(obj.toStringFormatada()));
		}

	}

	public void listaDespesasFornecedor(Pessoa fornecedor, int status) {
		List<Despesa> lRetorno = new ArrayList<Despesa>();
		StringBuilder cabecalho = new StringBuilder();

		despesaDAO.listar(fornecedor, status).forEach(obj -> lRetorno.add(obj));

		if (lRetorno.isEmpty()) {
			System.err.println("Nao existem despesas cadastradas!");
		} else {
			cabecalho.append(Formatacao.formata("ID", "D", 6)
					+ Formatacao.formata("Documento", "D", 15)
					+ Formatacao.formata("Descricao", "D", 30)
					+ Formatacao.formata("Vencimento", "D", 11)
					+ Formatacao.formata("Valor", "E", 10) + " "
					+ Formatacao.formata("Status", "D", 8)
					+ Formatacao.formata("Data Pgto", "D", 11)
					+ Formatacao.formata("Valor Pago", "E", 10) + " "
					+ Formatacao.formata("Fornecedor", "D", 40));

			System.out.println(cabecalho);
			lRetorno.forEach(obj -> System.out.print(obj.toStringFormatada()));
		}

	}

	public void exibirDepesaFornecedor() {
		int resposta;
		Pessoa fornecedor;

		fornecedor = selecionaFornecedor();

		System.out
				.println("Informe o status das despesas a serem listadas: (0) Pendentes, (1) Baixadas, (2) Todas ");
		resposta = lerInteiro();
		listaDespesasFornecedor(fornecedor, resposta);
	}

	public void exibirDespesa() {
		int resposta;

		System.out
				.println("Informe o status das despesas a serem listadas: (0) Pendentes, (1) Baixadas, (2) Todas ");
		resposta = lerInteiro();
		listaDespesas(resposta);
	}

	public void alterarDespesa() {
		Despesa despesa = new Despesa();
		listaDespesas(2);

		System.out.println("Informe o ID da despesa a ser alterada: ");
		id = entrada.nextInt();
		despesa = despesaDAO.procurar(id);

		if (desp != null) {
			System.out.println("Documento atual <" + despesa.getDocumento()
					+ ">, deseja alterar: S ou N?");
			resposta = entrada.next();
			if (resposta.equals("S")) {
				System.out.println("Qual o novo documento?");
				despesa.setDocumento(entrada.nextLine());
			}

			System.out.println("Descricao atual <" + despesa.getDescricao()
					+ ">, deseja alterar: S ou N?");
			resposta = entrada.next();
			if (resposta.equals("S")) {
				entrada.nextLine();
				System.out.println("Qual a nova descricao?");
				despesa.setDescricao(entrada.nextLine());
			}

			System.out.println("Vencimento atual <"
					+ despesa.getDataVencimento()
					+ ">, deseja alterar: S ou N?");
			resposta = entrada.next();
			if (resposta.equals("S")) {
				entrada.nextLine();
				System.out.println("Qual o novo vencimento?");
				despesa.setDataVencimento(entrada.next());
			}

			System.out.println("Valor atual <" + despesa.getValorNominal()
					+ ">, deseja alterar: S ou N?");
			resposta = entrada.next();
			if (resposta.equals("S")) {
				System.out.println("Qual o novo valor?");
				despesa.setValorNominal(entrada.nextDouble());
			}
			try {
				despesaDAO.alterarDespesa(despesa);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Despesa nao encontrada, tente novamente!");
		}

	}

	public void excluirDespesa() {
		listaDespesas(2);

		System.out.println("Informe o id da despesa a ser excluida?");
		int id = entrada.nextInt();
		desp = despesaDAO.procurar(id);
		if (desp != null) {
			try {
				despesaDAO.excluirDespesa(desp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Despesa nao encontrada, tente novamente!");
		}
	}

	public void realizarBaixaDespesa() {
		listaDespesas(0);

		System.out.println("Informe o id da despesa que sera dada baixa?");
		id = entrada.nextInt();
		String dataBaixa;
		double valorBaixa;

		desp = despesaDAO.procurar(id);
		if (desp != null) {
			try {
				entrada.nextLine();
				System.out.println("Qual data de baixa (dd/mm/aaaa)?");
				dataBaixa = entrada.nextLine();
				System.out.println("Qual o valor de baixa?");
				valorBaixa = entrada.nextDouble();

				despesaDAO.baixaDespesas(id, valorBaixa, dataBaixa);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Despesa nao encontrada, tente novamente!");
		}
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