package com.javayadu.week2;

import java.util.Iterator;

public class LinkedListIterator<Item> implements Iterable<Item>{
	
	/* Converting the concrete String implementation of a queue to Generic implementation
	 * */
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LlIterator();
	}
	
	private class LlIterator implements Iterator<Item>{
		
		Node current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current.next != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(hasNext()) {
				current = current.next;
				return current.val;
			}
				
			return null;
		}
		
	}
	
	private class Node{
		Item val;
		Node next = null;
	}
	
	private Node head = null;
	private Node current = head;
	
	public void add(Item item) {
		if(head == null) {
			head = new Node();
			head.val = item;
			current = head;
		}
		Node node = new Node();
		node.val = item;
		current.next = node;
		current = current.next;
		
	}
	
	public static void main(String[] args) {
		LinkedListIterator<Integer> ll = new LinkedListIterator<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		
		Iterator<Integer> ll_iter = ll.iterator();
		while(ll_iter.hasNext()) {
			System.out.println(ll_iter.next());
		}
	}

	

}
