package com.lec.java.j06_07_equals;

/* String 비교, char 비교
 * - 문자열 비교는 절대로 == 를 사용하지 말자
 * - 문자열 비교는 equals(), equalsIgnoreCase() 사용!
 * 
 * - char 는 기본적으로 정수값 (아스키 코드값) 이라 일반 산술 비교 가능 
 */
public class If07Main {

	public static void main(String[] args) {
		System.out.println("String 비교, char 비교");

		{
			String name1 = "john";
			String name2 = "john";

			if(name1 == name2){
				System.out.println(name1 + "과 " + name2 + "는 == 같습니다");
			} else {
				System.out.println(name1 + "과 " + name2 + "는 == 다릅니다");
			}
		}

		// 문자열 비교는 절대로 == 를 사용하지 말자
		{
			String name1 = "john";
			String name2 = "jo";
			name2 += "hn";

			if(name1 == name2){
				System.out.println(name1 + "과 " + name2 + "는 == 같습니다");
			} else {
				System.out.println(name1 + "과 " + name2 + "는 == 다릅니다");  // 다르다!
			}
		}

		{
			String name1 = "john";
			String name2 = "jo";
			name2 += "hn";
			// 문자열 비교는 equals() 사용!
			if(name1.equals(name2)){
				System.out.println(name1 + "과 " + name2 + "는 equals() 같습니다");
			} else {
				System.out.println(name1 + "과 " + name2 + "는 equals() 다릅니다");
			}
		}

		{
			String name1 = "John";
			String name2 = "jo";
			name2 += "hn";

			// equalsIgnoreCase() 대소문자 구분없이 비교
			if(name1.equalsIgnoreCase(name2)){
				System.out.println(name1 + "과 " + name2 + "는 equalsIgnoreCase() 같습니다");
			} else {
				System.out.println(name1 + "과 " + name2 + "는 equalsIgnoreCase() 다릅니다");
			}
		}
		
		System.out.println();
		// char 는 기본적으로 정수값 (아스키 코드값) 이라
		// 일반 산술 비교가 가능.
		char ch = '교';

		System.out.print(ch + "는 ");
		if('0' <= ch && ch <= '9'){
			System.out.println("숫자입니다");
		} else if('A' <= ch && ch <= 'Z'){
			System.out.println("알파벳 대문자 입니다");
		} else if('a' <= ch && ch <= 'z'){
			System.out.println("알파벳 소문자 입니다");
		} else if('가' <= ch && ch <= '힣'){
			System.out.println("한글입니다");
		} else {
			System.out.println("숫자도 한글도 알파벳도 도 아닙니다");
		}
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
