/**
 * 
 */
package br.fbv.compiladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Scanner {

	private static boolean flag = false;
	private static int coluna;
	private static int linha;
	private static char ε;
	
	private FileInputStream arquivo;
	public Map<String, Integer> tkLexico;
	
	/**
	 * 
	 */
	public Scanner(FileInputStream arquivo) throws IOException {
		super();
		coluna = 0;
		linha  = 1;
		ε = ' ';
		this.arquivo = arquivo;
		
		tkLexico = new HashMap<String, Integer>();
		
		tkLexico.put("<Programa>", Token.PROGRAMA_OPEN);
		tkLexico.put("</Programa>", Token.PROGRAMA_CLOSE);
		
		tkLexico.put("<Variavel>", Token.VARIAVEL_OPEN);
		tkLexico.put("</Variavel>", Token.VARIAVEL_CLOSE);
		
		tkLexico.put("<Operacao>", Token.OPERACAO_OPEN);
		tkLexico.put("</Operacao>", Token.OPERACAO_CLOSE);
		
		tkLexico.put("<Resposta>", Token.RESPOSTA_OPEN);
		tkLexico.put("</Resposta>", Token.RESPOSTA_CLOSE);
		
		tkLexico.put("<Inteiro>", Token.INTEIRO_OPEN);
		tkLexico.put("</Inteiro>", Token.INTEIRO_CLOSE);
		
		tkLexico.put("<Texto>", Token.TEXTO_OPEN);
		tkLexico.put("</Texto>", Token.TEXTO_CLOSE);
		
		tkLexico.put("<Soma>", Token.SOMA_OPEN);
		tkLexico.put("</Soma>", Token.SOMA_CLOSE);
		
		tkLexico.put("<Sub>", Token.SUB_OPEN);
		tkLexico.put("</Sub>", Token.SUB_CLOSE);
		
		tkLexico.put("<Valor>", Token.VALOR_OPEN);
		tkLexico.put("</Valor>", Token.VALOR_CLOSE);
		
		tkLexico.put("<Resultado>", Token.RESULTADO_OPEN);
		tkLexico.put("</Resultado>", Token.RESULTADO_CLOSE);
		
	} // end constructor Scanner
	
	public int isTkLexico(String str) {
		if(tkLexico.containsKey(str)) {
			return tkLexico.get(str);
		} else {
			return -1;
		}
	} // end method isTkLexico
	
	public Token percorrerArquivo() throws ExceptionLexico, IOException {
		Token tk = null;
		String lexema = "";
		
		do {
			this.flag = false;
			percorrerVazio();
		} while (this.flag==true);
		
   	 	if(tk != null) { return tk; }
   	 	
   	 	tk = Identificador(lexema);
   	 	
   	 	if(tk != null) { return tk; }
   	
   	 	if(ε != 3) {
   	 		throw new ExceptionLexico("Erro na linha " + linha + ", coluna " + coluna);
   	 	}
   	 	
   	 	return new Token(coluna, Token.eof, linha, "");
		
	} // end method lerArquivo
	
	public Token lerArquivo() throws ExceptionLexico, IOException {
		Token tk;
		tk = percorrerArquivo();
		return tk;
	} // end method lerArquivo
	
	public void percorrerVazio() throws IOException {
		while (ε == ' ' || ε == '\n' || ε == '\t' || ε == 9 || ε == 13) {
			if(ε == 13) {
				coluna = 0;
				linha++;
				ε = lerCaractere();
			} else if (ε == 9) {
				coluna += 8;
			} else if (ε == '\t') {
				coluna += 8;
			} else if (ε == '\n') {
				coluna = 1;
				linha++;
			}
			
			ε = lerCaractere();
			coluna++;
 		} // end loop while
		
	} // end method percorrerVazio
	
	public char lerCaractere() throws IOException{
		int r = arquivo.read();
		if(r != -1) { return (char) r; }
		return (char) 3;		
	} // end method lerCaratere
	
	public Token Identificador(String lexema) throws IOException {
		
		if(Character.isLetter(ε)) {
			lexema += ε;
			ε = lerCaractere();
			coluna++;
			
			while (Character.isLetterOrDigit(ε)) {
				lexema += ε;
				ε = lerCaractere();
				coluna++;
			} // end loop while
			
			int r = isTkLexico(lexema);
			
			if(r != -1) {
				return new Token(coluna, r, linha, lexema);
			} else {
				return new Token(coluna, Token.PROGRAMA_OPEN, linha, lexema);
			} // end if
			
		} // end if
		return null;
	} // end method Identificador
	
} // end class Scanner
