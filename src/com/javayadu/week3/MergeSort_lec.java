package com.javayadu.week3;

public class MergeSort_lec {

	public Comparable[] sort(Comparable[] arr,int low, int mid, int high) {
		System.out.println("arr.length: " + arr.length + " low:" + low + " mid:" + mid + " high:" + high);
		if(high <= low)
			return arr;
		arr = sort(arr,low,(low + mid)/2, mid);
		arr = sort(arr,mid+1,(mid+1+high)/2, high);
		return merge(arr,low,mid,high);
		
	}
	
	public Comparable[] sort(Comparable[] arr) {
		System.out.println("arr.length: " + arr.length + arr.length/2 + (arr.length/2-1));
		return sort(arr,0,arr.length/2,arr.length-1);
	}
	
	
	private Comparable[] merge(Comparable[] arr, int low, int mid, int high) {
		System.out.println("merge:  " + " low:" + low + " mid:" + mid + " high:" + high);
		Comparable[] aux_arr = new Comparable[arr.length];
		int i=low, j=mid+1, k=low;
		System.out.println("j: " + j);
		while(k <= high) {
			if(j>high ) {
				System.out.println("i: " + i + " j: " + j + " mid: " + mid);
				aux_arr[k] = arr[i];
				i++;
			}
			else if(i > mid){
				aux_arr[k] = arr[j];
				j++;
			}
			else if(less_or_equal(arr[i],arr[j])) {
				System.out.println("i: " + i + " j: " + j + " mid: " + mid);
				aux_arr[k] = arr[i];
				i++;
			}
			else{
				aux_arr[k] = arr[j];
				j++;
			}
			
			k++;
		}
		//
		for(i=high+1; i < arr.length; i++) {
			aux_arr[i] = arr[i];
		}
		for(i=low-1; i >= 0; i--) {
			aux_arr[i] = arr[i];
		}
		display(aux_arr);
		return aux_arr;
	}
	
	private boolean less_or_equal(Comparable a, Comparable b) {
		System.out.println("a: " + a + " b: " + b);
		if(a.compareTo(b) <= 0)
			return true;
		return false;
	}
	
	public void display(Object[] arr) {
		for(Object elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}
}
