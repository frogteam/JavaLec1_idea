package 문자열2.형성평가07;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=115&sca=10f0
 
 215 : 문자열2 - 형성평가7 

두 개의 문자열을 입력받아 앞에서부터 정수로 변환 가능한 부분을 변환한 후 두 수의 곱을 출력하는 프로그램을 작성하시오. 
각 문자열의 길이는 100이하이다.
   
  
[입력예]
123.45  67@12 

[출력예]
8241
 

 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
	
		int n1 = getInt(str1);
		int n2 = getInt(str2);
		
		System.out.println(n1 * n2);
		
		sc.close();
	} // end main()
	
	public static int getInt(String str) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if('0' <= ch && ch <= '9') {
				result.append(ch);
			}else {
				break;
			}
		} // end for
		return Integer.parseInt(result.toString());
	}

} // end class
