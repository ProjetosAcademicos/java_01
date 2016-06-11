package br.com.ifinance.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ifinance.beans.Despesa;
import br.com.ifinance.beans.Pessoa;


public class DespesaDAO {
	private List<Despesa> listaDespesas;
	
	
	@SuppressWarnings("unchecked")
	public DespesaDAO() throws NullPointerException {
		try {
			listaDespesas = (List<Despesa>) PersistenciaDAO.ler("despesa.txt");	
		
		} catch (NullPointerException e) {
		}
	}
	
	public void addDespesa (Despesa desp){
		if (listaDespesas == null)
			listaDespesas = new ArrayList<Despesa>();
		
		
		try {
			desp.setId(Collections.max(listaDespesas).getId() + 1);
			
		} catch (Exception e) {
			desp.setId(1);
		}
		
		
		listaDespesas.add(desp);
		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (Exception e) {
			System.out.println("Erro incluindo despesa.");
		}
	}

	public List<Despesa> listar(){
		return listaDespesas;
	}
	
	public List<Despesa> listar(Pessoa fornecedor, int baixado){
		List<Despesa> lResult = new ArrayList<Despesa>();		
		return lResult;
	}
	
	public Despesa procurar(String documento) {
		return listaDespesas.stream()
					  .filter( 
						 obj ->  obj.getDocumento().equals(documento)
					  )
					  .findFirst().orElse(null);
	}	

	public void baixaDespesas(String documento, double valorPago, String dataPgto) {
		for (Despesa despesa : listaDespesas) {
			if (despesa.getDocumento().equals(documento)) {
				despesa.baixar(valorPago, dataPgto);
			}
		}

		try {
			PersistenciaDAO.salvar(listaDespesas, "despesa.txt");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro baixando despesa.");
		}
				
	}	

	

}
