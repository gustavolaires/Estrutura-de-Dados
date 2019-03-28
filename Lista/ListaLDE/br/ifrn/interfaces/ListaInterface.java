package br.ifrn.interfaces;

import br.ifrn.classes.NoDE;

public interface ListaInterface {
	
	/*
	 * Substitui o Object do No passado como referencia
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No substituido) | False (No nao encontrado)
	 */
	public boolean replaceElement(NoDE n, Object o);
	
	/*
	 * Troca a posicao dos No´s passados como parametros
	 * 
	 * @ param NoDE - No_1 a ser trocado
	 * @ param NoDE - No_2 a ser trocado
	 * @ return boolean - True (Troca realizada) | False (Troca nao realizada)
	 */
	public boolean swapElements(NoDE n, NoDE q);
	
	/*
	 * Adiciona um Object antes do No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No inserido) | False (No nao encontrado)
	 */
	public boolean insertBefore(NoDE n, Object o);
	
	/*
	 * Adiciona um Object depois do No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No inserido) | False (No nao encontrado)
	 */
	public boolean insertAfter(NoDE n, Object o);
	
	/*
	 * O Object e inserido no inicio da fila
	 * 
	 * @ param Object - elemento a ser inserido no inicio 
	 */
	public void insertFirst(Object o);
	
	/*
	 * O Object e inserido no fim da fila
	 * 
	 * @ param Object - elemento a ser inserido no fim 
	 */
	public void insertLast(Object o);
	
	/*
	 * Remove o No passado como parametro da lista
	 * 
	 * @ param NoDE - No a ser removido da lista
	 * @ return boolean - True (No removido) | False (No não encontrado)
	 */
	public NoDE remove(NoDE n);
	
	/*
	 * Retorna o primeiro No
	 * 
	 * @ return NoDE - Primeiro No
	 */
	public NoDE first();
	
	/*
	 * Retorna o ultimo No
	 * 
	 * @ return NoDE - Ultimo No
	 */
	public NoDE last();
	
	/*
	 * Retorna o No anterior em relação ao No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return NoDE - Proximo No
	 */
	public NoDE before(NoDE n);
	
	/*
	 * Retorna o próximo No em relação ao No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return NoDE - Proximo No
	 */
	public NoDE after(NoDE n);
	
	/*
	 * Verifica se o no passado é o primeiro da lista
	 * 
	 * @ param NoDE - No que sera verificado
	 * @ return boolean - True (E o primeiro) | False (Nao e o primeiro)
	 */
	public boolean isFirst(NoDE n);
	
	/*
	 * Verifica se o no passado é o ultimo da lista
	 * 
	 * @ param NoDE - No que sera verificado
	 * @ return boolean - True (E o ultimo) | False (Nao e o ultimo)
	 */
	public boolean isLast(NoDE n);
	
	/*
	 * Retorna o numero de elementos que esta contido na lista
	 * 
	 * @ return int - Numero de elementos na lista
	 */
	public int size();
	
	/*
	 * Retorna verdadeiro se a lista estiver vazia ou false se tiver algum elemento
	 * na lista
	 * 
	 * @ return boolean - True (lista vazia) | False (lista nao vazia)
	 */
	public boolean isEmpty();
}
