package br.com.ifinance.view;

import java.util.ArrayList;
import java.util.List;

import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.dao.PersistenciaDAO;

public class testeRecuperar {

	public static void main(String[] args) {
		
		PessoaFisica pfis = new PessoaFisica();
		
		List<PessoaFisica> lPFisica = new ArrayList<PessoaFisica>();
		
		lPFisica = (List<PessoaFisica>) PersistenciaDAO.restaurar("pfisica.txt");
		
		System.out.println(lPFisica.get(0).getNome()); 
		System.out.println(lPFisica.get(1).getNome()); 
		
	}
}
