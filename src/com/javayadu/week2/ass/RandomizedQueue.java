package com.javayadu.week2.ass;

import java.util.Iterator;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {
	/*A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure.
	 * */
	
	   private class Node{
			Item val;
	    	Node next = null;
	   }
	   private Node head;
	   private Node tail;
	   private int size;

	   public RandomizedQueue() {
		   // construct an empty randomized queue
		   Node head = null;
		   Node tail = null;
		   size=0;
	   }
	   public boolean isEmpty() {
		   // is the randomized queue empty?
		   return head == null;
	   }
	   public int size() {
		   // return the number of items on the randomized queue
		   return size;
	   }
	   public void enqueue(Item item) {
			// TODO Auto-generated method stub
		   Node node = new Node();
			node.val = item;
			if(isEmpty()) {
				head = node;
				tail = head;
			}
			else {
				head.next = node;
				head = head.next;
			}
			size++;
		}
	   public Item dequeue() {
		   // remove and return a random item
		   Random rand = new Random();
		   int item_index = rand.nextInt(size());
		   Node node = this.tail;
		   Node prev = null;
		   while(item_index > 0) {
			   prev=node;
			   node = node.next;
			   item_index--;
		   }
		   prev.next = node.next;
		   size--;
		   return node.val;
	   }
	   public Item sample() {
		   // return a random item (but do not remove it)
		   Random rand = new Random();
		   int item_index = rand.nextInt(size()); //index starts with zero // why is not private allowed here?
		   return get_item_at_index(item_index);
	   }
	   private Item get_item_at_index(int item_index) {
		// TODO Auto-generated method stub
		   Node node = this.tail;
		   while(item_index > 0) {
			   node = node.next;
			   item_index--;
		   }
		return node.val;
	}
	public Iterator<Item> iterator(){
		   // return an independent iterator over items in random order
		return new RandQuIterator();
	   }
	
	
	private void shuffle(Comparable[] arr) {
		// Linear time shuffle
		Random rand = new Random();
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
	
	private class RandQuIterator implements Iterator<Item>{
		
		Integer[] arr; // to create an array of size size() and maintain the random order
		int arr_ind=0;
		public RandQuIterator() {
			// TODO Auto-generated constructor stub
			arr = new Integer[size()];
			for(int i=0; i<size(); i++)
				arr[i] = i;
			shuffle(arr);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return arr_ind < arr.length;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	   public static void main(String[] args) {
		   // unit testing (optional)
	   }
	}
