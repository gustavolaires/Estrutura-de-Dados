package classes;

public class NoAVL {
	private Object elemento;
	private NoAVL filhoDireito;
	private NoAVL filhoEsquerdo;
	private NoAVL pai;
	private int balanceFactor;
	
	/*
	 *----------------*
	 |  CONSTRUTORES  |
	 *----------------*
	 */
	public NoAVL() {
		this.elemento = null;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = null;
		this.balanceFactor = 0;
	}
	public NoAVL(NoAVL pai, Object elemento) {
		this.elemento = elemento;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = pai;
		this.balanceFactor = 0;
	}
	
	/*
	 *-----------------------*
	 |  GETTERS AND SETTERS  |
	 *-----------------------*
	 */
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	public NoAVL getFilhoDireito() {
		return filhoDireito;
	}
	public void setFilhoDireito(NoAVL filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	
	public NoAVL getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
	public void setFilhoEsquerdo(NoAVL filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	
	public NoAVL getPai() {
		return pai;
	}
	public void setPai(NoAVL pai) {
		this.pai = pai;
	}
	
	public int getBalanceFactor() {
		return balanceFactor;
	}
	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
	
	/*
	 *-------------------*
	 |  COMPARE METHODS  |
	 *-------------------*
	 */
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
