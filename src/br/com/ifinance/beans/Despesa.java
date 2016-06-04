package br.com.ifinance.beans;

import java.io.Serializable;

public class Despesa extends Movimento implements Serializable {

	private static final long serialVersionUID = 7532438393566281481L;
	private String documento;
	private String dataPgto;
	private double valorPago;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(String dataPgto) {
		this.dataPgto = dataPgto;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}
