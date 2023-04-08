package 반복제어문1.자가진단01;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&sca=1060
536 : 반복제어문1 - 자가진단1 

1부터 15까지 차례로 출력하는 프로그램을 작성하시오. while문을 이용하세요.

[출력예]
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 
[hint]          
int 변수를 선언하고 초기값으로 1을 대입한다.
 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 1;
		while(i <= 15) {
			System.out.print(i + " ");
			i++;
		} // end while
		
		sc.close();
	}// end main

}// end class
