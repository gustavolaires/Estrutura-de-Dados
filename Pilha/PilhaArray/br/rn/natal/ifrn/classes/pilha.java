package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.interfaces.EstruturaPilha;
import br.rn.natal.ifrn.exceptions.PilhaCheiaException;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public class pilha implements EstruturaPilha {
	private Object[] elements;
	private int size;
	private int index;
	
	/*
	 * Construtor
	 * 
	 * 
	 */
	public pilha() {
		this.elements = new Object[1];
		this.size = 1;
		this.index = -1;
	}

	/*
	 * Adiciona um novo elemento no topo da pilha
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean push(Object e) {
		if( this.size() >= this.size ) {
			// caso o vetor esteja cheio
			Object[] tmp = new Object[this.size*2];
			for( int i=0; i<this.size; i++) {
				tmp[i] = this.elements[i];
			}
			this.elements = tmp;
			this.size *= 2;
		}
		
		this.elements[++this.index] = e;
		return true;
	}
	
	/*
	 * Adiciona um novo elemento no topo da pilha
	 * Na possibilidade do vetor estar cheio retorna false
	 * 
	 * @ param Object
	 * @ return boolean
	 * @ throw PilhaCheiaException
	 */
	public boolean push_no_resizable(Object e) throws PilhaCheiaException {
		if( this.size() >= this.size ) {
			// caso o vetor esteja cheio
			throw new PilhaCheiaException();
		}
		this.elements[++this.index] = e;
		return true;
	}
	
	/*
	 * Remove o elemento do top da pilha e o remove da pilha
	 * 
	 * @ return Object
	 */
	public Object pop() throws PilhaVaziaException {
		if(this.isEmpty()) {
			throw new PilhaVaziaException();
		}
		return this.elements[this.index--];
	}
	
	/*
	 * Retorna o elemento do topo da pilha sem remove-lo
	 * 
	 * @ return Object
	 */
	public Object top() {
		return this.elements[index];
	}
	
	/*
	 * Informa o numero de elementos da pilha tamanho da pilha
	 * 
	 * @ return int
	 */
	public int size() {
		return this.index+1;
	}
	
	/*
	 * Informa se a pilha esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmpty() {
		if(this.index<0) {
			return true;
		}
		return false;
	}
	
}
