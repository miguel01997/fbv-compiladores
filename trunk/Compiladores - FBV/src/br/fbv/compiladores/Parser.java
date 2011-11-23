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
		
		if(token.getClassificacao() == Token.PROGRAMA_OPEN) {
			tabela.push(new Simbolo(Token.PROGRAMA_OPEN, "<Programa>"));
			ler();
			if(token.getClassificacao() == Token.VARIAVEL_OPEN) {
				tabela.push(new Simbolo(Token.VALOR_OPEN, "<Variavel>"));
				ler();
				if(token.getClassificacao() == Token.INTEIRO_OPEN || token.getClassificacao() == Token.TEXTO_OPEN) {
					
					if(token.getClassificacao() == Token.INTEIRO_OPEN) {
						tabela.push(new Simbolo(Token.INTEIRO_OPEN, "<Inteiro>"));
						ler();
						if(token.getClassificacao() == Token.INTEIRO_CLOSE) {
							tabela.push(new Simbolo(Token.INTEIRO_CLOSE, "</Inteiro>"));
							ler();
						}
					} 
					
					if(token.getClassificacao() == Token.TEXTO_OPEN) {
						tabela.push(new Simbolo(Token.TEXTO_OPEN, "<Texto"));
						ler();
						if(token.getClassificacao() == Token.TEXTO_CLOSE) {
							tabela.push(new Simbolo(Token.TEXTO_CLOSE, "</Texto"));
							ler();
						}
					}
								
					if(token.getClassificacao() == Token.VARIAVEL_CLOSE) {
						tabela.push(new Simbolo(Token.VARIAVEL_CLOSE, "</Variavel"));
						ler();
						if(token.getClassificacao() == Token.OPERACAO_OPEN) {
							tabela.push(new Simbolo(Token.VARIAVEL_OPEN, "<Operacao>"));
							ler();
							if(token.getClassificacao() == Token.SOMA_OPEN || token.getClassificacao() == Token.SUB_OPEN) {
								//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							} else {
								throw new ExceptionSintatico("Erro - Esperado Token <Soma> ou <Sub> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
							}
						} else {
							throw new ExceptionSintatico("Erro - Esperado Token <Operacao> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
						}
					} else {
						throw new ExceptionSintatico("Erro - Esperado Token </Variavel> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
					}
				} else {
					throw new ExceptionSintatico("Erro - Esperado Token <Inteiro> ou <Texto> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
				}
			} else {
				throw new ExceptionSintatico("Erro - Esperado Token <Variavel> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
			}
		} else {
			throw new ExceptionSintatico("Erro - Esperado Token <Programa> " + "\n\tLinha: " + token.getLinha() + "\tColuna: " + token.getColuna());
		} // end if/else bloco principal
		

					else{
						ler();
						bloco();
						tk=null;
						ler();
						if(tk.getClassificacao()!=Token.FIM)
							throw new ExcecaoErroSintatico("Caracetere '" + tk.lexema + "' inesperado no final do programa"+"\tLinha: "+tk.getLinha()+" Coluna: "+tk.getColuna());
						}
				}
			}
		}
	} // end method inicio
	
} // end class Parser
