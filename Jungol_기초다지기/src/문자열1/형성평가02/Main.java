package 문자열1.형성평가02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=83&sca=10e0

183 : 문자열1 - 형성평가2 

5개 이상 100개 이하의 문자로 된 단어를 입력받은 후 앞에서부터 5자를 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
AbCdEFG

[출력예]
AbCdE
 



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(str.substring(0, 5));
		
		sc.close();
	} // end main

} // end close
