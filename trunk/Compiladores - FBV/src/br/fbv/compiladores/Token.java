package br.fbv.compiladores;

public class Token {

	/*
	 * Definição dos Tokens
	 */
	public static final int PROGRAMA_OPEN 	= 1;
	public static final int PROGRAMA_CLOSE 	= 2;
	
	public static final int VARIAVEL_OPEN	= 3;
	public static final int VARIAVEL_CLOSE	= 4;
	
	public static final int OPERACAO_OPEN	= 5;
	public static final int OPERACAO_CLOSE	= 6;
	
	public static final int RESPOSTA_OPEN	= 7;
	public static final int RESPOSTA_CLOSE	= 8;
	
	public static final int INTEIRO_OPEN	= 9;
	public static final int INTEIRO_CLOSE	= 10;
	
	public static final int TEXTO_OPEN		= 11;
	public static final int TEXTO_CLOSE		= 12;
	
	public static final int SOMA_OPEN		= 13;
	public static final int SOMA_CLOSE		= 14;
	
	public static final int SUB_OPEN		= 15;
	public static final int SUB_CLOSE		= 16;
	
	public static final int VALOR_OPEN		= 17;
	public static final int VALOR_CLOSE		= 18;
	
	public static final int RESULTADO_OPEN	= 19;
	public static final int RESULTADO_CLOSE	= 20;
	
	public static final int error 	= 21;
	public static final int eof 	= 22;
	
	private int classificacao;
	private int coluna;
	private int linha;
	private String lexema;
	
	/**
	 * @param classificacao
	 * @param coluna
	 * @param linha
	 * @param lexema
	 */
	public Token(int classificacao, int coluna, int linha, String lexema) {
		super();
		this.classificacao = classificacao;
		this.coluna = coluna;
		this.linha = linha;
		this.lexema = lexema;
	} // end constructor Token

	/**
	 * @return the classificacao
	 */
	public int getClassificacao() {
		return classificacao;
	}

	/**
	 * @return the coluna
	 */
	public int getColuna() {
		return coluna;
	}

	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @return the lexema
	 */
	public String getLexema() {
		return lexema;
	}

	/**
	 * @param classificacao the classificacao to set
	 */
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * @param coluna the coluna to set
	 */
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * @param lexema the lexema to set
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("Classificação..: " + this.classificacao +
				"\tLexema.......: " + this.lexema +
				"\tLinha........: " + this.linha +
				"\tColuna.......: " + this.coluna);
	} // end method toString
	
} // end class Token
