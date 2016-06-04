package br.com.ifinance.view;

import java.io.IOException;

import br.com.ifinance.dao.ReceitaDAO;

public class ifinance {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {

		ReceitaDAO receitaDAO = new ReceitaDAO();
		receitaDAO.addReceita("Salário", "01/06/2016", 2500.00, 2550.00, "05/06/2016");

	}
}
