package br.rn.natal.ifrn.exceptions;

import java.lang.Exception;

public class PilhaVaziaException extends Exception {
	
	public PilhaVaziaException() {
		super("A pilha esta vazia.\nNao ha elementos para remover.");
	}
}
