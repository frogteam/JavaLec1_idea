package 반복제어문1.자가진단06;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2077&sca=1060
633 : 반복제어문1 - 자가진단6 

아래와 같이 나라 이름을 출력하고 숫자를 입력받아 해당하는 나라의 수도를 출력하는 작업을 반복하다가 
해당하는 번호 이외의 숫자가 입력되면 "none"라고 출력한 후 종료하는 프로그램을 작성하시오.


* 각 나라의 수도 : 
	대한민국 = 서울(Seoul)
	미국 = 워싱턴(Washington)
	일본 = 동경(Tokyo)
	중국 = 북경(Beijing)

* 입출력시 모양은 "입·출력예"와 같이 하시오.​ 

[입출력예] 
1. Korea
2. USA
3. Japan
4. China
number? 1

Seoul

1. Korea
2. USA
3. Japan
4. China
number? 5

none
 

 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		while(true) {
			System.out.print("1. Korea\r\n" + 
					"2. USA\r\n" + 
					"3. Japan\r\n" + 
					"4. China\r\n" + 
					"number? ");
			n = sc.nextInt();

			if(n == 1) {
				System.out.println("\nSeoul\n");
			} else if (n == 2) {
				System.out.println("\nWashington\n");
			} else if (n == 3) {
				System.out.println("\nTokyo\n");
			} else if (n == 4) {
				System.out.println("\nBeijing\n");
			} else {
				System.out.println("\nnone\n");
				break;
			}
			
		} // end while
		
		sc.close();
	}// end main

}// end class
