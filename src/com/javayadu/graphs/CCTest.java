package com.javayadu.graphs;

public class CCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph_len = 10;
		Graph g = new Graph(graph_len);
		int[][] edges = {
		{1,3},{1,4},{1,5},
		{3,6}, {3,7},
		{8,9}, {8,2}
		};
		add_edges(g,edges);
		
		//DfsPaths ps = new DfsPaths(g,1);
		ConnectedComp cc = new ConnectedComp(g);
		//display_id(cc.id_arr());
		print_cc(cc.id_arr());
	}
	
	private static void add_edges( Graph g ,int[][] edges) {
		for(int i=0; i<edges.length; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}
		
	}
	
	public static void display_id(int[] id) {
		for(int i=0; i<id.length; i++)
			System.out.println(i + " : " + id[i]);
	}
	
	public static void print_cc(int[] id) {
		int curr_id = id[0];
		for(int i=0; i<id.length;i++) {
			String cc = "";
			for(int j=0; j<id.length; j++) {
				if(id[j] == i)
					cc += j + " ";
			}
			System.out.println(cc);
		}
	}

}
