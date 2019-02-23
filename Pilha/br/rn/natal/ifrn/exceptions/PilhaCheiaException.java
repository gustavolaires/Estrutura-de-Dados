package br.rn.natal.ifrn.exceptions;

import java.lang.Exception;


public class PilhaCheiaException extends Exception {
	
	public PilhaCheiaException() {
		super("A pilha esta cheia.\nNao e possivel adicionar novos elementos.");
	}
	
}
