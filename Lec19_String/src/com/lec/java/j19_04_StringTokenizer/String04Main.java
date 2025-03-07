package com.lec.java.j19_04_StringTokenizer;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer 클래스

	token ? : '규칙'에 의해 구분된 더 이상 나눌수 없는 문자요소(문자열)
				(문법적으로 더 이상 나눌 수 없는 기본적인 언어요소)
*/

public class String04Main {

	public static void main(String[] args) {
		System.out.println("StringTokenizer 클래스");
		
		// token <- '규칙'에 의해 구분된 문자덩어리(문자열)?
		
		String str1 = "13:46:12";
		StringTokenizer tokenizer = new StringTokenizer(str1, ":");
		System.out.println("토큰 개수: " + tokenizer.countTokens());

		//System.out.println(tokenizer.nextToken());  // "13"
//		System.out.println(tokenizer.nextToken());  // "46"
//		System.out.println(tokenizer.nextToken());  // "12"
//		System.out.println(tokenizer.nextToken());  // NoSuchElementException

		while (tokenizer.hasMoreTokens()) { // 남아 있는 token 이 있는지 여부 true/false
			System.out.println(tokenizer.nextToken());
		} // end while
		
		// token.nextToken() <-- NoSuchElementException
		
		
		System.out.println();
		String str2 = "abc:def:ghi:jkl:mno";   // : 로 토큰분리
		StringTokenizer token2 = new StringTokenizer(str2, ":");
		System.out.println("토큰 개수: " + token2.countTokens());
		while (token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		} // end while
		
		System.out.println();
		String str3 = "2015/04/08";     // / 로 토큰분리
		StringTokenizer token3 = new StringTokenizer(str3, "/");
		while (token3.hasMoreTokens()) {
			System.out.println(token3.nextToken());
		} // end while
		
		System.out.println();
		String str4 = "2015년-4월-8일";   // - 으로 토큰분리
		StringTokenizer token4 = new StringTokenizer(str4, "-");
		while (token4.hasMoreTokens()) {
			System.out.println(token4.nextToken());
		} // end while
		
		System.out.println();
		String str5 = "2015-04-08 14:10:55";

		// 1. split 사용
		var dateStr = str5.trim().split("\\s+");

		for (var d : dateStr[0].split("-")) {
			System.out.println(d);
		}

		for (var d: dateStr[1].split(":")) {
			System.out.println(d);
		}

		// 2. 정규표현식 사용
		System.out.println(Arrays.toString(str5.split("[-: ]+")));

		// 3. StringTokenizer
		StringTokenizer token5 = new StringTokenizer(str5, "-: ");
		while (token5.hasMoreTokens()) {
			System.out.println(token5.nextToken());
		} // end while
		
		System.out.println();
		// StringTokenizer 생성자의 세번째 매개변수를 true 로 주면
		// delimiter 도 token 으로 추출된다
		String str6 = "num += 1";
		StringTokenizer token6 = new StringTokenizer(str6, "+=", true);
		while (token6.hasMoreTokens()) {
			System.out.println(token6.nextToken());
		} // end while
		
		
		// 실습]
		// 다음과 같은 수식이 있을때  토큰들을 분리해네세요
		// 연산자 + - / *   괄호 ( )
		// 10  +  (name * 2) / num8- (+3)
		// 힌트]
		// 일단 공백으로 분리 split()
		// 그리고 나서 각각을 StringTokenizer 함
		
		// 결과
		// 10, +, (, name, *, 2, ), /, num8, -, (, +, 3, ),
		
		System.out.println();
		System.out.println("수식 분석기");
//		Scanner sc = new Scanner(System.in);
		String expr = "10  +  (name * 2) / num8- (+3)";
//		while(true) {			
//			String expr = sc.nextLine();
//			if("exit".equals(expr)) break;
			for(String s : expr.split("\\s+")) {
				StringTokenizer exprTokenizer = new StringTokenizer(s, "+-*/()", true);
				while(exprTokenizer.hasMoreTokens()) {
					System.out.print(exprTokenizer.nextToken() + ", ");
				}
			}
			System.out.println();
//		}
//		sc.close();
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











