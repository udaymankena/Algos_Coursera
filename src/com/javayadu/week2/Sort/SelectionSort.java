package com.javayadu.week2.Sort;

public class SelectionSort {
	
	public void sort(Comparable[] elmts) {
		Comparable min = elmts[0];
		int min_index=0;
		for(int i=0; i<elmts.length-1; i++) {
			min_index = i;
			min = elmts[min_index];
			for(int j=i+1; j<elmts.length; j++) {
				if(elmts[j].compareTo(elmts[i]) == -1) {
					min = elmts[j];
					min_index = j;
				}
			}
			//swap
			Comparable current = elmts[i];
			elmts[i] = elmts[min_index];
			elmts[min_index] = current;
		}
	}

}
