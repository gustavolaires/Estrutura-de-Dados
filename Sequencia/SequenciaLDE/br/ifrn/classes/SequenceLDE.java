package br.ifrn.classes;

import br.ifrn.classes.NoDE;
import br.ifrn.exceptions.SequenceLDEException;
import br.ifrn.interfaces.SequenceInterface;

public class SequenceLDE implements SequenceInterface {

	private NoDE header;
	private NoDE trailer;
	private int size;
	
	/*
	 * Construtor
	 * 
	 */
	public SequenceLDE() {
		this.header = new NoDE();
		this.trailer = new NoDE();
		
		this.header.setNxtNo(this.trailer);
		this.trailer.setPrevNo(this.header);
		
		this.size = 0;
	}
	
	/*
	 * Substitui o Object do No passado como referencia
	 * 
	 * @param NoDE - No de referencia
	 */
	public void replaceElement(NoDE n, Object o) {
		n.setElement(o);
	}

	/*
	 * Troca a posicao dos No´s passados como parametros
	 * 
	 * @param NoDE - No_1 a ser trocado
	 * @param NoDE - No_2 a ser trocado
	 */
	public void swapElements(NoDE n, NoDE q) {
		Object tmp = n.getElement();
		n.setElement(q.getElement());
		q.setElement(tmp);
	}

	/*
	 * Adiciona um Object antes do No passado como parametro
	 * 
	 * @param NoDE - No de referencia
	 * @param Object - Objeto a ser inserido no No
	 */
	public void insertBefore(NoDE n, Object o) {
		NoDE tmp = new NoDE();
		tmp.setElement(o);
		
		tmp.setPrevNo(n.getPrevNo());
		tmp.setNxtNo(n);
				
		tmp.getPrevNo().setNxtNo(tmp);
		tmp.getNxtNo().setPrevNo(tmp);
		
		this.size += 1;
	}

	/*
	 * Adiciona um Object depois do No passado como parametro
	 * 
	 * @param NoDE - No de referencia
	 * @param Object - Objeto a ser inserido no No
	 */
	public void insertAfter(NoDE n, Object o) {
		NoDE tmp = new NoDE();
		tmp.setElement(o);
		
		tmp.setPrevNo(n);
		tmp.setNxtNo(n.getNxtNo());
		
		tmp.getPrevNo().setNxtNo(tmp);
		tmp.getNxtNo().setPrevNo(tmp);
		
		this.size += 1;
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
	 * Remove o No passado como parametro e retorna o Object
	 * 
	 * @param NoDE - No a ser removido da lista
	 * @return Object - Object armazenado no No removido
	 */
	public Object remove(NoDE n) {
		//ponteiro do NxtNo
		n.getNxtNo().setPrevNo(n.getPrevNo());
		//ponteiro do PrevNo
		n.getPrevNo().setNxtNo(n.getNxtNo());
				
		n.setNxtNo(null);
		n.setPrevNo(null);
		
		this.size -= 1;
		
		return n.getElement();
	}

	/*
	 * Retorna o primeiro No
	 * 
	 * @return NoDE - Primeiro No
	 */
	public NoDE first() {
		return this.header.getNxtNo();
	}

	/*
	 * Retorna o ultimo No
	 * 
	 * @return NoDE - Ultimo No
	 */
	public NoDE last() {
		return this.trailer.getPrevNo();
	}

	/*
	 * Retorna o No anterior em relação ao No passado
	 * 
	 * @param NoDE - No de referencia
	 * @return NoDE - Proximo No
	 */
	public NoDE before(NoDE n) {
		return n.getPrevNo();
	}

	/*
	 * Retorna o próximo No em relação ao No passado
	 * 
	 * @param NoDE - No de referencia
	 * @return NoDE - Proximo No
	 */
	public NoDE after(NoDE n) {
		return n.getNxtNo();
	}

	/*
	 * Verifica se o no passado é o primeiro da lista
	 * 
	 * @param NoDE - No que sera verificado
	 * @return boolean - True (E o primeiro) | False (Nao e o primeiro)
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
	 * @param NoDE - No que sera verificado
	 * @return boolean - True (E o ultimo) | False (Nao e o ultimo)
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
	 * @return int - Numero de elementos na lista
	 */
	public int size() {
		return this.size;
	}

	/*
	 * Retorna verdadeiro se a lista estiver vazia ou false se tiver algum elemento
	 * na lista
	 * 
	 * @return boolean - True (lista vazia) | False (lista nao vazia)
	 */
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Retorna o R-esimo No da lista
	 * 
	 * @param int - posicao r que se deseja obter o No
	 * @return NoDE - No na posicao r
	 */
	public NoDE atRank(int r) throws SequenceLDEException {
		if( r < 0 || r > this.size-1 ) {
			throw new SequenceLDEException();
		}
		
		NoDE tmp = null;
		
		if( r < this.size/2) {
			tmp = this.header.getNxtNo();
			for(int count = 0; count < r; count++) {
				tmp = tmp.getNxtNo();
			}
		}
		else {
			tmp = this.trailer.getPrevNo();
			for(int count = 0; count < this.size - 1 - r; count++) {
				tmp = tmp.getPrevNo();
			}
		}
		
		return tmp;	
	}
	
	/*
	 * Retorna o Objecto no R-esimo No da lista
	 * 
	 * @param int - posicao r que se deseja obter o No
	 * @return Object - Object na posicao r
	 */
	public Object elemAtRank(int r) throws SequenceLDEException{
		if( r < 0 || r > this.size-1 ) {
			throw new SequenceLDEException();
		}
		
		NoDE tmp = null;
		
		if( r < this.size/2) {
			tmp = this.header.getNxtNo();
			for(int count = 0; count < r; count++) {
				tmp = tmp.getNxtNo();
			}
		}
		else {
			tmp = this.trailer.getPrevNo();
			for(int count = 0; count < this.size - 1 - r; count++) {
				tmp = tmp.getPrevNo();
			}
		}
		
		return tmp.getElement();	
	}
	
	/*
	 * Retorna a posicao do No n
	 * 
	 * @param NoDE - NoDE que se deseja saber a posicao
	 * @return int - posicao r no No n
	 */
	public int rankOf(NoDE n) {
		NoDE tmp = this.header.getNxtNo();
		int r = 0;
		
		while(tmp != this.trailer && tmp != n) {
			tmp = tmp.getNxtNo();
			r++;
		}
		return r;
	}
	
	/*
	 * Substitui o Object na R-esima posicao
	 * 
	 * @param int - posicao r que se deseja substituir o Object
	 * @param Object - Object que se deseja inserir
	 */
	public void replaceAtRank(int r, Object o) throws SequenceLDEException{
		if( r < 0 || r > this.size-1 ) {
			throw new SequenceLDEException();
		}
		
		NoDE tmp = null;
		
		if( r < this.size/2) {
			tmp = this.header.getNxtNo();
			for(int count = 0; count < r; count++) {
				tmp = tmp.getNxtNo();
			}
		}
		else {
			tmp = this.trailer.getPrevNo();
			for(int count = 0; count < this.size - 1 - r; count++) {
				tmp = tmp.getPrevNo();
			}
		}
		
		tmp.setElement(o);
	}
	
	/*
	 * Insere o Object na R-esima posicao
	 * 
	 * @param int - posicao r que se deseja inserir o Object
	 * @param Object - Object que se deseja inserir
	 */
	public void insertAtRank(int r, Object o) throws SequenceLDEException{
		if( r < 0 || r > this.size ) {
			throw new SequenceLDEException();
		}
		//Localizando posicao
		NoDE selected = null;
		
		if( r < this.size/2) {
			selected = this.header.getNxtNo();
			for(int count = 0; count < r; count++) {
				selected = selected.getNxtNo();
			}
		}
		else {
			selected = this.trailer;
			for(int count = 0; count < this.size - r; count++) {
				selected = selected.getPrevNo();
			}
		}
		
		//Adicionando novo No
		NoDE tmp = new NoDE();
		tmp.setElement(o);
		
		tmp.setNxtNo(selected);
		tmp.setPrevNo(selected.getPrevNo());
		
		tmp.getPrevNo().setNxtNo(tmp);
		tmp.getNxtNo().setPrevNo(tmp);
		
		this.size += 1;
	}
	
	/*
	 * Remove o Object na R-esima posicao
	 * 
	 * @param int - posicao r que se deseja remover o Object
	 * @return Object - Object que foi removido
	 */
	public Object removeAtRank(int r) throws SequenceLDEException{
		if( r < 0 || r > this.size-1 ) {
			throw new SequenceLDEException();
		}
		//Localizando posicao
		NoDE tmp = null;
		
		if( r < this.size/2) {
			tmp = this.header.getNxtNo();
			for(int count = 0; count < r; count++) {
				tmp = tmp.getNxtNo();
			}
		}
		else {
			tmp = this.trailer.getPrevNo();
			for(int count = 0; count < this.size - 1 - r; count++) {
				tmp = tmp.getPrevNo();
			}
		}
		
		//Removendo o No
		tmp.getPrevNo().setNxtNo(tmp.getNxtNo());
		tmp.getNxtNo().setPrevNo(tmp.getPrevNo());
		
		tmp.setPrevNo(null);
		tmp.setNxtNo(null);
		
		this.size -= 1;
		
		return tmp.getElement();
	}

}
