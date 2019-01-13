package com.javayadu.week2.ass;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	   
	   private class Node{
		   Item val;
		   Node next;
		   Node prev;
	   }
	   private Node head;
	   private Node tail;
	   private int size;
	   
	   public Deque()
	   {// construct an empty deque
		   head = null;
		   tail = null;
		   size = 0;
	   }
	   
	   public boolean isEmpty() {
		   // is the deque empty?
		   return head == null;
	   }
	   public int size() {
		   // return the number of items on the deque
		   return size;
	   }
	   public void addFirst(Item item) {
		   // add the item to the front
		   Node old_head = head;
		   Node node = new Node();
		   node.val = item;
		   node.next = old_head;
		   node.prev = null;
		   head = node;
		   if(old_head == null) // If the Deque is empty
			   tail = head;
		   else
			   old_head.prev = head;
		   size++;
	   }
	   public void addLast(Item item) {
		   // add the item to the end
		   Node old_tail = tail; // If the Deque is empty
		   Node node = new Node();
		   node.val = item;
		   node.next = null;
		   node.prev = old_tail;
		   tail = node;
		   if(old_tail == null)
			   head = tail;
		   else
			   old_tail.next = node;
		   size++;
	   }
	   public Item removeFirst() {
		   // remove and return the item from the front
		   Node old_head = head;
		   head = head.next;
		   head.prev = null;
		   size--;
		   return old_head.val;
	   }
	   public Item removeLast() {
		   // remove and return the item from the end
		   Node old_tail = tail;
		   tail = tail.prev;
		   tail.next = null;
		   size--;
		   return old_tail.val;
	   }
	   public Iterator<Item> iterator(){
		   // return an iterator over items in order from front to end
		   Iterator<Item> deque_iter = new DequeIterator();
		   return deque_iter;
	   }
	   
	   private class DequeIterator implements Iterator<Item>{
		   
		   Node iter_head;
		   public DequeIterator() {
			// TODO Auto-generated constructor stub
			   iter_head = new Node();
			   iter_head.val = null;
			   iter_head.next = head;
		}
		   

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return iter_head.next != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item current = iter_head.next.val;
			iter_head = iter_head.next;
			return current;
		}
		   
	   }
	   
	   
	   public static void main(String[] args) {
		   // unit testing (optional)
		   Deque<Integer> deq = new Deque<>();
		   deq.addFirst(1);
		   deq.addFirst(2);
		   deq.removeFirst();
		   deq.addLast(2);
		   deq.addFirst(3);
		   deq.addFirst(4);
		   deq.addFirst(5);
		   Iterator iter = deq.iterator();
		   while(iter.hasNext()) {
			   System.out.println(iter.next());
		   }
	   }
	}
