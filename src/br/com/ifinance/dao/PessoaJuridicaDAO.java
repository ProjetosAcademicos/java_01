package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifinance.beans.PessoaJuridica;

public class PessoaJuridicaDAO {

	private List<PessoaJuridica> pessoas;

	@SuppressWarnings("unchecked")
	public PessoaJuridicaDAO() throws NullPointerException {
		try {
			pessoas = (List<PessoaJuridica>) PersistenciaDAO.ler("PessoaJuridicas.txt");

		} catch (NullPointerException e) {
		}
	}

	/**
	 * Metodo que solicita ao usuario as informacoes para adicionar uma nova
	 * PessoaJuridica.
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */
	public void addPessoaJuridica(PessoaJuridica r) throws IOException,
			ClassNotFoundException {
		if (pessoas == null) {
			pessoas = new ArrayList<PessoaJuridica>();
		}
		try {
			r.setId(pessoas.size()+1);
			//r.setId(Collections.max(pessoas).getId() + 1);

		} catch (Exception e) {
			r.setId(1);
		}
		pessoas.add(r);
		try {
			PersistenciaDAO.salvar(pessoas, "PessoaJuridicas.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo a PessoaJuridica.");
		}

	}

	public List<PessoaJuridica> listarPessoaJuridicas() {
		return pessoas;
	}

	public PessoaJuridica procurar(String descricao) {
		return pessoas.stream()
				.filter(obj -> obj.getCnpj().equals(descricao))
				.findFirst().orElse(null);
	}

	public PessoaJuridica procurar(int id) {
		return pessoas.stream().filter(obj -> obj.getId() == id).findFirst()
				.orElse(null);
	}

	/**
	 * Metodo para recuperar a lista de PessoaJuridicas do arquivo PessoaJuridicas.txt para
	 * memoria
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */

	public void alterarPessoaJuridica(PessoaJuridica PessoaJuridica) throws FileNotFoundException,
			IOException {
		pessoas.forEach(obj -> {
			if (obj.getId() == PessoaJuridica.getId()) {
				obj = PessoaJuridica;
			}
		});

		try {
			PersistenciaDAO.salvar(pessoas, "PessoaJuridicas.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Nao foi possivel alterar a PessoaJuridica.");
		}
	}

	public void excluirPessoaJuridica(PessoaJuridica PessoaJuridica) throws FileNotFoundException,
			IOException {
		pessoas.forEach(obj -> {
			if (obj.equals(PessoaJuridica)) {
				pessoas.remove(obj);
			}
		});

		try {
			PersistenciaDAO.salvar(pessoas, "PessoaJuridicas.txt");
		} catch (FileNotFoundException e) {
			System.out
					.println("Nao foi possivel excluir a PessoaJuridica.");
		}
	}

}
