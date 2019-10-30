package algoritmos;

public class BFS {
	private Object vertice;
	private int d;
	private int visited;
	
	public BFS() {
		this.vertice = null;
		this.d = -1;
		this.visited = 0;
	}
	
	public BFS(Object vertice) {
		this.vertice = vertice;
		this.d = -1;
		this.visited = 0;
	}

	public Object getVertice() {
		return vertice;
	}

	public void setVertice(Object vertice) {
		this.vertice = vertice;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}
}
