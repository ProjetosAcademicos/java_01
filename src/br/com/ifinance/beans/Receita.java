package br.com.ifinance.beans;

import java.io.Serializable;

public class Receita extends Movimento implements Serializable {

	private static final long serialVersionUID = -3582439682901639327L;
	private double valorRecebido;
	private String dataRecebimento;

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

}
