package com.javayadu.week2.queue;

public class LinkedListStringQueue implements StringQueueable{
	
	/* Implementing a queue using a linked list
	 * maintaining a tail node in addition to head
	 * */

	@Override
	public void enqueue(String elmt) {
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

	@Override
	public String dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;;
		String dequeued_string = head.val;
		head = head.next;
		return dequeued_string;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	
	private class Node{
		String val;
		Node next = null;
	}
	
	private Node head = null;
	private Node tail = null;
	
	public static void main(String[] args) {
		LinkedListStringQueue sq = new LinkedListStringQueue();
		sq.enqueue("1");
		sq.enqueue("2");
		sq.enqueue("3");
		sq.enqueue("4");
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
	}

}
