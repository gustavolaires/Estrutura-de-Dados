package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.exceptions.PilhaVaziaException;
import br.rn.natal.ifrn.interfaces.EstruturaPilhaRubro;

public class PilhaRubro implements EstruturaPilhaRubro{
	private Object [] elements;
	private int size;
	private int indexBlack;
	private int indexRed;
	
	
	/*
	 * Construtor
	 */
	
	public PilhaRubro() {
		this.elements = new Object[2];
		this.size = 2;
		this.indexBlack = -1;
		this.indexRed = -1;
	}
	
	// <----------------------- PILHA PRETA ----------------------->
	
	/*
	 * Adiciona um novo elemento no topo da pilha Preta
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 */
	public void pushPreta(Object e) {
		if( this.sizePreta() + this.sizeVermelha() >= this.size) {
			//caso a pilha esteja cheia
			int tmpSize = this.size*2;
			Object [] tmp = new Object[tmpSize];
			
			//organiza a pilha presta
			for(int i=0; i<=this.indexBlack; i++) {
				tmp[i] = this.elements[i];
			}
			
			//organiza a pilha vermelha
			for(int i=0; i<=this.indexRed; i++) {
				tmp[ tmpSize-1 - i ] = this.elements[ this.size-1 - i ]; 
			}
			this.elements = tmp;
			this.size = tmpSize;
		}
		this.elements[++this.indexBlack] = e;
	}
	
	/*
	 * Remove o elemento do top da pilha Preta
	 * 
	 * @ return Object
	 */
	public Object popPreta() throws PilhaVaziaException{
		if(this.indexBlack < 0) {
			throw new PilhaVaziaException();
		}
		return this.elements[this.indexBlack--];
	}
	
	/*
	 * Retorna o elemento do topo da pilha Preta sem remove-lo
	 * 
	 * @ return Object
	 */
	public Object topPreta() throws PilhaVaziaException{
		if(this.indexBlack < 0) {
			throw new PilhaVaziaException();
		}
		return this.elements[this.indexBlack];
	}
	
	/*
	 * Informa o numero de elementos da pilha Preta (tamanho da pilha Vermelha)
	 * 
	 * @ return int
	 */
	public int sizePreta() {
		return this.indexBlack+1;
	}
	
	/*
	 * Informa se a pilha Preta esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmptyPreta() {
		if(this.indexBlack < 0) {
			return true;
		}
		return false;
	}
		
	// <----------------------- PILHA VERMELHA ----------------------->
	
	/*
	 * Adiciona um novo elemento no topo da pilha Vermelha
	 * Na possibilidade do vetor estar cheio, o vetor dobra o tamanho de elementos
	 * 
	 * @ param Object
	 */
	public void pushVermelha(Object e) {
		if( this.sizePreta() + this.sizeVermelha() >= this.size) {
			//caso a pilha esteja cheia
			int tmpSize = this.size*2;
			Object [] tmp = new Object[tmpSize];
			
			//organiza a pilha presta
			for(int i=0; i<=this.indexBlack; i++) {
				tmp[i] = this.elements[i];
			}
			
			//organiza a pilha vermelha
			for(int i=0; i<=this.indexRed; i++) {
				tmp[ tmpSize-1 - i ] = this.elements[ this.size-1 - i ]; 
			}
			this.elements = tmp;
			this.size = tmpSize;
		}
		this.elements[ this.size-1 - (++this.indexRed)] = e;
	}
	
	/*
	 * Remove o elemento do top da pilha Vermelha
	 * 
	 * @ return Object
	 */
	public Object popVermelha() throws PilhaVaziaException{
		if(this.indexRed < 0) {
			throw new PilhaVaziaException();
		}
		return this.elements[ this.size-1 - (this.indexRed--) ];
	}
	
	/*
	 * Retorna o elemento do topo da pilha Vermelha sem remove-lo
	 * 
	 * @ return Object
	 */
	public Object topVermelha() throws PilhaVaziaException{
		if( this.indexRed < 0) {
			throw new PilhaVaziaException();
		}
		return this.elements[ this.size-1 - this.indexRed ];
	}
	
	/*
	 * Informa o numero de elementos da pilha Vermelha (tamanho da pilha Vermelha)
	 * 
	 * @ return int
	 */
	public int sizeVermelha() {
		return this.indexRed+1;
	}
	
	/*
	 * Informa se a pilha Vermelha esta vazia (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmptyVermelha() {
		if( this.indexRed < 0 ) {
			return true;
		}
		return false;
	}
}
