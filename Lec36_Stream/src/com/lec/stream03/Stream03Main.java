package com.lec.stream03;

import java.util.Arrays;
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
		System.out.println("reduce() 연산");
		
		int [] arr = {1, 2, 3, 4, 5};

		// 초깃값을 안 준 경우
		System.out.println(Arrays.stream(arr)
				.reduce((a, b) -> a + b));  // 이경우 OptionalInt 리턴


		System.out.println(Arrays.stream(arr)
				.reduce((a, b) -> a + b) // 이경우 OptionalInt 리턴
				.orElse(0)
		);

		// 1, 2, 3, 4, 5
		//    3
		//       6
		//         10
		//            15  <-- <-- 결국 최종값은 한개다



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












