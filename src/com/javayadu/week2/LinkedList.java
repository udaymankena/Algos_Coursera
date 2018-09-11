package com.javayadu.week2;

public class LinkedList {
	
	public class Node {
		
		int val;
		Node next;

	}
	
	Node head = null;
	
	public void insert(int elmt) {
		if(head == null) {
			head = new Node();
			head.val = elmt;
			return;
		}
		Node node = new Node();
		node.val = elmt;
		node.next = head;
		head = node;
	}
	
	public int del_head() {
		Node new_head = head.next;
		int old_head_val = head.val;
		head = new_head;
		return old_head_val;
	}
	

}
