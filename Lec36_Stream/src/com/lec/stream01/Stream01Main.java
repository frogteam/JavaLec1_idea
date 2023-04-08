package com.lec.stream01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 선행 : Collection, 배열, Lambda, 익명클래스, 
//       Optional, Consumer


/* 스트림 (Stream) : 집합자료의 연산을 위해 사용하는 객체
 *  - Java8 에서 등장
 *  - 람다 활용
 *  - InputStream / OutputStream 과는 전혀 다른 객체다. 헷갈리지 말자.
 *  
 *  자료의 대상과 관계 없이 '동일한 연산'을 수행할 수 있는 기능 (자료의 추상화!)
 *  
 *  주로 '배열', '컬렉션' 을 대상으로 '스트림 생성'하여 사용
 *  '배열', '컬렉션'에 '동일한 연산'으로 수행될수 있도록 '일관성' 있는 처리 가능
 *
 *  	: 동일한 연산임에도 불구하고 자료의 대상마다 다르다면, 불편+번거로움
 *  	: ex) 배열.length vs  컬렉션.size()
 *  		  배열[index] vs  list.get(index) 
 *  
 *  한번 생성하고 사용한 스트림은 재사용 불가
 *  스트림 연산은 기존자료를 변경하지 않음 (즉 배열에서 생성한 스트림이 원본 배열을 직접 건드리진 않음)
 *  '중간연산'과 '최종연산'으로 구분됨
 *
 *  	'중간연산'
 *  		어떤 조건으로 자료를 filtering 한다든가, 어떤 조건에 맞는 자료를 꺼내온다든다
 *  		중간연산은 체이닝 된다.  
 *  
 *  		map()
 *  		filter()
 * 			sorted()
 *  		...
 *  
 *  
 *  	'최종연산'
 *  		그 결과를 출력한다든가, 합 혹은 평균을 구하는 등의 연산 -> '결과'가 나온다
 *  		최종연산은 자료를 '소모' 하면서 연산을 수행
 *  		그래서, 맨 마지막에 등장. 최종연산후에 스트림은 더이상 다른연산 적용 불가.
 *  		최종연산이 적용(수행)되어야 모든 그 앞의 중간연산이 적용되는 '지연연산'이 발생
 *  
 *  		forEach() : 요소를 하나씩 꺼내옴
 *  		count() : 요소의 개수
 *  		sum() : 요소의 합
 *  		reduce(a, b) : 
 *  		...
 *  

 */

// 참조
// https://futurecreator.github.io/2018/08/26/java-8-streams/
// 패스트캠퍼스 자바 60강

public class Stream01Main {
	public static void main(String[] args) {
		System.out.println("Stream01");
		
		List<String> sList = Arrays.asList("John", "Susan", "Tom", "Michael");
		Customer[] arrCustomer = {
				new Customer("John", 32),
				new Customer("Susan", 22),
				new Customer("Tom", 55)
		};
		

		// 문자열의 길이 5이상인 요소만 출력하기
		sList.stream()  // 컬렉션에서 스트림 생성, Stream<T> 리턴
			.filter(s -> s.length() >= 5)  // 중간 연산
			.forEach(s -> System.out.println(s))  // 최종연산 (지금의 경우는 출력)
			;
		
		// 문자열의 개수 출력하기
		sList.stream()
//			.forEach(s -> System.out.print(s.length() + " "))
			.map(s -> s.length())
			.forEach(n -> System.out.print(n + " "));
			;
		
		System.out.println();


		// 고객클래스에서 고객이름만 가져오기
		Arrays.stream(arrCustomer) // 배열에서 스트림 생성, Stream<T> 리턴
			.map(c -> c.getName()) // 중간연산
			.forEach(s -> System.out.println(s)) // 최종연산
			;
		
		// ↑ 주로 람다식과 함께 많이 사용된다.

		System.out.println();
		sList.stream().sorted().forEach(s->System.out.print(s+ " "));
		System.out.println();
//		sList.stream().map(s->s.length()).forEach(n->System.out.print(n + " "));
//		System.out.println();
//		sList.stream().filter(s->s.length() >= 5).forEach(s->System.out.print(s));
//		System.out.println();

		System.out.println();
		// 한번 최종연산한 스트림은 다시 사용 불가
		Stream<Customer> stream = Arrays.stream(arrCustomer);
		stream.forEach(s -> System.out.println(s.getAge()));
		//stream.forEach(s -> System.out.println(s.getAge()));  // 에러 IllegalStateException
		
		// 다시 Stream 을 생성해선 사용 가능
		stream = Arrays.stream(arrCustomer);
		stream.forEach(s -> System.out.println(s.getAge()));
		
		System.out.println("\n프로그램 종료");
	} // end main
} // end class

class Customer{
	String name;
	int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
} // end Customer





