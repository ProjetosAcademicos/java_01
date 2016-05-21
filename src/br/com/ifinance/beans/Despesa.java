package br.com.ifinance.beans;

import java.util.Date;

public class Despesa extends Movimento {

	private static final long serialVersionUID = 1L;
	private String documento;
	private Date dataPgto;
	private boolean pago;
	private int valorPago;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public int getValorPago() {
		return valorPago;
	}

	public void setValorPago(int valorPago) {
		this.valorPago = valorPago;
	}

}
