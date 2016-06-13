package br.com.ifinance.utils;

public class Formatacao {
	public static String formata(String texto, String sentido, int NumCaracteres) {
		String formatado;
		int Qtde;

		formatado = texto;
		if (formatado == null)
			formatado = "";
		
		Qtde = NumCaracteres - formatado.length();
		if (Qtde <= 0)
			formatado = formatado.substring(0, NumCaracteres);
		else {
			if (sentido == "E") {
				for (int i = 0; i < Qtde; i = i + 1) {
					formatado = " " + formatado;
				}
			} else {
				for (int i = 0; i < Qtde; i = i + 1) {
					formatado = formatado + " ";
				}
			}

		}
		return formatado;
	}
}
