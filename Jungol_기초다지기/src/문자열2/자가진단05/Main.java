package 문자열2.자가진단05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=243&sca=10f0

 606 : 문자열2 - 자가진단5 

20개 이하의 문자열로 된 이름을 입력받아서 그 뒤에 "fighting"을 붙여서 저장하고 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
Korea

[출력예]
Koreafighting
 

 
 */


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(str + "fighting");
		
		
		sc.close();
	}

}
