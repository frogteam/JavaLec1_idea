package com.lec.java.j05_04_증감연산자;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		System.out.println("num1 = " + num1);
		
		// ++변수: 변수의 값을 1 증가시켜서 저장
		++num1;
		// num1 = num1 + 1; 와 동일한 결과
		// num1 += 1; 와 동일한 결과
		System.out.println("num1 = " + num1);

		// --변수: 변수의 값을 1 감소시켜서 저장
		int num2 = 100;
		--num2;
		// num2 = num2 - 1; 와 동일한 결과
		// num2 -= 1; 와 동일한 결과
		System.out.println("num2 = " + num2);
		
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)");
		int num3 = 100;
		System.out.println("num3 = " + num3);
		
		// prefix ++
		++num3;
		System.out.println("num3 = " + num3);
		
		// postfix ++
		num3++;
		System.out.println("num3 = " + num3);
		
		int num4 = 100;
		int num5 = ++num4; // prefix
		// 접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
		// (1) num4의 값이 1 증가
		// (2) 증가된 num4의 값이 num5에 저장
		System.out.println("num4 = " + num4);
		System.out.println("num5 = " + num5);
		
		int num6 = 100;
		int num7 = num6++; // postfix
		// 접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
		// (1) 처음 num6의 값(100)이 먼저 num7에 저장
		// (2) 그 다음에 num6의 값이 1 증가
		System.out.println("num6 = " + num6);
		System.out.println("num7 = " + num7);
		
		
		System.out.println("\n\n====================");
		int num8 = 10;
		int num9 = --num8 + 5;
		// (1) num8의 값이 1 감소
		// (2) 9 + 5 덧셈 실행
		// (3) 14 값이 num9에 저장
		System.out.println("num8 = " + num8);
		System.out.println("num9 = " + num9);
		
		int num10 = 10;
		int num11 = num10-- + 5;
		// (1) num10에 원래 저장된 값(10)과 5를 더하는 연산이 먼저 실행: 10 + 5
		// (2) num10의 값이 1 감소 -> 9
		// (3) 덧셈 결과(15)가 num11에 저장
		System.out.println("num10 = " + num10);
		System.out.println("num11 = " + num11);
		
		
		System.out.println("\n\n====================");
		int number1 = 10;
		int number2 = number1-- + 5 + --number1;
		// (1) number1에 저장된 값(10) + 5 -> 15
		// (2) number1의 값이 1 감소 -> 9
		// (3) 15 + --number1: number1의 값을 먼저 감소 -> 8
		// (4) 15 + 8 -> 23
		// (5) number2에 23이 저장
		// ★ 그러나, 실무에서는 절대로 이런 코드는 작성하지 마십시오.
		
		System.out.println("number1 = " + number1);
		System.out.println("number1 = " + number2);
		
		
		//------------------------------
		// 생각해보기
		int a, n;
		a = 0; n = 5;
		a = -n++;
		System.out.println("a = " + a + ", n = " + n);  // a= 5, n = 6
		
		n = 5;
		n = -n++;
		System.out.println("n = " + n);  // n = 5
		// https://stackoverflow.com/questions/16323179/how-does-a-a-work-in-java
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class












