package 함수3.자가진단05;

import java.util.Arrays;
import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=228&sca=10d0

591 : 함수3 - 자가진단5 

첫 번째 수는 1이고 N번째 수는 (N/2)번째 수와 (N-1)번째 수의 합으로 구성된 수열이 있다. 
50 이하의 자연수 N을 입력받아 재귀호출을 이용하여 이 수열에서 N번째 수를 출력하는 프로그램을 작성하시오.

(1 2 3 5 7 10 13 18 …)
   
[입력예]
8

[출력예]
18
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		arr[0] = 1;    // 첫번째 수는 1
		sc.close();
		func(arr, 2);  // 2번째부터
	}
	
	public static void func(int[] arr, int n) {
		arr[n - 1] = arr[n / 2 - 1] + arr[n - 1 - 1];  // 인덱스 주의

		if(arr.length == n) {
			System.out.println(arr[n - 1]);
			return;
		}
		
		// 테스트
		//System.out.println(n + ":" + Arrays.toString(arr));
		func(arr, n + 1);
	}

}
