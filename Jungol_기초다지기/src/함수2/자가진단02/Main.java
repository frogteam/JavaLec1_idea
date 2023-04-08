package 함수2.자가진단02;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=217&sca=10c0
 
 580 : 함수2 - 자가진단2 

2016년의 날짜를 두 개의 정수 월 일로 입력받아서 
입력된 날짜가 존재하면 "OK!" 그렇지 않으면 "BAD!"라고 출력하는 프로그램을 작성하시오.
   
[입력예] 
2 30

[출력예]
BAD!

 
 */
public class Main {

	public static final int [] DAYS = {
			31, 29, 31, 30, 31, 30, 
			31, 31, 30, 31, 30, 31
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mon = sc.nextInt();
		int day = sc.nextInt();
		chkDayOfMonth(mon, day);
		
		sc.close();
	} // end main
	
	public static void chkDayOfMonth(int mon, int day) {
		if(day <= DAYS[mon - 1] && day >= 1)
			System.out.println("OK!");
		else
			System.out.println("BAD!");
	}
	
} // end class
