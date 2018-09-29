package com.javayadu.week2.Sort;

public class SortClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {5,4,3,2,1};
		SelectionSort<Integer> ss = new SelectionSort();
		ss.sort(arr);
		display(arr);
	}
	
	public static void display(Object[] arr) {
		for(Object elmt: arr) {
			System.out.println(elmt);
		}
	}

}
