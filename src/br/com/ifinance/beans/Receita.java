package br.com.ifinance.beans;

public class Receita extends Movimento {

	private static final long serialVersionUID = 1L;
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
