/**
 * 
 */
package br.fbv.compiladores;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ExceptionLexico, ExceptionSintatico, IOException {
		// TODO Auto-generated method stub
		Parser parser = null;
		FileInputStream arquivo;
		String nome = "exemplo.txt";

		try {
			arquivo	= new FileInputStream(nome);
			parser	= new Parser(arquivo);
			parser.inicio();
			System.out.println("Programa Compilado!");
		} catch(FileNotFoundException e1) {
			System.out.println("Arquivo de Programa n‹o encontrado!");
		} catch(IOException errorIO) {
			System.out.println(errorIO.getMessage());
		} catch(ExceptionLexico errorLexico) {
			System.out.println(errorLexico.getMessage());
		} catch (ExceptionSintatico errorSintatico) {
			System.out.println(errorSintatico.getMessage());
		} // end try/catch

	} // end method main

} // end class Main
