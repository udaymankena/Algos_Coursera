package com.javayadu.week2.Sort;

public class ShellSort {
/* Shell sort is a performance improvement over insertion sort
 * Method is to h-sort the array to make it partially sorted, before 1-sorting it
 * It improves performance as insertion sort performs better on partially sorted arrays
 * */
	
	public void sort(Comparable[] elmts) {
		// do the h-sort in the order of 3K+1....Donald Knuth's
		// this order can be anything....Knuth's is the popular/efficient one
		int h = get_max_h(elmts.length);
		while(h > 0) {
			h_sort(elmts, h);
			System.out.println("h: " + h);
			display(elmts);
			h = (h-1)/3;
		}
	}
	
	private int get_max_h(int l) {
		int h = 1;
		while(l/h > 0) {
			h = 3*h + 1;
		}
		return (h-1)/3;
	}
	private void h_sort(Comparable[] elmts, int h) {
		for(int i=0; i<elmts.length; i+=h) {
			for(int j=i; j>0; j-=h) {
				if(less(elmts[j],elmts[j-h])) {
					exch(elmts,j,j-h);
				}
				else
					break;
			}
		}
	}
	
	private void exch(Comparable[] arr, int p, int q) {
		Comparable p_bef = arr[p];
		arr[p] = arr[q];
		arr[q] = p_bef;
	}
	
	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) <= 0;
	}
	
	private void display(Object[] arr) {
		for(Object elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}
	
}
