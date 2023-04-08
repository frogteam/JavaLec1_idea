package com.lec.java.collection07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Collection07Main {

	private String s;
	
	public Collection07Main(String str){ this.s = str; }
	
	public static void main(String[] args) {
		System.out.println("HashSet 연습");

		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기

		
		
		// String 타입을 저장할 수 있는 HashSet 인스턴스 생성
		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		set2.add(11);
		set2.add(22);
 		
		// 데이터 저장
		System.out.println("add 결과: " + set.add("One"));
		System.out.println("add 결과: " + set.add("Two"));
		System.out.println("add 결과: " + set.add("Three"));
		System.out.println("add 결과: " + set.add("Four"));
		System.out.println("add 결과: " + set.add("Five"));
		System.out.println("add 결과: " + set.add("Two"));
		System.out.println("add 결과: " + set.add("Three"));
		
		System.out.println();
		System.out.println("데이터 저장");
		System.out.println("데이터 개수: " + set.size());
		
		System.out.println();		
		
		// 데이터 검색 - Iterator 사용
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		// 데이터 삭제
		set.remove("Five");
		
		System.out.println("삭제 후:");
		itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		// enhanced for는 인덱스가 필요 없는 for문이기 때문에
		// Set 타입의 자료형에서도 사용 가능
		System.out.println("enhanced for 사용");
		for(String str : set) {
			System.out.println(str);
		}
		for(Integer x : set2) {
			System.out.println(x);
		}
		
		//-------------------------------------------
		// 기존의 List 에서 중복된 값을 제거하기 (Set<> 활용)
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(10);
		
		System.out.println(list);
		
		// 기존의 List<> 로부터 Set<> 생성
		Set<Integer> set4 = new HashSet<>(list);
		System.out.println(set4);

		// -------------------------------
		// hashCode()
		HashSet<Object> set3 = new HashSet<Object>();
		Collection07Main ws1 = new Collection07Main("aardvark");
		Collection07Main ws2 = new Collection07Main("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		System.out.println("ws1 hashcode = " + ws1.hashCode());
		System.out.println("ws2 hashcode = " + ws2.hashCode());
		System.out.println("s1 hashcode = " + s1.hashCode());
		System.out.println("s2 hashcode = " + s2.hashCode());
		set3.add(ws1);
		set3.add(ws2);
		set3.add(s1);
		set3.add(s2);
		System.out.println("set3.size() = " + set3.size());  // 과면 몇개일까?  3개!
		System.out.println();

		
		MyClass mc1 = new MyClass(100, 5);
		MyClass mc2 = new MyClass(100, 9);
		MyClass mc3 = new MyClass(200, 3);
		System.out.println("mc1 hashcode = " + mc1.hashCode());
		System.out.println("mc2 hashcode = " + mc2.hashCode());
		System.out.println("mc2 hashcode = " + mc3.hashCode());
		set3.add(mc1);
		set3.add(mc2);
		set3.add(mc3);
		System.out.println("set3.size() = " + set3.size());  // 과면 몇개일까?  5개!
		System.out.println();		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Collection09Main

// Set 에서 같은지 다른지, 식별 가능하려면
// hashCode 와 equals 가 오버라이딩 되어야 한다
// hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.
class MyClass {
	int a;
	int b;
	
	public MyClass(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int hashCode() {
		return a;
	}
	
	@Override
	public boolean equals(Object obj) {
		return a == ((MyClass)obj).a;
	}
}













