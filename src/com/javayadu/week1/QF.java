package com.javayadu.week1;

public class QF {
	
	/* This is a data type for Quick Find problem
	 * How many pairs of input nodes? - read it dynamically from user
	 * 
	 * Problem:  Connect a pair of nodes, find if a connection exists between two nodes
	 * Algorithm: Use array as the DS for simplicity. Index represents the id of the node
	 * 			  value of an index represents a connection.
	 * 			  Two nodes are connected if they have the same value in the array
	 * 			  While connecting two nodes n1 and n2, iterate through the entire array and replace
	 * 			  the n2s with n1s. replacement is on the values not the indices. Take a look at the "connect"
	 * 			  method for better understanding
	 * */
	
	int[] id;
	
	public QF(int id_len) {
		id = new int[id_len];
		for(int i=0; i<id.length; i++)
			id[i] = i;
	}
	
	public boolean isConnected(int n1, int n2) {
		// tells whether two given nodes are connected
		if(id[n1] == id[n2])
			return true;
		return false;
	}
	
	
	public void connect(int n1, int n2) {
		/* Creates a connection between n1 and n2 when there was no previous connection
		 * */
		// change all n2s to n1s
		int n1_id = id[n1]; // didn't think of these before the lecture
		int n2_id = id[n2];
		
		for(int i=0; i<id.length; i++) {
			if(id[i] == n2_id)
				id[i] = n1_id;
		}
		
	}

}
