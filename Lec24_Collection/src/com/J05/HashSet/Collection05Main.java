package com.J05.HashSet;

import dataset.Score;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Set, HashSet<E>

	Collection<E>
	 |__ Set<E>
	      |__ HashSet<E>, TreeSet<E>
	
	 Set:
	 1. 자료의 중복 저장이 허용되지 않는다. (hashCode() 값의 중복여부!)
	 2. 저장 순서가 유지되지 않는다.(인덱스 없다.)
	 (예) {1, 2, 3} = {1, 1, 2, 2, 3} : 중복 저장이 안되기 때문에 같은 Set
	 (예) {1, 2, 3} = {1, 3, 2}: 저장 순서가 중요하지 않기 때문에 같은 Set
	
	 HashSet: 매우 빠른 검색(조회) 속도를 제공

	 	(※ HashXXX ← '검색속도 향상'을 쓰는 자료구조 입니다)
*/

public class Collection05Main {

	public static void main(String[] args) {
		System.out.println("HashSet 클래스");
		
		// Integer 타입을 저장할 수 있는 HashSet 인스턴스 생성
		Set<Integer> hset = new HashSet<Integer>();
		
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

		System.out.println("\n다양한 Set initializer");
		// 참고: https://www.baeldung.com/java-initialize-hashset
		//      https://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction
		{
			Set<String> set = new HashSet<>();

			// List, 배열로부터 생성
			set = new HashSet<>(Arrays.asList("a", "a", "b"));  // mutable 이다
			System.out.println(set);

			// Collections utility 클래스 하용
			Collections.addAll(set, "a", "a", "b");  // 기존 set 에 추가됨.
			System.out.println(set);

			// Stream 사용 (Java8 이상)
			set = Stream.of("a", "a", "b")
					.collect(Collectors.toCollection(HashSet::new));
					//.collect(Collectors.toSet());  // 이것도 가능!
			System.out.println(set);

			// Factory method (Java9 이상)
//			set = Set.of("a", "a,", "b");  // 중복된 값 불가.  IllegalArgumentException
			set = Set.of("a", "b");
			System.out.println(set);

			// Double-brace initialization
			// 비추
			set = new HashSet<String>(){{
				add("a");
				add("a");
				add("b");
			}};
			System.out.println(set);

			// 그밖에도 guava 라는 3rd party 라이브러리도 활용할수 있다
			// https://guava.dev/releases/22.0/api/docs/com/google/common/collect/Sets.html#newHashSet--
			// Sets.newHashSet("a", "b", "c")
		}

		// HashSet에서 값을 찾을 때에는 이미 존재하는 요소인지 파악하기 위해서 아래와 같은 과정을 거치게 된다.
		// 검색할 값의 hashCode() 메소드를 호출해 반환된 해시값으로 검색 범위를 결정한다.
		// 해당 범위의 요소를 equals() 메소드로 비교한다. (Array Index에 있는 Linked List들과 값을 비교)
		// 참고: https://2ssue.github.io/base/study-about-set/

		System.out.println();
		{
			Person p1 = new Person(1, 20, "Mike");
			Person p2 = new Person(1, 20, "Mike");
			Person p3 = new Person(3, 20, "Susan");

			HashSet<Person> personSet = new HashSet<>();
			personSet.add(p1);
			personSet.add(p2);
			personSet.add(p3);

			// 과연?
			System.out.println(personSet.size());

			// Java 에서 두 객체가 '같다' 라는 것은 어케 정의되나?
			// 주소값에 따라 결정되나???  ==> 아니다!
			{
				HashSet<String> strSet = new HashSet<>();

				String s1 = new String("이유나");
				String s2 = new String("이유나");
				String s3 = new String("이유나");

				System.out.println(s1 == s2);  // f
				System.out.println(s3 == s2);

				strSet.add(s1);
				strSet.add(s2);
				strSet.add(s3);

				System.out.println(strSet.size());
				System.out.println(strSet);
			}
		}



		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

class Person {
	int id;
	int age;
	String name;

	public Person(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", age=" + age +
				", name='" + name + '\'' +
				'}';
	}

/*
	@Override
	public int hashCode() {
		return id * age;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Person)obj).id;
	}
*/

}









