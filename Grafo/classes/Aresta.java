package classes;

public class Aresta {
	private Object element;
	private int tipo;
	/*
	 * 1 - Direcionado
	 * 0 - Nao Direcionado
	 */
	
	/*
	 * CONSTRUTORES
	 */
	public Aresta() {
		this.element = null;
		this.tipo = 0;
	}
	
	public Aresta(Object o) {
		this.element = o;
		this.tipo = 0;
	}
	
	/*
	 * METODOS
	 */
	
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
