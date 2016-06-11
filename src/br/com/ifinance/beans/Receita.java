package br.com.ifinance.beans;


public class Receita extends Movimento {

	private static final long serialVersionUID = -3582439682901639327L;
	private double valorRecebido = 0;
	private String dataRecebimento = "N/A";
	private Pessoa cliente;

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

	@Override
	public String toString() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append("Descrição: " + getDescricao()+"\n"); 
		strUtil.append("Vencimento: " + getDataVencimento()+"\n");
		strUtil.append("Valor: " + getValorNominal()+"\n");
		strUtil.append("Baixado: " + getBaixado()+"\n");
		strUtil.append("Valor recebido: " + getValorRecebido()+"\n");
		strUtil.append("Data de recebimento: " + getDataRecebimento()+"\n");
		
		return strUtil.toString();
	}

}
