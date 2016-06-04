package br.com.ifinance.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

//	public static void salvar2(ArrayList<Object> lista, String caminho) {
//		try {
//			FileOutputStream saveFile = new FileOutputStream(caminho);
//			ObjectOutputStream stream = new ObjectOutputStream(saveFile);
//
//			// salva o objeto
//			stream.writeObject(lista);
//
//			stream.close();
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}
//	}
	
	/**
	 * recuperar qlq objeto do arquivo *.txt para memoria
	 * @param caminho do arquivo txt
	 * @return objeto requisitado
	 */
	public static Object restaurar(String caminho) {

		Object objeto = null;

		try {
			FileInputStream restFile = new FileInputStream(caminho);
			ObjectInputStream stream = new ObjectInputStream(restFile);

			// recupera o objeto
			objeto = stream.readObject();

			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objeto;
	}

}
