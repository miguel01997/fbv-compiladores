package br.fbv.compiladores;

public class Simbolo {

	private String tipo;
	private String lexema;
	
	/**
	 * @param tipo
	 * @param lexema
	 */
	public Simbolo(String tipo, String lexema) {
		super();
		this.tipo = tipo;
		this.lexema = lexema;
	} // end constructor Simbolo

	/**
	 * @return the tipo
	 */
	public String getTipo() {
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
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param lexema the lexema to set
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
} // end class Simbolo
