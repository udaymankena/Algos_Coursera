package com.javayadu.graphs;


import java.util.Stack;

import com.javayadu.graphs.Graph;

public class TopologicalSort {
	DiGraph graph;
	boolean[] visited;
	int[] edge_to;
	int s; // source vertex
	Stack<Integer> reversePostOrder;
	
	public TopologicalSort(DiGraph graph) {
		this.graph = graph;
		this.s = s;
		visited = new boolean[graph.V()];
		edge_to = new int[graph.V()];
		reversePostOrder = new Stack<Integer>();
		for(int i=0; i<graph.V(); i++)
			if(!visited[i])
				dfs(i);
	}

	private void dfs(int s){ // find vertices connected to source 's'
		visited[s] = true; // mark the current vertex as visited
		for(int w: graph.adj(s) ) { // Is 'w' a linkedlist node or an integer?
			if(!visited[w])
				dfs(w);
			edge_to[w] = s; // getting to w from s - marking it
		}
		reversePostOrder.push(s);
	}
	
	public String reversePostOrder_str() {
		String rpo = "";
		while(!reversePostOrder.isEmpty())
			rpo += reversePostOrder.pop() + " ";
		return rpo;
	}
	
	public int[] reversePostOrder() {
		int[] rpo = new int[graph.V()];
		int i=0;
		while(!reversePostOrder.isEmpty())
			rpo[i++] = reversePostOrder.pop();
		return rpo;
	}
	

}

