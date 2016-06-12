package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.ifinance.beans.PessoaFisica;

public class PessoaFisicaDAO {
	
	private List<PessoaFisica> pessoas;

	@SuppressWarnings("unchecked")
	public PessoaFisicaDAO() throws NullPointerException {
		try {
			pessoas = (List<PessoaFisica>) PersistenciaDAO.ler("PessoaFisicas.txt");

		} catch (NullPointerException e) {
		}
	}

	/**
	 * Metodo que solicita ao usuario as informacoes para adicionar uma nova
	 * PessoaFisica.
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */
	public void addPessoaFisica(PessoaFisica r) throws IOException,
			ClassNotFoundException {
		if (pessoas == null) {
			pessoas = new ArrayList<PessoaFisica>();
		}
		try {
			r.setId(pessoas.size()+1);
			//r.setId(Collections.max(pessoas).getId() + 1);

		} catch (Exception e) {
			r.setId(1);
		}
		pessoas.add(r);
		try {
			PersistenciaDAO.salvar(pessoas, "PessoaFisicas.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo a PessoaFisica.");
		}

	}

	public List<PessoaFisica> listarPessoaFisicas() {
		return pessoas;
	}

	public PessoaFisica procurar(String descricao) {
		return pessoas.stream()
				.filter(obj -> obj.getCpf().equals(descricao))
				.findFirst().orElse(null);
	}

	public PessoaFisica procurar(int id) {
		return pessoas.stream().filter(obj -> obj.getId() == id).findFirst()
				.orElse(null);
	}

	/**
	 * Metodo para recuperar a lista de PessoaFisicas do arquivo PessoaFisicas.txt para
	 * memoria
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */

	public void alterarPessoaFisica(PessoaFisica PessoaFisica) throws FileNotFoundException,
			IOException {
		pessoas.forEach(obj -> {
			if (obj.getId() == PessoaFisica.getId()) {
				obj = PessoaFisica;
			}
		});

		try {
			PersistenciaDAO.salvar(pessoas, "PessoaFisicas.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Nao foi possivel alterar a PessoaFisica.");
		}
	}

	public void excluirPessoaFisica(PessoaFisica PessoaFisica) throws FileNotFoundException,
			IOException {
		pessoas.forEach(obj -> {
			if (obj.equals(PessoaFisica)) {
				pessoas.remove(obj);
			}
		});

		try {
			PersistenciaDAO.salvar(pessoas, "PessoaFisicas.txt");
		} catch (FileNotFoundException e) {
			System.out
					.println("Nao foi possivel excluir a PessoaFisica.");
		}
	}

}