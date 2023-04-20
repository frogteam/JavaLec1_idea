package 반복제어문1.자가진단02;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=174&sca=1060
537 : 반복제어문1 - 자가진단2 

100 이하의 양의 정수만 입력된다. 
while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.

[입력예]
10

[출력예]
55
*/
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0; // 누적 합산할 변수
		int i = 1;
		while(i <= n) {
			sum += i;
			i++;
		} // end while
		
		System.out.println(sum);
		
		sc.close();
	}// end main

}// end class
