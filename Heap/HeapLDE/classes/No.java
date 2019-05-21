package classes;

public class No {
	private Object elemento;
	private No filhoDireito;
	private No filhoEsquerdo;
	private No pai;
	
	// Construtores
	public No() {
		this.elemento = null;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = null;
	}
	public No(No pai, Object elemento) {
		this.elemento = elemento;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = pai;
	}
	
	// Metodos
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public No getFilhoDireito() {
		return filhoDireito;
	}
	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	public No getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	
	public static int compare(Object a, Object b) {
		if(a instanceof Integer && b instanceof Integer) {
			Integer intA = (Integer) a;
			Integer intB = (Integer) b;
			
			if(intA > intB) {
				return 1;
			}
			else if(intA == intB) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else if(a instanceof String && b instanceof String) {
			String stringA = (String) a;
			String stringB = (String) b;
			
			return stringA.compareTo(stringB);
		}
		return 0;
	}
}
