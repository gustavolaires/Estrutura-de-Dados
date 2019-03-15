package br.ifrn.classes;

import br.ifrn.interfaces.FilaInterface;
import br.ifrn.exceptions.FilaVaziaException;

import br.ifrn.classes.No;

public class FilaLL implements FilaInterface{
	
	private No indexBegin;
	private No indexEnd;
	private int tamanho;
	
	/*
	 * Construtor
	 * 
	 */
	public FilaLL() {
		this.indexBegin = null;
		this.indexEnd = null;
		this.tamanho = 0;
	}

	/*
	 * Adiciona um novo elemento no final da fila
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean enfileirar(Object e) {
		No novoNo = new No();
		novoNo.setElement(e);
		novoNo.setNxtNo(null);
		
		if( this.estaVazia() ) {
			this.indexBegin = novoNo;
		}
		else {
			this.indexEnd.setNxtNo(novoNo);
		}
		
		this.tamanho += 1;
		this.indexEnd = novoNo;
		return true;
	}

	/*
	 * Retorna o elemento do inicio da fila e o remove da fila
	 * 
	 * @ return Object
	 */
	public Object desenfileirar() throws FilaVaziaException {
		if( this.estaVazia() ) {
			throw new FilaVaziaException();
		}
		
		No begin = this.indexBegin;
		this.indexBegin = this.indexBegin.getNxtNo();
		this.tamanho -= 1;
		return begin.getElement();
	}

	/*
	 * Retorna o elemento do inicio da fila
	 * 
	 * @ return Object
	 */
	public Object inicio() throws FilaVaziaException {
		if( this.estaVazia() ) {
			throw new FilaVaziaException();
		}
		return this.indexBegin.getElement();
		
	}

	/*
	 * Informa o numero de elementos da fila - tamanho da fila
	 * 
	 * @ return int
	 */
	public int tamanho() {
		return this.tamanho;
	}

	/*
	 * Informa se a fila esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean estaVazia() {
		if( this.indexBegin == null) {
			return true;
		}
		return false;
	}
}