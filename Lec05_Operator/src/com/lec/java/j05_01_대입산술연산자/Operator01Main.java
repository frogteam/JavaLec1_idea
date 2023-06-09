package com.lec.java.j05_01_대입산술연산자;

/*
 * 연산자 관련 일반사항
 * 
 * 연산 Operation
 * 연산자  Operator
 * 피연산자 Operand
 * 
 * ■ 피연산자의 개수에 따라
 * 이항연산자(binary operator) : 피연산자가 2개인 연산자 
 * 단항연산자(unary operator) : 피연산자가 1개인 연산자
 * 삼항연산자(ternary operator) : 피연산자가 3개인 연산자
 * 
 * ■ 연산자는 연산을 수행하기 전에 피연산자의 타입을 일치시키려 한다.
 * 
 * ■ 피연산자의 타입에 따라 수행하는 연산이 달라지는 연산자들도 있다  (ex: +  )
 * 
 * ■ 모든 연산은 연산의 결과값을 리턴한다 (어떠한 '값'인지?, 어떤 '타입'인지? 주목)
 * 
 * ■ 관례적으로 이항연산자는 피연산자와 연산자 간에 한칸씩(space) 띄어주는게 좋다
 *   단항연산자는 피연산자와 연산자를 붙여주는게 일반.
 */

/*
	대입 연산자 assignment operator : =
 		등호(=) 오른쪽의 값을 왼쪽에 대입(저장)
 		
 	산술 연산자 arithmetic operator : +, -, *, /, % 
 */
public class Operator01Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 01");
		
		System.out.println("\n====================");
		System.out.println("[1] 대입 연산자 : = (assignment operator)");
		int num = 123; // 등호(=) 오른쪽의 값을 왼쪽에 대입(저장)
		System.out.println("num = " + num);

		// 대입연산자도 연산자다! 따라서
		// 연산의 결과값이 있다.  대입된 값을 결과값으로 리턴함
		
		int num5;
		int num6;
		System.out.println("num5: " + (num5 = 100));
		
		num6 = num5 = 300;   // 대입연산자도 결과값이 있기 때문에 가능
		System.out.println("num5: " + num5);
		System.out.println("num6: " + num6);
		
		
		
		System.out.println("\n====================");
		System.out.println("[2] 산술 연산자: +, -, *, /, % (arithmetic operator)");
		int num1 = 7;
		int num2 = 3;
		int result;
		
		// 덧셈 연산자: +
		result = num1 + num2;
		System.out.println("더하기 결과: " +  result);
		
		// 뺄셈 연산자: -
		result = num1 - num2;
		System.out.println("빼기 결과: " + result);
		
		// 곱셈 연산자: *
		result = num1 * num2;
		System.out.println("곱하기 결과: " + result);
		
		// 나눗셈 연산자: /
		result = num1 / num2; 
		// 정수 / 정수 = 나눈 몫(정수)을 결과로 돌려 줌
		System.out.println("나눈 몫: " + result);
		
		// 나머지 연산자: %
		result = num1 % num2;
		// 정수 % 정수 = 나눈 나머지(정수)를 결과로 돌려 줌
		System.out.println("나눈 나머지: " + result);
		
		// 나눗셈 연산자(/)가 실수에 사용됐을 경우에는
		// 계산 결과를 실수로 돌려 줌.
		// 실수 / 정수, 정수 / 실수, 실수 /실수 경우에는 결과가 항상 실수형이 됨
		double result2 = 12.1 / 3;
		System.out.println("실수 나누기 결과: " + result2);  //4.033333333333333
		
		// 나머지 연산자(%)
		// 정수 % 정수 = 정수로 값을 돌려 줌.
		// 실수 % 정수, 정수 % 실수, 실수 % 실수 = 몫을 제외한 실수형 나머지를 돌려줌.
		double result3 = 12.1 % 3.0;
		System.out.println("나머지 연산자 결과: " + result3);  // 0.09999999999999964
		
		// 두 변수 값 바꾸는 방법
		System.out.println();
		int num3 = 100;
		int num4 = 200;
		int temp;		// 임시 변수 필요
		
		System.out.println("바꾸기전 num3=" + num3 + " num4="+num4);
		temp = num3;
		num3 = num4;
		num4 = temp;
		System.out.println("바꾼후 num3=" + num3 + " num4="+num4);
		
		

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









