package br.com.ifinance.beans;

import java.util.Date;

public class Receita extends Movimento {

	private static final long serialVersionUID = 1L;
	private double valorRecebido;
	private Date dataRecebimento;
	private boolean status;

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public boolean isRecebido() {
		return status;
	}

	public void setRecebido(boolean status) {
		this.status = status;
	}

}
