package 배열1.자가진단01;

import java.util.Arrays;
import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=192&sca=1090

555 : 배열1 - 자가진단1 

문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받아 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
A B C D E F G H I J

[출력예]
ABCDEFGHIJ
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char [] arr = new char[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		sc.close();
	} // end main()
} // end class
