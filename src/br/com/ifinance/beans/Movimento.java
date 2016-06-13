package br.com.ifinance.beans;

import java.io.Serializable;

public class Movimento implements Serializable, Comparable<Movimento> {

	private static final long serialVersionUID = 238784396833733304L;

	private int id;
	private String descricao;
	private String dataVencimento;
	private double valorNominal;
	private int baixado = 0;

	public int compareTo(Movimento comp) {
		if (this.id < comp.id) {
			return -1;
		}
		if (this.id > comp.id) {
			return 1;
		}
		return 0;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getBaixado() {
		return baixado;
	}

	public String getBaixadoSTR() {
		String status;

		if (this.baixado == 0)
			status = "PENDENTE";
		else
			if (this.baixado == 1)
				status = "BAIXADO";
			else
				status = "N/A";
		return status;
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