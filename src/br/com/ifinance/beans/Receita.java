package br.com.ifinance.beans;


public class Receita extends Movimento {

	private static final long serialVersionUID = -3582439682901639327L;
	private double valorRecebido;
	private String dataRecebimento;

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


}
