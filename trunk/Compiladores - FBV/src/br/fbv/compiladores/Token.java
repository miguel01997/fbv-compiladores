package br.fbv.compiladores;

public class Token {

	/*
	 * Definição dos Tokens
	 */
	public static final String PROGRAMA_OPEN 	= "<Programa>";
	public static final String PROGRAMA_CLOSE 	= "</Programa>";
	
	public static final String VARIAVEL_OPEN	= "<Variavel>";
	public static final String VARIAVEL_CLOSE	= "</Variavel>";
	
	public static final String OPERACAO_OPEN	= "<Operacao>";
	public static final String OPERACAO_CLOSE	= "</Operacao>";
	
	public static final String RESPOSTA_OPEN	= "<Resposta>";
	public static final String RESPOSTA_CLOSE	= "</Resposta>";
	
	public static final String INTEIRO_OPEN		= "<Inteiro>";
	public static final String INTEIRO_CLOSE	= "</Inteiro>";
	
	public static final String TEXTO_OPEN		= "<Texto>";
	public static final String TEXTO_CLOSE		= "</Texto>";
	
	public static final String SOMA_OPEN		= "<Soma>";
	public static final String SOMA_CLOSE		= "</Soma>";
	
	public static final String SUB_OPEN			= "<Sub>";
	public static final String SUB_CLOSE		= "</Sub>";
	
	public static final String VALOR_OPEN		= "<Valor>";
	public static final String VALOR_CLOSE		= "</Valor>";
	
	public static final String RESULTADO_OPEN	= "<Resultado>";
	public static final String RESULTADO_CLOSE	= "</Resultado>";
	
	public static final String eof 	 = "";
	
	private String classificacao;
	private int coluna;
	private int linha;
	private String lexema;
	
	/**
	 * @param classificacao
	 * @param coluna
	 * @param linha
	 * @param lexema
	 */
	public Token(String classificacao, int coluna, int linha, String lexema) {
		super();
		this.classificacao = classificacao;
		this.coluna = coluna;
		this.linha = linha;
		this.lexema = lexema;
	} // end constructor Token

	/**
	 * @return the classificacao
	 */
	public String getClassificacao() {
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
	public void setClassificacao(String classificacao) {
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
