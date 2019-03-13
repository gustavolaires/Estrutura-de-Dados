package br.rn.natal.ifrn.classes;

public class No {
	private Object element;
	private No nxtNo;
	
	public No() {
		this.element = null;
		this.nxtNo = null;
	}

	public Object getElement() {
		return this.element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public No getNxtNo() {
		return this.nxtNo;
	}

	public void setNxtNo(No nxtNo) {
		this.nxtNo = nxtNo;
	}
	
	
}
