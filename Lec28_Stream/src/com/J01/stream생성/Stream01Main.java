package com.J01.stream생성;

import common.Customer;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// 선행 : Collection, 배열, Lambda, 익명클래스,
//       Optional, 함수형인터페이스

/**
 *  스트림 (Stream) : 집합자료의 연산을 위해 사용하는 객체
 *  - Java8 에서 등장
 *  - 람다 활용
 *  - ※ InputStream / OutputStream 과는 전혀 다른 객체다. 헷갈리지 말자.
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
 *   stream()은 Collection<> 인터페이스의 기본 메서드로 정의되어 있다.
 *   Stream.of()를 통해 생성하는 것이 가능하다.
 *
 *   Stream<T> ← 일반(generic) stream
 *
 *   IntStream, DoubleStream, LongStream ← primitive type stream 3개 제공
 * *   boxed stream         primitive stream
 *  *   ------------------------------------
 *  *   Stream<Integer>     IntStream
 *  *   Stream<Double>      DoubleStream
 *  *   Stream<Long>        LongStream
 */

// 참조: https://zayson.tistory.com/entry/Stream-API-%EB%AC%B4%EC%9E%91%EC%A0%95-%EC%97%B0%EC%8A%B5%ED%95%98%EA%B8%B0

public class Stream01Main {
	public static void main(String[] args) {

		int [] intArr = {5, 2, 1, 4, 3};   // 배열
		double [] doubleArr = {0.1, 0.2, 0.3, 0.4};
		List<String> stringList = List.of("zayson", "maeng", "joon");  // List<String>
		List<Integer> intList = List.of(1, 2, 3, 4, 5);   // List<Integer>
		Set<Integer> integerSet = Set.of(10, 20, 30);     // Set<Integer>
		Map<String, Integer> person = Map.of("zayson", 28, "chaeyoung", 26);


		// 배열의 스트림 생성
		// Arrays.stream(int[]) => IntStream 생성
		IntStream stream1 = Arrays.stream(intArr);   // 배열의 스트림 생성
		//IntStream stream2 = intList.stream();   // 이건 에러인데..
		DoubleStream stream2 = Arrays.stream(doubleArr);

		// 컬렉션 의 스트림 생성
		Stream<String> stringStream = stringList.stream();  // Collection 의 Stream 생성
		Stream<Integer> intStream = intList.stream();

		// toString() 이 딱히...  볼수 있는 형태로 제공되지 않는다.
		System.out.println(stream1);  // java.util.stream.IntPipeline$Head@4eec7777
		System.out.println(stringStream); // java.util.stream.ReferencePipeline$Head@3b07d329

		// Map 의 Entry 들의 Stream
		Stream<Map.Entry<String, Integer>> entryStream = person.entrySet().stream(); // 맵의 EntrySet 스트림 생성

		Stream<Integer> stream = integerSet.stream();   // Set 의 스트림 생성 ->  Integer이므로 Integer 스트림 생성

		// Stream.of() 팩토리 메서드로 스트림 생성
		Stream<Integer> integerStream = Stream.of(20, 30);
		Stream<Customer> customerStream = Stream.of(
				new Customer("zayson", 28)
				, new Customer("chaeyoung", 26));


		System.out.println("\n프로그램 종료");
	} // end main()
} // end class












