package br.rn.natal.ifrn.classes;

import br.rn.natal.ifrn.exceptions.VectorArrayException;
import br.rn.natal.ifrn.interfaces.VectorArrayInterface;

public class VectorArray implements VectorArrayInterface {
	
	int size;
	Object [] elements;
	
	/*
	 * Construtor
	 */
	public VectorArray() {
		this.size = 0;
		this.elements = new Object[1];
	}

	/*
	 * Retorna o elemento na colocação p, sem remove-lo
	 * 
	 * @ param Integer p - posicao
	 * @ return Object
	 */
	public Object elemAtRank(Integer p) throws VectorArrayException{
		if(p > this.size()-1 || p < 0) {
			throw new VectorArrayException();
		}
		
		return this.elements[p];
	}
	
	/*
	 * Substitui o elemento na posicao p por 'o' e retorna o antigo elemento
	 * 
	 * @ param Integer p - posicao
	 * @ param Object o - novo elemento
	 * @ return Object
	 */
	public Object replaceAtRank(Integer p, Object o) throws VectorArrayException{
		if(p > this.size()-1 || p < 0) {
			throw new VectorArrayException();
		}
		
		Object tmp = this.elements[p];
		this.elements[p] = o;
		return tmp;
	}
	
	/*
	 * Insere um novo elemento 'o' na posicao p
	 * 
	 * @ param Integer p - posicao
	 * @ param Object o - novo elemento
	 * @ return boolean
	 */
	public boolean insertAtRank(Integer p, Object o) throws VectorArrayException{
		if(p > this.size() || p < 0) {
			throw new VectorArrayException();
		}
		
		//Se o array estiver cheio
		if( this.size() == this.elements.length) {
			Object [] tmp = new Object[2*this.elements.length];
			
			for(int i = this.size()-1; i>=p; i--) {
				tmp[i+1] = this.elements[i];
			}
			for(int i = p-1; i>=0; i--) {
				tmp[i] = this.elements[i];
			}
			
			this.elements = tmp;
		}
		else {
			for(int i = this.size()-1; i>=p; i--) {
				this.elements[i+1] = this.elements[i];
			}
		}
		
		this.elements[p] = o;
		this.size += 1;
		return true;
	}
	
	/*
	 * Remove e retorna o elemento na posicao p
	 * 
	 * @ param Integer p - posicao
	 * @ return Object
	 */
	public Object removeAtRank(Integer p) throws VectorArrayException{
		if(p > this.size()-1 || p < 0) {
			throw new VectorArrayException();
		}
		
		Object tmp = this.elements[p];
		
		for(int i=p; i<this.size()-1; i++) {
			this.elements[i] = this.elements[i+1];
		}
		
		this.size -= 1;
		return tmp;
	}
	
	/*
	 * Informa o numero de elementos do vector (tamanho do vector)
	 * 
	 * @ return int
	 */
	public int size() {
		return this.size;
	}
	
	/*
	 * Informa se o vector esta vazio (retorna true) ou nao (retorna false)
	 * 
	 * @ return boolean
	 */
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
}
