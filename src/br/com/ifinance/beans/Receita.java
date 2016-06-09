package br.com.ifinance.beans;

import java.io.Serializable;
import java.util.Date;

public class Receita extends Movimento implements Serializable {

	private static final long serialVersionUID = -3582439682901639327L;
	private double valorRecebido;
	private Date dataRecebimento;

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date date) {
		this.dataRecebimento = date;
	}

}
