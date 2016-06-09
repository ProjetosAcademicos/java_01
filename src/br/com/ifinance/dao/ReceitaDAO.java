package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.ifinance.beans.Receita;

public class ReceitaDAO {

	public ReceitaDAO() throws FileNotFoundException {
	}

	/**
	 * Esse metodo recebe uma lista de receitas e passa essa lista para o metodo
	 * salvar do PersistenciaDAO. Se ocorrer algum problema, alguma excecao sera
	 * acionada.
	 */
	public void addReceitas(List<Receita> receitas) throws IOException,
			ClassNotFoundException {
		Object objeto = receitas;
		PersistenciaDAO.salvar(objeto, "receitas.txt");
	}

	/**
	 * Metodo para recuperar a lista de receitas do arquivo receitas.txt para
	 * memoria
	 * 
	 * @param caminho
	 *            do arquivo txt
	 * @return lista de objetos requisitada
	 */
	@SuppressWarnings("unchecked")
	public void lerReceitas(String arquivo) throws ClassNotFoundException,
			IOException {
		List<Receita> receitas = (List<Receita>) PersistenciaDAO
				.ler("receitas.txt");
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

}
