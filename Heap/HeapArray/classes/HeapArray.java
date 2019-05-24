package classes;

import java.util.List;
import java.util.ArrayList;

public class HeapArray {
	private int size;
	private Object elements[];
	
	private List<Integer> auxList = null;
	
	// CONSTRUTORES
	public HeapArray() {
		this.elements = new Object[2];
		this.size = 0;
	}
	public HeapArray(Object n) {
		this.elements = new Object[2];
		this.elements[0] = n;
		this.size = 1;
	}
	
	// METODOS
		// <METODOS GENERICOS>
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}

	public void drawHeap() {
		//gerar lista inOrder
		List<Integer> tmpList = this.inOrder(0, true);
		
		int tmpSize = tmpList.size();
		
		//obter maior altura no heap
		int height = 0;
		while( height*2 + 1 < this.elements.length && this.elements[height*2 + 1] != null) {
			height += 1;
		}
		
		//criar tabela
		String[][] arvore = new String[height+1][tmpSize];
		
		//preencher tabela
		int h = 0;
		for(int i=0; i<tmpSize; i++) {
			h = this.depth( tmpList.get(i));
			arvore[h][i] = String.valueOf( tmpList.get(i));
		}
		
		//impressao da tabela
		if(this.size > 0) {
			for(int i=0; i<height+1; i++) {
				for(int j=0; j<tmpSize; j++) {
					if(arvore[i][j] == "null" || arvore[i][j] == "" || arvore[i][j] == null) {
						System.out.print("\t");
					}
					else {
						System.out.print(arvore[i][j]+"\t");
					}
				}
				System.out.println();
			}
		}
	}
	
	private List<Integer> preOrder(Integer n, boolean first) {
		if(first) {
			this.auxList = new ArrayList<Integer>();
		}
		
		if( this.elements.length > n && this.elements[n] != null) {
			int left = n*2 + 1;
			int right = n*2 + 2;
			
			this.auxList.add((Integer)this.elements[n]);
			//verifica se ha filho esquerdo
			if(this.elements.length > left) {
				if(this.elements[left] != null) {
					this.preOrder(left, false);
				}
			}
			//verifica se ha filho direito
			if(this.elements.length > right) {
				if(this.elements[right] != null) {
					this.preOrder(right, false);
				}
			}	
		}
		
		if(first) {
			List<Integer> tmp = this.auxList;
			this.auxList = null;
			return tmp; 
		}
		return null;
	}
	
	private List<Integer> inOrder(Integer n, boolean first) {
		if(first) {
			this.auxList = new ArrayList<Integer>();
		}
		
		if( this.elements.length > n && this.elements[n] != null) {
			int left = n*2 + 1;
			int right = n*2 + 2;
			
			
			//verifica se ha filho esquerdo
			if(this.elements.length > left) {
				if(this.elements[left] != null) {
					this.inOrder(left, false);
				}
			}
			this.auxList.add((Integer)this.elements[n]);
			//verifica se ha filho direito
			if(this.elements.length > right) {
				if(this.elements[right] != null) {
					this.inOrder(right, false);
				}
			}	
		}
		
		if(first) {
			List<Integer> tmp = this.auxList;
			this.auxList = null;
			return tmp; 
		}
		return null;
	}
	
	private List<Integer> posOrder(Integer n, boolean first) {
		if(first) {
			this.auxList = new ArrayList<Integer>();
		}
		
		if( this.elements.length > n && this.elements[n] != null) {
			int left = n*2 + 1;
			int right = n*2 + 2;
			
			//verifica se ha filho esquerdo
			if(this.elements.length > left) {
				if(this.elements[left] != null) {
					this.posOrder(left, false);
				}
			}
			//verifica se ha filho direito
			if(this.elements.length > right) {
				if(this.elements[right] != null) {
					this.posOrder(right, false);
				}
			}
			this.auxList.add((Integer)this.elements[n]);
		}
		
		if(first) {
			List<Integer> tmp = this.auxList;
			this.auxList = null;
			return tmp; 
		}
		return null;
	}
	
	public int depth(int value) {
		int depth = -1;
		for(int i=0; i<this.elements.length; i++) {
			if( (Integer)this.elements[i] == value) {
				//elemento localizado
				depth = 0;
				int pos = i;
				while(pos != 0) {
					//calcula profundidade retornando pra raiz
					if(pos % 2 == 1) {
						pos = (pos-1)/2;
					}
					else {
						pos = (pos-2)/2;
					}
					depth += 1;
				}
				break;
			}
		}
		return depth;
	}
	
	// <METODOS DE ATUALIZACAO>

	public void swapElements(int n1, int n2) {
		Object tmp = this.elements[n1];
		this.elements[n1] = this.elements[n2];
		this.elements[n2] = tmp;
	}
	
		// <METODOS DE MANIPULACAO>
	public boolean insert(Object n) {
		int index = this.size;
		
		//aumento do vetor
		if(this.size == this.elements.length) {
			Object tmp[] = new Object[this.elements.length*2];
			
			for(int i=0; i<this.elements.length; i++) {
				tmp[i] = this.elements[i];
			}
			
			this.elements = tmp;
		}
		
		this.elements[index] = n;
		
		this.upHeap(index);
		
		this.size += 1;
		return true;
	}
	
	public boolean removeMin() {
		if(this.size > 0) {
			this.swapElements(0, this.size-1);
			this.elements[this.size-1] = null;
		}
		else {
			return false;
		}
		
		this.downHeap(0);
		this.size -= 1;
		return true;
	}
	
	private void upHeap(int index) {
		int tmp = 0;
		while(index != 0) {
			
			if( index % 2 == 0) {
				tmp = (index-2)/2;
			}
			else {
				tmp = (index-1)/2;
			}
			
			if( (Integer)this.elements[index] < (Integer)this.elements[tmp]) {
				this.swapElements(index, tmp);
			}
			index = tmp;
		}
	}
	
	private void downHeap(int index) {
		int left = index*2 + 1;
		int right = index*2 + 2;
		
		boolean hasLeft = false;
		boolean hasRight = false;
		
		//verifica se ha filho esquerdo
		if(this.elements.length > left) {
			if(this.elements[left] != null) {
				hasLeft = true;
			}
		}
		//verifica se ha filho direito
		if(this.elements.length > right) {
			if(this.elements[right] != null) {
				hasRight = true;
			}
		}
		
		//busca do menor valor
		int menor = 0;
		if(hasLeft && hasRight) {
			if( (Integer)this.elements[left] > (Integer)this.elements[right] ) { menor = right; }
			else { menor = left; }
		}
		else if(hasLeft) { menor = left; }
		else if(hasRight) { menor = right; }
		else { menor = -1; }
		
		//swap elements e chamada recursiva
		if(menor != -1) {
			this.swapElements(index, menor);
			downHeap(menor);
		}	
	}
}
