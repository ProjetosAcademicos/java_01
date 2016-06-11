package br.com.ifinance.beans;

import java.io.Serializable;

public class Despesa extends Movimento implements Serializable {

	private static final long serialVersionUID = 7532438393566281481L;
	private String documento;
	private String dataPgto;
	private double valorPago;
	private Pessoa fornecedor;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDataPgto() {
		return dataPgto;
	}

	public double getValorPago() {
		return valorPago;
	}

	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public void baixar(double valorBaixa, String dataBaixa) {
		super.baixar(valorBaixa, dataBaixa);
		this.valorPago = valorBaixa;
		this.dataPgto = dataBaixa;
	}

}
