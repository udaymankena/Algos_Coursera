package com.javayadu.week2;

public class ArrayStackResized implements IntStackable {
	private int[] stack;
	private int len = 0;
	
	public ArrayStackResized() {
		// TODO Auto-generated constructor stub
		stack = new int[1];
	}
	
	@Override
	public void push(int elmt) {
		// TODO Auto-generated method stub
		// resizing the array....if stack is full, double the size
		if(isEmpty()) {
			stack = new int[1];
		}
		if(isFull()) 
			resize_stack(2*stack.length);
		
		stack[len] = elmt;
		len++;
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		if(len == stack.length/4)
			resize_stack(stack.length/2); // if the stack is 1/4th full, reduce the size by half so that the resulting array is half full
		int elmt = stack[len-1];
		len--;
		return elmt;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack[0] == 0;
	}
	
	private boolean isFull() {
		return stack.length == len;
	}
	
	public int size() {
		return stack.length;
	}
	
	private void resize_stack(int capacity) {
		
		int fill_index;
		if(capacity > stack.length)
			fill_index = stack.length;
		else
			fill_index = capacity;
		int[] stack_resized = new int[capacity];
		for(int i=0; i<fill_index; i++) {
			stack_resized[i] = stack[i];
		}
		stack = stack_resized;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStackResized as = new ArrayStackResized();
		as.push(1);
		as.push(2);
		as.push(3);
		System.out.println(as.size());
		as.push(4);
		as.push(5);
		System.out.println(as.size());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.size());
		System.out.println(as.isEmpty());
		

	}

}
