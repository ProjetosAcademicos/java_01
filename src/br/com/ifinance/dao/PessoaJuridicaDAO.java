package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifinance.beans.PessoaJuridica;

public class PessoaJuridicaDAO {

	private List<PessoaJuridica> pjuridicas;

	@SuppressWarnings("unchecked")
	public PessoaJuridicaDAO() throws NullPointerException {
		try {
			pjuridicas = (List<PessoaJuridica>) PersistenciaDAO
					.ler("PessoaJuridicas.txt");

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
		if (pjuridicas == null) {
			pjuridicas = new ArrayList<PessoaJuridica>();
		}
		try {
			r.setId(pjuridicas.size() + 1);
			// r.setId(Collections.max(pessoas).getId() + 1);

		} catch (Exception e) {
			r.setId(1);
		}
		pjuridicas.add(r);
		try {
			PersistenciaDAO.salvar(pjuridicas, "PessoaJuridicas.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo a PessoaJuridica.");
		}

	}

	public List<PessoaJuridica> listarPessoaJuridicas() {
		return pjuridicas;
	}

	public PessoaJuridica procurar(String descricao) {
		return pjuridicas.stream()
				.filter(obj -> obj.getCnpj().equals(descricao)).findFirst()
				.orElse(null);
	}

	public PessoaJuridica procurar(int id) {
		return pjuridicas.stream().filter(obj -> obj.getId() == id).findFirst()
				.orElse(null);
	}

	/**
	 * Metodo para recuperar a lista de PessoaJuridicas do arquivo
	 * PessoaJuridicas.txt para memoria
	 * 
	 * @param nenhum
	 * @return lista de objetos requisitada
	 */

	public void alterarPessoaJuridica(PessoaJuridica PessoaJuridica)
			throws FileNotFoundException, IOException {
		pjuridicas.forEach(obj -> {
			if (obj.getId() == PessoaJuridica.getId()) {
				obj = PessoaJuridica;
			}
		});

		try {
			PersistenciaDAO.salvar(pjuridicas, "PessoaJuridicas.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Nao foi possivel alterar a PessoaJuridica.");
		}
	}

	public void excluirPessoaJuridica(PessoaJuridica PessoaJuridica)
			throws FileNotFoundException, IOException {
		/*
		 * pjuridicas.forEach(obj -> { if (obj.equals(PessoaJuridica)) {
		 * pjuridicas.remove(obj); } });
		 */

		try {
			int indice = pjuridicas.indexOf(PessoaJuridica);
			pjuridicas.remove(indice);
			PersistenciaDAO.salvar(pjuridicas, "PessoaJuridicas.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Nao foi possivel excluir a PessoaJuridica.");
		}
	}

}
