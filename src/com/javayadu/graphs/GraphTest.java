package com.javayadu.graphs;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph_len = 10;
		Graph g = new Graph(graph_len);
		int[][] edges = {
		{1,3},{1,4},{1,5},
		{3,6}, {3,7}, {3,8},
		{8,9}, {8,2}
		};
		add_edges(g,edges);
		
		//DfsPaths ps = new DfsPaths(g,1);
		BfsPaths ps = new BfsPaths(g,1);
		
		System.out.println(ps.connections());
		System.out.println( pathStr(2, ps) );
	}
	
	private static void add_edges( Graph g ,int[][] edges) {
		for(int i=0; i<edges.length; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}
		
	}
	
	private static void edges_of_vertice(Graph g, int v) {
		String edges_v = "edges of v: ";
		for(int i:g.adj(v))
			edges_v += i + ",";
		System.out.println(edges_v);
	}
	
	private static String pathStr(int v, DfsPaths paths) {
		String path = "";
		for(int i:paths.pathTo(v)) {
			path += i + "<--"; // well the stack doesn't give the elements in the right order!
		}
		return path.substring(0,path.length()-3); // removing the last '-->'
	}
	
	private static String pathStr(int v, BfsPaths paths) {
		String path = "";
		for(int i:paths.pathTo(v)) {
			path += i + "<--"; // well the stack doesn't give the elements in the right order!
		}
		return path.substring(0,path.length()-3); // removing the last '-->'
	}

}
