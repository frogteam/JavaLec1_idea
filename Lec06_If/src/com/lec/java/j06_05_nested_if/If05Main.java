package com.lec.java.j06_05_nested_if;

/* 중첩된 if (nested-if) 문
 *   조건문 안의 조건문
 */
public class If05Main {

	public static void main(String[] args) {
		System.out.println("중첩된 if (nested-if) 문");
		
		int num = 98;
		
		if(num % 2 == 0) {
			System.out.println("짝수");
			
			if(num % 4 == 0) {
				System.out.println("4의 배수");
			}else {
				System.out.println("짝수이지만 4의 배수는 아닙니다");
			} // end if
			
		}else {
			System.out.println("홀수");
		} // end if
		
		
		if (num % 2 == 0) {
			System.out.println("짝수");
			
			if (num % 4 == 0) {
				System.out.println("4의 배수");
			} else {
				System.out.println("짝수이긴 하지만 4의 배수는 아님");
			} // end 안쪽 else
			
		} else {
			System.out.println("홀수");
			
		} // end 바깥 else

		
		// ※ 도전 선택-자가6
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










