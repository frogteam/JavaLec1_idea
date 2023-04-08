package 배열2.자가진단03;

import java.util.Scanner;

/*
566 : 배열2 - 자가진단3 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=203&sca=10a0

[문제]
100 이하의 자연수를 입력받아 첫 번째 항은 100으로 두 번째 항은 입력받은 수로 초기화하고 
다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여 
그 수가 음수가 나올 때까지 출력하는 프로그램을 작성하시오.



[입력예]
62


[출력예]
100 62 38 24 14 10 4 6 -2

*/

public class Main {

	public static void main(String[] args) {
		
		int [] num = new int[100];
		num[0] = 100;
		
		Scanner sc = new Scanner(System.in);
		num[1] = sc.nextInt();

		int i = 2;
		while(true){
			num[i] = num[i - 2] - num[i - 1];
			if(num[i] < 0)
				break;
			i++;
		} // end while
		
		i = 0;
		while(true){
			System.out.print(num[i] + " ");
			if(num[i] < 0){
				System.out.println();
				break;
			}
			i++;
		} // end while
		
		sc.close();

	} // end main()
} // end class
