package com.javayadu.graphs.edgeweighted;

import java.util.LinkedList;

public class EdgeWeightedGraph {
	LinkedList<Edge>[] adj;
	int V;
	public EdgeWeightedGraph(int V) {
		// create an empty graph with V vertices
		adj = new LinkedList[V];
		this.V = V;
		for(int v=0; v<V; v++)
			adj[v] = new LinkedList<Edge>();
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<Edge> adj(int v){
		// Edges incident to v
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		// all edges in the graph
		return null;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return 0;
	}
	
	public String toString() {
		return "";
	}
	
}
