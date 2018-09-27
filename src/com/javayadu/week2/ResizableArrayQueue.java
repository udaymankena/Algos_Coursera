package com.javayadu.week2;

public class ResizableArrayQueue<Item>{
	
	int enq_index = 0; // insert into the queue at this index
	int deq_index = 0; // extract from the queue from this index
	int elmts_filled = 0;
	Item[] queue;
	
	public ResizableArrayQueue() {
		queue = (Item[]) new Object[2];
	}

	public void enqueue(Item elmt) {
		// TODO Auto-generated method stub
		
		if(elmts_filled >= queue.length/2) {
			resize_queue(2*queue.length);
		}
		
		if(enq_index == queue.length && elmts_filled < queue.length/2) {
			// ==> The array is filled to the last index but more than half of the elmts are dequeued
			//     -- So start from the 0 index again
			enq_index = 0;
		}
		
		queue[enq_index] = elmt;
		enq_index++;
		elmts_filled++;
		
		
	}

	public Item dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		if(deq_index == queue.length && queue[0] != null)
			deq_index = 0;
		Item dequeued_elmt = queue[deq_index];
		queue[deq_index] = null;
		if(elmts_filled == queue.length/4)
			resize_queue(queue.length/2);
		else
			deq_index++;
		
		elmts_filled--;
		return dequeued_elmt;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elmts_filled == 0;
	}
	
	private void resize_queue(int capacity) {
		
		Item[] queue_resized = (Item[]) new Object[capacity];
		int i=0;
		while(deq_index < queue.length && queue[deq_index] != null) {
			queue_resized[i] = queue[deq_index];
			if(deq_index == queue.length - 1 && queue[0] != null)
				deq_index = 0;
			else
				deq_index++;
			i++;
		}
		deq_index = 0;
		enq_index = i;
		queue = queue_resized;
		
	}
	
	private int len() {
		return queue.length;
	}
	

	public static void main(String[] args) {
		
		String[] test = {"1","2","3","4","5",};
		int[] test_int = {1,2,3,4,5};
		test[0] = null;
		System.out.println("test[0]: " + test[0] );
		System.out.println("test.length: " + test.length);
		// TODO Auto-generated method stub
		ResizableArrayQueue<Integer> sq = new ResizableArrayQueue();
		System.out.println("length: " + sq.len());
		//sq.enqueue("1");
		System.out.println(sq.dequeue());
		System.out.println("length: " + sq.len());
		sq.enqueue(2);
		//System.out.println(sq.dequeue());
		System.out.println("length: " + sq.len());
		sq.enqueue(3);
		System.out.println(sq.dequeue());
		sq.enqueue(4);
		System.out.println(sq.dequeue());

	}

}
