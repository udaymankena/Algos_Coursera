package com.javayadu.graphs.edgeweighted;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EdgeWeightedGraph {
	private LinkedList<Edge>[] adj;
	private int V;
	private Set<Edge> all_edges;
	public EdgeWeightedGraph(int V) {
		// create an empty graph with V vertices
		adj = new LinkedList[V];
		this.V = V;
		for(int v=0; v<V; v++)
			adj[v] = new LinkedList<Edge>();
		all_edges = new HashSet<Edge>();
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		all_edges.add(e);
	}
	
	public Iterable<Edge> adj(int v){
		// Edges incident to v
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		// all edges in the graph
		return all_edges;
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
