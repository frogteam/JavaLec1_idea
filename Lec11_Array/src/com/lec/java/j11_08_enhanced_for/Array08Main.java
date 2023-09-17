package com.lec.java.j11_08_enhanced_for;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array08Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");
		// 일반적인 for 문의 형식
		// for (초기식; 조건식; 증감,조건변경) { ... }
		int[] arr = {11, 22, 33, 44, 55};
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		} // for (i)
		System.out.println();
		
		System.out.println("enhanced for 사용");
		// for (배열타입 변수 : 배열이름) { ... }
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();

		
		System.out.println("===============");
		System.out.println();
		System.out.println("2차원 배열에서 enhanced for");
		int[][] array = {
				{1, 2},
				{3, 4, 5, 6},
				{7, 8, 9}
		};
		// for (배열타입 변수 : 배열이름) {}
		for (int[] row : array) {
			for (int x : row) {
				System.out.print(x + " ");
			}
			System.out.println(); // 줄바꿈
		}

		// var 사용 가능!
		for (var row : array) {
			for (var x : row) {
				System.out.print(x + " ");
			}
			System.out.println(); // 줄바꿈
		}
		
		
		System.out.println("============");
		System.out.println("enhanced for 연습");
		int[] korean = {10, 20, 30, 40, 50, 100};
		int total = 0;
		// 총점을 for문, enhanced for문을 사용해서 계산
		// 1) for
		for (int i = 0; i < korean.length; i++) {
			total += korean[i];
		}
		System.out.println("총점: " + total);
		
		// 2) enhanced for
		total = 0;
		for (int score : korean) {
			total += score;
		}
		System.out.println("총점: " + total);
		
		
	} // end main()

} // end class Array10Main









