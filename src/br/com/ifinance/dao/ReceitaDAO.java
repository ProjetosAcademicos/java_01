package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.ifinance.beans.Movimento;
import br.com.ifinance.beans.Receita;

public class ReceitaDAO extends MovimentoDAO {

	public ReceitaDAO() throws FileNotFoundException {
		super();
	}

	public void addReceita(String descricao, String dataVencimento,
			double valorNominal, double valorRecebido, String dataRecebimento)
			throws IOException, ClassNotFoundException {

		Movimento movimento = new Movimento();
		Receita novaReceita = new Receita();
		novaReceita.setDescricao(descricao);
		novaReceita.setDataVencimento(dataVencimento);
		novaReceita.setValorNominal(valorNominal);
		novaReceita.setValorRecebido(valorRecebido);
		novaReceita.setValorRecebido(valorRecebido);
		movimento = novaReceita;
		EscreverMovimentacao(movimento, "receitas.txt");

	}

	public void lerReceita(String arquivo) throws ClassNotFoundException,
			IOException {
		super.LerMovimentacao(arquivo);
	}

}