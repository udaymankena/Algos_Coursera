package com.javayadu.week2.Sort;

public class InsertionSort {
	
	public void sort(Comparable[] elmts) {
		for(int i=0; i<elmts.length; i++) {
			//assume that the left part to j is already sorted
			for(int j=i-1; j >= 0; j--) {
				if(elmts[i].compareTo(elmts[j]) <= 0 ) {
					if(j==0 || elmts[i].compareTo(elmts[j-1]) > 0) {
						insert_at_index(i,j,elmts);
						break;
					}
				}
			}
		}
	}

	private void insert_at_index(int i, int j, Comparable[] elmts) {
		// TODO Auto-generated method stub
		Comparable curr_val = elmts[i];
		for(int k=i; k > j; k--) {
			elmts[k] = elmts[k-1];
		}
		elmts[j] = curr_val;
	}

}
