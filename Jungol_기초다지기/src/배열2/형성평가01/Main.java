package 배열2.형성평가01;

import java.util.Scanner;

/*
160 : 배열2 - 형성평가1  
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=60&sca=10a0

[문제]
승지는 주사위 놀이를 하다가 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다. 
한번 던질 때마다 나온 주사위의 숫자를 입력받아서 각 숫자가 몇 번씩 나왔는지 출력하는 프로그램을 작성하시오.

[입력예]
5 6 3 4 5 5 2 2 4 6


[출력예]
1 : 0
2 : 2
3 : 1
4 : 2
5 : 3
6 : 2
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 주어진 문제의 촛점은 '개수' 다.
		int [] count = new int[6];

		int n;
		for(int i = 0; i < 10; i++){
			n = sc.nextInt();
			count[n - 1]++;
		}
		
		for(int i = 0; i < count.length; i++){
			System.out.println((i + 1) + " : " + count[i]);
		}
		
		sc.close();

	} // end main()
} // end class
