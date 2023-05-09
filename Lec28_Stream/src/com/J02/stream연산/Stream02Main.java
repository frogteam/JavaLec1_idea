package com.J02.stream연산;

import common.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *   스트림 연산
 *  스트림 연산은 기존자료를 변경하지 않음 (즉 배열에서 생성한 스트림이 원본 배열을 직접 건드리진 않음)
 *  스트림 연산은 '중간연산'과 '최종연산'으로 구분됨
 *
 *  	'중간연산'
 *  		어떤 조건으로 자료를 filtering 한다든가, 어떤 조건에 맞는 자료를 꺼내온다든다
 *  		중간연산은 체이닝 된다.  
 *  
 *  		map(), filter(), sorted(), distinct(),
 *  		limit(), skip(), peek(), boxed()
 *  		...
 *
 *          중간연산은 데이터를 다시 Stream 타입으로 리턴하기 때문에 이후 체이닝 가능.
 *  
 *  
 *  	'최종연산 (터미널 연산)'
 *  		그 결과를 출력한다든가, 합 혹은 평균을 구하는 등의 연산 -> '결과'가 나온다
 *  		최종연산은 자료를 '소모' 하면서 연산을 수행
 *  		그래서, 맨 마지막에 등장. 최종연산후에 스트림은 더이상 다른연산 적용 불가.
 *  		최종연산이 적용(수행)되어야 모든 그 앞의 중간연산이 적용되는 '지연연산'이 발생
 *  
 *
 *  		min(), max(), count(), sum(), average()
 *  		reduce(a, b)
 *  		anyMatch(), allMatch(), noneMatch()
 *  	    collecting()
 *  	    forEach()
 *  		...
 */

// 참조
// https://futurecreator.github.io/2018/08/26/java-8-streams/
// 패스트캠퍼스 자바 60강

public class Stream02Main {
	public static void main(String[] args) {
		System.out.println("Stream01");

		List<String> sList = Arrays.asList("John", "Susan", "Tom", "Michael");
		Customer[] arrCustomer = {
				new Customer("John", 32),
				new Customer("Susan", 22),
				new Customer("Tom", 55)
		};


//		filter()는 Predicate 함수형 인터페이스를 파라미터로 받고 이에 해당하는 요소를 스트림에서 뽑는다.
//		filter()의 파라미터로 boolean값을 반환하는 람다식을 파라미터로 전달한다.


		// 문자열의 길이 5이상인 요소만 출력하기
		sList.stream()  // 컬렉션에서 스트림 생성, Stream<T> 리턴, 기존 컬렉션 데이터와는 별도의 데이터로 생성되기 때문에 원본데이터는 변경되지 않는다
				.filter(s -> s.length() >= 5)  // 중간 연산
				.forEach(s -> System.out.println(s))  // 최종연산 (지금의 경우는 출력)
		;

		// 문자열의 개수 출력하기
		sList.stream()
				.forEach(s -> System.out.print(s.length() + " "))
		;

		// 다음과 같이 해도 동일한 결과
		sList.stream()
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

		//--------------------------------------------
		// Stream 은 내부반복 로직 수행
		// 기존 for, while 루프 대체

		// 문자열에서 a를 포함했다면 true를 리턴하는 로직
		System.out.println(match(sList, "a"));
		// 이를 stream 으로 작성하면.
		System.out.println(sList.stream().anyMatch(str -> str.contains("a")));

		System.out.println("\n프로그램 종료");
	} // end main

	public static boolean match(List<String> list, String match){
		for (String string : list) {
			if (string.contains(match)) {
				return true;
			}
		}
		return false;
	}


} // end class





