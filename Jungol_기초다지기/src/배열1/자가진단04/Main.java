package 배열1.자가진단04;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=195&sca=1090
558 : 배열1 - 자가진단4 

100 개의 정수를 저장할 수 있는 배열을 선언하고 정수를 차례로 입력받다가 0 이 입력되면 0 을 제외하고 
그 때까지 입력된 정수를 가장 나중에 입력된 정수부터 차례대로 출력하는 프로그램을 작성하시오.
   

[입력예]
3 5 10 55 0

[출력예]
55 10 5 3

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[100];

		int i;
		for (i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 0) break;
		} // end for
		
		for(int j = i - 1; j >= 0; j--) {
			System.out.print(arr[j]);
			if(j - 1 >= 0) System.out.print(" ");
		}
		
		sc.close();

	} // end main()

} // end class
