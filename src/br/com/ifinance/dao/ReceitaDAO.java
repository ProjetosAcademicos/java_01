package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.ifinance.beans.Receita;

public class ReceitaDAO extends MovimentoDAO {

	public ReceitaDAO() throws FileNotFoundException {
		super();
	}

	public void addReceita(String descricao, String dataVencimento, double valorNominal, double valorRecebido,
			String dataRecebimento) throws IOException, ClassNotFoundException {

		Receita novaReceita = new Receita();
		novaReceita.setDescricao(descricao);
		novaReceita.setDataVencimento(dataVencimento);
		novaReceita.setValorNominal(valorNominal);
		novaReceita.setValorRecebido(valorRecebido);
		novaReceita.setValorRecebido(valorRecebido);
		String receita = "Receita: " + descricao + "\n" + "Data de Vencimento: " + dataVencimento + "\n"
				+ "Valor inicial: " + valorNominal + "\n" + "Valor recebido: " + valorRecebido + "\n"
				+ "Data de recebimento: " + dataRecebimento + "\n";
		EscreverMovimentacao(receita);

	}
	
	// Metodo que realiza apenas a leitura de todos os dados
		// do arquivo e retorna uma string que contem os dados
		public void LerReceita(String tipoMovimentacao) throws IOException, ClassNotFoundException {
			super.LerMovimentacao(tipoMovimentacao);
		}

}
