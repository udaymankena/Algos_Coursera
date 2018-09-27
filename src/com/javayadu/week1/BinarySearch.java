package com.javayadu.week1;

import java.util.Arrays;

public class BinarySearch {
	
	int[] arr;
	
	public BinarySearch(int[] arr) {
		this.arr = arr;
	}
	
	public boolean found(int[] arr, int elmt) {
		if(arr.length == 1)
			return arr[0] == elmt;
			
		int mid_ind = arr.length/2 - 1;
		if(elmt == arr[mid_ind])
			return true;
		if(elmt < arr[mid_ind])
			return found(subarr(arr,0,mid_ind+1),elmt);
		else
			return found(subarr(arr,mid_ind+1,arr.length-1),elmt);
	}
	
	private int[] subarr(int[] arr, int start, int end) {
		// start and end both inclusive
		int[] subarr = new int[end - start + 1];
		for(int i=0; i<subarr.length; i++) {
			subarr[i] = arr[start++];
		}
		return subarr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		BinarySearch bs = new BinarySearch(arr);
		System.out.println(bs.found(arr, 5));

	}

}

