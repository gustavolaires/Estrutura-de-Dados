package algoritmos;

public class DFS {
	private Object vertice;
	private int d;
	private int s;
	private int visited;
	
	public DFS() {
		this.vertice = null;
		this.d = 0;
		this.s = 0;
		this.visited = 0;
	}
	
	public DFS(Object vertice) {
		this.vertice = vertice;
		this.d = 0;
		this.s = 0;
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

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}
}
