package classes;

import java.util.List;
import java.util.ArrayList;

import interfaces.ArvoreRBInterface;

public class ArvoreRB implements ArvoreRBInterface{
	private int size;
	private NoRB root;
	
	private List<NoRB> auxNoList;
	
	// CONSTRUTORES
	public ArvoreRB() {
		this.root = null;
		this.size = 0;
		
		this.auxNoList = null;
	}
	public ArvoreRB(NoRB root) {
		this.root = root;
		this.size = 1;
		
		this.auxNoList = null;
	}
	public ArvoreRB(Object o) {
		this.root = new NoRB(null, o);
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
	public int height(NoRB n) {
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
	public int depth(NoRB n) {
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
		List<NoRB> noListTmp = nos(order);
		List<Object> objListTmp = new ArrayList<Object>();
		
		int listSize = noListTmp.size();
		for(int i=0; i<listSize; i++) {
			objListTmp.add(noListTmp.get(i).getElemento());
		}
		
		return objListTmp;
	}
	@Override
	public List<NoRB> nos(int order) {
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
	public NoRB root() {
		return this.root;
	}
	@Override
	public NoRB parent(NoRB n) {
		return n.getPai();
	}
	@Override
	public List<NoRB> children(NoRB n) {
		List<NoRB> list = new ArrayList<NoRB>();
		list.add(n.getFilhoEsquerdo());
		list.add(n.getFilhoDireito());
		return list;
	}
	@Override
	public NoRB leftChild(NoRB n) {
		return n.getFilhoEsquerdo();
	}
	@Override
	public NoRB rightChild(NoRB n) {
		return n.getFilhoDireito();
	}
	@Override
	public boolean hasRightChild(NoRB n) {
		if(n.getFilhoDireito() == null) {
			return false;
		}
		return true;
	}
	@Override
	public boolean hasLeftChild(NoRB n) {
		if(n.getFilhoEsquerdo() == null) {
			return false;
		}
		return true;
	}
	
		// <METODOS DE CONSULTA>
	@Override
	public boolean isInternal(NoRB n) {
		if( n.getFilhoDireito() != null || n.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isExternal(NoRB n) {
		if( n.getFilhoDireito() == null && n.getFilhoEsquerdo() == null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isRoot(NoRB n) {
		if( this.root == n) {
			return true;
		}
		return false;
	}
	@Override
	public List<NoRB> preOrder(NoRB n) {
		return this.preOrder(n, true);
	}
	private List<NoRB> preOrder(NoRB n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoRB>();
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
			List<NoRB> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	
	@Override
	public List<NoRB> inOrder(NoRB n) {
		return inOrder(n, true);
	}
	private List<NoRB> inOrder(NoRB n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoRB>();
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
			List<NoRB> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	@Override
	public List<NoRB> posOrder(NoRB n) {
		return posOrder(n, true);
	}
	private List<NoRB> posOrder(NoRB n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoRB>();
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
			List<NoRB> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	public void drawBinaryTree() {
		List<NoRB> tmpList = this.nos(0);
		
		int tmpSize = tmpList.size();
		int height = this.height(this.root);
		
		String[][] arvore = new String[height+1][tmpSize];
		
		NoRB n = null;
		int h = 0;
		
		for(int i=0; i<tmpSize; i++) {
			n = tmpList.get(i);
			h = this.depth(n);
			
			arvore[h][i] = String.valueOf( n.getElemento()) + "-" + n.getCorLetter();
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
	public Object replace(NoRB n, Object o) {
		Object tmp = n.getElemento();
		n.setElemento(o);
		return tmp;
	}
	@Override
	public void swapElements(NoRB n1, NoRB n2) {
		Object tmp = n1.getElemento();
		n1.setElemento(n2.getElemento());
		n2.setElemento(tmp);
	}
	
		// <METODOS DE MANIPULACAO>
	@Override
	public boolean insert(Object o) {
		NoRB newNo = new NoRB(null, o);
		return this.insert(newNo);	
	}
	@Override
	public boolean insert(NoRB n) {
		NoRB select = this.root;
		if(select == null) {
			this.root = n;
		}
		else {
			boolean condition = true;
			while(condition) {
				// No n ja existe
				if(NoRB.compare(n.getElemento(), select.getElemento()) == 0) {
					return false;
				}
				// No n é menor que o No select
				else if( NoRB.compare(n.getElemento(), select.getElemento()) < 0 ) {
					// Select tem filho esquerdo
					if( this.hasLeftChild(select) ) {
						select = select.getFilhoEsquerdo();
					}
					// Select nao tem filho esquerdo
					else {
						select.setFilhoEsquerdo(n);
						condition = false;
					}
				}
				// No n é maior que o No select
				else {
					// Select tem filho esquerdo
					if( this.hasRightChild(select) ) {
						select = select.getFilhoDireito();
					}
					// Select nao tem filho esquerdo
					else {
						select.setFilhoDireito(n);
						condition = false;
					}
				}
			}
			n.setPai(select);
		}
		this.size += 1;
		
		
		this.attTreeInsert(n); //Atualizar Arvore Rubro-Negra
		return true;
	}
	@Override
	public NoRB remove(NoRB n) {
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
			NoRB tmp = n.getFilhoDireito();
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
	@Override
	public NoRB search(Object o) {
		NoRB tmp = this.root;
		int cmp;
		while(tmp != null) {
			cmp = NoRB.compare( o, tmp.getElemento());
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
	
		/*
		 *----------------------------------*
		 |  MÉTODOS DE ROTACAO RUBRO-NEGRA  |
		 *----------------------------------*
		 */
	public void RSEsquerda(NoRB n) {
	/*
	*----------------------------------------------------------*
	|                IMPLEMENTACAO DIDATICA					|
	*----------------------------------------------------------*
	*/
	
	// Salvar referencia da sub-arvore
	NoRB tmpSubArvDE = n.getFilhoDireito().getFilhoEsquerdo();
	
	if(this.isRoot(n)) {
	// Eh raiz
	this.root = n.getFilhoDireito();
	}
	else {
	// Nao eh raiz
	if(n.getPai().getFilhoEsquerdo() == n) {
		// NoRB n eh filho esquerdo do pai
		n.getPai().setFilhoEsquerdo(n.getFilhoDireito());
	}
	else {
		// NoRB n eh filho direito do pai
		n.getPai().setFilhoDireito(n.getFilhoDireito());
	}
	}
	n.getFilhoDireito().setPai(n.getPai());
	
	n.setPai(n.getFilhoDireito());
	n.getFilhoDireito().setFilhoEsquerdo(n);
	
	n.setFilhoDireito(tmpSubArvDE);
	if(tmpSubArvDE != null) {
	tmpSubArvDE.setPai(n);
	}
	
	/*
	*----------------------------------------------------------*
	|           IMPLEMENTACAO SEM PONTEIRO AUXILIAR	  		||
	*----------------------------------------------------------*
	*
	*	n.setPai(n.getFilhoDireito());
	*
	*	n.setFilhoDireito(n.getFilhoDireito.getFilhoEsquerdo());
	*	n.getFilhoDireito().setPai(n);
	*
	*	n.getPai().setFilhoEsquerdo(n);
	*
	*/
	
	}
	
	public void RSDireita(NoRB n) {
	/*
	*----------------------------------------------------------*
	|                IMPLEMENTACAO DIDATICA					|
	*----------------------------------------------------------*
	*/
	
	// Salvar referencia da sub-arvore
	NoRB tmpSubArvED = n.getFilhoEsquerdo().getFilhoDireito();
	
	if(this.isRoot(n)) {
	// Eh raiz
	this.root = n.getFilhoEsquerdo();
	}
	else {
	// Nao eh raiz
	if(n.getPai().getFilhoEsquerdo() == n) {
		// NoRB n eh filho esquerdo do pai
		n.getPai().setFilhoEsquerdo(n.getFilhoEsquerdo());
	}
	else {
		// NoRB n eh filho direito do pai
		n.getPai().setFilhoDireito(n.getFilhoEsquerdo());
	}
	}
	n.getFilhoEsquerdo().setPai(n.getPai());
	
	n.setPai(n.getFilhoEsquerdo());
	n.getFilhoEsquerdo().setFilhoDireito(n);
	
	n.setFilhoEsquerdo(tmpSubArvED);
	if(tmpSubArvED != null) {
	tmpSubArvED.setPai(n);
	}
	
	
	/*
	*----------------------------------------------------------*
	|           IMPLEMENTACAO SEM PONTEIRO AUXILIAR	  		|
	*----------------------------------------------------------*
	*
	*	n.setPai(n.getFilhoEsquerdo());
	*
	*	n.setFilhoEsquerdo(n.getFilhoEsquerdo.getFilhoDireito());
	*	n.getFilhoEsquerdo().setPai(n);
	*
	*	n.getPai().setFilhoDireito(n);
	*
	*/
	
	}
	
	public void RDEsquerda(NoRB n) {
	this.RSDireita(n.getFilhoDireito());
	this.RSEsquerda(n);
	}
	public void RDDireita(NoRB n) {
	this.RSEsquerda(n.getFilhoEsquerdo());
	this.RSDireita(n);
	}
	
			/*
			 *----------------------------------------*
			 |  MÉTODOS DE BALANCEAMENTO RUBRO-NEGRA  |
			 *----------------------------------------*
			 */
	
	public void attTreeInsert(NoRB no) {
		if(this.isRoot(no) == true) {
			no.setNegro();
			return;
		}
		else if(no.getCorLetter() == 'r') {
			if(no.getPai().getCorLetter() == 'r') {
				if(no.getPai().getPai().getCorLetter() == 'n') {
					if(no.getPai().isLeftChild() ) {
						// pai filho esquerdo do avo
						if(no.getPai().getPai().getFilhoDireito() != null ) {
							// avo tem filho direito
							if(no.getPai().getPai().getFilhoDireito().getCorLetter() == 'r') {
								// cor do irmao do pai == rubro
								no.getPai().getPai().getFilhoDireito().setNegro();
								no.getPai().setNegro();
								no.getPai().getPai().setRubro();
								
								this.attTreeInsert(no.getPai().getPai());
							}
							else {
								// cor do irmao do pai == negro
								if(no.isLeftChild()) {
									// eh filho esquerdo
									no.getPai().getPai().setRubro();
									no.getPai().setNegro();
									this.RSDireita(no.getPai().getPai());
									
									this.attTreeInsert(no.getPai());
								}
								else {
									// eh filho direito
									no.getPai().getPai().setRubro();
									no.setNegro();
									this.RDDireita(no.getPai().getPai());
									
									this.attTreeInsert(no);
								}
							}
						}
						else {
							// avo nao tem filho direito
							if(no.isLeftChild()) {
								// eh filho esquerdo
								no.getPai().getPai().setRubro();
								no.getPai().setNegro();
								this.RSDireita(no.getPai().getPai());
								
								this.attTreeInsert(no.getPai());
							}
							else {
								// eh filho direito
								no.getPai().getPai().setRubro();
								no.setNegro();
								this.RDDireita(no.getPai().getPai());
								
								this.attTreeInsert(no);
							}
						}
					}
					else {
						// pai filho direito do avo
						if(no.getPai().getPai().getFilhoEsquerdo() != null ) {
							// avo tem filho esquerdo
							if(no.getPai().getPai().getFilhoEsquerdo().getCorLetter() == 'r') {
								// cor do irmao do pai == rubro
								no.getPai().getPai().getFilhoEsquerdo().setNegro();
								no.getPai().setNegro();
								no.getPai().getPai().setRubro();
								
								this.attTreeInsert(no.getPai().getPai());
							}
							else {
								// cor do irmao do pai == negro
								if(no.isLeftChild()) {
									// eh filho esquerdo
									no.getPai().getPai().setRubro();
									no.setNegro();
									this.RDEsquerda(no.getPai().getPai());
									
									this.attTreeInsert(no);
								}
								else {
									// eh filho direito
									no.getPai().getPai().setRubro();
									no.getPai().setNegro();
									this.RSEsquerda(no.getPai().getPai());
									
									this.attTreeInsert(no.getPai());
								}
							}
						}
						else {
							// avo nao tem filho esquerdo
							if(no.isLeftChild()) {
								// eh filho esquerdo
								no.getPai().getPai().setRubro();
								no.setNegro();
								this.RDEsquerda(no.getPai().getPai());
								
								this.attTreeInsert(no);
							}
							else {
								// eh filho direito
								no.getPai().getPai().setRubro();
								no.getPai().setNegro();
								this.RSEsquerda(no.getPai().getPai());
								
								this.attTreeInsert(no.getPai());
							}
						}
					}
				}
			}
			else {
				return;
			}
		}
	}
}
