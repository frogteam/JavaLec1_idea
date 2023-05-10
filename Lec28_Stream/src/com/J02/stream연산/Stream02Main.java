package com.J02.stream연산;

import common.Customer;

import java.util.*;
import java.util.stream.*;

/**
 *   스트림 연산
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
			Stream<Customer> stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s));  // 최종연산
			// ★한번 최종연산한 스트림은 다시 사용 불가
			// stream1.forEach(s -> System.out.println(s));  // IllegalStateException

			// 다시 Stream 을 생성해선 사용 가능
			stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s.getAge()));


			// 문자열의 개수 출력하기
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
			// 문자열의 길이 5이상인 요소만 출력하기
			stringList.stream()  // 컬렉션에서 스트림 생성, Stream<String> 리턴, 기존 컬렉션 데이터와는 별도의 데이터로 생성되기 때문에 원본데이터는 변경되지 않는다
					.filter(s -> s.length() >= 5)  // 중간 연산  Stream<String>
					.forEach(s -> System.out.println(s))  // 최종연산 (지금의 경우는 출력)
			;

			// 나이가 40살 이하인 사람만 출력
			System.out.println();
			customerList.stream()    // Stream<Customer>
					.filter(c -> c.getAge() <= 40)  // Stream<Customer>
					.forEach(System.out::print);
			System.out.println();
		}


		//---------------------------------------------------------------------
		// Map(Function<T, U>)  [중간연산]
		// Stream 의 요소를 '연산을 적용하여 변환'한 Stream 리턴
		// 입력  =>  출력
		//  n개  =>  n개
		System.out.println("-".repeat(30) +"\n▶ map(Function<T, U>)");
		{
			// 고객클래스에서 고객이름만 가져오기
			Arrays.stream(arrCustomer) // 배열에서 스트림 생성, Stream<T> 리턴
					.map(c -> c.getName()) // 중간연산
					.forEach(s -> System.out.println(s)); // 최종연산
			System.out.println();

			// 위 내용을 method reference 사용하여 작성 가능
			Arrays.stream(arrCustomer) // 배열에서 스트림 생성, Stream<T> 리턴
					.map(Customer::getName) // 중간연산
					.forEach(System.out::println); // 최종연산
			System.out.println();

			// 문자열의 길이만 출력
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
			stringList.stream()
					.sorted()
					.forEach(System.out::println);

			// customer 이름순으로 정렬 (오름차순)
			// Comparator.comparing(Function<T,U>
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
			Arrays.stream(intArr).distinct().forEach(System.out::println);

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
			Arrays.stream(intArr).limit(5).forEach(System.out::println);
		}

		//-------------------------------------------------------------
		// skip(n)  [중간연산]
		//   Stream 의 앞요소부터 지정한 개수 n만큼을 제외한 Stream 리턴
		System.out.println("-".repeat(30) +"\n▶ skip(n)");
		{
			Arrays.stream(intArr)
					.skip(3)
					.limit(6)
					.forEach(System.out::println);
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


		//--------------------------------------------
		// Stream 은 내부반복 로직 수행
		// 기존 for, while 루프 대체

		// 문자열에서 a를 포함했다면 true를 리턴하는 로직
		System.out.println(match(stringList, "a"));
		// 이를 stream 으로 작성하면.
		System.out.println(stringList.stream().anyMatch(str -> str.contains("a")));

		//---------------------------------------------------------------
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
			// 나이의 합
			var result1 = customerList.stream()
					//.mapToInt(Customer::getAge)  // IntStream  (OK)
					.mapToLong(Customer::getAge)  // LongStream  (OK)
					.mapToDouble(x -> (double)x)  // DoubleStream (OK)
					//.map(Customer::getAge)    // Stream<Integer>  (에러!)
					.sum();
			System.out.println("sum() = " + result1);

			// 나이 40이상
			var result2 = customerList.stream()
					.filter(x -> x.getAge() >= 40)
					.count();
			System.out.println("count() = " + result2);

			// 평균나이 구하기
			var result3 = customerList.stream()
					.mapToInt(Customer::getAge)
					.average().getAsDouble();
			System.out.println("average() = " + result3);
		}

		//---------------------------------------------------------------
		// min(), max()   [최종연산]
		//
		//  min(), max() 는 primitive, boxed 스트림 양쪽에서 사용 가능
		//    primitive 타입의 경우 max()에 파라미터가 없고, getAsInt()를 이용해 반환 받을 수 있다.
		//    reference 타입인 경우 max()에 Comparator가 파라미터로 들어간다.
		// Optional 리턴:  Optional<T>, OptionalInt, OptionalDouble ..
		System.out.println("-".repeat(30) +"\n▶ min(), max()");
		{
			// 1) 최대 나이
			// 프리미티브 타입
			int maxAge1 = customerList.stream()  // Stream<Customer>
					.mapToInt(Customer::getAge)// IntStream
					.max() // OptionalInt
					.getAsInt();

			// 래퍼런스 타입
			Integer maxAge2 = customerList.stream() // Stream<Customer>
					.map(Customer::getAge) // Stream<Integer>
					.max(Integer::compare) // Optional<Integer>
					.get();

			System.out.println("maxAge1 = " + maxAge1);
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
		// Match  [최종연산]
		// 스트림 연산 결과에 대해서 조건을 검사해 true/false로 리턴한다.
		//   매개변수: Predicate<T>
		//   anyMatch() : 조건을 충족하는 요소가 하나라도 있는 경우 true
		//   allMatch() : 모든 요소가 조건을 충족하는 경우 true
		//   noneMatch() : 모든 요소가 조건을 충족하지 않는경우 true
		System.out.println("-".repeat(30) +"\n▶ **Match(Predicate<T>)");
		{
			// 1) 이름에 "o"가 들어가는 경우
			boolean anyMatch1 = customerList.stream()
					.anyMatch(person -> person.getName().contains("o"));
			System.out.println("anyMatch1 = " + anyMatch1); // true

			boolean allMatch1 = customerList.stream()
					.allMatch(person -> person.getName().contains("o"));
			System.out.println("allMatch1 = " + allMatch1);  // false

			// 2) 나이가 모두 25살 이상인 경우
			boolean allMatch2 = customerList.stream()
					.allMatch(person -> person.getAge() >= 25);
			System.out.println("allMatch2 = " + allMatch2);  // false

			// 3) 이름이 모두 10글자 이 아닌 경우
			boolean noneMatch = customerList.stream()
					.noneMatch(person -> person.getName().length() >= 10);
			System.out.println("noneMatch = " + noneMatch);
		}

		/* 아래 collect 하기 전에 reduce 먼저 하길 추천 함 */

		//---------------------------------------------------------------
		// Collecting   [최종연산]
		//
		// collect(Collector<T, A, R>)
		//    스트린 중간 연산을 결과를 Collector 형태의 파라미터를 받아
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
			// 1) 이름만 List 로 뽑기
			List<String> nameList = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.toList());  // List로 변환
			System.out.println("nameList = " + nameList);

			// 2) 나이대를 Set으로 뽑기
			Set<Integer> ageSet = personList.stream()
					.map(x -> x.getAge() / 10 * 10)
					.collect(Collectors.toSet());  // Set으로 변환
			System.out.println("ageSet = " + ageSet);

			// 3) 이름:나이로 Map 뽑기
			Map<String, Integer> personMapByName = personList.stream()
					.collect(Collectors.toMap(Customer::getName, Customer::getAge)); // Map으로 변환
			System.out.println("personMapByName = " + personMapByName);

			// 나이:이름 의 Map 추출
			// key 가 중복인 경우 예외 발생
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
			// 6) 데이터 그룹핑 (나이기준으로 데이터 그룹핑)
			Map<Integer, List<Customer>> collectByAge = personList.stream()
					.collect(Collectors.groupingBy(Customer::getAge));
			System.out.println("collectByAge = " + collectByAge);

			// Collectors.partitioningBy()는 파라미터로 Predicate를 받는다.
			// 따라서, 해당 조건을 통해 나온 True/False를 기준으로 결과 데이터를 두 파티션으로 나눈다.
			// 7) 데이터 두 부분으로 구분
			// 이름이 5글자보다 많은 경우 구분
			Map<Boolean, List<Customer>> nameCollect = personList.stream()
					.collect(Collectors.partitioningBy(person -> person.getName().length() > 5));
			System.out.println("nameCollect = " + nameCollect);

			// 나이가 28살이 아닌 사람 구분
			Map<Boolean, List<Customer>> ageCollect = personList.stream()
					.collect(Collectors.partitioningBy(person -> person.getAge() != 28));
			System.out.println("ageCollect = " + ageCollect);
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
	}


} // end class





