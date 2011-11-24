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
	private static char vazio;
	
	private FileInputStream arquivo;
	public Map<String, String> tkLexico;
	
	/**
	 * 
	 */
	public Scanner(FileInputStream arquivo) throws IOException {
		super();
		coluna = 0;
		linha  = 1;
		vazio = ' ';
		this.arquivo = arquivo;
		
		tkLexico = new HashMap<String, String>();
		
		tkLexico.put("<Programa>", Token.PROGRAMA_OPEN);
//		tkLexico.put("</Programa>", Token.PROGRAMA_CLOSE);
//		
//		tkLexico.put("<Variavel>", Token.VARIAVEL_OPEN);
//		tkLexico.put("</Variavel>", Token.VARIAVEL_CLOSE);
//		
//		tkLexico.put("<Operacao>", Token.OPERACAO_OPEN);
//		tkLexico.put("</Operacao>", Token.OPERACAO_CLOSE);
//		
//		tkLexico.put("<Resposta>", Token.RESPOSTA_OPEN);
//		tkLexico.put("</Resposta>", Token.RESPOSTA_CLOSE);
//		
//		tkLexico.put("<Inteiro>", Token.INTEIRO_OPEN);
//		tkLexico.put("</Inteiro>", Token.INTEIRO_CLOSE);
//		
//		tkLexico.put("<Texto>", Token.TEXTO_OPEN);
//		tkLexico.put("</Texto>", Token.TEXTO_CLOSE);
//		
//		tkLexico.put("<Soma>", Token.SOMA_OPEN);
//		tkLexico.put("</Soma>", Token.SOMA_CLOSE);
//		
//		tkLexico.put("<Sub>", Token.SUB_OPEN);
//		tkLexico.put("</Sub>", Token.SUB_CLOSE);
//		
//		tkLexico.put("<Valor>", Token.VALOR_OPEN);
//		tkLexico.put("</Valor>", Token.VALOR_CLOSE);
//		
//		tkLexico.put("<Resultado>", Token.RESULTADO_OPEN);
//		tkLexico.put("</Resultado>", Token.RESULTADO_CLOSE);
		
	} // end constructor Scanner
	
	public String isTkLexico(String str) {
		if(tkLexico.containsKey(str)) {
			return tkLexico.get(str);
		} else {
			return null;
		}
	} // end method isTkLexico
	
	public Token percorrerArquivo() throws ExceptionLexico, IOException {
		Token tk2 = null;
		String lexema = "";

		do {
			this.flag = false;
			percorrerVazio();
		} while (this.flag == true);
		
   	 	if(tk2 != null) { return tk2; }
   	 	
   	 	tk2 = Identificador(lexema);
   	 	
   	 	if(tk2 != null) { return tk2; }

   	 	if(vazio != 3) {
   	 		throw new ExceptionLexico("Erro na linha " + linha + ", coluna " + coluna);
   	 	}
   	 	
   	 	return new Token(Token.eof, coluna, linha, "");
		
	} // end method lerArquivo
	
	public Token lerArquivo() throws ExceptionLexico, IOException {
		Token tk;
		tk = percorrerArquivo();
		return tk;
	} // end method lerArquivo
	
	public void percorrerVazio() throws IOException {
		while (vazio == ' ' || vazio == '\n' || vazio == '\t' || vazio == 9 || vazio == 13) {
			if(vazio == 13) {
				coluna = 0;
				linha++;
				vazio = lerCaractere();
			} else if (vazio == 9) {
				coluna += 8;
			} else if (vazio == '\t') {
				coluna += 8;
			} else if (vazio == '\n') {
				coluna = 1;
				linha++;
			}
			
			vazio = lerCaractere();
			coluna++;
 		} // end loop while
		
	} // end method percorrerVazio
	
	public char lerCaractere() throws IOException{
		int r = arquivo.read();
		if(r != -1) { return (char) r; }
		return (char) 3;		
	} // end method lerCaratere
	
	public Token Identificador(String lexema) throws IOException {
		
		if(Character.isDefined(vazio)) {
			lexema += vazio;
			vazio = lerCaractere();
			coluna++;
			
			while (Character.isLetterOrDigit(vazio) || Character.isDefined('/') || Character.isDefined('>')) {
				lexema += vazio;
				vazio = lerCaractere();
				coluna++;
				if(vazio == '>') {
					lexema += vazio;
					vazio = lerCaractere();
					coluna++;
					break;
				}
			} // end loop while
			
			String r = isTkLexico(lexema);
			
			if(r != null) {
				return new Token(r, coluna, linha, lexema);
			} else {
				return new Token(Token.PROGRAMA_OPEN, coluna, linha, lexema);
			} // end if
			
		} // end if
		return null;
	} // end method Identificador
	
} // end class Scanner
