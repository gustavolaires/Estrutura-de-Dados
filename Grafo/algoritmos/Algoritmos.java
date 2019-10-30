package algoritmos;

import classes.GrafoMA;
import classes.Aresta;
import java.util.List;
import java.util.ArrayList;

public class Algoritmos {
	private GrafoMA grafo;
	
	Algoritmos(){
		this.grafo = null;
	}
	public Algoritmos(GrafoMA grafo){
		this.grafo = grafo;
	}
	
	public GrafoMA getGrafo() {
		return grafo;
	}
	public void setGrafo(GrafoMA grafo) {
		this.grafo = grafo;
	}
	
	public List<DFS> AlgoritmoDFS(int verticeIndex){
		// Verificacao de seguranca
		if(this.grafo == null) return null;
		
		List<Object> verticesList = grafo.vertices();
		
		// Verifica se o grafo possui vertices
		if(verticesList.size() <= 0) return null;
		
		List<DFS> objsDFS = new ArrayList<DFS>();
		DFS obj = null;
		DFS objFirst = null;
		
		// Criando lista de objetos DFS
		// D, S e Visited -> 0
		for(int i=0; i<verticesList.size(); i++) {
			obj = new DFS(verticesList.get(i));
			objsDFS.add(obj);
			// Salva o primeiro elemento do caminhamento
			if(i == verticeIndex) objFirst = obj;
		}
		
		int t = 0;
		
		t = VisitObjectDFS(objFirst, t, objsDFS);
		for(int i=0; i<objsDFS.size(); i++) {
			if(objsDFS.get(i).getVisited() == 0) {
				t = VisitObjectDFS(objsDFS.get(i), t, objsDFS);
			}
		}
		
		// Retorno do metodo
		return objsDFS;
	}
	
	public void printListDFS(List<DFS> objsDFS) {
		System.out.println("\nResultado DFS:");
		for(int i=0; i<objsDFS.size(); i++) {
			System.out.println(
					objsDFS.get(i).getVertice().toString() + " D(v):" +
					objsDFS.get(i).getD() + " S(v):" +
					objsDFS.get(i).getS()
					);
		}
		System.out.println();
	}
	
	private int VisitObjectDFS(DFS objDFS, int t, List<DFS> objsDFS){
		objDFS.setVisited(-1); // visitado
		objDFS.setD(++t);
		
		// Pega os vertices adjacentes ao vertice
		List<Object> adjs = this.grafo.verticesAdjacentes(objDFS.getVertice());
		for(int i=0; i<adjs.size(); i++) {
			// Escolhe um vertice na lista de vertices adjacentes
			Object temp = adjs.get(i);
			
			for(int j=0; j<objsDFS.size(); j++) {
				//Procura o vertice na lista de objsDFS 
				if(objsDFS.get(j).getVertice() == temp) {
					if(objsDFS.get(j).getVisited() == 0 ) {
						t = this.VisitObjectDFS(objsDFS.get(j), t, objsDFS);
					}
					break;
				}
			}
		}
		
		objDFS.setVisited(1); // marcado
		objDFS.setS(++t);
		return t;
	}
	
	public List<BFS> AlgoritmoBFS(int verticeIndex){
		// Verificacao de seguranca
		if(this.grafo == null) return null;
		
		List<Object> verticesList = this.grafo.vertices();
		
		// Verifica se o grafo possui vertices
		if(verticesList.size() <= 0) return null;
		
		List<BFS> objsBFS = new ArrayList<BFS>();
		List<BFS> temp = new ArrayList<BFS>();
		BFS obj = null;
		BFS objFirst = null;
		
		// Criando lista de objetos BFS
		// D, S e Visited -> 0
		for(int i=0; i<verticesList.size(); i++) {
			obj = new BFS(verticesList.get(i));
			objsBFS.add(obj);
			// Salva o primeiro elemento do caminhamento
			if(i == verticeIndex) objFirst = obj;
		}
		
		// Executando para o objeto selecionado
		objFirst.setVisited(-1);
		objFirst.setD(0);
		temp.add(objFirst);
		
		while(temp.size() > 0) {
			obj = temp.remove(0);
			// Buscando adjacentes
			List<Object> adjsTemp = this.grafo.verticesAdjacentes(obj.getVertice());
			
			for(int i=0; i<adjsTemp.size(); i++) {
				for(int j=0; j<objsBFS.size(); j++) {
					if(objsBFS.get(j).getVertice().equals(adjsTemp.get(i))) {
						if(objsBFS.get(j).getVisited() == 0) {
							objsBFS.get(j).setD(obj.getD() + 1);
							objsBFS.get(j).setVisited(-1);
							temp.add(objsBFS.get(j));
						}
						break;
					}
				}
			}
			obj.setVisited(1);
		}
		
		// Retorno do metodo
		return objsBFS;
	}
	
	public void printListBFS(List<BFS> objsBFS) {
		System.out.println("\nResultado BFS:");
		for(int i=0; i<objsBFS.size(); i++) {
			System.out.println(
					objsBFS.get(i).getVertice().toString() + " D(s):" +
					objsBFS.get(i).getD() + " - Visited:" +
					objsBFS.get(i).getVisited()		
					);
		}
		System.out.println();
	}
}
