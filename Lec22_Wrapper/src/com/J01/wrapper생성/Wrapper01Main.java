package com.J01.wrapper생성;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * 
 * Wrapper 클래스는 String 과 마찬가지로 immutable(불변) 이다.
 *
 * Wrapper 는 null  값을 가질수 있다 (reference type 이니까!)
 * 	          ↑ primitive 는 표현할 수 없는 값!
 *
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();
		
		Integer i1 = 100;  // reference <= primitive ?!
		i1 = i1 + 200;  // reference 가 산술연산?!
		System.out.println("i1 = " + i1);
		// ★Wrapper 클래스는 마치 primitive 타입 처럼 동작한다!★

		
		// 1. 생성자 이용
//		Integer num1 = new Integer(123);   // Java9 부터 deprecated 됨.
//		System.out.println("num1 = " + num1);
		
		// 1. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num1 = Integer.valueOf(123);
		System.out.println("num1 = " + num1);
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);
		
		if (num1 == num2) { // Wrapper 끼리의 ==, != 연산은 주소비교
			System.out.println("== 같다..");   // 주소 비교인데도 같다! ?
		} else {
			System.out.println("== 다르다!!");  //
		}
		
		if (num1.equals(num2)) { // Wrapper 가 가지고 있는 값을 비교하려면 equals 사용하자!
			System.out.println("equals 같다...");  // 같다!
		} else {
			System.out.println("equals 다르다!!");
		}

		// valueOf() 는 Object를 cache 해둔다.  같은 literal로 생성하면 같은 Object.
	  // 메모리 절약 차원/
		// 도움말 확인 : . If a new Integer instance is not required, this method should generally be used in preference to the constructor

		// 2. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;
		// 123 Literal(상수)를 가지고 Integer 클래스의 인스턴스를 생성
		// Integer.valueOf(123)과 동일한 코드가 동작됨 (Auto-Boxing)
		if (num2 == num5) {
			System.out.println("같은 참조");
		} else {
			System.out.println("다른 참조");
		}

		// 3. valueOf(문자열) 가능!
		System.out.println();
		Integer num6 = Integer.valueOf("123"); // 문자열 가능
		System.out.println(num6);

		if (num6 == num5) {
			System.out.println("같은 참조");  // 심지어 위와 같은 상황도 같은 참조로 나온다
		} else {
			System.out.println("다른 참조");
		}

		// 4. 산술 연산 가능
		num6 *= 2;
		System.out.println(num6);
		System.out.println(num6 == num5);  // false  !!

		// 5. Wrapper 는 null  값을 가질수 있다 (당연!)  primitive 는 가질수 없는 값!
		Integer num3 = null;
		//num1 = num3 + 10;  // NPE 발생!

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















