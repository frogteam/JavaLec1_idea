package 함수2.자가진단01;

import java.util.Arrays;
import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=216&sca=10c0

	
10 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 
내림차순으로 정렬하여 출력하는 프로그램을 작성하시오. 
(배열을 전달하는 함수를 이용한다.)
   
  
[입력예] 
4
10 9 2 15

[출력예]
15 10 9 2
 



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		showDesc(arr);
		
		sc.close();
	} // end main()

	public static void showDesc(int[] arr) {
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
} // end class
