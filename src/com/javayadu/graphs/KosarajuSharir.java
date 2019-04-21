package com.javayadu.graphs;

public class KosarajuSharir {
	/*Algorithm for finding Strongly connected components in a DiGraph
	 * Simliar to Connected components in Undirected graphs
	 * 	Do DFS twice, 
	 * 		one to get reverse post order(Topological Sort) on reversed graph
	 * 		next a DFS on reverse post order to mark Strongly connected components
	 * */
	int[] id;
	DiGraph g;
	boolean[] visited;
	int[] edge_to;
	public KosarajuSharir(DiGraph g) {
		this.g = g;
		id = new int[g.V()];
		visited = new boolean[g.V()];
		edge_to = new int[g.V()];
		kshar();
	}
	
	private void kshar() {
		//reverse the graph
		DiGraph rg = g.reverse();
		//topological sort on reversed graph
		TopologicalSort ts = new TopologicalSort(rg);
		int[] rev_post_ord = ts.reversePostOrder();
		// DFS in reverse post order(from topological sort)
		int cnt = 0;
		for(int v: rev_post_ord) {
			if(!visited[v])
				dfs(v,cnt);
			cnt++;
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
	}
	public int[] id_arr() {
		return id;
	}
}
