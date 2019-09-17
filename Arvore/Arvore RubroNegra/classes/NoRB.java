package classes;

public class NoRB {
	private Object elemento;
	private NoRB filhoDireito;
	private NoRB filhoEsquerdo;
	private NoRB pai;
	
	private int cor;
		// -1 => rubro
		//  1 => negro
	private int duploNegro;
		// -1 => duploNegro filho esquerdo
		//  0 => SEM DUPLO NEGRO
		//  1 => duploNegro filho direito
	
	
	// Construtores
	public NoRB() {
		this.elemento = null;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = null;
		this.cor = -1;
		this.duploNegro = 0;
	}
	public NoRB(NoRB pai, Object elemento) {
		this.elemento = elemento;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = pai;
		this.cor = -1;
		this.duploNegro = 0;
	}
	
	// Metodos
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public NoRB getFilhoDireito() {
		return filhoDireito;
	}
	public void setFilhoDireito(NoRB filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	public NoRB getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
	public void setFilhoEsquerdo(NoRB filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	public NoRB getPai() {
		return pai;
	}
	public void setPai(NoRB pai) {
		this.pai = pai;
	}
	
	public int getCor() {
		return cor;
	}
	public String getCorNome(){
		if (this.cor == -1) return "rubro";
		return "negro";
	}
	public char getCorLetter() {
		if (this.cor == -1) return 'r';
		return 'n';
	}
	public void setCor(int cor) {
		this.cor = cor;
	}
	public void setRubro() {
		this.cor = -1;
	}
	public void setNegro() {
		this.cor = 1;
	}
	public int getDuploNegro() {
		return duploNegro;
	}
	public void setDuploNegro(int duploNegro) {
		this.duploNegro = duploNegro;
	}
	
	public boolean isLeftChild() {
		if(this.getPai().getFilhoEsquerdo() == this) {
			return true;
		}
		return false;
	}
	public boolean isRightChild() {
		if(this.getPai().getFilhoDireito() == this) {
			return true;
		}
		return false;
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
