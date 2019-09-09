package interfaces;

import java.util.List;
import classes.NoRB;

public interface ArvoreRBInterface {
	// Metodos genericos
	public int size();
	public int height(NoRB n);
	public int depth(NoRB n);
	public boolean isEmpty();
	public List<Object> elements(int order);
	public List<NoRB> nos(int order);
	
	// Metodos de acesso
	public NoRB root();
	public NoRB parent(NoRB n);
	public List<NoRB> children(NoRB n);
	
	public NoRB leftChild(NoRB n);
	public NoRB rightChild(NoRB n);
	public boolean hasRightChild(NoRB n);
	public boolean hasLeftChild(NoRB n);
	
	// Metodos de consulta
	public boolean isInternal(NoRB n);
	public boolean isExternal(NoRB n);
	public boolean isRoot(NoRB n);
	public List<NoRB> preOrder(NoRB n);
	public List<NoRB> inOrder(NoRB n);
	public List<NoRB> posOrder(NoRB n);
	public void drawBinaryTree();
	
	// Metodos de atualizacao
	public Object replace(NoRB n, Object o);
	public void swapElements(NoRB n1, NoRB n2);
	
	// Metodos de manipulacao
	public boolean insert(Object o);
	public boolean insert(NoRB n);
	public NoRB remove(NoRB n);
	public NoRB search(Object o);
}
