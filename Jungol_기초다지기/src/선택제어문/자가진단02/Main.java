package 선택제어문.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=166&sca=1050
529 : 선택제어문 - 자가진단2 

“몸무게+100-키”를 비만수치 공식이라고 하자.
키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치를 출력하고, 
비만수치가 0보다 크면 다음줄에 비만("Obesity")이라는 메시지를 출력하는 프로그램을 작성하시오. 
(출력형식은 아래 출력 예를 참고하세요.)
 
[입력예]
155 60

[출력예]
5
Obesity

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 키, 몸무게 입력 (정수)
		int height = sc.nextInt();
		int weight = sc.nextInt();
		
		// 비만수치 계산
		int obesity = weight + 100 - height; // 비만수치 공식
		
		// 비만수치 출력
		System.out.println(obesity);
		
		// 비만여부 판정 출력
		if(obesity > 0)
			System.out.println("Obesity");
		
		sc.close();
	} // end main

} // end class
