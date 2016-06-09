package br.com.ifinance.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaDAO {

	/**
	 * O arquivo eh aberto em uma FileOutputStream . Caso o arquivo nao exista,
	 * ele eh criado. Eh criado um ObjectOutputStream a partir da stream
	 * anterior. Ao escrever no ObjectOutputStream, os dados sao enviados por
	 * meio do FileOutputStream para o arquivo fisico. Por fim, a stream eh
	 * fechada.
	 * 
	 * @param objeto
	 *            passar o objeto a ser persistida
	 * @param caminho
	 *            do arquivo txt
	 * 
	 */
	public static void salvar(Object objeto, String caminho) {
		try {
			FileOutputStream saveFile = new FileOutputStream(caminho);
			ObjectOutputStream stream = new ObjectOutputStream(saveFile);

			// salva a lista de objetos no arquivo .txt"
			stream.writeObject(objeto);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperar a lista de objetos do arquivo .txt para memoria
	 * 
	 * @param caminho
	 *            do arquivo txt
	 * @return lista de objetos requisitada
	 */
	@SuppressWarnings("unchecked")
	public static Object ler(String caminho) {

		List<Object> objetos = new ArrayList<Object>();

		try {
			FileInputStream restFile = new FileInputStream(caminho);
			ObjectInputStream stream = new ObjectInputStream(restFile);
			// recupera a lista de objetos do arquivo
			objetos = (List<Object>) stream.readObject();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objetos;
	}

}
