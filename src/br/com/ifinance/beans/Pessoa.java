package br.com.ifinance.beans;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 20160604L;

	private int id;
	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;
	private String cep;

	public int compareTo(Pessoa comp) {
		if (this.id < comp.id) {
			return -1;
		}
		if (this.id > comp.id) {
			return 1;
		}
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDocumento(){
		String doc = "";
		
		return doc;
	}	
}
