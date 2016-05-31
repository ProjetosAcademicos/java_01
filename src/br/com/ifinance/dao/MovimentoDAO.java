package br.com.ifinance.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
	public void EscreverMovimentacao(String movimento) throws IOException {
		OutputStreamWriter bufferOut = new OutputStreamWriter(output, "UTF-8");
		bufferOut.write(movimento);
		bufferOut.close();
	}

	// Metodo que realiza apenas a leitura de todos os dados
	// do arquivo e retorna uma string que contem os dados
	public void LerMovimentacao(String tipoMovimentacao) throws IOException, ClassNotFoundException {

		Path caminho = Paths
				.get(System.getProperty("user.home"), tipoMovimentacao);
		Stream<String> linhas = Files.lines(caminho);
		linhas.forEach(System.out::println);
		linhas.close();
	}

}
