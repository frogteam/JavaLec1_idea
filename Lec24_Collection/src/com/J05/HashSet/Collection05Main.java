package com.J05.HashSet;

import java.util.HashSet;
import java.util.Iterator;

/* Set, HashSet<E>

	Collection<E>
	 |__ Set<E>
	      |__ HashSet<E>, TreeSet<E>
	
	 Set:
	 1. 자료의 중복 저장이 허용되지 않는다. (hashCode() 값의 중복여부!)
	 2. 저장 순서가 유지되지 않는다.(인덱스 없다.)
	 (예) {1, 2, 3} = {1, 1, 2, 2, 3} : 중복 저장이 안되기 때문에 같은 Set
	 (예) {1, 2, 3} = {1, 3, 2}: 저장 순서가 중요하지 않기 때문에 같은 Set
	
	 HashSet: 매우 빠른 검색 속도를 제공

	 	(※ HashXXX ← '검색속도 향상'을 쓰는 자료구조 입니다)
*/

public class Collection05Main {

	public static void main(String[] args) {
		System.out.println("HashSet 클래스");
		
		// Integer 타입을 저장할 수 있는 HashSet 인스턴스 생성
		HashSet<Integer> hset = new HashSet<Integer>();
		
		// 데이터 저장: add()
		hset.add(100);    // <-- Integer.valueOf(100)
		hset.add(200);
		hset.add(300);
		hset.add(100);
		hset.add(400);
		hset.add(500);
		hset.add(1);
		hset.add(2);
		
		// HashSet의 크기: size()
		System.out.println("집합의 크기: " + hset.size());
		// Set은 중복 저장을 허용하지 않는다.
		
		// 데이터 검색:
		// Set은 인덱스가 없기 때문에 get() 메소드를 제공하지 않습니다.
		// 데이터 검색을 위해서는 Iterator를 사용해야 함
		System.out.println();
		Iterator<Integer> itr = hset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		// ↑ 출력 결과를 보면 저장 순서와는 관계 없다.
		
		
		// 데이터 삭제
		// remove(element): Set에 있는 element를 찾아서 삭제
		//   element 있다면 삭제 후 true를 리턴
		//   element 없다면 false 리턴
		System.out.println("삭제 결과: " + hset.remove(2)); // 주의) index 2 를 삭제하는게 아니다!!!
		System.out.println("삭제 결과: " + hset.remove(2));
		
		System.out.println();
		System.out.println("삭제 후:");
		itr = hset.iterator();   // 한번 사용한 iterator 는 다시 사용 불가.  (새로이 생성해야 한다)
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// Set 자료형 데이터 변경을 할 수 있는 set() 메소드를 제공하지 않습니다.
		// 삭제(remove) 후 추가(add)하면 변경하는 효과
		hset.remove(500);
		hset.add(555);
		System.out.println("변경 후:");
		itr = hset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println(hset.contains(555));
		System.out.println(hset.contains(700));
		
		// enhanced-for 사용
		System.out.println();
		System.out.println("Enhanced for 사용 출력");
		for(Integer x : hset){
			System.out.println(x);
		}
		
		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용 출력");
		hset.forEach(System.out::println);

		// toString() 제공됨
		System.out.println();
		System.out.println(hset);
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












