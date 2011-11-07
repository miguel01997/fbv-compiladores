
package br.fbv.compiladores.projeto;

import java_cup.runtime.Symbol;

%%

%class Lexer
%cup

whiteSpace=([ \n\t\f\r]+)
numero=[0-9]

%%

{whiteSpace} { 
	// Expressao para caracteres ignorados (espacos).
	// Nenhum token e retornado.
}

";" { return new Symbol(sym.PT_VIRG); }
"+" { return new Symbol(sym.MAIS); }
"-" { return new Symbol(sym.MENOS); }
"*" { return new Symbol(sym.VEZES); }
"/" { return new Symbol(sym.DIVIDIDO); }
"(" { return new Symbol(sym.ABRE_PAR); }
")" { return new Symbol(sym.FECHA_PAR); }

{numero}+  { return new Symbol(sym.NUMERO, new Integer(yytext())); }

. { 
    // Casa com qualquer caracter que não casar com as expressoes anteriores.
    System.out.println("Illegal character : " + yytext());
    return new Symbol(sym.error);
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Symbol(sym.EOF);
}

