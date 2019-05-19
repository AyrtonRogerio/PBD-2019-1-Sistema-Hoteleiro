/**
 * 
 */
package br.com.sistemahoteleiro.util;

import java.util.Base64;

/**
 * @author ayrtons
 *
 */
public class Cryptography {

	/**
	 * Metodo para criptografar
	 * @param base
	 * @return
	 */
	public static String cryptography(byte[] base) {
		return Base64.getEncoder().encodeToString(base);
	}
	
	/**
	 * Metodo para descriptografar
	 * @param password
	 * @return
	 */
	public static String decryption(String password) {
		byte[] decode = Base64.getDecoder().decode(password);
		String decoded = new String(decode);
		return decoded;
	}
	
	/**
	 * Metodo para verificar se esta encriptografado
	 * @param password
	 * @return
	 */
	public static boolean isEncrypted(String password) {
		boolean is64 = password.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");
		try {
			if(is64) {
				password = decryption(password);
				is64 = password.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			is64 = false;
		}
		
		return is64;
	}
	
	
}
