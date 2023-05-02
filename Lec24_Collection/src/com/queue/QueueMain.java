package com.lec.java.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 	큐 (Queue)
 	
 	Collection<E>
 		└─ Queue<E> (Queue)
 		      └─ LinkedList<E>,  PriorityQueue<E>
 		      
 	 	 	
 FIFO 구조 : First-in-first-out
 	
 주요메소드
 	 
 	 	Throws exception 	Returns special value 
Insert 		add(e) 				offer(e) 
Remove 		remove() 			poll() 
Examine		element() 			peek() 
 	                             ↑
 	                             Exception 을 안내니 안전
 	  
 */
public class QueueMain {

	public static void main(String[] args) {
		System.out.println("Queue");
		Queue<String> queue = new LinkedList<String>();
		
		// add() 메소드를 이용한 요소의 저장
		queue.offer("넷");
		queue.offer("둘");
		queue.offer("셋");
		queue.offer("하나");

		// peek() 메소드를 이용한 요소의 반환
		System.out.println(queue.peek());
		System.out.println(queue);

		// poll() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(queue.poll());
		System.out.println(queue);

		// remove() 메소드를 이용한 요소의 제거
		queue.remove("하나");
		System.out.println(queue);

	}

}
