package br.rn.natal.ifrn.interfaces;

import br.rn.natal.ifrn.exceptions.VectorArrayException;

public interface VectorArrayInterface {
	
	/*
	 * Retorna o elemento na colocação p, sem remove-lo
	 * 
	 * @ param Integer p - posicao
	 * @ return Object
	 */
	public Object elemAtRank(Integer p) throws VectorArrayException;
	
	/*
	 * Substitui o elemento na posicao p por 'o' e retorna o antigo elemento
	 * 
	 * @ param Integer p - posicao
	 * @ param Object o - novo elemento
	 * @ return Object
	 */
	public Object replaceAtRank(Integer p, Object o) throws VectorArrayException;
	
	/*
	 * Insere um novo elemento 'o' na posicao p
	 * 
	 * @ param Integer p - posicao
	 * @ param Object o - novo elemento
	 * @ return boolean
	 */
	public boolean insertAtRank(Integer p, Object o) throws VectorArrayException;
	
	/*
	 * Remove e retorna o elemento na posicao p
	 * 
	 * @ param Integer p - posicao
	 * @ return Object
	 */
	public Object removeAtRank(Integer p) throws VectorArrayException;
	
	/*
	 * Informa o numero de elementos do vector (tamanho do vector)
	 * 
	 * @ return int
	 */
	public int size();
	
	/*
	 * Informa se o vector esta vazio (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmpty();
}
