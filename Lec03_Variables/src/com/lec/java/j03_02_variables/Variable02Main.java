package com.lec.java.j03_02_variables;

/*
    변수명 등 사용자가 이름을 지어준것들 --> 식별자 (identifier) 라고 함.

    식별자 수정할때는 refactor-rename 기능을 활용하자.
 */

public class Variable02Main {

	public static void main(String[] args) {
		System.out.println("변수 02");
		
        int number;
        //System.out.println("number = " + number);  // 에러!  지역변수(local variable)은 사용하기 전에 반드시 값을 대입(assign)해야 한다.
                                              // 지역변수에 최초로 값을 대입하는 것을 초기화 (initialize) 한다 라고 함
                                              // 대입 이라고도 하고 할당이라고도 한다 (번역마다 다름)
		
		// 변수의 선언과 동시에 초기화
		// 변수타입 변수이름 = 값;
		int num1 = 10;
		System.out.println("num1 = "  + num1);
		
		num1 = 11111;
		System.out.println("num1 = "  + num1);
		
		// int 타입 변수 korean을 선언하고, 초기화
		int korean = 50;
		System.out.println("국어 점수: " + korean);
		
		// int 타입 변수 english를 선언하고, 초기화
		int english = 50;
		System.out.println("영어 점수: " + english);
		
		// int 타입 변수 math를 선언하고, 77을 입력
		int math = 33;
		System.out.println("수학 점수: " + math);
		
		// 국어, 영어, 수학 총점을 계산해서 출력
		System.out.println("총점: " + (korean + english + math));
		int total;
		total = korean + english + math;
		System.out.println("총점 = " + total);
		
		
		// 세과목의 평균을 계산해서 출력
		System.out.println("평균: " + ((double)(korean + english + math) / 3));
		
		// 변수를 사용하여 평균을 저장한뒤 출력
		double avg = (double)(korean + english + math) / 3;
		System.out.println("평균: " + avg);

		// 변수명 바꿀때는 refactor-rename 사용하자!   SHIFT+F6

		// 변수명 (식별자) 작명 제약사항.
		// 알파벳, 숫자, _, $
		// 숫자로 시작하면 안됨
		// 띄어쓰기 안됨
		// 대소문자 구분
		// 중복 안됨.
		int abc;
//        int abc;  // 중복선언 불가

		double Abc;
		double year2020;
//        int 2020year;   // 숫자로 시작 안됨

//        short year 2020;  // 띄어쓰기 안됨.

		int myLittleToy;   // 자바에선 일반적으로 변수명은 camel-notation 따름
		int my_little_toy;
		int _my_toy_;
		int $aa;   // $ 가능
//        int a#;    // 다른 특수문자 불가
	} // end main()

} // end class Variable02Main
