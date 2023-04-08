package 문자열2.자가진단10;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=248&sca=10f0

611 : 문자열2 - 자가진단A 

한 개의 문자열을 입력받아서 첫 줄에는 정수로 변환하여 2배한 값을 출력하고, 
다음 줄에는 실수로 변환한 값을 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.
   
  
[입력예]
50.1*34

[출력예]
100
50.10

 
[입력예]
48...5a4

[출력예]
96
48.00

[입력예]
5+26

[출력예]
10
5.00



 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		int i;
		// 소숫점 이상 처리 : 숫자 와 '.' 허용
		for(i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('0' <= ch && ch <= '9') {  // 숫자이면 추가
				sb.append(ch);
			}else if(ch == '.'){   // 소숫점 등장하면 추가하고 종료
				sb.append('.');  
				break;
			}else {   // 그 밖이면 더이상 숫자가 아님. 종료
				i = str.length();
				break;
			}
		}
		
		// 소숫점 이하 처리. 여기서부터는 숫자만 허용
		for(i = i + 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('0' <= ch && ch <= '9') {
				sb.append(ch);
			}else{
				break;
			}			
		}
		
		System.out.println((int)Double.parseDouble(sb.toString()) * 2);
		System.out.printf("%.2f", Double.parseDouble(sb.toString()));		

		sc.close();
	}
}