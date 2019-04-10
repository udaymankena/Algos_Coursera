package com.javayadu.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BfsPaths {
	
	Graph g;
	boolean[] visited;
	int[] edge_to;
	int[] dist;
	int s;
	
	public BfsPaths(Graph g, int s) {
		this.g = g;
		this.s = s;
		visited = new boolean[g.V()];
		edge_to = new int[g.V()];
		dist = new int[g.V()];
		bfs(s);
	}
	
	public void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while( !q.isEmpty() ) {
			int w = q.poll();
			visited[w] = true;
			for(int elmt: g.adj(w)) {
				if(!visited[elmt]) {
					q.add(elmt);
					edge_to[elmt] = w;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return visited[v];
	}
	
	public Iterable<Integer> pathTo(int v){
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
	
	public String connections() {
		String cons = "";
		for(int i=0; i<visited.length; i++) {
			if(visited[i])
				cons += i + ",";
		}
		return cons;//.substring(0,cons.length()-1);// removing the last ','
	}
	
	
}
