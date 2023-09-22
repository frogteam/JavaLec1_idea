package com.lec.java.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;

/*
	Stack: FILO – push(), pop(), peek() 
	Queue: FIFO – offer(), poll(), peek()
	
	Priority Queue: 
		–Is a Queue –Each element has a “priority” 
		– offer()stores new element (with “priority”) 
		– poll()removes element with highest/lowest priority 
		– peek()shows that element but doesn’t remove
 */
public class PriorityQueueMain {

	public static void main(String[] args) {

		System.out.println("PriorityQueue<>");
		
		// Comparator 적용전
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		// Comparator 적용후
		// initial capacity, comparator 
		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Desc());
					
		// offer() : add item
		pq.offer(7);
		pq.offer(3);
		pq.offer(5);
		
		// peek() : head value 보기
		System.out.println("Head value: " + pq.peek());
		
		// 모든 요소들 보기
		// PriorityQueue 를 아래와 같이 Iterator 로 
		// 원소들을 출력할수는 있으나!
		// 우선순위 대로 출력되는게 보장되지 않는다.
		Iterator itr;
		System.out.println("All elements");
		itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		// poll()
		System.out.println("Top proority: " + pq.poll());
		
		System.out.println("All elements after poll()"); 
		itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		pq.offer(2);
		
		System.out.println("All elements after offer(2)");
		itr = pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
	} // end main
} // end class
