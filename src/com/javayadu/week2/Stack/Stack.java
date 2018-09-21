package com.javayadu.week2.Stack;


public class Stack<Item> {
	/* This is a linkedlist implementation of Integer stack
	 * */
	
	LinkedList<Item> ll;
	
	public Stack() {
		ll = new LinkedList();
	}
	
	public void push(Item elmt) {
		ll.insert(elmt);
	}
	
	public Item pop() {
		return ll.del_head();
	}
	
	public boolean isEmpty() {
		return ll.head == null;
	}
	
	private class LinkedList<Item> {
		
		private class Node<Item> {
			
			Item val;
			Node next;

		}
		
		Node<Item> head = null;
		
		public void insert(Item elmt) {
			if(head == null) {
				head = new Node<Item>();
				head.val = elmt;
				return;
			}
			Node node = new Node();
			node.val = elmt;
			node.next = head;
			head = node;
		}
		
		public Item del_head() {
			Node new_head = head.next;
			Item old_head_val = head.val;
			head = new_head;
			return old_head_val;
		}
		

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> st = new Stack();
		st.push("1");
		st.push("2");
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

}
