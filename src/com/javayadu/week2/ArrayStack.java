package com.javayadu.week2;

public class ArrayStack implements IntStackable{
	
	private int[] stack;
	private int current_ind = 0;
	
	public ArrayStack(int len) {
		stack = new int[len];
	}

	@Override
	public void push(int elmt) {
		// TODO Auto-generated method stub
		if(current_ind < stack.length)
			stack[current_ind++] = elmt;
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		return stack[current_ind-- - 1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack[0] == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack as = new ArrayStack(5);
		as.push(1);
		as.push(2);
		System.out.println(as.pop());
		as.push(3);
		System.out.println(as.isEmpty());
		

	}

}
