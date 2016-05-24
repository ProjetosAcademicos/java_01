package br.com.ifinance.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MovimentoDAO {

	protected InputStream input;
	protected OutputStream output;

	// Declaracao do construtor da classe inicializando
	// as variaveis de leitura e escrita no arquivo
	public MovimentoDAO() throws FileNotFoundException {

		input = new FileInputStream("/home/josinaldo/arquivo.txt");
		output = new FileOutputStream("/home/josinaldo/arquivo.txt", true);

	}

	// Metodo para escerver um movimentacao no arquivo
	// Este metodo esta funcionando corretamente, entretanto
	// a codificacaco do arquivo ainda esta incorreta.
	public void WriteMovimentacao(String movimento) throws IOException {

		/*
		 * ObjectOutputStream osw = new ObjectOutputStream(output);
		 * osw.writeObject(movimento); osw.flush(); // Forcando a escrita do
		 * objeto osw.close(); // Fechando o metodo que escreve o objeto
		 * output.flush(); // Forcando a escrita no arquivo output.close(); //
		 * Fechando a escrita no arquivo
		 */
		OutputStreamWriter bufferOut = new OutputStreamWriter(output, "UTF-8");
		bufferOut.write(movimento);
		bufferOut.write("...\n");
		bufferOut.close();
	}

	// Metodo que realiza apenas a leitura de todos os dados
	// do arquivo e retorna uma string que contem os dados
	public void ReadMovimentacao() throws IOException, ClassNotFoundException {

		/*
		 * ObjectInputStream object = new ObjectInputStream(input); return
		 * object.readObject();
		 */
		BufferedReader bufferIn = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		String linha = bufferIn.readLine();
		while (linha != null) {
			System.out.println(linha);
			linha = bufferIn.readLine();

		}
		bufferIn.close();
	}

}
