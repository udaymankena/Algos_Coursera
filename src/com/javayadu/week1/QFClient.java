package com.javayadu.week1;

public class QFClient {
	/* Reads pairs of integers and connects them if they are not connected
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//QF uf = new QF(10);
		// using the same client for Quick Union as well
		QU uf = new QU(10);
		
		uf.connect(1, 4);
		uf.connect(2, 6);
		uf.connect(6, 8);
		uf.connect(7, 3);
		
		System.out.println(uf.isConnected(2, 8));
		//System.out.println(uf.root(8));

	}

}
