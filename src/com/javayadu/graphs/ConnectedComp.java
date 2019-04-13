package com.javayadu.graphs;

public class ConnectedComp {
	/* A data type to understand different connected components in a graph
	 * A group of connected components will have the same id
	 * id[] will be an additional data structure to maintain this info
	 * */
	int[] id;
	Graph g;
	boolean[] visited;
	int[] edge_to;
	public ConnectedComp(Graph g) {
		this.g = g;
		id = new int[g.V()];
		visited = new boolean[g.V()];
		edge_to = new int[g.V()];
		cc();
	}
	
	private void cc() {
		int cnt = 0;
		for(int i=0; i<g.V(); i++) {
			if(!visited[i]) {
				dfs(i,cnt);
				cnt++;
			}
		}
	}
	
	private void dfs(int v, int cnt) {
		visited[v] = true;
		id[v] = cnt;
		// check for the connections
		for(int w: g.adj(v)) {
			if(!visited[w])
				dfs(w, cnt);
			edge_to[w] = v;
			//id[w] = cnt;
		}
		// if a vertex doesn't have any connections?
		
	}
	
	public int[] id_arr() {
		return id;
	}
	

}
