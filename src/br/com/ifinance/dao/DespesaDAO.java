package br.com.ifinance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.ifinance.beans.Despesa;
import br.com.ifinance.beans.Movimento;

public class DespesaDAO extends MovimentoDAO {

	public DespesaDAO() throws FileNotFoundException {
		super();
	}

	public void addDespesa(String descricao, String dataVencimento,
			double valorNominal, String documento, String dataPagto,
			double valorPago) throws IOException, ClassNotFoundException {

		Movimento movimento = new Movimento();
		Despesa novaDespesa = new Despesa();
		novaDespesa.setDescricao(descricao);
		novaDespesa.setDataVencimento(dataVencimento);
		novaDespesa.setValorNominal(valorNominal);
		novaDespesa.setDocumento(documento);
		novaDespesa.setDataPgto(dataPagto);
		novaDespesa.setValorPago(valorPago);
		movimento = novaDespesa;
		EscreverMovimentacao(movimento, "despesas.txt");

	}

	public void lerDespesa(String arquivo) throws ClassNotFoundException,
			IOException {
		super.LerMovimentacao(arquivo);
	}

}
