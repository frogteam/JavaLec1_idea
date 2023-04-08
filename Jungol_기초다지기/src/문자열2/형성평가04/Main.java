package 문자열2.형성평가04;

import java.util.Arrays;
import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=92&sca=10f0
 
 192 : 문자열2 - 형성평가4 

10 이하의 정수 n을 입력받고 n개의 문자열을 입력받은 후 그 크기를 비교하여 
가장 작은 문자열부터 차례로 출력하는 프로그램을 작성하시오. 
문자열의 길이는 100자 이하다. 사전순(아스키코드순)으로 뒤에 나오는 것을 큰 것으로 한다.
   

[입력예]
3
notebook
pencil
eraser

[출력예]
eraser
notebook
pencil

 */
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		String [] arr = new String[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
		
	} // end main
} // end class
