package com.J03.reduce;

import common.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/* reduce() 연산
 * 
 *  전달된 스트림의 데이터를 2개를 소모하며 주어진 '연산' 수행
 *  주어진 연산은 결괏값 1개 리턴
 *  
 * 	reduce(초깃값, (전달된 스트림의 데이터) -> 연산기능)
 * 				  ↑
 * 				  직접 구현하든지,
 * 				  BinaryOperator 를 구현한 클래스
 * 
 *  기존의 주어진 연산 (count, sum 등..) 이 아닌 연산을 Stream 에 수행할때 필요
 *
 *  리턴값은 Optional 객체
 *
 * ※ 데이터 연산 3대장
 *  	map : n -> n
 *  	filter : n -> n' ( <= n)
 *  	reduce : n -> 1
 */

// 중간 단게를 보여줄수 있으면 좋다!


public class Stream03Main {

	public static void main(String[] args) {
		//---------------------------------------------------------------
		// Reduction   [최종연산]
		//   Stream 요소들에 reduce 연산을 적용하여 개수를 감소시켜 가며
		//   최종적으로 1개의 값을 리턴한다
		//
		//   입력 =>  출력
		//    n개 =>  1개
		//
		//   매개변수
		//     Identity : 초기값
		//     accumulator : 누산 로직, 누산 로직을 통해 작은 컬렉션으로 감소시키는 것이 가능하다.
		//     combinder : 병렬 스트림 연산에서 병렬 연산 이후 결과를 하나로 합치는 기능

		//  리턴값
		//     초깃값이 없으면 Optional 리턴
		//     초깃값이 있으면 초깃값 타입 리턴
		System.out.println("-".repeat(30) +"\n▶ reduce()");

		int [] arr = {1, 2, 3, 4, 5};

		// 초깃값을 안 준 경우
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
		);  // 결과 15


		// 100, 1, 2, 3, 4, 5
		//    101
		//      103
		//        106
		//           110
		//              115<-- 결국 최종값은 한개다


		System.out.println();
		// 문자열에서 길이가 가장 긴 문자열을 뽑아내기
		String [] greetings = {"안녕하세요~~~", "Hello", "Good morning", "반갑습니다"};
		String result;

		result = Arrays.stream(greetings)
				.reduce("", (s1, s2) -> {
					return (s1.length() >= s2.length()) ? s1 : s2;
				})
		;

		System.out.println(result);

		result = Arrays.stream(greetings)
				.reduce(new CompareStirng())  // Optional<String> 리턴
				.get()
		;
		System.out.println(result);

		// 도전!
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


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


// 직접 구현도 가능
class CompareStirng implements BinaryOperator<String>{

	// '두개'의 String 을 받아서 '한개'의 String 을 리턴하는 apply() 구현
	@Override
	public String apply(String s1, String s2) {
		return (s1.length() >= s2.length()) ? s1 : s2;
	}

}












