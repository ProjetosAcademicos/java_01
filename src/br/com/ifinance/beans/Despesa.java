package br.com.ifinance.beans;

import java.io.Serializable;

import br.com.ifinance.utils.Formatacao;

public class Despesa extends Movimento implements Serializable {

	private static final long serialVersionUID = 7532438393566281481L;
	private String documento;
	private String dataPgto;
	private double valorPago;
	private int tipoFornecedor;
	private Pessoa fornecedor;

	public int getTipoFornecedor() {
		return tipoFornecedor;
	}

	public void setTipoFornecedor(int tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}
	
	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDataPgto() {
		return dataPgto;
	}

	public Double getValorPago() {
		return valorPago;
	}

	@Override
	public void baixar(double valorBaixa, String dataBaixa) {
		super.baixar(valorBaixa, dataBaixa);
		this.valorPago = valorBaixa;
		this.dataPgto = dataBaixa;
	}
	
	@Override
	public String toString() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append("Identificador: " + getId() + "\n");
		strUtil.append("Documento: " + getDocumento() + "\n");
		strUtil.append("Descricao: " + getDescricao() + "\n");
		strUtil.append("Vencimento: " + getDataVencimento() + "\n");
		strUtil.append("Valor: " + getValorNominal() + "\n");
		strUtil.append("Data Pagamento: " + getDataPgto() + "\n");
		strUtil.append("Valor Pago: " + getValorPago() + "\n");
		strUtil.append("Fornecedor: " + getFornecedor().getNome() + "\n");

		return strUtil.toString();
	}

	public String toStringFormatada() {
		StringBuilder strUtil = new StringBuilder();
//		strUtil.append(getId() + "\t" + getDocumento() + "\t" + getDescricao() + "\t\t" + getDataVencimento() + "\t"
//		+ getValorNominal() + "\t\t" + getFornecedor().getNome());

		System.out.println(Formatacao.formata(Integer.toString(this.getId()), "D", 6) +
        Formatacao.formata(this.getDocumento(), "D", 15) +
        Formatacao.formata(this.getDescricao(), "D", 30) +
        Formatacao.formata(this.getDataVencimento(), "D", 11) +
        Formatacao.formata(this.getValorNominal().toString(), "E", 10) + " " +
        Formatacao.formata(this.getBaixadoSTR(), "D", 8) +
        Formatacao.formata(this.getDataPgto(), "D", 11) +
        Formatacao.formata(this.getValorPago().toString(), "E", 10) + " " +
        Formatacao.formata(this.getFornecedor().getNome(), "D", 40));
		//Formatacao.formata(this.getFornecedor().toString(), "D", 40));
		
		return strUtil.toString();
	}	

}
