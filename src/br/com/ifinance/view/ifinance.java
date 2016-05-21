package br.com.ifinance.view;

import java.util.ArrayList;
import java.util.Date;

import br.com.ifinance.beans.Despesa;
import br.com.ifinance.beans.PessoaFisica;
import br.com.ifinance.beans.Usuario;

public class ifinance {

	public static void main(String[] args) {
		PessoaFisica gio = new PessoaFisica();
		gio.setNome("Giovanni Nicoletti");
		gio.setBairro("Lagoa Nova");
		gio.setCep("59064370");
		gio.setCidade("Natal");
		gio.setCpf("03464888427");
		gio.setEndereco("Rua Anibal Correia");
		
		Usuario uGiovanni = new Usuario();
		uGiovanni.setLogin("gioNic");
		uGiovanni.setSenha("123");		
		gio.setUsuario(uGiovanni);	
		
		Despesa dAgua = new Despesa();		
		dAgua.setDataVencimento(new Date(2016, 05, 10));
		dAgua.setDescricao("Agua");
		dAgua.setTipoMovimento('D');
		dAgua.setValorNominal(200.0);
		dAgua.setValorPago(205.09);
		
		//new ArrayList<Movimento>();
		gio.setMovimento(dAgua);
		
		System.out.println("Inicio do Funcionamento do Sistema ... ");
		System.out.println( ((Despesa) gio.getMovimento()).getValorPago() );
		
		
	}

}
