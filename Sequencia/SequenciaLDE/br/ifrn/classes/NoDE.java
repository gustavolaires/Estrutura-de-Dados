package br.ifrn.classes;

import br.ifrn.classes.NoDE;

public class NoDE {
	private Object element;
	private NoDE prevNo;
	private NoDE nxtNo;
	
	
	public NoDE() {
		this.element = null;
		this.prevNo = null;
		this.nxtNo = null;
	}

	public Object getElement() {
		return this.element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
	public NoDE getPrevNo() {
		return this.prevNo;
	}
	
	public void setPrevNo(NoDE prevNo) {
		this.prevNo = prevNo;
	}

	public NoDE getNxtNo() {
		return this.nxtNo;
	}

	public void setNxtNo(NoDE nxtNo) {
		this.nxtNo = nxtNo;
	}
	
	
}
