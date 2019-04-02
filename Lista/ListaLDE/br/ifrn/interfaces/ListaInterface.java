package br.ifrn.interfaces;

import br.ifrn.classes.NoDE;

public interface ListaInterface {
	
	/*
	 * Substitui o Object do No passado como referencia
	 * 
	 * @param NoDE - No de referencia
	 */
	public void replaceElement(NoDE n, Object o);
	
	/*
	 * Troca a posicao dos No´s passados como parametros
	 * 
	 * @param NoDE - No_1 a ser trocado
	 * @param NoDE - No_2 a ser trocado
	 */
	public void swapElements(NoDE n, NoDE q);
	
	/*
	 * Adiciona um Object antes do No passado como parametro
	 * 
	 * @param NoDE - No de referencia
	 * @param Object - Objeto a ser inserido no No
	 */
	public void insertBefore(NoDE n, Object o);
	
	/*
	 * Adiciona um Object depois do No passado como parametro
	 * 
	 * @param NoDE - No de referencia
	 * @param Object - Objeto a ser inserido no No
	 */
	public void insertAfter(NoDE n, Object o);
	
	/*
	 * O Object e inserido no inicio da fila
	 * 
	 * @param Object - elemento a ser inserido no inicio 
	 */
	public void insertFirst(Object o);
	
	/*
	 * O Object e inserido no fim da fila
	 * 
	 * @param Object - elemento a ser inserido no fim 
	 */
	public void insertLast(Object o);
	
	/*
	 * Remove o No passado como parametro e retorna o Object
	 * 
	 * @param NoDE - No a ser removido da lista
	 * @return Object - Object armazenado no No removido
	 */
	public Object remove(NoDE n);
	
	/*
	 * Retorna o primeiro No
	 * 
	 * @return NoDE - Primeiro No
	 */
	public NoDE first();
	
	/*
	 * Retorna o ultimo No
	 * 
	 * @return NoDE - Ultimo No
	 */
	public NoDE last();
	
	/*
	 * Retorna o No anterior em relação ao No passado
	 * 
	 * @param NoDE - No de referencia
	 * @return NoDE - Proximo No
	 */
	public NoDE before(NoDE n);
	
	/*
	 * Retorna o próximo No em relação ao No passado
	 * 
	 * @param NoDE - No de referencia
	 * @return NoDE - Proximo No
	 */
	public NoDE after(NoDE n);
	
	/*
	 * Verifica se o no passado é o primeiro da lista
	 * 
	 * @param NoDE - No que sera verificado
	 * @return boolean - True (E o primeiro) | False (Nao e o primeiro)
	 */
	public boolean isFirst(NoDE n);
	
	/*
	 * Verifica se o no passado é o ultimo da lista
	 * 
	 * @param NoDE - No que sera verificado
	 * @return boolean - True (E o ultimo) | False (Nao e o ultimo)
	 */
	public boolean isLast(NoDE n);
	
	/*
	 * Retorna o numero de elementos que esta contido na lista
	 * 
	 * @return int - Numero de elementos na lista
	 */
	public int size();
	
	/*
	 * Retorna verdadeiro se a lista estiver vazia ou false se tiver algum elemento
	 * na lista
	 * 
	 * @return boolean - True (lista vazia) | False (lista nao vazia)
	 */
	public boolean isEmpty();
}
