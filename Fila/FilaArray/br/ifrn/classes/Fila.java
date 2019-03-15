package br.ifrn.classes;

import br.ifrn.interfaces.FilaInterface;
import br.ifrn.exceptions.FilaVaziaException;

public class Fila implements FilaInterface{
	
	private int indexBegin;
	private int indexEnd;
	private Object[] elements;
	
	/*
	 * Construtor
	 * 
	 */
	public Fila() {
		this.indexBegin = 0;
		this.indexEnd = 0;
		this.elements = new Object[2];
	}

	/*
	 * Adiciona um novo elemento no final da fila
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean enfileirar(Object e) {
		if( this.tamanho() == this.elements.length - 1) {
			Object[] tmp = new Object[ 2 * this.elements.length];
			
			int indexTmp = this.indexBegin;
			int elementsLength = this.elements.length;
			
			while( indexTmp % elementsLength != this.indexEnd) {
				tmp[ indexTmp] = this.elements[ indexTmp % elementsLength];
				indexTmp += 1;
			}
			
			this.elements = tmp;
			this.indexEnd = indexTmp;
		}
		
		this.elements[this.indexEnd] = e;
		this.indexEnd = ( this.indexEnd + 1) % this.elements.length;
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
		
		Object begin = this.elements[this.indexBegin];
		this.indexBegin = (this.indexBegin + 1) % this.elements.length;
		return begin;
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
		return this.elements[this.indexBegin];
		
	}

	/*
	 * Informa o numero de elementos da fila - tamanho da fila
	 * 
	 * @ return int
	 */
	public int tamanho() {
		return ( ( this.indexEnd - this.indexBegin + this.elements.length )
					% this.elements.length );
	}

	/*
	 * Informa se a fila esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean estaVazia() {
		if( this.indexBegin == this.indexEnd) {
			return true;
		}
		else return false;
	}
}
