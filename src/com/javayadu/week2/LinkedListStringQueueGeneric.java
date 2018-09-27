package com.javayadu.week2;


public class LinkedListStringQueueGeneric<Item>{
	
	/* Converting the concrete String implementation of a queue to Generic implementation
	 * */

	public void enqueue(Item elmt) {
		// TODO Auto-generated method stub
		
		Node node = new Node();
		node.val = elmt;
		if(isEmpty()) {
			head = node;
			tail = head;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}

	public Item dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;;
		Item dequeued_string = head.val;
		head = head.next;
		return dequeued_string;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	
	private class Node{
		Item val;
		Node next = null;
	}
	
	private Node head = null;
	private Node tail = null;
	
	public static void main(String[] args) {
		LinkedListStringQueueGeneric<Integer> sq = new LinkedListStringQueueGeneric<Integer>();
		sq.enqueue(1);
		sq.enqueue(2);
		sq.enqueue(3);
		sq.enqueue(4);
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
	}

}
