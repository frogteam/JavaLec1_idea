package com.lec.java.stack;

import java.util.Stack;

/*
 	스택 (Stack)
 	
 	Object
		└─AbstractCollection<E>
			└─AbstractList<E>
				└─Vector<E>
					└─Stack<E>
 	
 LIFO 구조 : last-in-first-out
 	
 주요메소드
 	push(e)
 	pop()
 	peek()
 	empty()
 	
 	다양한 용도사용
 		: 컴파일러 구문분석
 		: 함수 호출
 		: undo/redo
 */
public class StackMain {

	public static void main(String[] args) {
		System.out.println("Stack");
		Stack<Integer> st = new Stack<Integer>(); // 스택의 생성

		// push() 메소드를 이용한 요소의 저장
		st.push(4);
		st.push(2);
		st.push(3);
		st.push(1);
		 
		// peek() 메소드를 이용한 요소의 반환
		System.out.println(st.peek());
		System.out.println(st);

		// pop() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(st.pop());
		System.out.println(st);

		// search() 메소드를 이용한 요소의 위치 검색
		System.out.println(st.search(4));
		System.out.println(st.search(3));
	}

}
