package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.classes.No;
import br.rn.natal.ifrn.interfaces.PilhaLLInterface;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public class PilhaLL implements PilhaLLInterface{
	int size;
	No index;
	
	/*
	 * Construtor
	 * 
	 * 
	 */
	public PilhaLL() {
		this.size = 0;
		this.index = null;
	}

	/*
	 * Adiciona um novo elemento no topo da pilha
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean push(Object e) {
		//Cria o novo nó
		No tmp = new No();
		tmp.setElement(e);
		tmp.setNxtNo(this.index);
		
		//adiciona o novo nó a pilha
		this.index = tmp;
		this.size ++;
		return true;
	}
	
	/*
	 * Remove o elemento do top da pilha e o remove da pilha
	 * 
	 * @ return Object
	 */
	public Object pop() throws PilhaVaziaException {
		if( this.index == null ) {
			throw new PilhaVaziaException();
		}
		//muda o topo da pilha
		No tmp = this.index;
		this.index = tmp.getNxtNo();
		this.size --;
		
		return tmp.getElement();
	}
	
	/*
	 * Retorna o elemento do topo da pilha sem remove-lo
	 * 
	 * @ return Object
	 */
	public Object top() {
		return this.index.getElement();
	}
	
	/*
	 * Informa o numero de elementos da pilha tamanho da pilha
	 * 
	 * @ return int
	 */
	public int size() {
		return this.size;
	}
	
	/*
	 * Informa se a pilha esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmpty() {
		if(this.index == null) {
			return true;
		}
		return false;
	}
}
