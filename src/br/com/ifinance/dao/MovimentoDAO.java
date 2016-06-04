package br.com.ifinance.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import br.com.ifinance.beans.Movimento;

public class MovimentoDAO {

	protected InputStream input;
	protected OutputStream output;

	// Declaracao do construtor da classe inicializando
	// as variaveis de leitura e escrita no arquivo
	public MovimentoDAO() throws FileNotFoundException {

	}

	// Metodo para escerver um movimentacao no arquivo
	// Este metodo esta funcionando corretamente, entretanto
	// a codificacaco do arquivo ainda esta incorreta.
	public void EscreverMovimentacao(Movimento movimento, String caminho)
			throws IOException {
		try {
			output = new FileOutputStream("/home/josinaldo/" + caminho, true);
			ObjectOutputStream outputStream = new ObjectOutputStream(output);
			outputStream.writeObject(movimento);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo que realiza apenas a leitura de todos os dados
	// do arquivo e retorna uma string que contem os dados
	public void LerMovimentacao(String caminho) throws IOException,
			ClassNotFoundException {
		try {
			input = new FileInputStream("/home/josinaldo/" + caminho);
			ObjectInputStream inputObject = new ObjectInputStream(input);
			Movimento m = (Movimento) inputObject.readObject();
			System.out.println(m.getDescricao());
			System.out.println(m.getValorNominal());
			System.out.println(m.getDataVencimento());
		} catch (Exception e) {
			throw new RuntimeException(
					"Erro ao deserializar o objeto vindo do arquivo.", e);
		}
	}

}
