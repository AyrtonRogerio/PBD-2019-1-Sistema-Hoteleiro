/**
 * 
 */
package br.com.sistemahoteleiro.util;

import java.io.BufferedReader;
import java.io.File;
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
		}  else if (System.getProperty("os.name").equalsIgnoreCase("Windows"))
			processBuilder = new ProcessBuilder("C:\\Program Files\\PostgreSQL\\10\\bin\\pg_dump.exe", "-i", "-h", "localhost",
					"-p", "5432", "-U", "postgres", "-F", "c", "-b", "-v", "-f", dir, "SistemaHotel");
		
		processBuilder.environment().put("PGPASSWORD", "postgres");
		processBuilder.redirectErrorStream(true);
		process = processBuilder.start();
		final InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
		bufferedReader = new BufferedReader(inputStreamReader);
		
		String line;
		
		String temp = null;
		
		int i = 0;
		
		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println("cond backup antes do if");
			if(i==0) {
				temp = line;
				System.out.println(temp);
			}
//			System.out.println("cond backup dps do if");
		}
		
		
	}

	
//	public static void main(String[] args) {
//		
//		try {
//			Backup.backup(System.getProperty("user.home")+"/backup");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println("/  -> " + new File("/").getCanonicalPath());
//			System.out.println(".. -> " + new File("..").getCanonicalPath());
//			System.out.println(".  -> " + new File(".").getCanonicalPath());
//			
//			 System.out.println( System.getProperty("user.home"));
//			 System.out.println( System.getProperty("user.desktop"));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
}
