package br.fbv.compiladores.projeto;

import java.io.FileInputStream;


/**
 * Exemplo de integracao do analisador lexico (gerador pelo JLex) com o parser
 * (gerador pelo CUP). Este exemplo usa um arquivo como entrada.
 */

public class Main {

	public static void main(String args[]) throws Exception {
		Lexer lexer = new Lexer(new FileInputStream("exemplo.txt"));
		Parser parser = new Parser(lexer);

		parser.parse();

		System.out.println("Codigo interpretado com sucesso!");
	}

}
