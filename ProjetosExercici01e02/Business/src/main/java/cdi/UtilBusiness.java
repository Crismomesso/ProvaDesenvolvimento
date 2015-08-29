package main.java.cdi;

import java.io.IOException;
import java.io.InputStream;

public interface UtilBusiness {
	/**
	 * Converte um InputStream para uma String
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public String convertInputStreamToString(InputStream input)throws IOException;
	/**
	 * Verifica se existe letras na palavra 
	 * @param text
	 * @return
	 */
	public boolean hasLetter(String text);
}
