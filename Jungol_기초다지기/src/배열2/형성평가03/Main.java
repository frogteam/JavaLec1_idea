package 배열2.형성평가03;

import java.util.Scanner;

/*
162 : 배열2 - 형성평가3 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=62&sca=10a0

[문제]
10 미만의 자연수 두 개를 입력받아서 첫 번째 항과 두 번째 항을 입력받은 수로 초기화 시킨 후 
세 번째 항부터는 전전항과 전항의 합을 구하여 그 합의 1의 자리로 채워서 차례로 10개를 출력하는 프로그램을 작성하시오.


[입력예]
3 5


[출력예]
3 5 8 3 1 4 5 9 4 3

*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[10];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();

		for(int i = 2; i < arr.length; i++){
			arr[i]  = (arr[i - 1] + arr[i - 2]) % 10; 
		}
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		
		sc.close();

	} // end main()
} // end class
