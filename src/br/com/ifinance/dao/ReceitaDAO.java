package br.com.ifinance.dao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.ifinance.beans.Receita;

public class ReceitaDAO {

	private Scanner entrada = new Scanner(System.in);
	List<Receita> receitas;

	@SuppressWarnings("unchecked")
	public ReceitaDAO() throws NullPointerException {
		try {
			receitas = (List<Receita>) PersistenciaDAO.ler("receitas.txt");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Metodo que solicita ao usuario as informacoes para adicionar uma nova
	 * receita.
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */
	public void addReceita(List<Receita> receitas) throws IOException, ClassNotFoundException {
		Receita r = new Receita();

		System.out.print("Digite a descrição da receita:");
		r.setDescricao(entrada.nextLine());

		System.out.print("Digite a data de vencimento no formato dd/mm/aaaa:");
		r.setDataVencimento(entrada.next());

		System.out.println("Digite o valor nominal:");
		r.setValorNominal(entrada.nextDouble());

		receitas.add(r);

		try {
			PersistenciaDAO.salvar(receitas, "receitas.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para recuperar a lista de receitas do arquivo receitas.txt para
	 * memoria
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */
	public void lerReceitas() throws ClassNotFoundException, IOException {
		System.out.println("LISTA DE RECEITAS\n");
		System.out.println("-----------------");
		for (int i = 0; i < receitas.size(); i++) {
			System.out.println("Descrição: " + receitas.get(i).getDescricao());
			System.out.println("Vecimento: "
					+ receitas.get(i).getDataVencimento());
			System.out.println("Valor inicial: "
					+ receitas.get(i).getValorNominal());
			System.out.println("Situação: " + receitas.get(i).getBaixado());
			System.out.println("Valor recebido: "
					+ receitas.get(i).getValorRecebido());
			System.out.println("Data de recebimento: "
					+ receitas.get(i).getDataRecebimento());
			System.out.println("-----------------");
		}
	}

	public void alterarReceita() throws ClassNotFoundException, IOException {
		System.out.println("Digite o nome da receita para alterar");
		String nome = entrada.nextLine();
		if (buscarReceita(nome) != -1) {
			int posicao = buscarReceita(nome);
			Scanner entrada = new Scanner(System.in);
			System.out.print("Descreva o nome da receita:");
			String descricao = entrada.nextLine();
			receitas.get(posicao).setDescricao(descricao);
			System.out.print("Digite o valor nominal:");
			double valorNominal = entrada.nextDouble();
			receitas.get(posicao).setValorNominal(valorNominal);
			entrada.close();
			addReceita(receitas);
			System.out.println("Receita alterada com sucesso!");
		}
	}

	public int buscarReceita(String nome) throws ClassNotFoundException,
			IOException {
		for (int i = 0; i < receitas.size(); i++) {
			if (receitas.get(i).getDescricao().equals(nome)) {
				return i;
			}
		}
		System.out.println("Receita não encontrada");
		return -1;
	}

	public void exluirReceita() {
	}

}
