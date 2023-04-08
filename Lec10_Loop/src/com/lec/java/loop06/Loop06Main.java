package com.lec.java.loop06;

/* break 레이블;   // 레이블(label) 위치까지 순환문 탈출
 * 
 * 프로그래밍의 구조적 설계에 악영향을 줄수 있으니 가급적 지양하기 바랍니다 
 */
public class Loop06Main {

	public static void main(String[] args) {
		System.out.println("레이블 (label)");

		// 구구단에서 2단은 x2 까지..  3단은 x3까지 출력..
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
				
				if(i == j){
					break;    // 안쪽의 for문
				}
			} // end of for(j)
		} // end of for(i)
		
		
		System.out.println();
		// 구구단이 결과가 50을 넘어가면 출력 종료. 어떻게 하나?
		// 맨 밑의 '프로그램 종료' 까지 진행해야 한다.

		z:	// 레이블은 반드시 순환문 직전에 표시되어야 한다.
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 9; j++) {
				if(i * j > 50)
					break z;    // 레이블의 위치까지 탈출.
				System.out.println(i + " * " + j + " = " + i * j);
			} // end of for(j)
		} // end of for(i)

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









