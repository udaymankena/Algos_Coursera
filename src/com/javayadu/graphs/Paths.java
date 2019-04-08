package com.javayadu.graphs;

import java.util.Stack;

public class Paths {
	Graph graph;
	boolean[] visited;
	int[] edge_to;
	int s; // source vertex
	
	public Paths(Graph graph, int s) {
		this.graph = graph;
		this.s = s;
		visited = new boolean[graph.V()];
		edge_to = new int[graph.V()];
		dfs(s);
	}

	public void dfs(int s){ // find vertices connected to source 's'
		visited[s] = true; // mark the current vertex as visited
		for(int w: graph.adj(s) ) { // Is 'w' a linkedlist node or an integer?
			if(!visited[w])
				dfs(w);
			edge_to[w] = s; // getting to w from s - marking it
		}
	}
	
	public String connections() {
		String cons = "";
		for(int i=0; i<visited.length; i++) {
			if(visited[i])
				cons += i + ",";
		}
		return cons.substring(0,cons.length()-1);// removing the last ','
	}
	
	public boolean hasPathTo(int v) {
		return visited[v];
	}
	
	public Iterable<Integer> pathTo(int v){ // path to v from s
		Stack<Integer> path = new Stack<Integer>();
		while(v != s) {
			path.push(v);
			v = edge_to[v];
		}
		path.push(s);
		return path;
	}
	
	public void display_edge_to() {
		for(int i=0; i<edge_to.length; i++)
			System.out.println(i + " : " + edge_to[i]);
	}
}
