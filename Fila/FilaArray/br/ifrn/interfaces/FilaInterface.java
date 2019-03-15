package br.ifrn.interfaces;

import br.ifrn.exceptions.FilaVaziaException;

public interface FilaInterface {

	/*
	 * Adiciona um novo elemento no final da fila
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 * @ return boolean
	 */
	public boolean enfileirar(Object e);
	
	/*
	 * Retorna o elemento do inicio da fila e o remove da fila
	 * 
	 * @ return Object
	 */
	public Object desenfileirar() throws FilaVaziaException;
	
	/*
	 * Retorna o elemento do inicio da fila
	 * 
	 * @ return Object
	 */
	public Object inicio() throws FilaVaziaException;
	
	/*
	 * Informa o numero de elementos da fila - tamanho da fila
	 * 
	 * @ return int
	 */
	public int tamanho();
	
	/*
	 * Informa se a fila esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean estaVazia();
}
