package br.com.ifinance.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ifinance.beans.Receita;

public class ReceitaDAO {

	private List<Receita> receitas;

	@SuppressWarnings("unchecked")
	public ReceitaDAO() throws NullPointerException {
		try {
			receitas = (List<Receita>) PersistenciaDAO.ler("receitas.txt");

		} catch (NullPointerException e) {
		}
	}

	/**
	 * Metodo que solicita ao usuario as informacoes para adicionar uma nova
	 * receita.
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */
	public void addReceita(Receita r) throws IOException,
			ClassNotFoundException {
		if (receitas == null) {
			receitas = new ArrayList<Receita>();
		}
		try {
			r.setId(Collections.max(receitas).getId() + 1);

		} catch (Exception e) {
			r.setId(1);
		}
		receitas.add(r);
		try {
			PersistenciaDAO.salvar(receitas, "receitas.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo a receita.");
		}

	}

	public List<Receita> listarReceitas() {
		return receitas;
	}

	public Receita procurar(String descricao) {
		return receitas.stream()
				.filter(obj -> obj.getDescricao().equals(descricao))
				.findFirst().orElse(null);
	}

	/**
	 * Metodo para recuperar a lista de receitas do arquivo receitas.txt para
	 * memoria
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */

	public void alterarReceita(Receita receita) throws ClassNotFoundException,
			IOException {
		
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

	public void exluirReceita(String nome) {

	}

}
