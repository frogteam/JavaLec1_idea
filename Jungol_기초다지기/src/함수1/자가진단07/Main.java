package 함수1.자가진단07;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=214&sca=10b0
 
 577 : 함수1 - 자가진단7 

서로 다른 두 개의 정수가 주어진다. 두 정수를 입력받아 큰 수는 2로 나눈 몫을 저장하고 작은 수는 2를 곱하여 저장한 후 출력하는 프로그램을 작성하시오.(참조에 의한 호출을 이용한 함수를 작성하여 값을 수정하고 출력은 메인함수에서 한다.)

[입력예]
100 500

[출력예]
200 250
 
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Integer i1 = sc.nextInt();
		Integer i2 = sc.nextInt();
		
		func1(i1, i2);
		
		System.out.println(i1 + " " + i2);
		
		sc.close();
	}
	
	public static void func1(Integer i1, Integer i2) {
//		if(i1 > i2) {			
//			i1 /= 2;
//			i2 *= 2;
//		} else {
//			i2 /= 2;
//			i1 *= 2;
//		}
		
		// 답안나오나?
		
		System.out.println(i1 + " " + i2);
	}
}
