package com.J01.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/* Java Collection Framework (JCF)
 * 	프로그래밍 할때 각각의 작업에 맞는 자료구조 (com.Data Structure) 들이 있다
 * 	자바는 이러한 자료구조들을 한곳에 모아 관리하고 편하게 사용하기 위한것을 제공하는데
 * 	이를 Collection 이라 한다.
 * 
 * 	크게 3가지로 분류
 * 		1. List  : 순서가 있는 데이터 집합
 * 		2. Set  : 순서가 없는 데이터 집합
 * 		3. Map :  Key-Value 쌍으로 이루어진 데이터 집합
*/

/* ArrayList<E>
	 ※계층도 숙지 중요
	
	 Collection<E>
	  |__ List<E>
	       |__ ArrayList<E>, LinkedList<E>
	
	 List 특징(ArrayList와 LinkedList의 공통점)
	 1. 중복 저장 허용
	 2. 저장 순서 유지 (인덱스 존재)
	
	 ArrayList:
	 1. 저장 용량을 늘리는 데 많은 시간 소요 - 단점
	 2. 데이터를 삭제하는 데 많은 연산 - 단점
	 3. 데이터 참조 매우 빠름 - 장점
	
	 LinkedList:
	 1. 저장 용량을 늘리는 과정이 매우 간단 - 장점
	 2. 데이터를 삭제하는 과정이 간단 - 장점
	 3. 데이터 참조가 불편 - 단점
	 
	 
	 ※ Vector<E> <-- ArrayList 와 비슷하나... ArrayList 추천.
	 
	 ※ 데이터 자료구조를 다룰시 각 자료구조에서 데이터에 대한 다음 동작들이 어떻게 되는지 주목하자
	 - C (Create) 생성
	 - R (Read) 조회
	 - U (Update) 수정
	 - D (Delete) 삭제 
	 
*/


public class Collection01Main {

	public static void main(String[] args) {
		System.out.println("ArrayList<E>");
		
		// ArrayList 선언 - ArrayList 인스턴스 생성
		List<Integer> list1 = new ArrayList<>();

		// isEmpty(): 데이터가 없는지 여부 (boolean 리턴)
		System.out.println("isEmpty(): " + list1.isEmpty());  // true
		
		// 데이터 추가(저장): add(element) 메소드 사용
		//               add(index, element) -> index 번째 삽입
		list1.add(100);
		list1.add(400);
		list1.add(500);
		list1.add(200);
		list1.add(2, 700);  // 2번째 삽입 추가 가능
		list1.add(2, 200);  // 중복저장도 가능
		
		// 데이터 참조(읽기, 검색): get(index) 메소드 사용
		// size(): ArrayList의 크기를 반환(리턴)
		System.out.println("size() : " + list1.size());
		System.out.println(list1.size() == 0);   // 비어있는지 여부.  그러나 아래와 같이 하는 것을 추천.
		System.out.println("isEmpty(): " + list1.isEmpty());  // false


		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// System.out.println(list1.get(100));  // IndexOutOfBoundsException
		
		// 데이터 삭제: remove(index) 메소드 사용, 삭제된 element 리턴함
		list1.remove(2);
		System.out.println("삭제 후");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// 데이터 수정: set(index, element) 메소드 사용
		list1.set(2, 333);
		System.out.println("수정 후");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}

		// 데이터 존재여부: contains(E) => true/false
		System.out.println(list1.contains(400));
		System.out.println(list1.contains(600));

		// ArrayList 순환(iteration) 방법
		// 1) for
		// 2) Enhanced-for 사용
		// 3) Iterator(반복자) 사용
		// 4) forEach() 사용

		System.out.println("Enhanced for를 사용한 출력");
		// Enhanced for 사용 가능
		for(var e : list1) {
			System.out.println(e);
		}
		
		System.out.println("Iterator 를 사용한 출력");
		// Iterator(반복자) 사용법
		// iterator() 메소드를 사용해서 인스턴스 생성
		Iterator<Integer> itr = list1.iterator();
		// hasNext(): iterator가 다음 원소를 가지고 있는 지(true/false)
		// next(): 현재 iterator 위치의 원소를 값을 리턴하고,
		//   iterator의 위치를 다음 원소의 위치로 변경
		while (itr.hasNext()) {
			System.out.println(itr.next());
		} // end while
		// itr.next(); // NoSuchElementException
		
		System.out.println("forEach() 를 사용한 출력");
		// forEach() + functional interface
		// Java8 부터 등장
		list1.forEach(System.out::println);  // method reference 사용
		
		list1.forEach((a)->System.out.println(a));  // lambda-expression 사용
		
		System.out.println("toString() 사용");
		// Collection<> 대부분은 toString() 오버라이딩 되어 있다.
		System.out.println(list1);
		
		
		// * Vector<E> <-- ArrayList 와 비슷하나... ArrayList 추천.

		System.out.println("\n다양한 List<> initializer");
		// 참고: https://www.baeldung.com/java-init-list-one-line
		{
			List<String> list;

			// List <- 배열
			// immutable list 생성
			list = Arrays.asList(new String[]{"반숙", "완숙"});
			System.out.println(list);

			// List <- var args
			list = Arrays.asList("부먹", "찍먹");
			System.out.println(list);

			// Stream 사용 (Java8 이상)
			list = Stream.of("삽겹살", "목살")
					.collect(Collectors.toList());
			System.out.println(list);

			// Factory method (Java9 이상)
			// ★ immutable list(unmodifiable list) 가 생성된다.
			list = List.of("소금장", "기름장", "쌈장");
			System.out.println(list);
			//list.add("된장");  //  불가 UnsupportedOperationException

			// Double-brace initialization
			// 그러나 이 방법은 가급적 비추함. 매번 내부적으로 익명 클래스를 생성하고,
			//   이 생성객체에 hidden reference 가 발생하기 때문에  메모리 누수가 발생할수도 있다!
			list = new ArrayList() {{
				add("New York");
				add("Rio");
				add("Tokyo");
			}};
			System.out.println(list);
		}

		//-----------------------------------------------
		// 제네릭은 공변성이 없다. (아래는 에러다)
		// ArrayList<Object> Covariance = new ArrayList<Integer>();
		// ArrayList<Integer> Contravariance = new ArrayList<Object>();

		// ArrayList<Object> arr = new ArrayList<Integer>();

		System.out.println("\n프로그램 종료");
	} // end main

} // end class Collection03Main










