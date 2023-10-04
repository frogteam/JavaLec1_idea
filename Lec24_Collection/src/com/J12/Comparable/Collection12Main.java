package com.J12.Comparable;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */


// Comparable 발음 : '캄퍼러블
// Comparator 발음 : 컴'패러터
//http://movefast.tistory.com/80

public class Collection12Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("Collections 메소드");

		List<String> list1 = new LinkedList<String>();

		list1.add("장길산");
		list1.add("김철수");
		list1.add("구자철");
		
		System.out.println(list1);
		
		System.out.println("sort()");
		// sort()
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용
		Collections.sort(list1);  
		System.out.println(list1);  // <-- 정렬후 결과는?
		

		
		System.out.println();
//		List<Date> list2 = new LinkedList<Date>();		
//		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16"));
//		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2017-05-21"));
//		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-03"));
		
		List<LocalDate> list2 = new LinkedList<>();
		list2.add(LocalDate.parse("2018-08-16"));
		list2.add(LocalDate.parse("2017-05-21"));
		list2.add(LocalDate.parse("2022-03-03"));		
		
		System.out.println(list2);
		
		Collections.sort(list2);  
		System.out.println(list2);  // <-- 정렬후 결과는?
		
		
		// String 타입이면 알파벳 순으로 정렬된다.
		// Date, Calendar, java.time.* 타입이면 날짜/시간 순으로 정렬된다
		// ↑ 이들은 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자
	
		System.out.println();
		List<Student> list3 = new LinkedList<Student>();
		list3.add(new Student("Susie", 50));
		list3.add(new Student("James", 80));		
		list3.add(new Student("Kevin", 30));
		
		System.out.println(list3);
		
		System.out.println("Comparable 구현, sort() 적용");
		Collections.sort(list3);  //Student 에 Comparable 이 구현안되어 있으면 sort() 가 에러 난다
		// Comparable 구현후 아래 실행
		System.out.println(list3);
		
		// 역순 정렬
		System.out.println("reverseOrder() 적용");
		Collections.sort(list3, Collections.reverseOrder());
		System.out.println(list3);
		
		// 뒤집기
		System.out.println("reverse() 적용");
		Collections.reverse(list3);
		System.out.println(list3);
		
		
		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.
		System.out.println("Comparator<> 적용");
		Collections.sort(list3, new Asc());  // '이름' 오름차순
		System.out.println(list3);
		Collections.sort(list3, new Desc()); // '이름' 내림차순
		System.out.println(list3);
		
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable<> 은 클래스 자체에 구현하는 인터페이스  compareTo(자기사진 vs 매개변수)
		// Comparator<> 는 두개의 객체 비교하는 기능제공 인터페이스  compare(매개변수1 vs 매개변수2)
		//      구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임
		
		// Shuffling 하기 (섞기)
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1);
		System.out.println(list1.toString());
		Collections.shuffle(list1);
		System.out.println(list1.toString());
		
		// 배열에서 랜덤으로 3명만 뽑기
		String [] arr = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"};
		List<String> arrList = Arrays.asList(arr);  // 배열 --> List<>    ( List<> 의 toArray() 의 반대)
		Collections.shuffle(arrList);  
		arrList = arrList.subList(0, 3);   // index 0 부터 3전까지의 List<> 생성
		System.out.println(arrList);
		
		List<Integer> arrList2 = Arrays.asList(10, 20, 30, 40);  // asList() 안에 직접 값들 입력 가능.  ※ 1개 짜리 List 작성등 손쉽게 가능!
		Collections.shuffle(arrList2);
		System.out.println(arrList2.subList(0, 2));
		System.out.println();
		
		
		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		System.out.println(Collections.min(list3));  // Comparable 메소드 영향 받음
		System.out.println(Collections.max(list3));
		
		// copy(dest, src)
		System.out.println();
		List<Student> list4 = new LinkedList<Student>();
		list4.add(new Student("aaa", 10));
		list4.add(new Student("bbb", 20));
		list4.add(new Student("ccc", 30));
		System.out.println("copy() 전");
		System.out.println(list4);
		System.out.println("copy() 후");
		Collections.copy(list4, list3);
		System.out.println(list4);
		
		// 로또 번호 추첨
		//List<Integer> list4 = new ArrayList<Integer> 
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

// 우선은 Comparable 구현 없이 해보자
class Student implements Comparable<Student>{
	String name;
	double point;
	
	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}

	//comparaTo() 메소드는 매개변수 객체를 현재의 객체와 비교하여 
	// 정렬순위가 낮으면 음수, 같으면 0, 높으면 양수를 반환한다.
	@Override
	public int compareTo(Student o) {
		//  점수(point) 오름차순
		if(o.point > this.point) return -1;
		if(this.point > o.point) return 1;
		return 0;

		// 점수(point) 내림차순
//		if(o.point < this.point) return -1;
//		if(this.point < o.point) return 1;
//		return 0;
		
		// 점수(point) 내림차순
//		if(o.point < this.point) return -1;
//		if(this.point < o.point) return 1;
//		return 0;
		
		// 이름(name) 오름차순
//		return this.name.compareTo(o.name);

		// 이름(name) 내림차순
//		return o.name.compareTo(this.name);
	}
	
} // end class


class Asc implements Comparator<Student>{

	// 두개의 객체를 비교
	// o1 이 o2 보다 우선순위 낮으면 음수 리턴
	// o1 이 o2 보다 우선순위 높으면 양수 리턴
	// o1 과 o2 가 같으면 0 리턴
	@Override
	public int compare(Student o1, Student o2) {
//		if(o1.point < o2.point) return -1;
//		if(o1.point > o2.point) return 1;
//		return 0;
		
		// 이름(name) 오름차순
		return o1.name.compareTo(o2.name);
	}	
} // end Asc


class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
//		if(o1.point > o2.point) return -1;
//		if(o1.point < o2.point) return 1;
//		return 0;

		// 이름
		return -o1.name.compareTo(o2.name);
	}	
} // end Desc

