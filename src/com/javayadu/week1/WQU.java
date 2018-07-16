package com.javayadu.week1;

public class WQU {
	
	/* ------WEIGHTED QUICK UNION Implementation-----
	 * In the Quick Union algorithm, when connecting two trees, we are just replacing the roots of all the right nodes
	 * with the root of the left tree...we can make some improvement here, by chosing the tree whose roots are gonna be replaced.
	 * This is what the Wieghted quick union does.
	 * Maintain an additional data structure which represents the number of objects in each tree
	 * When combining two trees, combine the smaller tree with the bigger one
	 * */
	
	int id[];
	int id_sz[]; // Array for maintaining size of the trees
	
	public WQU(int id_len) {
		id = new int[id_len];
		id_sz = new int[id_len];
		
		for(int i=0; i<id.length; i++) {
			id[i] = i; // initializing each id with it's own index
			id_sz[i] = 1; // initializing all the sizes to one
		}
	}
	public boolean isConnected(int n1, int n2) {
		return root(n1) == root(n2);
	}
	
	public void connect(int n1, int n2) {
		/* smaller tree should be connected to the bigger tree*/
		if(!isConnected(n1,n2)) {
			int n1_root = root(n1);
			int n2_root = root(n2);
			if(id_sz[n1_root] < id_sz[n2_root]) { // if n1 is smaller
				// go to n1's root in the array and change it to n2's root.
				id[n1_root] = id[n2_root];
				id_sz[n2_root] = id_sz[n2_root] + id_sz[n1_root];
			}
			else { // do the opposite of if
				id[n2_root] = id[n1_root];
				id_sz[n1_root] = id_sz[n1_root] + id_sz[n2_root];
			}
		}
		
	}
	
	public int root(int p) {
		if(id[p] == p) return p;
		return root(id[p]);
	}
	
	/*
	 * PATH COMPRESSION......enhancement to the weighted quick union
	 * Pass through the entire array and flatten the trees by one level...
	 * ...i.e, make the grand parent of a node as it's parent.
	 * for(int i=0; i<id.length; i++){
	 * id[i] = id[id[i]];
	 * }
	 */

}
