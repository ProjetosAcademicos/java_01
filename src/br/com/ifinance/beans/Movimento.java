package br.com.ifinance.beans;

import java.io.Serializable;
import java.util.Date;

public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;
	private String descricao;
	private Date dataVencimento;
	private double valorNominal;
	private char tipoMovimentacao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorNominal() {
		return valorNominal;
	}

	public void setValorNominal(Double valorNominal) {
		this.valorNominal = valorNominal;
	}

	public char getTipoMovimento() {
		return tipoMovimentacao;
	}

	public void setTipoMovimento(char tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public void realizarMovimentacao(String descricao, Date dataVencimento, double valorNominal,
			char tipoMovimentacao) {
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.valorNominal = valorNominal;
		this.tipoMovimentacao = tipoMovimentacao;
	}
}
