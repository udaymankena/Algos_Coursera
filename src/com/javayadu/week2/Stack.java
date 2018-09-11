package com.javayadu.week2;

public class Stack {
	/* This is a linkedlist implementation of Integer stack
	 * */
	
	LinkedList ll;
	
	public Stack() {
		ll = new LinkedList();
	}
	
	public void push(int elmt) {
		ll.insert(elmt);
	}
	
	public int pop() {
		return ll.del_head();
	}
	
	public boolean isEmpty() {
		return ll.head == null;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

}
