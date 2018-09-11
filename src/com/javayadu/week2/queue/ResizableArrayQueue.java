package com.javayadu.week2.queue;

public class ResizableArrayQueue implements StringQueueable {
	
	int enq_index = 0; // insert into the queue at this index
	int deq_index = 0; // extract from the queue from this index
	int elmts_filled = 0;
	String[] queue;
	
	public ResizableArrayQueue() {
		queue = new String[2];
	}

	@Override
	public void enqueue(String elmt) {
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

	@Override
	public String dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		if(deq_index == queue.length && queue[0] != null)
			deq_index = 0;
		String dequeued_elmt = queue[deq_index];
		queue[deq_index] = null;
		if(elmts_filled == queue.length/4)
			resize_queue(queue.length/2);
		else
			deq_index++;
		
		elmts_filled--;
		return dequeued_elmt;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elmts_filled == 0;
	}
	
	private void resize_queue(int capacity) {
		
		String[] queue_resized = new String[capacity];
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
		test[0] = null;
		System.out.println("test[0]: " + test[0] );
		System.out.println("test.length: " + test.length);
		// TODO Auto-generated method stub
		ResizableArrayQueue sq = new ResizableArrayQueue();
		System.out.println("length: " + sq.len());
		//sq.enqueue("1");
		System.out.println(sq.dequeue());
		System.out.println("length: " + sq.len());
		sq.enqueue("2");
		//System.out.println(sq.dequeue());
		System.out.println("length: " + sq.len());
		sq.enqueue("3");
		System.out.println(sq.dequeue());
		sq.enqueue("4");
		System.out.println(sq.dequeue());

	}

}
