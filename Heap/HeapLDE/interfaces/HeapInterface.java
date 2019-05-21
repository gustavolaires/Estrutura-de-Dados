package interfaces;

import java.util.List;
import classes.No;

public interface HeapInterface {
	// Metodos genericos
	public int size();
	public int height(No n);
	public int depth(No n);
	public boolean isEmpty();
	public List<Object> elements(int order);
	public List<No> nos(int order);
	
	// Metodos de acesso
	public No root();
	public No parent(No n);
	public List<No> children(No n);
	
	public No leftChild(No n);
	public No rightChild(No n);
	public boolean hasRightChild(No n);
	public boolean hasLeftChild(No n);
	
	// Metodos de consulta
	public boolean isInternal(No n);
	public boolean isExternal(No n);
	public boolean isRoot(No n);
	public List<No> preOrder(No n);
	public List<No> inOrder(No n);
	public List<No> posOrder(No n);
	public void drawHeap();
	
	// Metodos de atualizacao
	public Object replace(No n, Object o);
	public void swapElements(No n1, No n2);
	
	// Metodos de manipulacao
	public boolean insert(Object o);
	public boolean insert(No n);
	//public No remove(No n);
	public No search(Object o);
}
