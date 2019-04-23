import java.util.Iterator;
import java.util.Vector;

public class ArvoreSimples implements ArvoreGenerica
{
	//Atributos da árvore
	NoArvore raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new NoArvore(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da árvore */
	public Position root()
	{
		return raiz;
	}
	/** Retorna o nó pai de um nó */
	public Position parent(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.parent());
	}
	/** retorna os filhos de um nó */
	public Iterator children(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n.children();
	}
	/** Testa se um nó é interno */
	public boolean isInternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() > 0);
	}
	/** Testa se um nó é externo*/
	public boolean isExternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() == 0);
	}
	/** Testa se um nó é a raiz */
	public boolean isRoot(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n == raiz;
	}
	/** Adiciona um filho a um nó */
	public void addChild(Position v, Object o)
	{
		NoArvore n = (NoArvore) v;
		NoArvore novo = new NoArvore(n, o);
		n.addChild(novo);
		tamanho++;
	}
	/** Remove um nó
	 *  Só pode remover nós externos e que tenham um pai (não seja raiz)
	*/
	public Object remove(Position v) throws InvalidPositionException
	{
		NoArvore n = (NoArvore) v;
		NoArvore pai = n.parent();
		if (pai != null || isExternal(n))
			pai.removeChild(n);
		else
			throw new InvalidPositionException();
		Object o = n.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posição */
	public void swapElements(Position v, Position w)
	{
		Object aux = v.element();
		((NoArvore)v).setElement( w.element());
		((NoArvore)w).setElement(aux);
	}
	/** Retorna a profundidade de um nó */
	public int depth(Position v)
	{
		NoArvore n = (NoArvore) v;
		int profundidade = profundidade(n);
		return profundidade;
	}
	private int profundidade(NoArvore n)
	{
		if (n == raiz)
			return 0;
		else
			return 1 + profundidade(n.parent());
	}
	/** Retorna a altura da árvore */
	public int height(Position v)
	{
		if(this.isExternal(v)) {
			return 0;
		}
		
		int h=0;
		int aux=0;
		Iterator iter = ((NoArvore)v).children();
			
		while( iter.hasNext()) {
			NoArvore f = (NoArvore) iter.next();
			aux = 1 + this.height(f);
			
			if(aux > h) h = aux;
		}
		
		return h;
	}
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements()
	{
		// Método não implementados --- Coleguinha fique a vontade para fazê-los
		return null;
	}
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator nos() {
		// Método não implementados --- Coleguinha fique a vontade para fazê-los
		return null;
	}
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator positions()
	{
		// Método não implementados --- Coleguinha fique a vontade para fazê-los
		return null;
	}
	/** Retorna o número de nós da árvore
	 */
	public int size()
	{
		return 0;
	}
	/** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(Position v, Object o)
	{
		Object aux = v.element();
		((NoArvore)v).setElement(o);
		return aux;
	}
	/* Início da classe aninhada para armazenar o nó*/
	private class NoArvore implements Position
	{
		private Object o;
		private NoArvore pai;
		private Vector filhos = new Vector();
		public NoArvore(NoArvore pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public NoArvore parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(NoArvore o)
		{
			filhos.add(o);
		}
		public void removeChild(NoArvore o)
		{
			filhos.remove(o);
		}
		public int childrenNumber()
		{
			return filhos.size();
		}
		public Iterator children()
		{
			return filhos.iterator();
		}
	}
	/* Fim da classe aninhada para armazenar o nó */
}
