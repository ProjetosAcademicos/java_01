package br.com.ifinance.beans;

public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 20160604L;
	
	private String cpf;

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
