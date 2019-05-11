package classes;

import java.util.List;
import java.util.ArrayList;

import exceptions.NoSuchKeyException;


public class HashMap {
	private int fatorP;
	private int fatorS;
	
	private No vetor[];
	
	private int op; // 0 - Linear Probing | 1 - Hashing duplo 
	
	private int size;
	
	// <CONSTRUTORES>
	public HashMap() {
		this.fatorP = 3;
		this.fatorS = 2;
		
		this.vetor = new No[this.fatorP];
		
		this.op = 0;
		
		this.size = 0;
	}
	
	// <MANIPULATION METHODS>
	public int getOp() {
		return op;
	}
	
	public void setOp(int op) {
		this.op = op;
	}
	
	public No[] getVetor() {
		return this.vetor;
	}
	
	// <METHODS>
	public No findElement(int k) throws NoSuchKeyException {
		int key = this.dispersao(k);
		
		No tmp = this.vetor[key];
		
		if(tmp == null) {
			// Chave vazia (Nunca Mapeada)
			throw new NoSuchKeyException();
		}
		else if(tmp.getKey() == k) {
			if(tmp.isAvailable()) {
				// Chave disponivel (Mapeada e Desmapeada)
				throw new NoSuchKeyException();
			}
			// Chave mapeada(Mapeada)
			return tmp;
		}
		else {
			int auxKey, incr;
			
			// Chave mapeada (Mapeada)
			if(this.op == 0) {
				//Linear Probing
				incr = 1;
			}
			else {
				//Hashing Duplo
				incr = this.dispersao2(k);
			}
			
			auxKey = (key+incr) % this.fatorP;
			
			while( this.vetor[auxKey] != null && !this.vetor[auxKey].isAvailable() ) {
				//Busca pelo elemento
				
				if( this.vetor[auxKey].getKey() == k) {
					if(!tmp.isAvailable()) {
						// Chave mapeada(Mapeada)
						return this.vetor[auxKey];
					}
					break;
				}
				
				auxKey = (auxKey+incr) % this.fatorP;
				if(auxKey == key) {
					// Chave nao localizada (Nao Mapeada)
					break;
				}
			}
			throw new NoSuchKeyException();
		}
	}
	
	public void insertItem(int k, Object o) {
		
		if(this.size() == this.vetor.length) {
			//O vetor esta cheio
			this.aumentarHashMap();
		}
		
		int key = this.dispersao(k);
		
		No tmp = this.vetor[key];
		No novoNo = new No(k, o, null);
		
		if(tmp == null) {
			// Chave vazia (Nunca Mapeada)
			this.vetor[key] = novoNo;
			this.size += 1;
		}
		else if(tmp.isAvailable()) {
			// Chave disponivel (Mapeada e Desmapeada)
			this.vetor[key] = novoNo;
			this.size += 1;
		}
		else {
			int auxKey, incr;
			
			// Chave mapeada (Mapeada)
			if(this.op == 0) {
				//Linear Probing
				incr = 1;
			}
			else {
				//Hashing Duplo
				incr = this.dispersao2(k);
			}
			
			auxKey = (key+incr) % this.fatorP;
			
			while( this.vetor[auxKey] != null && !this.vetor[auxKey].isAvailable() ) {
				//Busca por espaco vazio
				auxKey = (auxKey+incr) % this.fatorP;
				if(auxKey == key) {
					//Ausencia de espaco vazio
					break;
				}
			}
			
			if(auxKey != key) {
				this.vetor[auxKey] = novoNo;
				this.size += 1;
			}
		}
	}
	
	public No removeElement(int k) throws NoSuchKeyException {
		try {
			No n = this.findElement(k);
			n.setAvailable(true);
			return n;
		}catch(NoSuchKeyException e){
			throw new NoSuchKeyException();
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
	
	public List<Integer> keys() {
		List<Integer> keys = new ArrayList<Integer>();
		
		for(int i=0; i<this.vetor.length; i++) {
			if(this.vetor[i] != null && (!this.vetor[i].isAvailable()) ) {
				keys.add(this.vetor[i].getKey());
			}
		}
		return keys;
	}
	
	public List<Object> elements() {
		List<Object> elements = new ArrayList<Object>();
		
		for(int i=0; i<this.vetor.length; i++) {
			if(this.vetor[i] != null && (!this.vetor[i].isAvailable()) ) {
				elements.add(this.vetor[i].getElement());
			}
		}
		return elements;
	}
	
	// <EXTRA METHODS>
	/**
	 * Retorna o mapeamento da chave k no array vector
	 * 
	 * @param k
	 * @return
	 */
	private int dispersao(int k) {
		return ( k % fatorP );
	}
	
	/**
	 * Retorna o incremento para tratamento de colisao
	 * 
	 * @param k
	 * @return
	 */
	private int dispersao2(int k) {
		return ( fatorS - k % fatorS );
	}
	
	/**
	 * Gerador de primos
	 * @param p
	 * @return
	 */
	public static int geradorPrimos(int p) {
		int maxPrimo = 2*p + 1;
		List<Integer> primos = new ArrayList<Integer>();
		
		primos.add(2);
		primos.add(3);
		
		if(p < 1) {
			return primos.get(1);
		}
		for(int i=5; i<=maxPrimo; i+=2) {
			
			boolean divisores = false;
			for(int k=0; k<primos.size(); k++) {
				if( i % primos.get(k) == 0) {
					divisores = true;
					break;
				}
			}
			
			if(!divisores) {
				primos.add(i);
			}
		}
		
		return primos.get(primos.size()-1);
	}
	
	/**
	 * Aumentar o tamanho da tabela hash reorganizando os valores
	 */
	public void aumentarHashMap() {
		int newSize = HashMap.geradorPrimos(this.fatorP);
		No antigoVetor[] = this.vetor;
		
		this.vetor = new No[newSize];
		this.fatorS = this.fatorP;
		this.fatorP = newSize;
		
		for(int i=0; i<antigoVetor.length; i++) {
			this.insertItem(antigoVetor[i].getKey(), antigoVetor[i].getElement());
			System.out.println(antigoVetor[i].getKey() + " ");
			antigoVetor[i] = null;
		}
	}
}
