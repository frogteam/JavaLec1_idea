package com.lec.java.j05_08_비트연산자;

/* 비트 연산자 (bit-wise operator)
 *   a & b: (and) a,b가 모두 1 이면 결과도 1, 그 외에는 0
 *   a | b: (or) a가 1이거나 또는 b가 1이면 결과는 1, a,b 모두 0일 때만 0
 *   a ^ b: (xor) a와 b 둘 중 하나만 1이 있는 경우는 1, 그 외에는 0
 *          결국 둘이 같으면 0, 다르면 1
 *    ~a  : (not) a가 1이면 0, a가 0이면 1로 바꿔줌
 *
 * ★ 비트연산자의 피연산자는 정수!  (논리연산자와 다르다!)
*/
public class Operator08Main {

	public static void main(String[] args) {
		System.out.println("연산자 8 - 비트 연산자");
		
		System.out.println("[1] &(and), |(or), ^(exclusive or), ~(not)");
		
		
		byte n1 = 10; // byte n1 = 0b1010;
		byte n2 = 7; // byte n2 = 0b111;
		int result = n1 & n2;
		System.out.println("& 결과 = " + result);  // 2
		System.out.println("& 결과 = " + Integer.toBinaryString(result));  // 10
		/*
		 *   0000 1010  n1
		 *   0000 0111  n2
		 *   ---------- &
		 *   0000 0010  2
		 */  
				
		result = n1 | n2;
		System.out.println("| 결과 = " + result);  // 15
		System.out.println("| 결과 = " + Integer.toBinaryString(result)); // 1111
		/*
		 *   0000 1010  n1
		 *   0000 0111  n2
		 *   ---------- |
		 *   0000 1111  15
		 */  
		
		result = n1 ^ n2;
		System.out.println("^ 결과(10진수) = " + result);
		System.out.println("^ 결과(2진수) = " + Integer.toBinaryString(result));
		/*
		 *   0000 1010  n1
		 *   0000 0111  n2
		 *   ---------- ^
		 *   0000 1101  13
		 */  
		
		result = ~n1;
		System.out.println("~ 결과(10진수) = " + result);  // -11
		// ↑ 위 결과가 음수가 나온다

		System.out.printf(" n1 : [%32s]\n", Integer.toBinaryString(n1));
		System.out.printf("~n1 : [%32s]\n", Integer.toBinaryString(~n1));
//		 n1 : [                            1010]
//		~n1 : [11111111111111111111111111110101]




		// 음수 정수 표현 참조 : http://tcpschool.com/c/c_refer_negativeNumber

		System.out.println("\n\n================");
		System.out.println("비트 이동(shift) 연산자: >>, <<");
		int n3 = 10;
		int result2 = n3 >> 1; // 비트를 오른쪽(>>)으로 1비트씩 이동
		System.out.println(">> 결과(10진수): " + result2);
		System.out.println(">> 결과(2진수): " + Integer.toBinaryString(result2));
		
		// 0000 1010  :10
		// ↘↘↘↘ ↘↘↘↘
		// 00000 101  :5

		System.out.printf("    n3 : [%32s]\n", Integer.toBinaryString(n3));
		System.out.printf("result : [%32s]\n", Integer.toBinaryString(result));

		System.out.println(n3 / 2);
		System.out.println(n3 >> 1);


		n3 = 10;
		result2 = n3 << 1; // 비트를 왼쪽(<<)으로 1비트씩 이동
		
		/*
		 *   0000 1010  10
		 *   --------- << 1
		 *   0001 0100  20
		 */
		
		System.out.println("<< 결과(10진수): " + result2);
		System.out.println("<< 결과(2진수): " + Integer.toBinaryString(result2));
		
		
		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class







