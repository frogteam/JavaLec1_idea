package com.J01.stream생성;

import common.Customer;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// 선행 : Collection, 배열, Lambda, 익명클래스,
//       Optional, 함수형인터페이스

/**
 *  스트림 (Stream) : 집합자료의 연산을 위해 사용하는 객체
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
 *
 */

/**
 * 스트림 생성
 *   스트림을 생성할 때 스트림이 열리고 모든 연산이 행해지고 결과를 받으면 스트림이 닫힌다.
 *   스트림이 닫히면 해당 스트림을 재사용할 수 없기 때문에 스트림을 다시 생성해야한다.
 *   스트림의 생성은 stream(), of() 메서드를 이용해 컬렉션, 배열 등 다양한 곳에서 생성이 가능하다.
 *   stream()은 컬렉션 인터페이스의 기본 메서드로 정의되어 있다. Stream.of()를 통해 생성하는 것이 가능하다.
 */

// 참조: https://zayson.tistory.com/entry/Stream-API-%EB%AC%B4%EC%9E%91%EC%A0%95-%EC%97%B0%EC%8A%B5%ED%95%98%EA%B8%B0#%EC%-A%A-%ED%-A%B-%EB%A-%BC%--%EC%--%B-%EC%--%B-%---%--%EC%A-%--%EA%B-%--%--%EC%--%B-%EC%--%B-

public class Stream01Main {
	public static void main(String[] args) {


		int [] intArr = {5, 2, 1, 4, 3};
		List<String> stringList = List.of("zayson", "maeng", "joon");
		List<Integer> intList = List.of(1, 2, 3, 4, 5);

		// Arrays.stream(int[]) => IntStream 생성
		IntStream is = Arrays.stream(intArr);   // 배열의 스트림 생성
		//IntStream is2 = intList.stream();   // 이건 에러인데..
		Stream<String> stringStream = stringList.stream();  // 리스트의 스트림 생성
		Stream<Integer> intStream = intList.stream();

		// toString() 은 따로 없다..
		System.out.println(is);  // java.util.stream.IntPipeline$Head@4eec7777
		System.out.println(stringStream); // java.util.stream.ReferencePipeline$Head@3b07d329

		Map<String, Integer> person = Map.of("zayson", 28, "chaeyoung", 26);
		Stream<Map.Entry<String, Integer>> entryStream = person.entrySet().stream(); // 맵의 EntrySet 스트림 생성

		Set<Integer> integerSet = Set.of(10, 20, 30);
		Stream<Integer> stream = integerSet.stream();   // Set 의 스트림 생성 ->  Integer이므로 Integer 스트림 생성

		// Stream.of 팩토리 메서드로 스트림 생성
		Stream<Integer> integerStream = Stream.of(20, 30);
		Stream<Customer> customerStream = Stream.of(
				new Customer("zayson", 28)
				, new Customer("chaeyoung", 26));


		// --------------------------------------------------------
		// IntStream 의 메소드 sum(), count()
		int sum, min, max;
		long count;

		sum = Arrays.stream(intArr).sum();
		count = Arrays.stream(intArr).count();  // 한번 사용한 스트림 재사용 불가.  따라서 새로 만듬.
		System.out.println("sum = " + sum + ", count =" + count);

		// min(), max() 은 OptionalInt 리턴
		min = Arrays.stream(intArr).min().getAsInt();  // get() 은 확실하게 empty 가 아닌 경우만 동작
		max = Arrays.stream(intArr).max().getAsInt();  // 만약 배열이 비어있다면 여기서 예외 발생
		System.out.println("min = " + min + ", max = " + max);


		Arrays.stream(intArr)
				.sorted()  // 중간연산 (정렬, Comparable이 구현된 객체만 가능)
				.forEach(s -> System.out.print(s + " "))  // 최종연산
		;
		System.out.println();

		// average() 의 리턴타입은 OptionalDouble
		Arrays.stream(intArr).average().ifPresent(v -> System.out.println(v));

		IntStream.range(1, 10).forEach(i -> {
			System.out.print(i + " ");
		});

		System.out.println();

		// Integer collection  에 대해서는 곧바로 sum()  사용 불가
		//System.out.println(intList.stream().sum());  // 불가
		// mapToInt() 는 IntStream 리턴
		System.out.println(intList.stream().mapToInt(n->n.intValue()).sum());

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class












