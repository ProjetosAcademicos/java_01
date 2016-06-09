package br.com.ifinance.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifinance.beans.Movimento;
import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.Usuario;
import br.com.ifinance.dao.PersistenciaDAO;

public class testeSalvar {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<PessoaFisica> lFisica = new ArrayList<PessoaFisica>();
		
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
		
		lFisica.add(gio);
		
		PessoaFisica gio2 = new PessoaFisica("0346548887");
		gio2.setBairro("Lagoa Nova");
		gio2.setCep("59064300");
		gio2.setCidade("Natal");
		gio2.setEndereco("rua rodolfo garcia");
		gio2.setNome("Glaudson Marcel");

		Movimento cpLuz2 = new Movimento();
		cpLuz2.setDataVencimento("05-06-2017");
		cpLuz2.setDescricao("Conta de LUZ");
		cpLuz2.setValorNominal(1234.3);
		gio2.setMovimento(cpLuz2);
		
		Usuario u2 = new Usuario();
		u2.setLogin("loginGiovanni");
		u2.setSenha("123");
		gio.setUsuario(u2);
		
		lFisica.add(gio2);

		PersistenciaDAO.salvar(lFisica, "pfisica.txt");
		
	}
	
}
