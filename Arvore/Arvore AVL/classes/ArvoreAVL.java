package classes;

import java.util.List;
import java.util.ArrayList;
import interfaces.ArvoreAVLInterface;

public class ArvoreAVL implements ArvoreAVLInterface{
	private int size;
	private NoAVL root;
	
	private List<NoAVL> auxNoList;
	
	/*
	 *----------------*
	 |  CONSTRUTORES  |
	 *----------------*
	 */
	public ArvoreAVL() {
		this.root = null;
		this.size = 0;
		
		this.auxNoList = null;
	}
	public ArvoreAVL(NoAVL root) {
		this.root = root;
		this.size = 1;
		
		this.auxNoList = null;
	}
	public ArvoreAVL(Object o) {
		this.root = new NoAVL(null, o);
		this.size = 1;
		
		this.auxNoList = null;
	}
	
	/*
	 *-----------*
	 |  MÉTODOS  |
	 *-----------*
	 */
				/*
				 *---------------------*
				 |  MÉTODOS GENÉRICOS  |
				 *---------------------*
				 */
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public int height(NoAVL n) {
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
	public int depth(NoAVL n) {
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
		List<NoAVL> noListTmp = nos(order);
		List<Object> objListTmp = new ArrayList<Object>();
		
		int listSize = noListTmp.size();
		for(int i=0; i<listSize; i++) {
			objListTmp.add(noListTmp.get(i).getElemento());
		}
		
		return objListTmp;
	}
	@Override
	public List<NoAVL> nos(int order) {
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
	
				/*
				 *---------------------*
				 |  MÉTODOS DE ACESSO  |
				 *---------------------*
				 */
	@Override
	public NoAVL root() {
		return this.root;
	}
	@Override
	public NoAVL parent(NoAVL n) {
		return n.getPai();
	}
	@Override
	public List<NoAVL> children(NoAVL n) {
		List<NoAVL> list = new ArrayList<NoAVL>();
		list.add(n.getFilhoEsquerdo());
		list.add(n.getFilhoDireito());
		return list;
	}
	@Override
	public NoAVL leftChild(NoAVL n) {
		return n.getFilhoEsquerdo();
	}
	@Override
	public NoAVL rightChild(NoAVL n) {
		return n.getFilhoDireito();
	}
	@Override
	public boolean hasRightChild(NoAVL n) {
		if(n.getFilhoDireito() == null) {
			return false;
		}
		return true;
	}
	@Override
	public boolean hasLeftChild(NoAVL n) {
		if(n.getFilhoEsquerdo() == null) {
			return false;
		}
		return true;
	}
	
				/*
				 *-----------------------*
				 |  MÉTODOS DE CONSULTA  |
				 *-----------------------*
				 */
	@Override
	public boolean isInternal(NoAVL n) {
		if( n.getFilhoDireito() != null || n.getFilhoEsquerdo() != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isExternal(NoAVL n) {
		if( n.getFilhoDireito() == null && n.getFilhoEsquerdo() == null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isRoot(NoAVL n) {
		if( this.root == n) {
			return true;
		}
		return false;
	}
	@Override
	public List<NoAVL> preOrder(NoAVL n) {
		return this.preOrder(n, true);
	}
	private List<NoAVL> preOrder(NoAVL n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoAVL>();
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
			List<NoAVL> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	
	@Override
	public List<NoAVL> inOrder(NoAVL n) {
		return inOrder(n, true);
	}
	private List<NoAVL> inOrder(NoAVL n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoAVL>();
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
			List<NoAVL> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	@Override
	public List<NoAVL> posOrder(NoAVL n) {
		return posOrder(n, true);
	}
	private List<NoAVL> posOrder(NoAVL n, boolean first) {
		if(first) {
			this.auxNoList = new ArrayList<NoAVL>();
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
			List<NoAVL> tmp = this.auxNoList;
			this.auxNoList = null;
			return tmp; 
		}
		
		return null;
	}
	
	public void drawBinaryTree() {
		List<NoAVL> tmpList = this.nos(0);
		
		int tmpSize = tmpList.size();
		int height = this.height(this.root);
		
		String[][] arvore = new String[height+1][tmpSize];
		
		NoAVL n = null;
		int h = 0;
		
		for(int i=0; i<tmpSize; i++) {
			n = tmpList.get(i);
			h = this.depth(n);
			
			arvore[h][i] = String.valueOf( n.getElemento()) + ":" + String.valueOf( n.getBalanceFactor());
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
	
				/*
				 *--------------------------*
				 |  MÉTODOS DE ATUALIZAÇÃO  |
				 *--------------------------*
				 */
	@Override
	public Object replace(NoAVL n, Object o) {
		Object tmp = n.getElemento();
		n.setElemento(o);
		return tmp;
	}
	@Override
	public void swapElements(NoAVL n1, NoAVL n2) {
		Object tmp = n1.getElemento();
		n1.setElemento(n2.getElemento());
		n2.setElemento(tmp);
	}
	
				/*
				 *--------------------------*
				 |  MÉTODOS DE MANIPULACAO  |
				 *--------------------------*
				 */
	@Override
	public boolean insert(Object o) {
		NoAVL newNo = new NoAVL(null, o);
		return this.insert(newNo);	
	}
	@Override
	public boolean insert(NoAVL n) {
		NoAVL select = this.root;
		if(select == null) {
			this.root = n;
		}
		else {
			boolean condition = true;
			while(condition) {
				// NoAVL n ja existe
				if(NoAVL.compare(n.getElemento(), select.getElemento()) == 0) {
					return false;
				}
				// NoAVL n é menor que o NoAVL select
				else if( NoAVL.compare(n.getElemento(), select.getElemento()) < 0 ) {
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
				// NoAVL n é maior que o NoAVL select
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
		
		//	Aplicacao metodos da AVL - Insercao
		
		NoAVL tmp = n;
		while(select != null) {
			if(tmp == select.getFilhoEsquerdo()) {
				select = this.addRmvBF(select, -1, 1);
			}
			else {
				select = this.addRmvBF(select, 1, 1);
			}
			
			if(select != null) {
				this.chooseRotation(select);
				if( !this.checkBF(select, 1)) {
					select = null;
				}
				else {
					tmp = select;
					select = select.getPai();
				}
			}
		}
		
		return true;
	}
	@Override
	public NoAVL remove(NoAVL n) {
		NoAVL selectRmv = null;
		int side = 0;
		
		// não possui filhos
		if( this.isExternal(n)) {
			if( this.isRoot(n)) {
				this.root = null;
			}
			else {
				if( n.getPai().getFilhoEsquerdo() == n ) {
					n.getPai().setFilhoEsquerdo(null);
					side = -1; //capitura de posicao do No n em relacao ao pai
				}
				else {
					n.getPai().setFilhoDireito(null);
					side = 1; //capitura de posicao do No n em relacao ao pai
				}
				selectRmv = n.getPai(); //capitura de referencia do pai do elemento q sera removido
				n.setPai(null);
			}
		}
		// possui 2 filhos
		else if( this.hasLeftChild(n) && this.hasRightChild(n) ) {
			NoAVL tmp = n.getFilhoDireito();
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
						side = -1; //capitura de posicao do No n em relacao ao pai
					}
					else {
						n.getPai().setFilhoDireito(n.getFilhoEsquerdo());
						n.getFilhoEsquerdo().setPai(n.getPai());
						side = 1; //capitura de posicao do No n em relacao ao pai
						
					}
					n.setFilhoEsquerdo(null);
				}
				else {
					if( n.getPai().getFilhoEsquerdo() == n) {
						n.getPai().setFilhoEsquerdo(n.getFilhoDireito());
						n.getFilhoDireito().setPai(n.getPai());
						side = -1; //capitura de posicao do No n em relacao ao pai
					}
					else {
						n.getPai().setFilhoDireito(n.getFilhoDireito());
						n.getFilhoDireito().setPai(n.getPai());
						side = 1; //capitura de posicao do No n em relacao ao pai
						
					}
					n.setFilhoDireito(null);
				}
				selectRmv = n.getPai(); //capitura de referencia do pai do elemento q sera removido
				n.setPai(null);
			}
		}
		this.size -= 1;
		
		//	Aplicacao metodos da AVL - Remocao
		
		while(selectRmv != null) {
			if( side != 0 ) {
				selectRmv = this.addRmvBF(selectRmv, side, -1);
			}
			else {
				break;
			}
			
			if(selectRmv != null) {
				this.chooseRotation(selectRmv);
				
				selectRmv = selectRmv.getPai(); // TESTE
				
				if( !this.checkBF(selectRmv, -1)) {
					selectRmv = null;
				}
				else {
					if(selectRmv.getPai() != null) {
						if(selectRmv.getPai().getFilhoEsquerdo() == selectRmv) {
							side = -1;
						}
						else {
							side = 1;
						}
					}
					selectRmv = selectRmv.getPai();
				}
			}
		}
		
		return n;
	}
	@Override
	public NoAVL search(Object o) {
		NoAVL tmp = this.root;
		int cmp;
		while(tmp != null) {
			cmp = NoAVL.compare( o, tmp.getElemento());
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
				 *--------------------------*
				 |  MÉTODOS DE ROTACAO AVL  |
				 *--------------------------*
				 */
	public void RSEsquerda(NoAVL n) {
		/*
		 *----------------------------------------------------------*
		 |                IMPLEMENTACAO DIDATICA					|
		 *----------------------------------------------------------*
		 */
		
		// Salvar referencia da sub-arvore
		NoAVL tmpSubArvDE = n.getFilhoDireito().getFilhoEsquerdo();
		
		if(this.isRoot(n)) {
			// Eh raiz
			this.root = n.getFilhoDireito();
		}
		else {
			// Nao eh raiz
			if(n.getPai().getFilhoEsquerdo() == n) {
				// NoAVL n eh filho esquerdo do pai
				n.getPai().setFilhoEsquerdo(n.getFilhoDireito());
			}
			else {
				// NoAVL n eh filho direito do pai
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
		
		atualizaBF(n.getPai(), n, -1);
	}
	public void RSDireita(NoAVL n) {
		/*
		 *----------------------------------------------------------*
		 |                IMPLEMENTACAO DIDATICA					|
		 *----------------------------------------------------------*
		 */
		
		// Salvar referencia da sub-arvore
		NoAVL tmpSubArvED = n.getFilhoEsquerdo().getFilhoDireito();
		
		if(this.isRoot(n)) {
			// Eh raiz
			this.root = n.getFilhoEsquerdo();
		}
		else {
			// Nao eh raiz
			if(n.getPai().getFilhoEsquerdo() == n) {
				// NoAVL n eh filho esquerdo do pai
				n.getPai().setFilhoEsquerdo(n.getFilhoEsquerdo());
			}
			else {
				// NoAVL n eh filho direito do pai
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
		
		atualizaBF(n.getPai(), n, 1);
	}
	
	public void RDEsquerda(NoAVL n) {
		this.RSDireita(n.getFilhoDireito());
		this.RSEsquerda(n);
	}
	public void RDDireita(NoAVL n) {
		this.RSEsquerda(n.getFilhoEsquerdo());
		this.RSDireita(n);
	}
	
				/*
				 *--------------------------------*
				 |  MÉTODOS DE BALANCEAMENTO AVL  |
				 *--------------------------------*
				 */
	public void atualizaBF(NoAVL nA, NoAVL nB, int direction) {
		int menor = 0, maior = 0;
		
		if(direction == -1) {
			/*	rotacao a esquerda
			 * 
			 * FB_B_novo= FB_B + 1 - min(FB_A, 0);
			 * FB_A_novo= FB_A + 1 + max(FB_B_novo, 0);
			 */
			
			if( nA.getBalanceFactor() < 0) {
				menor = nA.getBalanceFactor();
			}
			nB.setBalanceFactor( nB.getBalanceFactor() + 1 - menor );
			
			if( nB.getBalanceFactor() > 0) {
				maior = nB.getBalanceFactor();
			}
			nA.setBalanceFactor( nA.getBalanceFactor() + 1 + maior );
		}
		if(direction == 1) {
			/*	rotacao a direita
			 * 
			 * FB_B_novo= FB_B - 1 - max(FB_A, 0);
			 * FB_A_novo= FB_A - 1 + min(FB_B_novo, 0);
			 */
			
			if( nA.getBalanceFactor() > 0) {
				maior = nA.getBalanceFactor();
			}
			nB.setBalanceFactor( nB.getBalanceFactor() - 1 - maior );
			
			if( nB.getBalanceFactor() < 0) {
				menor = nB.getBalanceFactor();
			}
			nA.setBalanceFactor( nA.getBalanceFactor() - 1 + menor );
		}
	}
	
	public NoAVL addRmvBF(NoAVL n, int side, int op){
		/* 
		 *  -- SIDE --
		 *   -1: Left
		 *   1: Right
		 */
		n.setBalanceFactor(n.getBalanceFactor() + (op*side*(-1)) );
		System.out.println(n.getElemento() + " + " + String.valueOf(side) + " : " + String.valueOf(op) ); //imprimir
		if(op == 1) {
			//increment
			if(checkBF( n, op)) {
				// Criterio para continuar atualizacao por insercao/remocao
				if(n.getBalanceFactor() > 1 || n.getBalanceFactor() < -1) {
					return n;
				}
				if(this.isRoot(n)) {
					return null;
				}
				if( n == n.getPai().getFilhoEsquerdo() ) {
					// o No n eh filho esquerdo
					return addRmvBF(n.getPai(), -1, op);
				}
				else {
					// o No n eh filho direito
					return addRmvBF(n.getPai(), 1, op);
				}
			}
		}
		else {
			//decrement
			if(checkBF( n, op)) {
				// Criterio para continuar atualizacao por insercao/remocao
				if(n.getBalanceFactor() > 1 || n.getBalanceFactor() < -1) {
					return n;
				}
				if(this.isRoot(n)) {
					return null;
				}
				if( n == n.getPai().getFilhoEsquerdo() ) {
					// o No n eh filho esquerdo
					return addRmvBF(n.getPai(), -1, op);
				}
				else {
					// o No n eh filho direito
					return addRmvBF(n.getPai(), 1, op);
				}
			}
		}
		return null;
	}
	
	public boolean checkBF(NoAVL n, int op) {
		if(op == 1) {
			if(n.getBalanceFactor() == 0) return false;
			return true;
		}
		else {
			if(n.getBalanceFactor() == -1 || n.getBalanceFactor() == 1) return false;
			return true;
		}
	}
	
	public void chooseRotation(NoAVL n) {
		if(n.getBalanceFactor() <= -2) {
			//System.out.println( (int)n.getElemento() );
			if(n.getFilhoDireito().getBalanceFactor() > 0) {
				this.RDEsquerda(n);
			}
			else {
				this.RSEsquerda(n);
			}
		}
		else if(n.getBalanceFactor() >= 2){
			if(n.getFilhoEsquerdo().getBalanceFactor() < 0) {
				this.RDDireita(n);
			}
			else {
				this.RSDireita(n);
			}
		}
	}
}
