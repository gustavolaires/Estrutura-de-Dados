package br.ifrn.exceptions;

import java.lang.Exception;

public class SequenceLDEException extends Exception {
	
	public SequenceLDEException() {
		super("Posicao invalida na sequencia.\n");
	}
}
