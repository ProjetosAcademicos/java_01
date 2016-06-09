package br.com.ifinance.beans;

import java.io.Serializable;
import java.util.Date;

public class Movimento implements Serializable {

	private static final long serialVersionUID = 238784396833733304L;
	private String descricao;
	private Date dataVencimento;
	private double valorNominal;
	private int baixado;

	public int getBaixado() {
		return baixado;
	}

	public void setBaixado(int baixado) {
		this.baixado = baixado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date date) {
		this.dataVencimento = date;
	}

	public Double getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(Double valorNominal) {
		this.valorNominal = valorNominal;
	}

}
