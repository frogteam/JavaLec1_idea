package 배열1.자가진단07;

import java.util.Scanner;

/*
561 : 배열1 - 자가진단7 
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=198&sca=1090

[문제]
10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오. 
(입력되는 정수의 범위는 1이상 10,000 미만이다. 만약 해당하는 수가 없을 때에는 100 을 출력한다.)

[입력예]
88 123 659 15 443 1 99 313 105 48

[출력예]
99 105


[입력예]
200 300 400 500 600 700 800 900 1000 1100

[출력예]
100 200

[입력예]
-100 -90 -80 -70 -60 -50 -40 -30 -20 -10 -5

[출력예]
100 100

[입력예]
1이 포함된 경우



100 이 포한된 경우는?

Hint!]
100 미만의 수로 입력 가능한 범위는 1~99, 100 이상의 수로 입력 가능한 범위는 100~9999 이다. 
입력값보다 큰수(작은수)를 초기값으로 정하고 작업이 끝난 후 초기값이 그대로 있다면 해당하는 수가 없는 것이다.
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] array = new int[10];

		// 기준점 설정이 가장 중요!!
		int max = 0;	//100 미만의 수중 가장 큰수  (1로 설정하면 안된다)
		int min = 10000;  // 100 이상의 수중 가장 작은수
		
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			
			if(array[i] >= 1 && array[i] < 100 && max < array[i])
				max = array[i];
			
			if(array[i] >= 100 && array[i] < 10000 && min > array[i])
				min = array[i];
		}
		System.out.println(((max == 0)? 100 : max));
		System.out.println(((min == 10000)? 100 : min));
		
	} // end main()
} // end class
