package br.com.ifinance.beans;

import java.io.Serializable;

public class Movimento implements Serializable {

	private static final long serialVersionUID = 238784396833733304L;
	
	private int id;
	private String descricao;
	private String dataVencimento;
	private double valorNominal;
	private int baixado;

	public int getId() {
		return id;
	}
	
	public int getBaixado() {
		return baixado;
	}

	public void baixar(double valorBaixa, String dataBaixa) {
		this.baixado = 1;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String date) {
		this.dataVencimento = date;
	}

	public Double getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(Double valorNominal) {
		this.valorNominal = valorNominal;
	}

}
