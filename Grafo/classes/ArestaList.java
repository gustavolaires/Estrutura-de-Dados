package classes;

import java.util.List;
import java.util.ArrayList;

public class ArestaList {
	private List<Aresta> arrayList = null;
	
	public ArestaList() {
		arrayList = new ArrayList<Aresta>();
	}

	public List<Aresta> getArrayList() {
		return arrayList;
	}

	public void setArrayList(List<Aresta> arrayList) {
		this.arrayList = arrayList;
	}
	

	
}
