package br.com.ifinance.view;

import java.io.IOException;

import br.com.ifinance.dao.ReceitaDAO;

public class ifinance {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ReceitaDAO receitaDAO = new ReceitaDAO();
		//receitaDAO.addReceita("Salário", "30/05/2016", 2500.00, 2140.00, "25/05/2016");
		//receitaDAO.addReceita("Conta de água", "30/05/2016", 150.99, 160.00, "30/05/2016");
		//receitaDAO.addReceita("Conta de Internet", "30/05/2016", 140.99, 100.00, "31/05/2016");
		//receitaDAO.addReceita("Parcela do condomínio", "31/05/2016", 250.00, 250.00, "31/05/2016");
		receitaDAO.LerMovimentacao("Receita");
		//receitaDAO.LerReceitas();
	}

}
