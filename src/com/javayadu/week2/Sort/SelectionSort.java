package com.javayadu.week2.Sort;

public class SelectionSort<Item> {
	
	public void sort(Comparable<Item>[] elmts) {
		Comparable<Item> min = elmts[0];
		int min_index=0;
		for(int i=0; i<elmts.length-1; i++) {
			min_index = i;
			min = elmts[min_index];
			for(int j=i+1; j<elmts.length; j++) {
				if(elmts[j].compareTo((Item) min) == -1) {
					min = elmts[j];
					min_index = j;
				}
			}
			//swap
			Comparable<Item> current = elmts[i];
			elmts[i] = min;
			elmts[min_index] = current;
		}
	}

}
