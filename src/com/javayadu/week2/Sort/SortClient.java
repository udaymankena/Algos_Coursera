package com.javayadu.week2.Sort;

import com.javayadu.week2.Shuffling;

public class SortClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
		Shuffling sh = new Shuffling();
		sh.shuffle(arr);
		
		//ShellSort ss = new ShellSort();
		//ss.sort(arr);
		display(arr);
		//Object obj = new Integer(10);
		//System.out.println(obj.toString());
	}
	
	public static void display(Object[] arr) {
		for(Object elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}

}
