package classes;

public class No {
	private int key;
	private Object element;
	private boolean available;
	private No nxt;
	
	// <CONSTRUTORES>
	public No () {
		
	}
	public No(int key, Object element, No nxt) {
		this.key = key;
		this.element = element;
		this.available = false;
		this.nxt = nxt;
	}
	
	// <METHODS>
	public int getKey() {
		return this.key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Object getElement() {
		return this.element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public No getNxt() {
		return this.nxt;
	}
	public void setNxt(No nxt) {
		this.nxt = nxt;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
