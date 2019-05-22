package com.javayadu.graphs.edgeweighted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.javayadu.week1.QU;

public class Kruskals {
	/* Kruskal's is an algorithm to compute MSTs
	 * Algo: Sort the edges in ascending order of weights
	 * 		 Add each edge to MST if it doesn't form a cycle
	 *  */
	EdgeWeightedGraph g;
	public Kruskals(EdgeWeightedGraph g) {
		this.g = g;
	}
	
	public Iterable<Edge> getMst(){
		Iterable<Edge> edges = g.edges();
		List<Edge> edge_list = new ArrayList<Edge>();
		List<Edge> mst = new ArrayList<Edge>();
		QU qu = new QU(g.V());
		for(Edge e: edges)
			edge_list.add(e);
		Collections.sort(edge_list);
		for(int i=0; i<edge_list.size() && i < g.V(); i++) {
			if( !formsCycle(edge_list.get(i),qu) ) {
				mst.add(edge_list.get(i));
			}
		}
		return mst;
	}
	
	private boolean formsCycle(Edge e, QU qu) {
		int v = e.either();
		int w = e.other(v);
		if(qu.isConnected(v, w))
			return true;
		qu.connect(v, w);
		return false;
	}
	
	
}
