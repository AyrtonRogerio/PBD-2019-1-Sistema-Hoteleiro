/**
 * 
 */
package br.com.sistemahoteleiro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ayrton
 *
 */
public class Backup {

	public static void backup(String dir) throws IOException {

		ProcessBuilder processBuilder = null;
		Process process;
		BufferedReader bufferedReader = null;

		if (System.getProperty("os.name").equalsIgnoreCase("linux")) {

			processBuilder = new ProcessBuilder("/usr/bin/pg_dump", "--file", dir, "--host", "localhost", "--port",
					"5432", "--username", "postgres", "--no-password", "--verbose", "--format=t", "--blobs",
					"SistemaHotel");
		}
		
		processBuilder.environment().put("PGPASSWORD", "postgres");
		processBuilder.redirectErrorStream(true);
		process = processBuilder.start();
		final InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
		bufferedReader = new BufferedReader(inputStreamReader);
		
		String line;
		
		String temp = null;
		
		int i = 0;
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("cond backup antes do if");
			if(i==0) {
				temp = line;
			}
			System.out.println("cond backup dps do if");
		}
		
		
	}

}
