package com.javayadu.week2.Sort;

public class InsertionSortProf {
/* This is an implementation of the insertion sort method taught in the course
 * -- using exchange() and less() methods
 * In my method I am doing just one exchange, but using 3 loops to shift elements to right
 * */
	public void sort(Comparable[] elmts) {
		for(int i=0; i<elmts.length; i++) {
			for(int j=i; j>0; j--) {
				if(less(elmts[j],elmts[j-1])) {
					exch(elmts,j,j-1);
				}
				else
					break;
			}
		}
	}
	
	public void exch(Comparable[] arr, int p, int q) {
		Comparable p_bef = arr[p];
		arr[p] = arr[q];
		arr[q] = p_bef;
	}
	
	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) <= 0;
	}
}


