package com.javayadu.week1;

public class QU {
	
	/* ------QUICK UNION Implementation-----
	 * 
	 * */
	
	int id[];
	
	public QU(int id_len) {
		id = new int[id_len];
		for(int i=0; i<id.length; i++)
			id[i] = i;
	}
	public boolean isConnected(int n1, int n2) {
		return root(n1) == root(n2);
	}
	
	public void connect(int n1, int n2) {
		/* if n1 and n2 are not connected, n2 becomes child of root of n1*/
		if(!isConnected(n1,n2)) {
			id[n2] = root(n1);
		}
		
	}
	
	private int root(int p) {
		if(id[p] == p) return p;
		return root(id[p]);
	}

}
