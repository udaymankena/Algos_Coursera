package com.javayadu.graphs.edgeweighted;

public class MSTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// build an edge weighted graph
		EdgeWeightedGraph g = new EdgeWeightedGraph(8);
		addEdges(g,0,7,0.16);
		addEdges(g,1,7,0.19);
		addEdges(g,0,2,0.26);
		addEdges(g,2,3,0.17);
		addEdges(g,5,7,0.28);
		addEdges(g,4,5,0.35);
		addEdges(g,6,2,0.40);
		
		Kruskals mst = new Kruskals(g);
		
		for(Edge e: mst.getMst() ) {
			System.out.println(e);
		}
		
	}
	
	public static void addEdges(EdgeWeightedGraph g, int v, int w, double weight) {
		Edge e = new Edge(v,w,weight);
		g.addEdge(e);
	}

}
