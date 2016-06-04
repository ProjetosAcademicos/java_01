package br.com.ifinance.view;

import br.com.ifinance.beans.Movimento;
import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.Usuario;
import br.com.ifinance.dao.PersistenciaDAO;

public class testeSalvar {
	
	public static void main(String[] args) {
		PessoaFisica gio = new PessoaFisica("0346548887");
		gio.setBairro("Lagoa Nova");
		gio.setCep("59064300");
		gio.setCidade("Natal");
		gio.setEndereco("rua rodolfo garcia");
		gio.setNome("Giovanni Nicoletti");

		Movimento cpLuz = new Movimento();
		cpLuz.setDataVencimento("05-06-2017");
		cpLuz.setDescricao("Conta de LUZ");
		cpLuz.setValorNominal(1234.3);
		gio.setMovimento(cpLuz);
		
		Usuario u = new Usuario();
		u.setLogin("loginGiovanni");
		u.setSenha("123");
		gio.setUsuario(u);
		
		PersistenciaDAO.salvar(gio, "pfisica.txt");
		
	}
	
}
