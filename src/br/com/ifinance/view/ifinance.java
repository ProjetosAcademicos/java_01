package br.com.ifinance.view;

import java.io.IOException;

import br.com.ifinance.dao.ReceitaDAO;

public class ifinance {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ReceitaDAO receitaDAO = new ReceitaDAO();
		receitaDAO.addReceita("Conta de Luz", "30/05/2016", 123.99, 123.99, "25/05/2016");
		receitaDAO.addReceita("Conta de Água", "28/05/2016", 150.92, 150.92, "25/05/2016");
		receitaDAO.addReceita("Condomínio", "05/05/2016", 250.00, 250.00, "01/05/2016");
		receitaDAO.ReadMovimentacao();
	}

}
