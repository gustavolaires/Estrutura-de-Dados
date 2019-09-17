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
			
			String dn = "";
			if(n.getDuploNegro() == -1) {
				dn = "DN-L";
			}
			else if(n.getDuploNegro() == 1) {
				dn = "DN-D";
			}
			else {
				dn = "";
			}
			
			arvore[h][i] = String.valueOf( n.getElemento()) + "-" + n.getCorLetter() + " " + dn;
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
				//atualizar arvore removacao
				attTreeRemove(n, null);
				
				if( n.getPai().getFilhoEsquerdo() == n ) {
					n.getPai().setFilhoEsquerdo(null);
				}
				else {
					n.getPai().setFilhoDireito(null);
				}
				
				//captura do pai
				NoRB pai = n.getPai();
				
				n.setPai(null);
				
				//rebalaceamento da arvore
				rebalanceTreeRemove(pai);
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
					//atualizar arvore removacao
					attTreeRemove(n, n.getFilhoEsquerdo());
					
					this.root = n.getFilhoEsquerdo();
					n.setFilhoEsquerdo(null);
				}
				else {
					//atualizar arvore removacao
					attTreeRemove(n, n.getFilhoDireito());
					
					this.root = n.getFilhoDireito();
					n.setFilhoDireito(null);
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
					
					//atualizar arvore removacao
					attTreeRemove(n, n.getFilhoEsquerdo());
					
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
					
					//atualizar arvore removacao
					attTreeRemove(n, n.getFilhoDireito());
					
					n.setFilhoDireito(null);
				}
				
				//captura do pai
				NoRB pai = n.getPai();
				
				n.setPai(null);
				
				//rebalaceamento da arvore
				rebalanceTreeRemove(pai);
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
	
	private void attTreeInsert(NoRB no) {
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
	
	private void attTreeRemove(NoRB noRemoved, NoRB noRelocated) {
		if(noRelocated != null) {
			
			/*
			if(this.isRoot(noRelocated)) {
				noRelocated.setNegro();
				return;
			}
			*/
			
			if(noRelocated.getCorLetter() == 'n') {
				if(noRelocated.isLeftChild()) {
					noRelocated.getPai().setDuploNegro(-1);
				}
				else {
					noRelocated.getPai().setDuploNegro(1);
				}
			}
			
			noRelocated.setCor(noRemoved.getCor());
		}
		else {
			
			if(noRemoved.getCorLetter() == 'n') {
				if(noRemoved.isLeftChild()) {
					noRemoved.getPai().setDuploNegro(-1);
				}
				else {
					noRemoved.getPai().setDuploNegro(1);
				}
			}
		}
	}
	
	private void rebalanceTreeRemove(NoRB no) {
		if(no == null) {
			return;
		}
		
		if(no.getDuploNegro() != 0) {
			// duploNegro no filho da esquerda
			if(no.getDuploNegro() == -1) {
				
				//filho esquerdo - n
				if( ( no.getFilhoEsquerdo() != null && no.getFilhoEsquerdo().getCorLetter() == 'n' ) ||
						no.getFilhoEsquerdo() == null ) {
					
					//filho direito - n
					if( no.getFilhoDireito() != null && no.getFilhoDireito().getCorLetter() == 'n' ) {
						
						//caso 4
						if( no.getFilhoDireito().getFilhoDireito() != null 
								&& no.getFilhoDireito().getFilhoDireito().getCorLetter() == 'r' ) {
							no.getFilhoDireito().setCor(no.getCor());
							no.setCor(1);
							no.getFilhoDireito().getFilhoDireito().setCor(1);
							this.RSEsquerda(no);
							no.setDuploNegro(0);
						}
						
						//caso 3
						else if(no.getFilhoDireito().getFilhoEsquerdo() != null 
								&& no.getFilhoDireito().getFilhoEsquerdo().getCorLetter() == 'r'
								&& (no.getFilhoDireito().getFilhoDireito() == null 
									|| (no.getFilhoDireito().getFilhoDireito() != null 
										&& no.getFilhoDireito().getFilhoDireito().getCorLetter() == 'n'))) {
							no.getFilhoDireito().getFilhoEsquerdo().setCor(1);
							no.getFilhoDireito().setCor(-1);
							this.RSDireita(no.getFilhoDireito());
						}
						
						//caso 2
						else if( ( no.getFilhoDireito().getFilhoDireito() == null 
								|| (no.getFilhoDireito().getFilhoDireito() != null 
								&& no.getFilhoDireito().getFilhoDireito().getCorLetter() == 'n' ))
							&& ( no.getFilhoDireito().getFilhoEsquerdo() == null 
									|| (no.getFilhoDireito().getFilhoEsquerdo() != null 
									&& no.getFilhoDireito().getFilhoEsquerdo().getCorLetter() == 'n' ))
							) {
							
							//caso 2a
							if(no.getCorLetter() == 'n') {
								no.getFilhoDireito().setCor(-1);
								no.setDuploNegro(0);
								if(no.getPai() != null) {
									if(no.isLeftChild()) {
										no.getPai().setDuploNegro(-1);
									}
									else {
										no.getPai().setDuploNegro(1);
									}
									//no = no.getPai();
								}
							}
							//caso 2b
							else {
								no.getFilhoDireito().setCor(-1);
								no.setDuploNegro(0);
								no.setCor(1);
								return;
							}
						}
					}
					else if( no.getFilhoDireito() != null && no.getFilhoDireito().getCorLetter() == 'r' ) {
						//caso 1
						no.setCor(-1);
						no.getFilhoDireito().setCor(1);
						this.RSEsquerda(no);
					}
				}
			}
			// duploNegro no filho da direta
			else {
				
				// filho direito - n
				if( ( no.getFilhoDireito() != null && no.getFilhoDireito().getCorLetter() == 'n' ) ||
						no.getFilhoDireito() == null ) {
					
					// filho esquerdo - n
					if( no.getFilhoEsquerdo() != null && no.getFilhoEsquerdo().getCorLetter() == 'n' ) {
						
						//caso 4
						if( no.getFilhoEsquerdo().getFilhoEsquerdo() != null && 
								no.getFilhoEsquerdo().getFilhoEsquerdo().getCorLetter() == 'r' ) {
							no.getFilhoEsquerdo().setCor(no.getCor());
							no.setCor(1);
							no.getFilhoEsquerdo().getFilhoEsquerdo().setCor(1);
							this.RSDireita(no);
							no.setDuploNegro(0);
						}
						
						//caso 3
						else if(no.getFilhoEsquerdo().getFilhoDireito() != null 
								&& no.getFilhoEsquerdo().getFilhoDireito().getCorLetter() == 'r'
								&& (no.getFilhoEsquerdo().getFilhoEsquerdo() == null 
									|| (no.getFilhoEsquerdo().getFilhoEsquerdo() != null 
										&& no.getFilhoEsquerdo().getFilhoEsquerdo().getCorLetter() == 'n'))) {
							no.getFilhoEsquerdo().getFilhoDireito().setCor(1);
							no.getFilhoEsquerdo().setCor(-1);
							this.RSEsquerda(no.getFilhoEsquerdo());
						}
						
						//caso 2
						else if( ( no.getFilhoEsquerdo().getFilhoEsquerdo() == null 
								|| (no.getFilhoEsquerdo().getFilhoEsquerdo() != null 
								&& no.getFilhoEsquerdo().getFilhoEsquerdo().getCorLetter() == 'n' ))
							&& ( no.getFilhoEsquerdo().getFilhoDireito() == null 
									|| (no.getFilhoEsquerdo().getFilhoDireito() != null 
									&& no.getFilhoEsquerdo().getFilhoDireito().getCorLetter() == 'n' ))
							) {
							
							//caso 2a
							if(no.getCorLetter() == 'n') {
								no.getFilhoEsquerdo().setCor(-1);
								no.setDuploNegro(0);
								if(no.getPai() != null) {
									if(no.isLeftChild()) {
										no.getPai().setDuploNegro(-1);
									}
									else {
										no.getPai().setDuploNegro(1);
									}
									//no = no.getPai();
								}
							}
							//caso 2b
							else {
								no.getFilhoEsquerdo().setCor(-1);
								no.setDuploNegro(0);
								no.setCor(1);
								return;
							}
						}
					
					}
					else if( no.getFilhoEsquerdo() != null && no.getFilhoEsquerdo().getCorLetter() == 'r' ) {
						//caso 1
						no.setCor(-1);
						no.getFilhoEsquerdo().setCor(1);
						this.RSDireita(no);
					}
				}
			}
			rebalanceTreeRemove(no);
		}
		else {
			rebalanceTreeRemove(no.getPai());
		}
	}
	
}
