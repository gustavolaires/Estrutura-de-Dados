package br.rn.natal.ifrn.interfaces;

import br.rn.natal.ifrn.exceptions.PilhaVaziaException;

public interface EstruturaPilhaRubro {
	
	// <----------------------- PILHA PRETA ----------------------->
	
	/*
	 * Adiciona um novo elemento no topo da pilha Preta
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 */
	public void pushPreta(Object e);
	
	/*
	 * Remove o elemento do top da pilha Preta
	 * 
	 * @ return Object
	 */
	public Object popPreta() throws PilhaVaziaException;
	
	/*
	 * Retorna o elemento do topo da pilha Preta sem remove-lo
	 * 
	 * @ return Object
	 * @ throw PilhaVaziaException
	 */
	public Object topPreta() throws PilhaVaziaException;
	
	/*
	 * Informa o numero de elementos da pilha Preta (tamanho da pilha Vermelha)
	 * 
	 * @ return int
	 * @ throw PilhaVaziaException
	 */
	public int sizePreta();
	
	/*
	 * Informa se a pilha Preta esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmptyPreta();
		
	// <----------------------- PILHA VERMELHA ----------------------->
	
	/*
	 * Adiciona um novo elemento no topo da pilha Vermelha
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 */
	public void pushVermelha(Object e);
	
	/*
	 * Remove o elemento do top da pilha Vermelha
	 * 
	 * @ return Object
	 * @ throw PilhaVaziaException
	 */
	public Object popVermelha() throws PilhaVaziaException;
	
	/*
	 * Retorna o elemento do topo da pilha Vermelha sem remove-lo
	 * 
	 * @ return Object
	 * @ throw PilhaVaziaException
	 */
	public Object topVermelha() throws PilhaVaziaException;
	
	/*
	 * Informa o numero de elementos da pilha Vermelha (tamanho da pilha Vermelha)
	 * 
	 * @ return int
	 */
	public int sizeVermelha();
	
	/*
	 * Informa se a pilha Vermelha esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmptyVermelha();
}
