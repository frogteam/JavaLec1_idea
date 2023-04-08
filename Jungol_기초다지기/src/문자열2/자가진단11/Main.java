package 문자열2.자가진단11;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=249&sca=10f0

612 : 문자열2 - 자가진단B 

5개의 정수를 입력받아 모두 붙여서 문자열로 저장한 후 세 자씩 나누어서 출력하는 프로그램을 작성하시오.
     
[입력예] 
12 5963 58 1 45678

[출력예]
125
963
581
456
78



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		for (int i = 0; i < 5; i++) {
			str += sc.nextInt() + "";
		}
		
		for(int i = 0; i < str.length(); i += 3) {
			if(i + 3 < str.length())
				System.out.println(str.substring(i, i + 3));
			else
				System.out.println(str.substring(i));
		}
		
		
		sc.close();
	}

}
