package com.javayadu.week3;

public class SortClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,9,8,7,6,5,4,3,2,1,7};
		
		MergeSort ms = new MergeSort();
		display(ms.sort(arr));
		//Object obj = new Integer(10);
		//System.out.println(obj.toString());
	}
	
	public static void display(Object[] arr) {
		for(Object elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}
	
	public static void display(int[] arr) {
		for(int elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}

}
