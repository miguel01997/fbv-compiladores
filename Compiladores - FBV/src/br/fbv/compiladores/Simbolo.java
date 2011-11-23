package br.fbv.compiladores;

public class Simbolo {

	private int tipo;
	private String lexema;
	
	/**
	 * @param tipo
	 * @param lexema
	 */
	public Simbolo(int tipo, String lexema) {
		super();
		this.tipo = tipo;
		this.lexema = lexema;
	} // end constructor Simbolo

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @return the lexema
	 */
	public String getLexema() {
		return lexema;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param lexema the lexema to set
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
} // end class Simbolo
