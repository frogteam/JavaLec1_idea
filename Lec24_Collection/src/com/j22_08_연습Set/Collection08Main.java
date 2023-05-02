package com.lec.java.j22_08_연습Set;

import java.util.HashSet;
import java.util.Iterator;


public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enahnce-for 등을 
		// 사용하여 출력해보기
		
		HashSet<MyClass> hset = new HashSet<MyClass>();
		
		// 데이터 3개 저장
		MyClass mc1 = new MyClass(1, "Abc");
		MyClass mc2 = new MyClass(2, "Def");
		MyClass mc3 = new MyClass(3, "Asdf");
		hset.add(mc1);
		hset.add(mc2);
		hset.add(mc3);
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = hset.iterator();
		while (itr.hasNext()) {
			//System.out.println(itr.next());
			MyClass mc = itr.next();
			System.out.println("id: " + mc.getId());
			System.out.println("name: " + mc.getName());
		} // end while
		
		System.out.println();
		System.out.println("enhanced for");
		// for (자료타입 변수명 : 배열/리스트/셋) {}
		for (MyClass m : hset) {
			m.displayInfo();
		}
		
		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		hset.forEach(MyClass::display);		// static 메소드인 display 
		hset.forEach(System.out::println);  // toString 을 오버라이드 하여 println 으로도 출력 가능

		System.out.println("\n프로그램 종료");

	} // end main()
} // end class

