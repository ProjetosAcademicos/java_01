package br.com.ifinance.beans;

public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 20160604L;
	
	private String cnpj;

	public PessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
