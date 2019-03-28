package br.ifrn.classes;

import br.ifrn.classes.NoDE;
import br.ifrn.interfaces.ListaInterface;

public class ListaLDE implements ListaInterface {

	private NoDE header;
	private NoDE trailer;
	private int size;
	
	/*
	 * Construtor
	 * 
	 */
	public ListaLDE() {
		this.header = new NoDE();
		this.trailer = new NoDE();
		
		this.header.setNxtNo(this.trailer);
		this.trailer.setPrevNo(this.header);
		
		this.size = 0;
	}
	
	/*
	 * Substitui o Object do No passado como referencia
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No substituido) | False (No nao encontrado)
	 */
	@Override
	public boolean replaceElement(NoDE n, Object o) {
		NoDE tmp = this.header.getNxtNo();
		
		while(tmp != this.trailer) {
			if(tmp == n) {
				tmp.setElement(o);
				return true;
			}
			tmp = tmp.getNxtNo();
		}
		
		return false;
	}

	/*
	 * Troca a posicao dos No´s passados como parametros
	 * 
	 * @ param NoDE - No_1 a ser trocado
	 * @ param NoDE - No_2 a ser trocado
	 * @ return boolean - True (Troca realizada) | False (Troca nao realizada)
	 */
	public boolean swapElements(NoDE n, NoDE q) {
		NoDE select = this.header.getNxtNo();
		NoDE tmp1 = null;
		NoDE tmp2 = null;
		
		while(select != this.trailer) {
			if(select == n) {
				tmp1 = select;
			}
			if(select == q) {
				tmp2 = select;
			}
			if( tmp1 != null && tmp2 != null) {
				Object tmpE = tmp1.getElement();
				
				tmp1.setElement(tmp2.getElement());
				tmp2.setElement(tmpE);
				return true;
			}
			select = select.getNxtNo();
		}
		return false;
	}

	/*
	 * Adiciona um Object antes do No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No inserido) | False (No nao encontrado)
	 */
	public boolean insertBefore(NoDE n, Object o) {
		NoDE select = this.header.getNxtNo();
		
		while(select != this.trailer) {
			if(select == n) {
				NoDE tmp = new NoDE();
				tmp.setElement(o);
				
				tmp.setPrevNo(select.getPrevNo());
				tmp.setNxtNo(select);
				
				tmp.getPrevNo().setNxtNo(tmp);
				tmp.getNxtNo().setPrevNo(tmp);
				
				this.size += 1;
				return true;
			}
			select = select.getNxtNo();
		}
		
		return false;
	}

	/*
	 * Adiciona um Object depois do No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return boolean - True (No inserido) | False (No nao encontrado)
	 */
	public boolean insertAfter(NoDE n, Object o) {
		NoDE select = this.header.getNxtNo();
		
		while(select != this.trailer) {
			if(select == n) {
				NoDE tmp = new NoDE();
				tmp.setElement(o);
				
				tmp.setPrevNo(select);
				tmp.setNxtNo(select.getNxtNo());
				
				tmp.getPrevNo().setNxtNo(tmp);
				tmp.getNxtNo().setPrevNo(tmp);
				
				this.size += 1;
				return true;
			}
			select = select.getNxtNo();
		}
		
		return false;
	}

	/*
	 * O Object e inserido no inicio da fila
	 * 
	 * @ param Object - elemento a ser inserido no inicio 
	 */
	public void insertFirst(Object o) {
		NoDE tmp = new NoDE();
		tmp.setElement(o);
		
		tmp.setNxtNo(this.header.getNxtNo());
		tmp.setPrevNo(this.header);
		
		tmp.getPrevNo().setNxtNo(tmp);
		tmp.getNxtNo().setPrevNo(tmp);
		
		this.size += 1;
	}

	/*
	 * O Object e inserido no fim da fila
	 * 
	 * @ param Object - elemento a ser inserido no fim 
	 */
	public void insertLast(Object o) {
		NoDE tmp = new NoDE();
		tmp.setElement(o);
		
		tmp.setNxtNo(this.trailer);
		tmp.setPrevNo(this.trailer.getPrevNo());
			
		tmp.getPrevNo().setNxtNo(tmp);
		tmp.getNxtNo().setPrevNo(tmp);
		
		this.size += 1;
	}

	/*
	 * Remove o No passado como parametro da lista
	 * 
	 * @ param NoDE - No a ser removido da lista
	 * @ return boolean - True (No removido) | False (No não encontrado)
	 */
	public NoDE remove(NoDE n) {
		NoDE tmp = this.header.getNxtNo();
		
		while(tmp != this.trailer) {
			if(tmp == n) {
				//ponteiro do NxtNo
				tmp.getNxtNo().setPrevNo(tmp.getPrevNo());
				//ponteiro do PrevNo
				tmp.getPrevNo().setNxtNo(tmp.getNxtNo());
				
				tmp.setNxtNo(null);
				tmp.setPrevNo(null);
				
				this.size -= 1;
				return tmp;
			}
			tmp = tmp.getNxtNo();
		}
		return null;
	}

	/*
	 * Retorna o primeiro No
	 * 
	 * @ return NoDE - Primeiro No
	 */
	public NoDE first() {
		if(this.size > 0) {
			return this.header.getNxtNo();
		}
		return null;
	}

	/*
	 * Retorna o ultimo No
	 * 
	 * @ return NoDE - Ultimo No
	 */
	public NoDE last() {
		if(this.size > 0) {
			return this.trailer.getPrevNo();
		}
		return null;
	}

	/*
	 * Retorna o No anterior em relação ao No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return NoDE - Proximo No
	 */
	public NoDE before(NoDE n) {
		NoDE tmp = this.header.getNxtNo();
		
		if(tmp == n) {
			return null;
		}
		
		while(tmp != this.trailer) {
			if(tmp == n) {
				return tmp.getPrevNo();
			}
			tmp = tmp.getNxtNo();
		}
		
		return null;
	}

	/*
	 * Retorna o próximo No em relação ao No passado
	 * 
	 * @ param NoDE - No de referencia
	 * @ return NoDE - Proximo No
	 */
	public NoDE after(NoDE n) {
		NoDE tmp = this.trailer.getPrevNo();
		
		if(tmp == n) {
			return null;
		}
		
		while(tmp != this.header) {
			if(tmp == n) {
				return tmp.getNxtNo();
			}
			tmp = tmp.getPrevNo();
		}
		
		return null;
	}

	/*
	 * Verifica se o no passado é o primeiro da lista
	 * 
	 * @ param NoDE - No que sera verificado
	 * @ return boolean - True (E o primeiro) | False (Nao e o primeiro)
	 */
	public boolean isFirst(NoDE n) {
		if( this.header.getNxtNo() == n) {
			return true;
		}
		return false;
	}

	/*
	 * Verifica se o no passado é o ultimo da lista
	 * 
	 * @ param NoDE - No que sera verificado
	 * @ return boolean - True (E o ultimo) | False (Nao e o ultimo)
	 */
	public boolean isLast(NoDE n) {
		if( this.trailer.getPrevNo() == n) {
			return true;
		}
		return false;
	}

	/*
	 * Retorna o numero de elementos que esta contido na lista
	 * 
	 * @ return int - Numero de elementos na lista
	 */
	public int size() {
		return this.size;
	}

	/*
	 * Retorna verdadeiro se a lista estiver vazia ou false se tiver algum elemento
	 * na lista
	 * 
	 * @ return boolean - True (lista vazia) | False (lista nao vazia)
	 */
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}

}
