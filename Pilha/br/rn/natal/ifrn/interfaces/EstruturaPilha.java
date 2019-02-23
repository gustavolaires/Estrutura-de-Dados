package br.rn.natal.ifrn.interfaces;

import br.rn.natal.ifrn.exceptions.PilhaCheiaException;
import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public interface EstruturaPilha {
	
	/*
	 * Adiciona um novo elemento no topo da pilha
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean push(Object e);
	
	/*
	 * Adiciona um novo elemento no topo da pilha
	 * Na possibilidade do vetor estar cheio retorna false
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean push_no_resizable(Object e) throws PilhaCheiaException;
	
	/*
	 * Remove o elemento do top da pilha e o remove da pilha
	 * 
	 * @ return Object
	 */
	public Object pop() throws PilhaVaziaException;
	
	/*
	 * Retorna o elemento do topo da pilha sem remove-lo
	 * 
	 * @ return Object
	 */
	public Object top();
	
	/*
	 * Informa o numero de elementos da pilha tamanho da pilha
	 * 
	 * @ return int
	 */
	public int size();
	
	/*
	 * Informa se a pilha esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmpty();
}
