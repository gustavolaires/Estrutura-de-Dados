package classes;

import java.util.List;
import java.util.ArrayList;

import interfaces.HeapInterface;

public class Heap implements HeapInterface{
	private int size;
	private No root;
	private No last;
	
	private List<No> auxNoList;
	
	// CONSTRUTORES
	public Heap() {
		this.root = null;
		this.last = null;
		this.size = 0;
		
		this.auxNoList = null;
	}
	public Heap(No root) {
		this.root = root;
		this.last = root;
		this.size = 1;
		
		this.auxNoList = null;
	}
	public Heap(Object o) {
		this.root = new No(null, o);
		this.last = this.root();
		this.size = 1;
		
		this.auxNoList = null;
	}
	
	// METODOS
		// <METODOS GENERICOS>
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public int height(No n) {
		if(n == null || this.isExternal(n)) {
			return 0;
		}
		else {
			int left = this.height(n.getFilhoEsquerdo());
			int right = this.height(n.getFilhoDireito());
			if( left > right ) {
				return 1+left;
			}
			return 1+right;
		}
	}
	@Override
	public int depth(No n) {
		if(n == null) {
			return -1;
		}
		if(this.isRoot(n)) {
			return 0;
		}
		return 1+this.depth(n.getPai());
	}
	@Override
	public boolean isEmpty() {
		if(this.root == null) {
			return true;
		}
		return false;
	}
	@Override
	public List<Object> elements(int order) {
		List<No> noListTmp = nos(order);
		List<Object> objListTmp = new ArrayList<Object>();
		
		int listSize = noListTmp.size();
		for(int i=0; i<listSize; i++) {
			objListTmp.add(noListTmp.get(i).getElemento());
		}
		
		return objListTmp;
	}
	@Override
	public List<No> nos(int order) {
		if( order < 0) {
			return this.preOrder(this.root);
		}
		else if( order == 0) {
			return this.inOrder(this.root);
		}
		else {
			return this.posOrder(this.root);
		}
	}
	
		// <METODOS DE ACESSO>
	@Override
	public No root() {
		return this.root;
	}
	public No last() {
		return this.last;
	}
	@Override
	public No parent(No n) {
		return n.getPai();
	}
	@Override
	public List<No> children(No n) {
		List<No> list = new ArrayList<No>();
		list.add(n.getFilhoEsquerdo());
		list.add(n.getFilhoDireito());
		return list;
	}
	@Override
	public No leftChild(No n) {
		return n.getFilhoEsquerdo();
	}
	@Override
	public No rightChild(No n) {
		return n.getFilhoDireito();
	}
	@Override
	public boolean hasRightChild(No n) {
		if(n.getFilhoDireito() == null) {
			return false;
		}
		return true;
	}
	@Override
	public boolean hasLeftChild(No n) {
		if(n.getFilhoEsquerdo() == null) {
			return false;
		}
		return true;
	}
	
		// <METODOS DE CONSULTA>
	@Override
	public boolean isInternal(No n) {
		if( n.getFilhoDireito() != null || n.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isExternal(No n) {
		if( n.getFilhoDireito() == null && n.getFilhoEsquerdo() == null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isRoot(No n) {
		if( this.root == n) {
			return true;
		}
		return false;
	}
	@Override
	public List<No> preOrder(No n) {
		return this.preOrder(n, true);
	}
	private List<No> preOrder(No n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<No>();
		}
		
		if( n != null) {
			this.auxNoList.add(n);
			if( n.getFilhoEsquerdo() != null) {
				this.preOrder(n.getFilhoEsquerdo(), false);
			}
			if( n.getFilhoDireito() != null) {
				this.preOrder(n.getFilhoDireito(), false);
			}
			
		}
		
		if(first) {
			List<No> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	
	@Override
	public List<No> inOrder(No n) {
		return inOrder(n, true);
	}
	private List<No> inOrder(No n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<No>();
		}
		
		if( n != null) {
			if( n.getFilhoEsquerdo() != null) {
				this.inOrder(n.getFilhoEsquerdo(), false);
			}
			this.auxNoList.add(n);
			if( n.getFilhoDireito() != null) {
				this.inOrder(n.getFilhoDireito(), false);
			}
		}
		
		
		if(first) {
			List<No> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	@Override
	public List<No> posOrder(No n) {
		return posOrder(n, true);
	}
	private List<No> posOrder(No n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<No>();
		}
		
		if( n != null) {
			if( n.getFilhoEsquerdo() != null) {
				this.posOrder(n.getFilhoEsquerdo(), false);
			}
			
			if( n.getFilhoDireito() != null) {
				this.posOrder(n.getFilhoDireito(), false);
			}
			this.auxNoList.add(n);
		}
		
		if(first) {
			List<No> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	public void drawHeap() {
		List<No> tmpList = this.nos(0);
		
		int tmpSize = tmpList.size();
		int height = this.height(this.root);
		
		String[][] arvore = new String[height+1][tmpSize];
		
		No n = null;
		int h = 0;
		
		for(int i=0; i<tmpSize; i++) {
			n = tmpList.get(i);
			h = this.depth(n);
			
			arvore[h][i] = String.valueOf( n.getElemento());
		}
		
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
	
	// <METODOS DE ATUALIZACAO>
	@Override
	public Object replace(No n, Object o) {
		Object tmp = n.getElemento();
		n.setElemento(o);
		return tmp;
	}
	@Override
	public void swapElements(No n1, No n2) {
		Object tmp = n1.getElemento();
		n1.setElemento(n2.getElemento());
		n2.setElemento(tmp);
	}
	
		// <METODOS DE MANIPULACAO>
	@Override
	public boolean insert(Object o) {
		No newNo = new No(null, o);
		return this.insert(newNo);	
	}
	@Override
	public boolean insert(No n) {
		No select = this.root;
		if(select == null) {
			//Heap vazio
			this.root = n;
			n.setPai(null);
		}
		else {
			//Heap com elementos
			select = this.last;
			if(select == this.root) {
				//Ultimo elemento inserido foi o root
				select.setFilhoEsquerdo(n);
			}
			else {
				while(select.getPai() != null && select != select.getPai().getFilhoEsquerdo()) {
					select = select.getPai();
				}
				
				if(select.getPai() != null) {
					//Filho esquerdo
					select = select.getPai();
					
					if(select.getFilhoDireito() == null) {
						//Nao tem filho direito
						select.setFilhoDireito(n);
					}
					else {
						//Possui filho direito
						select = select.getFilhoDireito();
						while(select.getFilhoEsquerdo() != null) {
							select = select.getFilhoEsquerdo();
						}
						select.setFilhoEsquerdo(n);
					}
				}
				else {
					//É root
					while(select.getFilhoEsquerdo() != null) {
						select = select.getFilhoEsquerdo();
					}
					select.setFilhoEsquerdo(n);
				}
			}
			n.setPai(select);
		}
		this.upHeap(n);
		this.last = n;
		this.size += 1;
		return true;
	}
	
	public boolean removeMin() {
		No select = this.root;
		if(select == null) {
			//Heap vazio
			return false;
		}
		else {
			//Heap com elementos
			this.swapElements(this.last, this.root);
			
			select = this.last;
			
			if(select == this.root) {
				//Ultimo elemento inserido foi o root
				this.root = null;
				this.last = null;
			}
			else {
				No tmp = this.last;
				while(select.getPai() != null && select != select.getPai().getFilhoDireito()) {
					select = select.getPai();
				}
				
				if(select.getPai() != null) {
					//Filho direito
					select = select.getPai().getFilhoEsquerdo();
					
					while(select.getFilhoDireito() != null) {
						select = select.getFilhoDireito();
					}
					this.last = select;
				}
				else {
					//É root
					while(select.getFilhoDireito() != null) {
						select = select.getFilhoDireito();
					}
					this.last = select;
				}
				
				if( tmp == tmp.getPai().getFilhoEsquerdo() ) {
					tmp.getPai().setFilhoEsquerdo(null);
					tmp.setPai(null);
				}
				else {
					tmp.getPai().setFilhoDireito(null);;
					tmp.setPai(null);
				}
			}
		}
		
		this.downHeap();
		this.size -= 1;
		return true;
	}
	
	/*
	@Override
	public No remove(No n) {
		// não possui filhos
		if( this.isExternal(n)) {
			if( this.isRoot(n)) {
				this.root = null;
			}
			else {
				if( n.getPai().getFilhoEsquerdo() == n ) {
					n.getPai().setFilhoEsquerdo(null);
				}
				else {
					n.getPai().setFilhoDireito(null);
				}
				n.setPai(null);
			}
		}
		// possui 2 filhos
		else if( this.hasLeftChild(n) && this.hasRightChild(n) ) {
			No tmp = n.getFilhoDireito();
			while( this.hasLeftChild(tmp)) {
				tmp = tmp.getFilhoEsquerdo();
			}
			Object objTmp = n.getElemento();
			n.setElemento(tmp.getElemento());
			tmp.setElemento(objTmp);
			
			return this.remove(tmp);
		}
		// possui apenas 1 filho
		else {
			if( this.isRoot(n)) {
				if( this.hasLeftChild(n)) {
					this.root = n.getFilhoEsquerdo();
				}
				else {
					this.root = n.getFilhoDireito();
				}
				this.root.setPai(null);
			}
			else {
				if( this.hasLeftChild(n)) {
					if( n.getPai().getFilhoEsquerdo() == n) {
						n.getPai().setFilhoEsquerdo(n.getFilhoEsquerdo());
						n.getFilhoEsquerdo().setPai(n.getPai());
					}
					else {
						n.getPai().setFilhoDireito(n.getFilhoEsquerdo());
						n.getFilhoEsquerdo().setPai(n.getPai());
						
					}
					n.setFilhoEsquerdo(null);
				}
				else {
					if( n.getPai().getFilhoEsquerdo() == n) {
						n.getPai().setFilhoEsquerdo(n.getFilhoDireito());
						n.getFilhoDireito().setPai(n.getPai());
					}
					else {
						n.getPai().setFilhoDireito(n.getFilhoDireito());
						n.getFilhoDireito().setPai(n.getPai());
						
					}
					n.setFilhoDireito(null);
				}
				n.setPai(null);
			}
		}
		this.size -= 1;
		return n;
	}
	*/
	
	@Override
	public No search(Object o) {
		No tmp = this.root;
		int cmp;
		while(tmp != null) {
			cmp = No.compare( o, tmp.getElemento());
			if(cmp == 0) {
				break;
			}
			else if(cmp > 0) {
				tmp = tmp.getFilhoDireito();
			}
			else {
				tmp = tmp.getFilhoEsquerdo();
			}
		}
		return tmp;
	}
	
	private void upHeap(No n) {
		No select = n;
		while(select.getPai() != null) {
			if( No.compare(select.getElemento(), select.getPai().getElemento()) < 0) {
				this.swapElements(select, select.getPai());
				select = select.getPai();
			}
			else {
				break;
			}
		}
	}
	
	
	private void downHeap() {
		No select = this.root;
		while(select != null) {
			if(select.getFilhoEsquerdo() != null) {
				if(select.getFilhoDireito() != null) {
					//possui os dois filhos
					if( No.compare(select.getFilhoEsquerdo().getElemento(), select.getFilhoDireito().getElemento()) <= 0) {
						//filho direito não é o menor
						if(No.compare(select.getElemento(), select.getFilhoEsquerdo().getElemento()) > 0) {
							this.swapElements(select.getFilhoEsquerdo(), select);
						}
						select = select.getFilhoEsquerdo();
					}
					else {
						//filho direito é o menor
						if(No.compare(select.getElemento(), select.getFilhoDireito().getElemento()) > 0) {
							this.swapElements(select.getFilhoDireito(), select);
						}
						select = select.getFilhoDireito();
					}
					
				}
				else {
					//possui um filho
					if(No.compare(select.getElemento(), select.getFilhoEsquerdo().getElemento()) > 0) {
						this.swapElements(select.getFilhoEsquerdo(), select);
					}
					select = select.getFilhoEsquerdo();
				}
			}
			else {
				//nao possui filho
				select = null;
				break;
			}
		}
	}
}
