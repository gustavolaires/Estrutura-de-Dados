package classes;

import java.util.ArrayList;
import java.util.List;
//import java.util.Set;
//import java.util.HashSet;

public class GrafoMA {
	private Object [] vertice;
	private ArestaList [][] arestas;
	private int qtdVertice;
	
	/*
	 * CONSTRUTOR
	 */
	
	public GrafoMA() {
		this.vertice = new Object[2];
		this.arestas = new ArestaList [2][2];
		this.qtdVertice = 0;
	}
	
	/*
	 * METODOS 
	 */
	
	public List<Object> finalVertices(Aresta e) {
		List<Object> verticesTemp = new ArrayList<Object>();
		boolean brk = false;
		
		for(int i=0; i<this.qtdVertice; i++) {
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[i][j].getArrayList().size(); k++) {
					if(this.arestas[i][j].getArrayList().get(k).getElement().equals(e.getElement()) ) {
						verticesTemp.add(this.vertice[i]);
						if( i!=j ) {
							verticesTemp.add(this.vertice[j]);
						}
						brk = true;
						break;
					}
				}
				if(brk) break;
			}
			if(brk) break;
		}
		
		return verticesTemp;
	}
	
	public List<Object> oposto(Object v, Aresta e) {
		List<Object> vertices = this.finalVertices(e);
		
		if( vertices.contains(v) ) {
			vertices.remove(v);
			return vertices;
		}
		return null;
	}
	
	public boolean ehAdjacente(Object v, Object w) {
		int lin = -1, col = -1;
		
		for(int i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v) ) lin = i;
			if(this.vertice[i].equals(w) ) col = i;
			if( (lin != -1) && (col != -1) ) break;
		}
		
		if( (lin == -1) || (col == -1) ) {
			return false;
		}
		
		int qtd = this.arestas[lin][col].getArrayList().size() +
				this.arestas[col][lin].getArrayList().size();
	
		if(qtd > 0) return true;
		return false;
	}
	
	public boolean substituir(Object v, Object x) {
		for(int i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v) ) {
				this.vertice[i] = x;
				return true;
			}
		}
		return false;
	}
	
	public boolean substituir(Aresta e, Object x) {
		for(int i=0; i<this.qtdVertice; i++) {
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[i][j].getArrayList().size(); k++) {
					if(this.arestas[i][j].getArrayList().get(k).getElement().equals(e.getElement()) ) {
						this.arestas[i][j].getArrayList().get(k).setElement(x);
						return true;
					}
				}
			}
		}
		return false;
	}

	public void inserirVertice(Object v) {
		if( this.qtdVertice == this.vertice.length ) {
			this.aumentarGrafo();
		}
		
		this.vertice[this.qtdVertice] = v;
		
		for(int i=0; i<this.qtdVertice+1; i++) {
			this.arestas[i][this.qtdVertice] = new ArestaList();
			this.arestas[this.qtdVertice][i] = new ArestaList();
		}
		
		this.qtdVertice++;
	}
	
	public void inserirAresta(Object v, Object w, Object o) {
		int lin = -1, col = -1;
		
		for(int i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v) ) lin = i;
			if(this.vertice[i].equals(w) ) col = i;
			if( (lin != -1) && (col != -1) ) break;
		}
		
		if( (lin != -1) && (col != -1) ) {
			Aresta newAresta = new Aresta(o);
			this.arestas[lin][col].getArrayList().add(newAresta);
			this.arestas[col][lin].getArrayList().add(newAresta);
		}
	}
	
	public void inserirArestaDirecionada(Object v, Object w, Object o) {
		int lin = -1, col = -1;
		
		for(int i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v) ) lin = i;
			if(this.vertice[i].equals(w) ) col = i;
			if( (lin != -1) && (col != -1) ) break;
		}
		
		if( (lin != -1) && (col != -1) ) {
			Aresta newAresta = new Aresta(o);
			newAresta.setTipo(1);
			this.arestas[lin][col].getArrayList().add(newAresta);
		}
	}
	
	public void removeVertice(Object v) {
		int i=0;
		for(i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v) ) break;
		}
		
		if( i == this.qtdVertice ) return;
		
		for(int j=0; j<this.qtdVertice; j++) {
			this.arestas[i][j].getArrayList().clear();
			this.arestas[j][i].getArrayList().clear();
		}
		
		for(i++; i<this.qtdVertice; i++) {
			this.vertice[i-1] = this.vertice[i];
			
			for(int j=0; j<this.qtdVertice; j++) {
				this.arestas[i-1][j] = this.arestas[i][j];
				this.arestas[j][i-1] = this.arestas[j][i];
				
				if( i == this.qtdVertice-1 ) {
					this.vertice[i] = null;
					this.arestas[i][j] = new ArestaList();
					this.arestas[j][i] = new ArestaList();
				}
			}
		}
		
		this.qtdVertice --;
	}
	
	public void removeAresta(Aresta e) {
		boolean brk = false;
		
		for(int i=0; i<this.qtdVertice; i++) {
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[i][j].getArrayList().size(); k++) {
					if(this.arestas[i][j].getArrayList().get(k).getElement().equals(e.getElement()) ) {
						Aresta tmp = this.arestas[i][j].getArrayList().get(k);
						if( this.arestas[i][j].getArrayList().get(k).getTipo() == 0 ) {
							this.arestas[j][i].getArrayList().remove(tmp);
						}
						this.arestas[i][j].getArrayList().remove(tmp);
						brk = true;
						break;
					}
				}
				if(brk) break;
			}
			if(brk) break;
		}
	}
	
	public List<Aresta> arestasIncidentes(Object v){
		List<Aresta> arestaListTemp = new ArrayList<Aresta>();
		
		int lin = -1;
		
		for(int i=0; i<this.qtdVertice; i++) {
			if(this.vertice[i].equals(v)) {
				lin = i;
				break;
			}
		}
		
		if(lin != -1) {
			//Elementos saida do vertice
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[lin][j].getArrayList().size(); k++) {
					arestaListTemp.add(this.arestas[lin][j].getArrayList().get(k));
				}
			}
			
			//Elementos destino no vertice
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[j][lin].getArrayList().size(); k++) {
					Aresta tmp = this.arestas[j][lin].getArrayList().get(k);
					if( !arestaListTemp.contains(tmp) ) arestaListTemp.add(tmp);
				}
			}
		}
		
		return arestaListTemp;
	}
	
	public List<Object> vertices() {
		List<Object> verticesList = new ArrayList<Object>();
		
		for(int i=0; i<this.qtdVertice; i++) {
			verticesList.add(this.vertice[i]);
		}
		
		return verticesList;
	}
	
	public List<Aresta> arestas () {
		List<Aresta> ArestaListTemp = new ArrayList<Aresta>();
		
		for(int i=0; i<this.qtdVertice; i++) {
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[i][j].getArrayList().size(); k++) {
					if( i <= j) {
						ArestaListTemp.add(this.arestas[i][j].getArrayList().get(k));
					}
					else {
						if(!ArestaListTemp.contains(this.arestas[i][j].getArrayList().get(k))) {
							ArestaListTemp.add(this.arestas[i][j].getArrayList().get(k));
						}
					}
					
				}
			}
		}
		
		return ArestaListTemp;
	}
	
	public boolean ehDirecionado(Aresta a) {
		for(int i=0; i<this.qtdVertice; i++) {
			for(int j=0; j<this.qtdVertice; j++) {
				for(int k=0; k<this.arestas[i][j].getArrayList().size(); k++) {
					if(this.arestas[i][j].getArrayList().get(k).getElement().equals(a.getElement()) ) {
						
						if(this.arestas[i][j].getArrayList().get(k).getTipo() == 1) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public List<Object> verticesAdjacentes(Object v){
		// Busca vertice no grafo
		int pos=0;
		for(pos=0; pos<this.qtdVertice; pos++) {
			if(this.vertice[pos] == v) break;
		}
		
		// Vertice nao existe no grafo
		if(pos == this.qtdVertice) return null;
		
		List<Object> adj = new ArrayList<Object>();
		List<Aresta> arestaList = null;
		
		// Pega os vertices adjacentes
		for(int j=0; j<this.qtdVertice; j++) {
			arestaList = this.arestas[pos][j].getArrayList();
			if(arestaList.size() > 0) adj.add(this.vertice[j]);
		}
		return adj;
	}
	
	/*
	 * METODOS PESSOAIS
	 */
	
	public void printGrafo() {
		
		System.out.println("Grafo");
		if(this.qtdVertice == 0) {
			System.out.println("O grafo nao possui vertices!\n");
			return;
		}
		
		//Variavel de selecao de lista de arestas
		List<Aresta> arestasListTemp;
		
		for(int i=0; i<this.qtdVertice; i++) {
			System.out.println("Vertice " + String.valueOf(this.vertice[i]) + ":");
			
			for(int j=0; j<this.qtdVertice; j++) {
				System.out.print(String.valueOf(this.vertice[j]) + ": ");
				
				arestasListTemp = this.arestas[i][j].getArrayList();
				int arrayListSize = arestasListTemp.size();
				
				for(int k=0; k< arrayListSize; k++) {
					System.out.print(String.valueOf(arestasListTemp.get(k).getElement()) + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/*
	 * METODOS PRIVADOS
	 */
	
	private void aumentarGrafo() {
		int newSize = this.vertice.length * 2;
		
		Object [] tempVertices = new Object[ newSize];
		ArestaList [][] tempMatriz =  new ArestaList[ newSize][ newSize];
		
		for(int i=0; i<this.vertice.length; i++) {
			tempVertices[i] = this.vertice[i];
			tempMatriz[i][i] = this.arestas[i][i];
			
			for(int j=i+1; j<this.vertice.length; j++) {
				tempMatriz[i][j] = this.arestas[i][j];
				tempMatriz[j][i] = this.arestas[j][i];
			}
		}
		
		this.vertice = tempVertices;
		this.arestas = tempMatriz;
	}
}
