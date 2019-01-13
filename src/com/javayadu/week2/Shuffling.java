package com.javayadu.week2;
import java.util.Random;
public class Shuffling {
	
	/* 
	 * Is there a best shuffling technique?
	 * How can we measure efficiency of shuffling?
	 * Process1: Generate random real numbers for each element in the array and sort them
	 * Process2: iterate through the array and on each iteration, get a random number <i
	 * 			 swap i with random(i). This is a linear time shuffle
	 * */
	Random rand = new Random();
	public void shuffle(Comparable[] arr) {
		// Linear time shuffle
		for(int i=1; i<arr.length;i++) {
			int rand_i = rand.nextInt(i);
			exch(arr,i,rand_i);
		}
	}
	
	private void exch(Comparable[] arr, int p, int q) {
		Comparable p_bef = arr[p];
		arr[p] = arr[q];
		arr[q] = p_bef;
	}

}
