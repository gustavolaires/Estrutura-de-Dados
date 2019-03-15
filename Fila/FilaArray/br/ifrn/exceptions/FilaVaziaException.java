package br.ifrn.exceptions;

import java.lang.Exception;

public class FilaVaziaException extends Exception {

	public FilaVaziaException() {
		super("A fila esta vazia.\nNao ha elementos para remover.");
	}
}
