package interfaces;

import java.util.List;
import classes.NoAVL;

public interface ArvoreAVLInterface {
	// Metodos genericos
	public int size();
	public int height(NoAVL n);
	public int depth(NoAVL n);
	public boolean isEmpty();
	public List<Object> elements(int order);
	public List<NoAVL> nos(int order);
	
	// Metodos de acesso
	public NoAVL root();
	public NoAVL parent(NoAVL n);
	public List<NoAVL> children(NoAVL n);
	
	public NoAVL leftChild(NoAVL n);
	public NoAVL rightChild(NoAVL n);
	public boolean hasRightChild(NoAVL n);
	public boolean hasLeftChild(NoAVL n);
	
	// Metodos de consulta
	public boolean isInternal(NoAVL n);
	public boolean isExternal(NoAVL n);
	public boolean isRoot(NoAVL n);
	public List<NoAVL> preOrder(NoAVL n);
	public List<NoAVL> inOrder(NoAVL n);
	public List<NoAVL> posOrder(NoAVL n);
	public void drawBinaryTree();
	
	// Metodos de atualizacao
	public Object replace(NoAVL n, Object o);
	public void swapElements(NoAVL n1, NoAVL n2);
	
	// Metodos de manipulacao
	public boolean insert(Object o);
	public boolean insert(NoAVL n);
	public NoAVL remove(NoAVL n);
	public NoAVL search(Object o);
}
