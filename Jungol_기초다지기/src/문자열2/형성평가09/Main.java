package 문자열2.형성평가09;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=137&sca=10f0

237 : 문자열2 - 형성평가9 

정수, 실수, 문자열을 차례로 입력받아서 새로운 문자열에 출력한 후 
전체의 길이를 2등분하여 출력하는 프로그램을 작성하시오. 
실수는 반올림하여 소수 셋째자리까지 출력하는 것으로 하고, 
새로운 문자열의 길이가 홀수일 때는 첫 번째 줄에 한 개를 더 출력한다. 
각 문자열의 길이는 30자 이내이다.
   

[입력예]
12345 5.0123 fighting

[출력예]
123455.01
2fighting
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double d = sc.nextDouble();
		String str = sc.next();
		
		String all = "" + n + String.format("%.3f", d) + str;
		
		if(all.length() % 2 == 1) {
			// 홀수이면
			System.out.println(all.substring(0, all.length() / 2 + 1));
			System.out.println(all.substring(all.length() / 2 + 1));
		}else {
			System.out.println(all.substring(0, all.length() / 2));
			System.out.println(all.substring(all.length() / 2));
		}
		
		sc.close();
	}

}
