package br.com.ifinance.beans;

public class Despesa extends Movimento {

	private static final long serialVersionUID = 1L;
	private String documento;
	private String dataPgto;
	private boolean pago;
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

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}
