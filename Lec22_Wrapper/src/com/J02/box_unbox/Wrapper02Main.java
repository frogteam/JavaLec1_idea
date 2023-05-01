package com.J02.box_unbox;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");
		// Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
		
		Integer num1 = 10; // Integer.valueOf(10); // auto-boxing
		Integer num2 = 20;
		Integer num3 = num1 + num2;
		Integer num30 = Integer.valueOf(num1.intValue() + num2.intValue());
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num30 = " + num30);
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4 = Integer.valueOf(100); // boxing
		int n4 = num4.intValue(); // unboxing
		System.out.println("n4 = " + n4);
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");
		Integer num5 = 200; // auto-boxing
		// ↑내부적으로는 Integer num5 = Integer.valueOf(200); 실행
		
		System.out.println("num5 = " + num5);
		// ↑내부적으로는 num5.intValue() 실행
		
		int n5 = num5; // auto-unboxing
		// 내부적으로는 int n5 = num5.intValue(); 실행
		System.out.println("n5 = " + n5);
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		Long num100 = Long.valueOf(10000000000L); // boxing
		long n100 = num100.longValue(); // unboxing
		
		Double num200 = Double.valueOf(3.14); // boxing
		double n200 = num200.doubleValue(); // unboxing
		
		Long num300 = 300L; //auto-boxing
		long n300 = num300; // auto-unboxing
		
		Double num400 = 1.2345; // auto-boxing
		double n400 = num400; // auto-unboxing
		num400 = num1.doubleValue(); // Integer 로부터 doubleValue로 unboxing 추출 가능 
				//↑ num1 = 10;
		
		Double num500 = num400 + num300;
		System.out.println(num500);
		
		
		// 주의! 
//		Wrapper 클래스는 == 와 같은 비교연산시 한쪽이 primitive type 이면 auto-unboxing 하여 비교 하나
//				비교연산자의 양쪽이 wrapper 인 경우는 주소값으로 비교한다.
//				x 와 y 는 각각 달리 생성된 객체이므로 다른 주소값을 가진다. wrapper 끼리의 비교를 해야 한다면 equals() 를 사용해야 한다
		// OCJP D-01
		// https://marobiana.tistory.com/130

		System.out.println(num1 == 10);   // true,  unboxing 발생!
		System.out.println(num1 == num2);  // false unboxing 발생안함!
		//Integer num7 = "10";  // auto-boxing 불가
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















