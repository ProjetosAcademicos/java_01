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
	
	@Override
	public String toString() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append("CPF: " + getCpf()+"\n"); 
		strUtil.append("Nome: " + getNome()+"\n");
		strUtil.append("Endereco: " + getEndereco()+"\n");
		strUtil.append("Bairro: " + getBairro()+"\n");
		strUtil.append("Cidade: " + getCidade()+"\n");
		strUtil.append("CEP: " + getCep()+"\n");
		strUtil.append("login: " + getUsuario().getLogin()+"\n");		
		
		return strUtil.toString();
	}


}
