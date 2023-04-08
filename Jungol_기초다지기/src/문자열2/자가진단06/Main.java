package 문자열2.자가진단06;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=244&sca=10f0
 
 607 : 문자열2 - 자가진단6 

20자 이하인 두 개의 문자열을 입력받아 
첫 번째 문자열의 앞부분 두자를 두 번째 문자열의 앞부분에 복사하고 
다시 뒷부분에 이어 붙여서 저장한 후 두 번째 문자열을 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
ABCDE QWERTY

[출력예]
ABERTYAB
 


 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		String prefix =  str1.substring(0, 2);
		
		System.out.println(prefix + str2.substring(2) + prefix);
		
		
		sc.close();

	}

}
