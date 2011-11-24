package br.fbv.compiladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class Parser {

	private Scanner scanner;
	private Token token;
	public Stack<Simbolo> tabela;
	
	/**
	 * @param arquivo
	 */
	public Parser(FileInputStream arquivo) throws ExceptionLexico, IOException {
		scanner = new Scanner(arquivo);
		tabela	= new Stack<Simbolo>();
		token	= scanner.lerArquivo();		
	} // end constructor Parser
	
	public void ler() throws ExceptionLexico, ExceptionSintatico, IOException {
		Token temp = scanner.lerArquivo();
		if(temp != null) { 
			token = temp; 
		} else {
			return;
		}
	} // end method ler
	
	public void inicio() throws ExceptionLexico, ExceptionSintatico, IOException {
		//tabela.push(new Simbolo(Token.PROGRAMA_OPEN, "<Programa>"));
		if(token.getClassificacao().equals(Token.PROGRAMA_OPEN)) {
			ler();
			if(token.getClassificacao().equals(Token.VARIAVEL_OPEN)) {
				ler();
				if(token.getClassificacao().equals(Token.INTEIRO_OPEN) || token.getClassificacao().equals(Token.TEXTO_OPEN)) {
					if(token.getClassificacao().equals(Token.INTEIRO_OPEN)) {
						tabela.push(new Simbolo(token.INTEIRO_OPEN, token.toString()));
						System.out.println(token.getLexema());
					}
				} else {
					throw new ExceptionSintatico("Erro - Esperado Token <Inteiro> ou <Texto> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
				}
			} else {
				throw new ExceptionSintatico("Erro - Esperado Token <Variavel> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
			}
		} else {
			throw new ExceptionSintatico("Erro - Esperado Token <Programa> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
		} // end if/else
	} // end method inicio
	
} // end class Parser
