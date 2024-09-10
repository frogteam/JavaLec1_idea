package com.J02.stream연산;

import common.Customer;

import java.util.*;
import java.util.stream.*;

/**
 *  스트림 연산
 *  스트림 연산은 기존자료를 변경하지 않음 (즉 배열에서 생성한 스트림이 원본 배열을 직접 건드리진 않음)
 *  스트림 연산은 '중간연산'과 '최종연산'으로 구분됨
 *
 *  	'중간연산'
 *  		어떤 조건으로 자료를 filtering 한다든가, 어떤 조건에 맞는 자료를 꺼내온다든다
 *  		중간연산은 체이닝 된다.  
 *  
 *  		map(), filter(), sorted(), distinct()
 *  		limit(), skip(), peek(), boxed()
 *  		mapToInt(), mapToDouble(), mapToLong()
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
 *          forEach()
 *  		min(), max(), count(), sum(), average()
 *  		reduce(a, b)
 *  		anyMatch(), allMatch(), noneMatch(),
 *  		findFirst(), findAny(),
 *  	    collecting()
 */

// 참조
// https://futurecreator.github.io/2018/08/26/java-8-streams/
// 패스트캠퍼스 자바 60강

public class Stream02Main {
	public static void main(String[] args) {
		System.out.println("Stream연산");

		List<String> stringList = Arrays.asList("John", "Susan", "Tom", "Michael");
		Customer[] arrCustomer = {
				new Customer("John", 32),
				new Customer("Susan", 22),
				new Customer("Tom", 55),
				new Customer("john", 43),
		};
		List<Customer> customerList = Arrays.asList(arrCustomer);

		//----------------------------------------------------------------------
		// forEach(Consumer<T>)    [최종연산]
		// 리턴값: void
		// 주어진 Stream 을 순환하며 연산 수행
		System.out.println("-".repeat(30) +"\n▶ forEach(Consumer<T>)");
		{
			// customerList 의 내용들 출력하기
			// 1. for문 사용
			// TODO

			// 2. Stream 사용
			Stream<Customer> stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s));  // 최종연산
			// ★한번 최종연산한 스트림은 다시 사용 불가 --> IllegalStateException
			// stream1.forEach(s -> System.out.println(s));

			// 다시 Stream 을 생성해선 사용 가능
			stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s.getAge()));


			// 문자열의 문자 개수 출력하기
			System.out.println();
			stringList.stream()
					.forEach(s -> System.out.print(s.length() + " "));
			System.out.println();
		}


		//----------------------------------------------------------------------
		// filter(Predicate<T>)   [중간연산]
		//   주어진 Stream 에서 Predicate 이 true 로 판정(리턴)하는 것들의 Stream을 생성하여 리턴
		//   입력 ->  출력
		//    n개 ->  <=n개
		System.out.println("-".repeat(30) +"\n▶ filter(Predicate<T>)");
		{
			System.out.println(stringList);
			// 문자열의 길이 5이상인 요소만 출력하기

			// 1. 일반 for 문 사용
			for(var str : stringList){
				if(str.length() >= 5){
					System.out.println(str);
				}
			}
			System.out.println();

			// 2. Stream 사용
			stringList.stream()  // 컬렉션에서 스트림 생성, Stream<String> 리턴, 기존 컬렉션 데이터와는 별도의 데이터로 생성되기 때문에 원본데이터는 변경되지 않는다
					.filter(s -> s.length() >= 5)  // 중간 연산  Stream<String>
					.forEach(System.out::println)  // 최종연산 (지금의 경우는 출력)
					;

			// 도전] 나이가 40살 이하인 사람만 출력
			System.out.println();
			customerList.stream()    // Stream<Customer>
					.filter(c -> c.getAge() <= 40)  // Stream<Customer>
					.forEach(System.out::print);
			System.out.println();
		}


		//---------------------------------------------------------------------
		// Map(Function<T, U>)  [중간연산]
		// Stream 의 요소 '각각'에 '연산을 적용하여 변환'한 Stream 리턴
		// 입력  =>  출력
		//  n개  =>  n개
		System.out.println("-".repeat(30) +"\n▶ map(Function<T, U>)");
		{
			// Customer 리스트에서 고객이름만 출력하기

			// 1. for 사용
			for(var c : arrCustomer){
				String name = c.getName();
				System.out.println(name);
			}

			System.out.println();
			// 2. Stream 사용
			Arrays.stream(arrCustomer) // 배열에서 스트림 생성, Stream<Customer> 4개
					.map(c -> c.getName()) // 중간연산 -> Stream<String> 4개
					.forEach(s -> System.out.println(s)); // 최종연산

			System.out.println();

			// 위 내용을 method reference 사용하여 작성 가능
			Arrays.stream(arrCustomer) // 배열에서 스트림 생성, Stream<Customer> 리턴
					.map(Customer::getName) // 중간연산   Stream<String> 리턴
					.forEach(System.out::println); // 최종연산
			System.out.println();

			// 도전] stringList 에서 문자열의 길이만 출력
			stringList.stream() // Stream<String>
					.map(s -> s.length())   // Stream<Integer>
					.forEach(n -> System.out.print(n + " "));
			System.out.println();
		}


		//-------------------------------------------------------
		// sorted(), sorted(Comparator<T>)   [중간연산]
		//    Stream 을 정렬한 Stream<T> 리턴
		//
		// sorted() : Comparable 을 구현한 객체들의 대소비교
		// sorted(Comparator<T>):   매개변수 Comparator<>  <- 대소 비교

		System.out.println("-".repeat(30) +"\n▶ sorted(), sorted(Comparator<T>)");
		{
			stringList.stream().forEach(System.out::println);  // 일단 출력

			System.out.println();
			// 사전순 정렬.  String 은 Comparable<>이 구현된 객체니까. sorted() 사용 가능
			stringList.stream()
					.sorted()   // Stream<String>  정렬된 결과
					.forEach(System.out::println);

			// Comparable<> 이 구현되지 않은 객체로 sorted() 하면
			// ClassCastException 발생!
//			customerList.stream()
//					.sorted()
//					.forEach(System.out::println);

			// sorted(Comparator<>) 사용
			// 글자 개수 오름차순으로 정렬
			System.out.println();
			stringList.stream()
					.sorted((o1, o2) -> o1.length() - o2.length())
					.forEach(System.out::println);

			// 글자 개수 내림차순으로 정렬
			System.out.println();
			stringList.stream()
					.sorted((o1, o2) -> o2.length() - o1.length())
					.forEach(System.out::println);

			System.out.println();
			customerList.stream().forEach(System.out::println);

			System.out.println();
			// customer 이름 오름차순으로 정렬
			// Comparator.comparing(Function<T,U>
			customerList.stream()
					.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
					.forEach(System.out::println);

			System.out.println();
			// customer 이름 내림차순으로 정렬
			customerList.stream()
					.sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
					.forEach(System.out::println);

			System.out.println();
			// customer 나이 내림차순으로 정렬

			// customer 나이 오름차순으로 정렬


			// Comparator 에서 제공하는 comparing(Function<T, U>) 사용
			System.out.println();
			customerList.stream()
					.sorted(Comparator.comparing(Customer::getName))
					.forEach(System.out::println);

			// customer 나이순으로 정렬 (오름차순)
			System.out.println();
			customerList.stream()
					.sorted(Comparator.comparing(Customer::getAge))  // 나이 오름차순
					.forEach(System.out::println);

			// customer 나이 역순으로 정렬 (내림차순)
			System.out.println();
			customerList.stream()
					.sorted(Comparator.comparing(Customer::getAge).reversed())  // 나이 내림정렬
					.forEach(System.out::println);
		}

		//-------------------------------------------------------------
		// distinct()    [중간연산]
		//  Stream 에서 중복된 요소 제거한 Stream 리턴
		// primitive type 의 경우  == 으로 '같은지 여부' 판단
		// object type 의 경우 .equals() 로 '같은지 여부' 판단
		System.out.println("-".repeat(30) +"\n▶ distinct()");
		int[] intArr = {9, 1, 1, 0, 2, 2, 2, 5, 9, 2, 0};
		{
			System.out.println(Arrays.toString(intArr));

			Arrays.stream(intArr)
					.distinct()
					.forEach(n -> System.out.print(n + ", "));
			System.out.println();

			// 흠  ... equals 가 될줄 알았는데... 안된다.
			// stateful 이슈? https://stackoverflow.com/questions/23699371/java-8-distinct-by-property
			//		System.out.println();
			//		customerList.stream().distinct().forEach(System.out::println);
		}


		//-------------------------------------------------------------
		// limit(maxSize)    [중간연산]
		//   Stream 의 가장 앞 요소부터 지정한 maxSize만큼을 Stream 으로 리턴
		System.out.println("-".repeat(30) +"\n▶ limit(maxSize)");
		{
			Arrays.stream(intArr).limit(5).forEach(s -> System.out.print(s + ","));
			System.out.println();
			Arrays.stream(intArr).limit(4).forEach(s -> System.out.print(s + ","));
			System.out.println();
			Arrays.stream(intArr).limit(3).forEach(s -> System.out.print(s + ","));
			System.out.println();
		}

		//-------------------------------------------------------------
		// skip(n)  [중간연산]
		//   Stream 의 앞요소부터 지정한 개수 n만큼을 제외한 Stream 리턴
		System.out.println("-".repeat(30) +"\n▶ skip(n)");
		{
			System.out.println(Arrays.toString(intArr));

			Arrays.stream(intArr).skip(3).forEach(s -> System.out.print(s + ", "));
			System.out.println();
			Arrays.stream(intArr).skip(4).forEach(s -> System.out.print(s + ", "));
			System.out.println();
			Arrays.stream(intArr).skip(5).forEach(s -> System.out.print(s + ", "));
			System.out.println();

			// 도전] 0, 2, 2, 2, 5, 9  <- 출력하기
			// hint: skip 과 limit 사용
			Arrays.stream(intArr)
					.skip(3)
					.limit(6)
					.forEach(System.out::println);

			// ※ 위의 예에서 skip 과 limit 순서를 바꾸면 결과는?
			// ※ 위의 결과를 for문으로 만들어 내려면?
		}

		//-------------------------------------------------------------
		// peek(Consumer<T>)   [중간연산]
		//    현재 진행중인 Stream 에 영향을 주지 않으면서 현재까지 연산된 요소들을 출력하는등의 동작 수행
		System.out.println("-".repeat(30) +"\n▶ Consumer<T>");
		{
			List<String> nameList = new ArrayList<>();

			customerList.stream()
					.limit(2)
					.map(Customer::getName)
					.peek(name -> nameList.add(name))
					.filter(name -> name.startsWith("J"))   // "J" 로 시작하는 사람만
					.forEach(System.out::print);
			System.out.println("\n" + "*".repeat(20));

			System.out.println("nameList : " + nameList);
		}

		//-------------------------------------------------------------
		// boxed()는
		// primitive 타입 스트림을 => 레퍼런스 타입 스트림으로 boxing 해준다. (boxed 스트림)
		System.out.println("-".repeat(30) +"\n▶ boxed()");
		{
			IntStream intStream = Arrays.stream(intArr);
			Stream<Integer> boxedStream = intStream.boxed();
			// boxedStream = intStream;  XXX
		}

		//-------------------------------------------------------------
		// mapToInt(), mapToDouble(), mapToLong()
		// boxed 타입 스트림 -> primitive 타입 스트림을 변환
		System.out.println("-".repeat(30) +"\n▶ mapToInt(), mapToDouble(), mapToLong()");
		{
			Stream<Double> boxedStream;

			boxedStream = Stream.of(10., 20., 30.);
			IntStream intStream = boxedStream.mapToInt(x -> x.intValue());

			boxedStream = Stream.of(10., 20., 30.);
			DoubleStream doubleStream = boxedStream.mapToDouble(x -> x.doubleValue());

			boxedStream = Stream.of(10., 20., 30.);
			LongStream longStream = boxedStream.mapToLong(x -> x.longValue());
		}




		/*************************************************************/
		System.out.println("■".repeat(30));
		System.out.println("[최종연산(터미널 연산)]");

		//---------------------------------------------------------------
		// sum(), count(), average()    [최종연산]
		//
		//  sum()
		//    primitive stream 에서만 사용 가능.
		//    리턴값: 해당 타입
		//  count()
		//    primitive, boxed 스트림 양쪽에서 사용 가능
		//    리턴값: long
		// average()
		//    primitive stream 에서만 사용 가능.
		//    리턴값 Optional:  Optional<T>, OptionalInt, OptionalDouble ..
		System.out.println("-".repeat(30) +"\n▶ sum(), count(), average()");
		{
			customerList.forEach(System.out::println);  // 원본 확인
			// 나이의 합
			var result1 = customerList.stream()  // Stream<Customer>
					.mapToInt(Customer::getAge)  // IntStream  (OK)
					//.mapToLong(Customer::getAge)  // LongStream  (OK)
					//.mapToDouble(x -> (double)x)  // DoubleStream (OK)
					//.map(Customer::getAge)    // Stream<Integer>  (에러!)
					.sum();
			System.out.println("sum() = " + result1);

			// 나이 40이상 몇명?
			var result2 = customerList.stream()
					.filter(x -> x.getAge() >= 40)
					.count();
			System.out.println("count() = " + result2);

			// 평균나이 구하기
			var result3 = customerList.stream()
					.mapToInt(Customer::getAge)
					.average().getAsDouble()

					;
			System.out.println("average() = " + result3);

			//.average().orElse(0)  // empty 처리 할라믄..
			List<Customer> emptyList = new ArrayList<>();
			var result4 = emptyList.stream()
					.mapToInt(Customer::getAge)
					.average()  // OptionalDouble.empty
//					.getAsDouble()  // 에러!
					.orElse(0.0)
					;
			System.out.println("result4 = " + result4);
		}

		//---------------------------------------------------------------
		// min(), max()   [최종연산]
		//
		//  min(), max() 는 primitive, boxed 스트림 양쪽에서 사용 가능
		//    primitive 타입의 경우 max()에 파라미터가 없고, getXXX()를 이용해 반환 받을 수 있다.
		//    reference 타입인 경우 max()에 Comparator가 파라미터로 들어간다.
		// Optional 리턴:  Optional<T>, OptionalInt, OptionalDouble ..
		System.out.println("-".repeat(30) +"\n▶ min(), max()");
		{
			// 1-1) 최대 나이값  (primitive)
			var maxAge1 = customerList.stream()   // Stream<Customer>
					.mapToInt(Customer::getAge)   // IntStream
					.max()    // OptionalInt
					.getAsInt()
					;
			System.out.println("maxAge1 = " + maxAge1);

			// 1-2) 최대 나이값  (reference)
			var maxAge2 = customerList.stream()   // Stream<Customer>
					.map(Customer::getAge)   // Stream<Integer>
					//.max((o1, o2) -> o1.compareTo(o2))    //  Optional<Integer>
					.max(Integer::compare) // int Integer.compare(o1, o2)
					.get()
					;
			System.out.println("maxAge2 = " + maxAge2);


			// 2) 최소 나이
			// 프리미티브 타입
			int minAge1 = customerList.stream()
					.mapToInt(Customer::getAge)
					.min().getAsInt();

			// 래퍼런스 타입
			Integer minAge2 = customerList.stream()
					.map(Customer::getAge)
					.min(Integer::compare).get();

			System.out.println("minAge1 = " + minAge1);
			System.out.println("minAge2 = " + minAge2);
		}

		//---------------------------------------------------------------
		// **Match  [최종연산]
		// 스트림 연산 결과에 대해서 조건을 검사해 true/false로 리턴한다.
		//   매개변수: Predicate<T>
		//   anyMatch() : 조건을 충족하는 요소가 하나라도 있는 경우 true
		//   allMatch() : 모든 요소가 조건을 충족하는 경우 true
		//   noneMatch() : 모든 요소가 조건을 충족하지 않는경우 true
		System.out.println("-".repeat(30) +"\n▶ **Match(Predicate<T>)");
		{
			customerList.forEach(System.out::println);

			//--------------------------------------------
			// Stream 은 내부반복 로직 수행
			// 기존 for, while 루프 대체
			System.out.println(stringList);
			// 문자열에서 a를 포함했다면 true를 리턴하는 로직
			System.out.println(match(stringList, "a"));   // ※ 하단의 match() 메소드부터 보고오자.
			// 이를 stream 으로 작성하면.
			System.out.println(stringList.stream().anyMatch(str -> str.contains("a")));


			customerList.forEach(System.out::println);  // 확인 출력

			// 1) 이름에 "o"가 들어가는 사람이 한명이라도 있습니까? (anyMatch 사용)
			boolean anyMatch1 = customerList.stream()
					.anyMatch(customer -> customer.getName().contains("o"));
			System.out.println("anyMatch1 = " + anyMatch1); // true

			// 2) 모든 사람의 이름에 "o" 가 있습니까? (allMatch 사용)
			boolean allMatch1 = customerList.stream()
					.allMatch(customer -> customer.getName().contains("o"));
			System.out.println("allMatch1 = " + allMatch1);  // false

			// 3)  모든 사람의 나이가 25살 이상입니까?  (allMatch 사용)
			boolean allMatch2 = customerList.stream()
					.allMatch(customer -> customer.getAge() >= 25);
			System.out.println("allMatch2 = " + allMatch2);  // false

			// 4) 어떤 사람의 이름도 10글자이상이 아닙니까?  (noneMatch 사용)
			boolean noneMatch = customerList.stream()
					.noneMatch(customer -> customer.getName().length() >= 10);
			System.out.println("noneMatch = " + noneMatch);  // true
		}

		//-------------------------------------------------------
		// find   [중간연산]
		//
		//   findFirst() : 주어진 스트림에서 '순서상 첫번째' 원소를 리턴
		//   findAny() : 주어진 스트림에서 '가장 먼저' 탐색되는 원소 리턴  (병렬처리 환경)
		//
		//   리턴값: Optional
		//        Stream 에 원소가 없으면 empty 리턴
		//
		//   findFirst() 와 findAny() 의 차이점
		//     Stream 이 직렬로 처리될때는 둘다 동일 값 리턴
		//     Stream 을 병렬로 처리할때는 차이가 있을수 있다
		//         병렬로 처리하는 상황에선 findAny 는 '가장 먼저' 탐색되는 요소 리턴
		
		// 참조: https://codechacha.com/ko/java8-stream-difference-findany-findfirst/#3-findfirst%EC%99%80-findany%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90

		System.out.println("-".repeat(30) +"\n▶ findFirst() findAny()");
		{
			// 1) 나이가 40 이상인 고객중 첫번째 고객
			var result1 = customerList.stream()
					.filter(x -> x.getAge() >= 40)
					.findFirst();  // Optional<Customer>
			System.out.println("result1 = " + result1);

			var result2 = customerList.stream()
					.filter(x -> x.getAge() >= 20)
					.findAny();
			System.out.println("result2 = " + result2);
		}


		/* 아래 collect 하기 전에 reduce 먼저 하길 추천 함 */

		//---------------------------------------------------------------
		// Collecting   [최종연산]
		//
		// collect(Collector<T, A, R>)
		//    스트림 중간 연산을 결과를 Collector 형태의 파라미터를 받아
		//    다양한 형태로 결과를 만들어준다.
		//
		// Collector<T, A, R>
		//     T : 입력 요소 타입
		//     A : reduction 연산의 누적값 타입
		//     R : reduction 최종 결과 타입
		//
		// Collectors.toList(), Collectors.toMap(), Collectors.toSet()
		//     각각 연산의 결과를 List, Map, Set 으로 변환해 결과를 만든다.
		//
		System.out.println("-".repeat(30) +"\n▶ collect(Collector<T, A, R>)");
		{
			List<Customer> personList = List.of(
					new Customer("zayson", 28),
					new Customer("chaeyoung", 26),
					new Customer("maeng", 30),
					new Customer("joon", 28)
			);
			personList.forEach(System.out::println);

			// 1) 이름만 List 로 뽑기
			List<String> nameList1 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.toList());  // List로 변환
			System.out.println("nameList = " + nameList1);

			List<String> nameList2 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.toList());  // List로 변환
			System.out.println("nameList = " + nameList2);

			// 2) 나이대를 Set으로 뽑기
			Set<Integer> ageSet = personList.stream()
					.map(x -> x.getAge() / 10 * 10)
					.collect(Collectors.toSet());  // Set으로 변환
			System.out.println("ageSet = " + ageSet);

			// 3) 이름-나이 로 Map 뽑기
			Map<String, Integer> personMapByName = personList.stream()
					.collect(Collectors.toMap(Customer::getName, Customer::getAge));  // Map<String, Integer> 로 변환
			System.out.println("personMapByName = " + personMapByName);

			// 나이:이름 의 Map 추출
			// key 가 중복인 경우 예외 발생  IllegalStateException: Duplicate key 28 (attempted merging values zayson and joon)
			Map<Integer, String> personMapByAge;

//			personMapByAge = personList.stream()
//					.collect(Collectors.toMap(Customer::getAge, Customer::getName));  // IllegalStateException: Duplicate key 28 (attempted merging values zayson and joon)

			// 위 경우 BinaryOperator 이용해 덮어쓰기
			personMapByAge = personList.stream()
					.collect(Collectors.toMap(Customer::getAge, Customer::getName, (oldValue, newValue) -> newValue)); // Map으로 변환하고, 동일한 키인 경우 새로운 값으로 갱신
			System.out.println("personMapByAge = " + personMapByAge);

			// Collectors.joining()은 연산한 결과가 String 타입일 때 여러 결과 문자열을 하나로 합쳐주는 역할을 한다.
			//    파라미터가 없는 경우 : 문자열을 그대로 이어붙힌다.
			//    파라미터가 1개인 경우 (delimiter) : 각 문자열 사이에 구분자를 넣을 수 있다.
			//    파라미터가 3개인 경우 (delimiter, prefix, suffix) : 각 문자열 사이에 구분자를 넣고, 하나로 합쳐진 문자열 앞뒤에 문자열을 추가해 붙힌다.

			// 4) 이름을 뽑아 다양한 형태로 이어붙히기
			// 연산한 문자열을 하나의 문자열로 이어붙힌다.
			String name1 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.joining());
			System.out.println("name1 = " + name1);

			// 각각의 연산된 문자열에 구분자를 넣을 수 있다.
			String name2 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.joining(" / "));
			System.out.println("name2 = " + name2);

			// 구분자와 함께 합쳐진 문자열 앞뒤에 문자를 넣을 수 있다.
			String name3 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.joining(" / ", "[", "]"));
			System.out.println("name3 = " + name3);

			// Collectors.summarizingInt(), Collectors.summingInt(), Collectors.averagingInt()
			//   통계를 내어 최대값, 최소값, 개수, 합계, 평균을 구하거나
			//   직접 합계나 평균을 구하는 것이 가능하다.
			// Int, Double, Long 모두 지원

			// 5) 합계, 평균, 통계를 이용한 계산
			Integer sum1 = personList.stream().collect(Collectors.summingInt(Customer::getAge));
			long sum2 = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getSum(); // 통계이용
			System.out.println("sum1 = " + sum1);
			System.out.println("sum2 = " + sum2);

			Double average1 = personList.stream().collect(Collectors.averagingInt(Customer::getAge));
			double average2 = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getAverage();// 통계이용
			System.out.println("average1 = " + average1);
			System.out.println("average2 = " + average2);

			long count = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getCount();
			int maxAge = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getMax();
			int minAge = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getMin();
			System.out.println("count = " + count);
			System.out.println("maxAge = " + maxAge);
			System.out.println("minAge = " + minAge);

			// Collectors.groupingBy()는 파라미터로 그룹핑 할 기준을 정해주면 해당 기준으로 데이터를 그룹핑한다.
			// 6) 데이터 그룹핑 (나이대 기준으로 데이터 그룹핑)
			//  groupingBy(Function<T, R>)
			Map<Integer, List<Customer>> collectByAge = personList.stream()
					.collect(Collectors.groupingBy(c -> c.getAge() / 10 * 10));
			System.out.println("collectByAge = " + collectByAge);

			// Collectors.partitioningBy()는 파라미터로 Predicate를 받는다.
			// 따라서, 해당 조건을 통해 나온 True/False를 기준으로 결과 데이터를 두 파티션으로 나눈다.
			// 7-1) 이름이 5글자보다 많은 경우 구분
			Map<Boolean, List<Customer>> nameCollect = personList.stream()
					.collect(Collectors.partitioningBy(person -> person.getName().length() > 5));
			System.out.println("nameCollect = " + nameCollect);

			// 7-2) 나이가 28살이 아닌 사람 구분
			Map<Boolean, List<Customer>> ageCollect = personList.stream()
					.collect(Collectors.partitioningBy(person -> person.getAge() != 28));
			System.out.println("ageCollect = " + ageCollect);

			// 8)
			//    String 을 쪼개어 List 로 만들기
			//    List 를 묶어서 String 으로 만들기
			String str = "GUEST,MEMBER,ADMIN";
			List<String> list = List.of("GUEST", "MEMBER", "ADMIN");

			List<String> listCollect = Arrays.stream(str.split(",")).toList();
			System.out.println("String -> List: " + listCollect);

			String strCollect = list.stream().collect(Collectors.joining(","));
			System.out.println("List -> String: " + strCollect);
		}

		System.out.println("\n프로그램 종료");
	} // end main

	public static boolean match(List<String> list, String match){
		for (String string : list) {
			if (string.contains(match)) {
				return true;
			}
		}
		return false;
	} // end match()



} // end class





