package 배열1.자가진단06;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=197&sca=1090
 
 560 : 배열1 - 자가진단6 

10개의 정수를 입력받아 그 중 가장 작은 수를 출력하는 프로그램을 작성하시오.(입력받을 정수는 1000을 넘지 않는다.)
   
  
[입력예]
5 10 8 55 6 31 12 24 61 2

[출력예]
2
 
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(min > arr[i])
				min = arr[i];
		}
		System.out.println(min);
		
		
		sc.close();
	} // end main()

} // end close()
