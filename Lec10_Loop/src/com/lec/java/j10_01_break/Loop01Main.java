package com.lec.java.j10_01_break;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		int num = 1;
		while (num <= 10) {
			System.out.println(num);
			
			// num이 3이 되는 순간 while 반복문 종료
			if (num == 3) {
				break;
				// break를 만나게 되면 가장 가까운 반복문을 끝냄
			}
			
			num++;
		} // end while ()
		System.out.println("while 끝난 후 num = " + num);
		
		
		System.out.println();
		// 1 ~ 100 사이에서 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수
		num = 1;
		while (num <= 100) {
			if (num % 2 == 0 && num % 7 == 0) {
				// 2의 배수 && 7의 배수 -> 2와 7의 공배수
				System.out.println(num);
				
				break;
			} // end if
			
			num++;
		} // end while

		
		System.out.println();
		System.out.println("무한 루프와 break;");
		num = 1;
		while (true) {
			System.out.println(num);
			num++;
			
			// 어떤 조건을 만족하면 무한 루프를 끝내라...
			if (num == 5) {
				break;
			}
			
		} // end while
		
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		
		int i, j;
		for(i = 2; i <= 9; i++) {
			System.out.println(i+"단");
			for(j = 1; j <= 9; j++) {
				System.out.println(i+"x"+j+"="+i*j);
				if(i == j) {
					break;
				}
			}//in for
			System.out.println();
		}//out for
		
		
		// 도전 :
		// 반복1-형성2
		// 반복제어문1 - 형성평가3
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









