package br.com.ifinance.beans;

public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 20160604L;
	
	private String cnpj;

	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		StringBuilder strUtil = new StringBuilder();
		strUtil.append("CNPJ: " + getCnpj()+"\n"); 
		strUtil.append("Nome: " + getNome()+"\n");
		strUtil.append("Endereco: " + getEndereco()+"\n");
		strUtil.append("Bairro: " + getBairro()+"\n");
		strUtil.append("Cidade: " + getCidade()+"\n");
		strUtil.append("CEP: " + getCep()+"\n");
		strUtil.append("login: " + getUsuario().getLogin()+"\n");		
		
		return strUtil.toString();
	}

}
