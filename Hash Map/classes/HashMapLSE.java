package classes;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoSuchKeyException;

public class HashMapLSE {
	private int fatorP;
	private No vetor[];
	private int size;
	
	// <CONSTRUTORES>
	public HashMapLSE() {
		this.fatorP = 3;
		this.vetor = new No[this.fatorP];
		this.size = 0;
	}
	
	// <MANIPULATION METHODS>	
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
		else {
			// Chave mapeada (Mapeada)
			while(tmp != null) {
				if(tmp.getKey() == k) {
					// Chave encontrada (Mapeada)
					return tmp;
				}
				tmp = tmp.getNxt();
			}
			// Chave desejada nao mapeada(Nao Mapeada)
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
		
		if(tmp != null) {
			// Chave mapeada (Mapeada)
			while( tmp.getNxt() != null ) {
				//pega o ultimo elemento da lista encadeada.
				tmp = tmp.getNxt();
			}
			tmp.setNxt(novoNo);
		}
		else {
			this.vetor[key] = novoNo;
		}
		

		this.size += 1;
	}
	
	public No removeElement(int k) throws NoSuchKeyException {
		int key = this.dispersao(k);
		
		No tmp = this.vetor[key];
		No before = null;
		
		if( tmp == null) {
			// Nao chaves nessa posicao
			throw new NoSuchKeyException();
		}
		else {
			// Existe(m) chave(s) nessa posicao
			if( tmp.getKey() == k) {
				// A chave eh o primeiro elemento;
				if( tmp.getNxt() == null) {
					// Nao possui proximo
					this.vetor[key] = null;
				}
				else {
					// Possui proximo
					this.vetor[key] = tmp.getNxt();
				}
				
				this.size -= 1;
				return tmp;
			}
			else {
				// A chave  nao e o primeiro elemento;
				if( tmp.getNxt() == null) {
					// Nao possui proximo
					throw new NoSuchKeyException();
				}
				else {
					// Possui proximo
					while( tmp != null ) {
						// Buscar chave
						before = tmp;
						tmp = tmp.getNxt();
						if( tmp.getKey() == k) {
							break;
						}
					}
						
					if(tmp == null) {
						// Nao encontrou a chave
						throw new NoSuchKeyException();
					}
					
					// Encontrou a chave
					before.setNxt(tmp.getNxt());
					this.size -= 1;
					return tmp;
				}
			}
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
		No tmp;
		
		for(int i=0; i<this.vetor.length; i++) {
			tmp = this.vetor[i];
			
			while(tmp != null) {
				keys.add(tmp.getKey());
				tmp = tmp.getNxt();
			}
		}
		return keys;
	}
	
	public List<Object> elements() {
		List<Object> elements = new ArrayList<Object>();
		No tmp;
		
		for(int i=0; i<this.vetor.length; i++) {
			tmp = this.vetor[i];
			
			while(tmp != null) {
				elements.add(tmp.getElement());
				tmp = tmp.getNxt();
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
		No novoVetor[] = new No[newSize];
		No antigoVetor[] = this.vetor;
		
		this.vetor = novoVetor;
		this.size = 0;
		this.fatorP = newSize;
		
		No tmp, tmpNxt;
		
		for(int i=0; i<antigoVetor.length; i++) {
			tmp = antigoVetor[i];
			while(tmp != null) {
				this.insertItem(tmp.getKey(), tmp.getElement());
				tmpNxt = tmp.getNxt();
				tmp.setNxt(null);
				tmp = tmpNxt;
			}
			antigoVetor[i] = null;
		}
		
		
	}
}
