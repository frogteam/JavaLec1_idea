package com.J03.reduce;

import common.Customer;

import java.util.*;
import java.util.function.BinaryOperator;

/** reduce() 연산 [최종연산]
 *
 *  전달된 스트림의 데이터에서
 *  '2개'를 소모하며 결괏값 '1개'를 리턴하는 'reduce 연산'(BinaryOperator)을 반복 수행 하며 개수를 감소시킨다.
 *  최종적으로 '한개' 까지 reduce 되면 그 값을 리턴한다.
 *
 *  리턴값
 * 		초깃값이 없으면 Optional<T> 리턴
 * 		초깃값이 있으면 초깃값 타입 리턴
 *
 *  입력 =>  출력
 *  n개 =>  1개
 *
 *  reduce(BinaryOperator<T>)
 * 	reduce(Identity, BinaryOperator<T>)
 * 	  매개변수
 * 	     Identity: 초깃값
 * 	     BinaryOperator: reduce 연산로직
 *
 *  기존의 주어진 연산 (count, sum 등..) 이 아닌 연산을 Stream 에 수행할때 필요
 *
 * ※ 데이터 연산 3대장
 *  	map : n -> n
 *  	filter : n -> n' ( <= n)
 *  	reduce : n -> 1
 */

// 중간 단게를 보여줄수 있으면 좋다!


public class Stream03Main {

	public static void main(String[] args) {
		System.out.println("-".repeat(30) +"\n▶ reduce()");
		{
			int [] arr = {1, 2, 3, 4, 5};

			// 초깃값을 안 준 경우
			// 리턴값은 Optional
			System.out.println(Arrays.stream(arr)
					.reduce((a, b) -> a + b));  // 초깃값이 없는 경우 OptionalInt 리턴

			System.out.println(Arrays.stream(arr)
					.reduce((a, b) -> a + b) // 초깃값이 없는 경우 OptionalInt 리턴
					.orElse(0)
			);

			// 1, 2, 3, 4, 5
			// ↘ ↓
			//    3, 3, 4, 5
			//    ↘ ↓
			//       6, 4, 5
			//       ↘ ↓
			//         10, 5
			//          ↘ ↓
			//            15   <-- 결국 최종값은 한개다


			// 초깃값을 준 경우
			// 리턴타입은 초깃값 타입!
			System.out.println(Arrays.stream(arr)
					.reduce(100, (a, b) -> a + b)
			);  // 결과 115


			// 100, 1, 2, 3, 4, 5
			//    101
			//      103
			//        106
			//           110
			//              115<-- 결국 최종값은 한개다
		}


		System.out.println();
		{
			// 문자열에서 길이가 가장 긴 문자열을 뽑아내기
			String [] greetings = {"안녕하세요~~~", "Hello", "Good morning", "반갑습니다"};
			String result;

			result = Arrays.stream(greetings)
					.reduce("", (s1, s2) -> {
						// System.out.println("s1:" + s1 + ", s2:" + s2);  // reduce 중간과정
						return (s1.length() >= s2.length()) ? s1 : s2;
					})
			;

			System.out.println(result);

			result = Arrays.stream(greetings)
					.reduce(new CompareString())  // 직접 구현한 BinaryOperator, Optional<String> 리턴
					.get()
			;
			System.out.println(result);
		}

		// 도전!
		//		중간연산  map, filter 등.. 사용가능
		//		최종연산은 reduce 로 결과 만들기!
		{
			List<Customer> personList = List.of(
					new Customer("zayson", 28),
					new Customer("chaeyoung", 26),
					new Customer("maeng", 30)
			);

			// reduction : 시퀀스가 있는 요소를 작은 값으로 감소시킨다.
			// 파라미터 1개인 경우 (accumulator) -> Optional<T>

			// 나이가 28이하인 사람들의 나이의 합
			Integer sum1 = personList.stream()
					.map(Customer::getAge)
					.filter(age -> age <= 28)
					.reduce((a, b) -> Integer.sum(a, b))
					.get();
			System.out.println("sum1 = " + sum1);  // 54

			// 파라미터 2개인 경우 (identity, accumulator) -> T
			Integer sum2 = personList.stream()
					.map(Customer::getAge)
					.filter(age -> age <= 28)
					.reduce(6, (a, b) -> Integer.sum(a, b));
			System.out.println("sum2 = " + sum2);

			// 이름들만 묶어서 하나의 문자열 만들기
			String result2 = personList.stream()
					.map(Customer::getName)
					.reduce((a, b) -> String.join("/", a, b)).get();
			System.out.println("result2 = " + result2);  // zayson/chaeyoung/maeng
		}


		// map(), filter(), reduce() 고충 (작성중)
		/*
		{
			List<Integer> intList = List.of(3, 5, 6, 7, 8, 9, 10, 11);

			// 3,  5,  6,  7,  8,  9, 10, 11
			// ↓   ↓   ↓   ↓   ↓   ↓   ↓   ↓
			// 6, 10, 12, 14, 16, 18, 20, 22

			var result1 = intList.stream()
					.map(x -> x * 2)
					.toList();
			System.out.println(result1);

			// 흠... 이거 안되나?
			intList.stream()
					.reduce(new ArrayList<Integer>(), (acc, com) -> acc + com);
		}
		 */

		// 빈도수 (작성중)
		{
			String[] arr2 = {"a", "a", "b", "a", "c", "c", "c"};
//			Arrays.stream(arr2)
//					.reduce(new HashMap<String, Integer>()
//							, (map, str) -> {
//
//							});
//			참조: https://johngrib.github.io/wiki/java/stream/  <- Java reduce 에선
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


// 직접 구현도 가능
class CompareString implements BinaryOperator<String>{

	// '두개'의 String 을 받아서 '한개'의 String 을 리턴하는 apply() 구현
	@Override
	public String apply(String s1, String s2) {
		return (s1.length() >= s2.length()) ? s1 : s2;
	}

}












