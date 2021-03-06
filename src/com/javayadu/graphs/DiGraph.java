package com.javayadu.graphs;

import java.util.LinkedList;

public class DiGraph {
	private final int V; // number of vertices in the Graph
	private int E=0;
	private LinkedList<Integer> adj_list[]; // Array of Linkedlists with vertex as index
	
	public DiGraph(int V) {
		// Construct a Graph with V vertices
		this.V = V;
		adj_list = new LinkedList[V];
		// Create an adjacency list for each vertex
		for(int i=0; i<V; i++)
			adj_list[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int v, int w) {
		adj_list[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		// Iterable to browse through the connections of a vertex
		return adj_list[v];
	}
	
	public int V() { // no of vertices
		return V;
	}
	
	public int E() { // no of edges
		return E;
	}
	
	public DiGraph reverse() {
		DiGraph rg = new DiGraph(V);
		for(int i=0; i<V; i++) {
			for(int v:adj_list[i]) {
				rg.addEdge(v, i);
			}
		}
		return rg;
	}
	
}

