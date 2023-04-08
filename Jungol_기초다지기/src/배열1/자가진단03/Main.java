package 배열1.자가진단03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=194&sca=1090

557 : 배열1 - 자가진단3 

10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.
   
  
[입력예]
A B C D E F G H I J

[출력예]
A D G
 
 */
public class Main {

	public static void main(String[] args) {
		String [] arr = new String[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		System.out.println(arr[0] + " " + arr[3] + " " + arr[6]);
	} // end main()

} // end class
