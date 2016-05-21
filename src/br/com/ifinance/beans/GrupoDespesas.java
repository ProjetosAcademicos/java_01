package br.com.ifinance.beans;

import java.util.LinkedList;

public class GrupoDespesas {

	private String descricaoGrupo;

	private Movimento movimento;

	private LinkedList<Despesa> despesas;

	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}

	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public LinkedList<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(LinkedList<Despesa> despesas) {
		this.despesas = despesas;
	}

}
