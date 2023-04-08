package 반복제어문2.자가진단04;

/*
544 : 반복제어문2 - 자가진단4 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=181&sca=1070
100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.

[입력예]
95

[출력예]
585
*/
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int sum = 0;
		for (int i = num; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum);

		sc.close();
	} // end main()

} // end class
