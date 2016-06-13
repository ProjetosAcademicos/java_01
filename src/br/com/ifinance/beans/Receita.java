package br.com.ifinance.beans;

public class Receita extends Movimento {

	private static final long serialVersionUID = -3582439682901639327L;
	private double valorRecebido = 0;
	private String dataRecebimento = "N/A";
	private Pessoa cliente;
	private int tipoCliente = 1;

	public double getValorRecebido() {
		return valorRecebido;
	}

	@Override
	public void baixar(double valorBaixa, String dataBaixa) {
		super.baixar(valorBaixa, dataBaixa);
		this.dataRecebimento = dataBaixa;
		this.valorRecebido = valorBaixa;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append("Id: " + getId() + "\n");
		strUtil.append("Descrição: " + getDescricao() + "\n");
		strUtil.append("Vencimento: " + getDataVencimento() + "\n");
		strUtil.append("Valor: " + getValorNominal() + "\n");
		strUtil.append("Baixado: " + getBaixado() + "\n");
		strUtil.append("Valor recebido: " + getValorRecebido() + "\n");
		strUtil.append("Data de recebimento: " + getDataRecebimento() + "\n");
		strUtil.append("Tipo de cliente: " + getTipoCliente() + "\n");
		return strUtil.toString();
	}

	public String toStringFormatada() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append(getId() + "\t" + getDescricao() + "\t\t"
				+ getDataVencimento() + "\t" + getValorNominal() + "\t"
				+ getBaixadoSTR() + "\t" + getValorRecebido() + "\t"
				+ getDataRecebimento() + "\t" + getTipoCliente());

		return strUtil.toString();
	}

}
