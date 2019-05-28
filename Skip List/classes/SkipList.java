package classes;

import exceptions.NoSuchKey;
import java.util.Random;

public class SkipList {
	private NoQuad head;
	private NoQuad trailer;
	private Random rand;
	private int height;
	private int size;
	
	/**
	 * 	CONSTRUTORES
	 */
	public SkipList() {
		this.head = new NoQuad("-inf");
		this.trailer = new NoQuad("+inf");
		
		this.head.setRight(this.trailer);
		this.trailer.setLeft(this.head);
		
		this.rand = new Random();
		
		this.height = 0;
		this.size = 0;
	}
	
	/**
	 * 	METHODS
	 */
	
	public void inserir(Integer n) {
		int randCount = 0;
		while( rand.nextBoolean() ) {
			randCount += 1;
		}
		
		//	atualizar altura das laterais
		this.atualizarHeaderTrailer(randCount+1);
		
		NoQuad next = null;
		NoQuad last = null;
		NoQuad tmp = null;
		
		//	buscar ponto inical de insercao
		next = this.head.getDown();
		for(int i=0; i<this.height-(randCount+1); i++) {
			next = next.getDown();
		}
		
		while(next != null) {
			//	varredura vertical
			while( ((String)next.getRight().getElement()).compareTo("+inf") != 0
					&& ((String)next.getRight().getElement()).compareTo(String.valueOf(n)) < 0 ) {
				// varredura horizontal
				next = next.getRight();
			}
			
			// setting tmp
			tmp = new NoQuad(String.valueOf(n));
			tmp.setLeft(next);
			tmp.setRight(next.getRight());
			tmp.setUp(last);
			
			// setting tmp neighbor
			next.getRight().setLeft(tmp);
			next.setRight(tmp);
			if(last != null) {
				last.setDown(tmp);
			}
			
			last = tmp;
			next = next.getDown();
		}
		
		this.size += 1;
	}
	
	public NoQuad find(Integer n) throws NoSuchKey{
		NoQuad tmp = this.head;
		
		while(tmp != null && ((String)tmp.getElement()).compareTo(String.valueOf(n)) != 0 ) {
			//	Enquanto nao localizar elemento ou chegar em nulo
			if( ((String)tmp.getRight().getElement()).compareTo("+inf") == 0 ) {
				tmp = tmp.getDown();
			}
			else {
				if( ((String)tmp.getRight().getElement()).compareTo(String.valueOf(n)) <= 0 ) {
					tmp = tmp.getRight();
				}
				else {
					tmp = tmp.getDown();
				}
			}
		}
		
		if(tmp == null) {
			throw new NoSuchKey();
		}
		return tmp;
	}
	
	public NoQuad deletar(Integer n) throws NoSuchKey {
		NoQuad d = null;
		
		try {
			d = this.find(n);
		}catch(NoSuchKey e) {
			throw e;
		}
		
		NoQuad tmp = d;
		while(tmp != null) {
			tmp.setUp(null);
			tmp.getLeft().setRight(tmp.getRight());
			tmp.getRight().setLeft(tmp.getLeft());
			tmp.setLeft(null);
			tmp.setRight(null);
			
			tmp = tmp.getDown();
			if(tmp != null) {
				tmp.getUp().setDown(null);
			}
		}
		
		this.size -= 1;
		return d;
	}
	
	
	public String imprimir() {
		String result = null;
		result = "Header: " + String.valueOf(this.height+1) + "\n";
		
		NoQuad nextE = this.head;
		NoQuad nextCount = null;
		int count = 0;
		
		//	vai ate a base
		while(nextE.getDown() != null) {
			nextE = nextE.getDown();
		}
		
		nextE = nextE.getRight();
		while( ((String)nextE.getElement()).compareTo("+inf") != 0 ) {
			nextCount = nextE.getUp();
			count = 1;
			
			while(nextCount != null) {
				//	conta o numero de elementos extras
				nextCount = nextCount.getUp();
				count += 1;
			}
			
			result += (String)nextE.getElement() + ": " + String.valueOf(count) + "\n";
			nextE = nextE.getRight();
		}
		
		result += "Trailer: " + String.valueOf(this.height+1) + "\n";
		return result;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * 	PRIVATE METHODS
	 */
	
	private void atualizarHeaderTrailer(Integer n) {
		if(n > this.height) {
			int delta = n-this.height;
			NoQuad NoHeadTmp = null;
			NoQuad NoTrailerTmp = null;
			
			for(int i=0; i<delta; i++) {
				NoHeadTmp = new NoQuad("-inf");
				NoHeadTmp.setDown(this.head);
				
				NoTrailerTmp = new NoQuad("+inf");
				NoTrailerTmp.setDown(this.trailer);
				
				NoHeadTmp.setRight(NoTrailerTmp);
				NoTrailerTmp.setLeft(NoHeadTmp);
				
				this.head = NoHeadTmp;
				this.trailer = NoTrailerTmp;
				
				this.height += 1;
			}
		}
	}
}
// busca
// insercao *
// remocao