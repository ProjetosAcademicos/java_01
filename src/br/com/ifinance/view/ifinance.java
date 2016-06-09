package br.com.ifinance.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ifinance.beans.Receita;
import br.com.ifinance.dao.ReceitaDAO;

public class ifinance {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {

		Receita r1 = new Receita();
		Receita r2 = new Receita();
		ReceitaDAO dao = new ReceitaDAO();
		List<Receita> receitas = new ArrayList<Receita>();
		
		r1.setDescricao("Salário");
		r1.setDataVencimento(new Date());
		r1.setValorNominal(2500.00);
		r1.setBaixado(1);
		r1.setValorRecebido(2000.00);
		r1.setDataRecebimento(new Date());
		
		receitas.add(r1);
		
		r2.setDescricao("13 salário");
		r2.setDataVencimento(new Date());
		r2.setValorNominal(2500.00);
		r2.setBaixado(1);
		r2.setValorRecebido(2500.00);
		r2.setDataRecebimento(new Date());
		
		receitas.add(r2);
		
		dao.addReceitas(receitas);
		dao.lerReceitas("receitas.txt");

	}
}
