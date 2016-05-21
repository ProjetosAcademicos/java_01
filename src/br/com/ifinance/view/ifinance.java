package br.com.ifinance.view;

import java.util.Date;

import br.com.ifinance.beans.Movimento;
import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.Usuario;

public class ifinance {

	public static void main(String[] args) {
		PessoaFisica gio = new PessoaFisica();
		gio.setNome("Giovanni Nicoletti");
		gio.setBairro("lagoa nova");
		gio.setCep("59064370");
		gio.setCidade("natal");
		gio.setCpf("03464888427");
		gio.setEndereco("rua anibal correia");
		
		Movimento dAgua = new Movimento();
		dAgua.setDataVencimento(new Date(2016, 05, 10));
		dAgua.setDescricao("Agua");
		dAgua.setTipoMovimento('D');
		dAgua.setValorNominal(200.0);		
		gio.setMovimento(dAgua);
		
		Usuario uGiovanni = new Usuario();
		uGiovanni.setLogin("gioNic");
		uGiovanni.setSenha("123");
		
		gio.setUsuario(uGiovanni);	
		
		System.out.println("inicio do funcionamento do sistema ... ");
		
		
	}

}
