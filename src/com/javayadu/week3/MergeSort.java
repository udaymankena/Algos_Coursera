package com.javayadu.week3;

public class MergeSort {

	public int[] sort(int[] arr) {
		if(arr.length == 1)
			return arr;
		int[] arr1 = arrBtw(arr,0,arr.length/2-1);
		int[] arr2 = arrBtw(arr,arr.length/2, arr.length-1);
		return merge(arr1,arr2);
	}
	
	private int[] arrBtw(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int[] subarr = new int[j-i+1];
		for(int index=0; index<subarr.length; index++) {
			subarr[index] = arr[i];
			i++;
		}
		return subarr;
	}

	private int[] merge(int[] arr1, int[] arr2) {
		int[] arr1_sorted = sort(arr1);
		int[] arr2_sorted = sort(arr2);
		assert isSorted(arr1_sorted);
		assert isSorted(arr2_sorted);
		int[] arr_sorted = new int[arr1.length + arr2.length];
		int i=0, j=0, k=0;
		while(k < arr_sorted.length) {
			
			if( j >= arr2_sorted.length  ||  (i < arr1_sorted.length && arr1_sorted[i] <= arr2_sorted[j])  ) {
				arr_sorted[k] = arr1_sorted[i];
				i++;
			}
			else {
				arr_sorted[k] = arr2_sorted[j];
				j++;
			}
			k++;
		}
		return arr_sorted;
		
	}

	private boolean isSorted(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=1;i<arr.length; i++) {
			if(arr[i] < arr[i-1])
				return false;
		}
		return true;
	}
	
	

}
