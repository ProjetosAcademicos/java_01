package br.com.ifinance.view;

import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.dao.PersistenciaDAO;

public class testeRecuperar {

	public static void main(String[] args) {
		
		PessoaFisica pfis = new PessoaFisica();
		pfis = (PessoaFisica) PersistenciaDAO.restaurar("pfisica.txt");
		
		System.out.println(pfis.getNome()); 
		
	}
}
