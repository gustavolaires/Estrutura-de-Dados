package classes;

public class NoQuad {
	private Object element;
	private NoQuad up;
	private NoQuad down;
	private NoQuad left;
	private NoQuad right;
	
	/**
	 * CONSTRUTORES
	 */
	public NoQuad() {
		this.element = null;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
	}
	public NoQuad(Object element) {
		this.element = element;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
	}
	public NoQuad(Object element, NoQuad up, NoQuad down, NoQuad left, NoQuad right) {
		this.element = element;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * GETTERS AND SETTERS
	 */
		//	ELEMENT
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
		//	UP
	public NoQuad getUp() {
		return up;
	}
	public void setUp(NoQuad up) {
		this.up = up;
	}
		//	DOWN
	public NoQuad getDown() {
		return down;
	}
	public void setDown(NoQuad down) {
		this.down = down;
	}
		//	LEFT
	public NoQuad getLeft() {
		return left;
	}
	public void setLeft(NoQuad left) {
		this.left = left;
	}
		// RIGHT
	public NoQuad getRight() {
		return right;
	}
	public void setRight(NoQuad right) {
		this.right = right;
	}
}
