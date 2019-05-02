package com.javayadu.misc;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		int[] arr = {8,4,2,1};
		combs = combs(arr,0,combs);
		display_listOfLists(combs);
		
		}
	
	public static List<String> combs_str(int[] arr, int start, List<String> combs){
		// 8 4 2 1
		if(start == arr.length)
			return combs;
		List<String> curr_combs = new ArrayList<String>();
		curr_combs.add(arr[start] + "");
		int curr = arr[start];
		for(String comb: combs) {
			curr_combs.add(comb + arr[start]);
		}
		combs.addAll(curr_combs);
		return combs_str(arr,start+1,combs);
			
	}
	
	public static List<List<Integer>> combs(int[] arr, int start, List<List<Integer>> combs){
		// 8 4 2 1
		if(start == arr.length)
			return combs;
		List<List<Integer>> curr_combs = new ArrayList<List<Integer>>();
		List<Integer> curr_start = new ArrayList<Integer>();
		curr_start.add(arr[start]);
		curr_combs.add(curr_start);
		for(List<Integer> comb: combs) {
			List<Integer> curr_list = new ArrayList<Integer>();
			curr_list.addAll(comb);
			curr_list.add(arr[start]);
			curr_combs.add(curr_list);
		}
		combs.addAll(curr_combs);
		return combs(arr,start+1,combs);
			
	}
	
	public static void display(List<String> arr) {
		for(String elmt: arr) {
			System.out.print(elmt + " ");
		}
		System.out.println(" ");
	}
	
	public static void display_listOfLists(List<List<Integer>> list_lists) {
		for(List<Integer> lst: list_lists) {
			for(int elmt:lst) {
				System.out.print(elmt + " ");
			}
			System.out.println(" ");
		}
	}

}
