package 배열1.자가진단05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=196&sca=1090

559 : 배열1 - 자가진단5 

1반부터 6반까지의 평균점수를 저장한 후 
두 반의 반 번호를 입력받아 두 반 평균점수의 합을 출력하는 프로그램을 작성하시오. 
반별 평균점수는 초기값으로 1반부터 차례로 85.6 79.5 83.1 80.0 78.2 75.0으로 초기화하고 

출력은 소수 두 번째 자리에서 반올림하여 소수 첫째자리까지 한다.
   
[입력예]  
1 3

[출력예]
168.7
 
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double [] arr = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		
		System.out.printf("%.1f", arr[i1 - 1] + arr[i2 - 1]);
		
		
		sc.close();
		
	} // end main()

} // end class
