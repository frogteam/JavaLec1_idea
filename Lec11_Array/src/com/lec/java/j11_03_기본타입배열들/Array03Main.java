package com.lec.java.j11_03_기본타입배열들;

public class Array03Main {

	public static void main(String[] args) {
		System.out.println("여러가지 자료형의 배열");
		
		System.out.println();
		System.out.println("[1] double형 배열");
		// 타입[] 이름 = new 타입[배열 길이];
		// 타입[] 이름 = new 타입[] {a, b, ...};
		// 타입[] 이름 = {a, b, ...};
		
		double[] array1 = {1.2, 2.3, 3.4};
		for (int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "] = " + array1[i]);
		}
		
		System.out.println();
		System.out.println("[2] char형 배열");
		char[] array2 = new char[5];
		array2[0] = 'a';
		array2[1] = 'b';
		array2[2] = '0';
		array2[3] = '배';
		array2[4] = '열';
		for (int i = 0; i < array2.length; i++) {
			System.out.println("array2[" + i + "] = " + array2[i]);
		}
		
		System.out.println();
		System.out.println("[3] boolean형 배열");
		boolean[] array3 = new boolean[4];
		// for문을 사용해서 초기화
		// 짝수번째 인덱스(0, 2)에는 true, 홀수번째 인덱스(1, 3)에는 false
		for (int i = 0; i < array3.length; i++) {
			if (i % 2 == 0) { // 짝수 인덱스
				array3[i] = true;
			} else { // 홀수 인덱스
				array3[i] = false;
			} // end else
			
		} // end for (i)
		
		for (int i = 0; i < array3.length; i++) {
			System.out.println("array3[" + i + "] = " + array3[i]);
		}
		
		System.out.println();
		System.out.println("[4] String형의 배열");
		String[] array4 = new String[3];
		array4[0] = "Hello, Java";
		array4[1] = "Hello, C++";
		array4[2] = "Hello, HTML5";
		for (int i = 0; i < array4.length; i++) {
			System.out.println("array4[" + i + "] = " + 
					array4[i] + "(" + array4[i].length() + "글자)");
		} // end for
		
	} // end main()

} // end class Array03Main









