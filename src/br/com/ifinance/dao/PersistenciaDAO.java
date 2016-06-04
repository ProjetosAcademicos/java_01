package br.com.ifinance.dao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PersistenciaDAO {

	
	/**
	 * O arquivo é aberto em uma FileOutputStream . Caso o arquivo não exista,
	 * ele é criado. É criado um ObjectOutputStream a partir da stream anterior.
	 * Ao escrever no ObjectOutputStream, os dados são enviados por meio da
	 * FileOutputStream para o arquivo físico. Por fim, a stream é fechada.
	 * 
	 * @param objeto
	 *            passar o objeto a ser persistido
	 * @param caminho
	 *            do arquivo txt
	 * 
	 */
	public static void salvar(Object objeto, String caminho) {
		try {
			FileOutputStream saveFile = new FileOutputStream(caminho);
			ObjectOutputStream stream = new ObjectOutputStream(saveFile);

			// salva o objeto
			stream.writeObject(objeto);

			stream.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	

}
