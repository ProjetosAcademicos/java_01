package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import br.com.ifinance.beans.Despesa;
import br.com.ifinance.beans.Pessoa;

public class DespesaDAO {
	private List<Despesa> listaDespesas;

	@SuppressWarnings("unchecked")
	public DespesaDAO() throws NullPointerException {
		try {
			listaDespesas = (List<Despesa>) PersistenciaDAO.ler("despesa.txt");

		} catch (NullPointerException e) {
		}
	}

	public void addDespesa(Despesa desp) {
		if (listaDespesas == null)
			listaDespesas = new ArrayList<Despesa>();

		try {
			desp.setId(Collections.max(listaDespesas).getId() + 1);

		} catch (Exception e) {
			desp.setId(1);
		}

		listaDespesas.add(desp);
		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo despesa.");
		}
	}

	public Stream<Despesa> listar(int baixado) {
		if (baixado == 2)
			return listaDespesas.stream();
		else
			return listaDespesas.stream().filter(
					obj -> (obj.getBaixado() == baixado));
	}

	public Stream<Despesa> listar(Pessoa fornecedor, int baixado) {
		if (baixado == 2) {
			return listaDespesas.stream().filter(
					obj -> (obj.getFornecedor().getId() == fornecedor.getId()));
		} else {
			return listaDespesas.stream().filter(
					obj -> (obj.getFornecedor().getId() == fornecedor.getId())
							&& (obj.getBaixado() == baixado));
		}
	}

	public Despesa procurar(String documento) {
		return listaDespesas.stream()
				.filter(obj -> obj.getDocumento().equals(documento))
				.findFirst().orElse(null);
	}

	public Despesa procurar(int id) {
		return listaDespesas.stream().filter(obj -> obj.getId() == id)
				.findFirst().orElse(null);
	}

	public void baixaDespesas(String documento, double valorPago,
			String dataPgto) {
		for (Despesa despesa : listaDespesas) {
			if (despesa.getDocumento().equals(documento)) {
				despesa.baixar(valorPago, dataPgto);
			}
		}

		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro baixando despesa.");
		}

	}

	public void alterarDespesa(Despesa despesa) throws FileNotFoundException,
			IOException {
		listaDespesas.forEach(obj -> {
			if (obj.getId() == despesa.getId()) {
				obj = despesa;
			}
		});

		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (FileNotFoundException e) {
			System.out
					.println("Erro alterando despesa. Arquivo n�o encontrado");
		}
	}

	public void excluirDespesa(Despesa despesa) throws FileNotFoundException,
			IOException {
		listaDespesas.forEach(obj -> {
			if (obj.equals(despesa)) {
				listaDespesas.remove(obj);
			}
		});

		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (FileNotFoundException e) {
			System.out
					.println("Erro alterando despesa. Arquivo nao encontrado");
		}
	}

}
