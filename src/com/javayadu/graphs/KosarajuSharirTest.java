package com.javayadu.graphs;

public class KosarajuSharirTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph_len = 10;
		DiGraph g = new DiGraph(graph_len);
		int[][] edges = {
		{1,2},
		{2,3},{2,5},
		{3,1},
		{4,5}
		};
		add_edges(g,edges);
		
		//DfsPaths ps = new DfsPaths(g,1);
		KosarajuSharir kshr = new KosarajuSharir(g);
		display_id(kshr.id_arr());
		print_cc(kshr.id_arr());
	}
	
	private static void add_edges( DiGraph g ,int[][] edges) {
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
			String scc = "";
			for(int j=0; j<id.length; j++) {
				if(id[j] == i)
					scc += j + " ";
			}
			System.out.println(scc);
		}
	}

}
