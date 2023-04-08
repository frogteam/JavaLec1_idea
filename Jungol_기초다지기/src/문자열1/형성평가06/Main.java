package 문자열1.형성평가06;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=87&sca=10e0

187 : 문자열1 - 형성평가6 

문자열(100자 이하)을 입력받은 후 정수를 입력받아 
해당위치의 문자를 제거하고 출력하는 작업을 반복하다가 
문자 1개가 남으면 종료하는 프로그램을 작성하시오.

첫 번째 문자의 위치는 1이며 
만약 입력받은 번호가 문자열의 길이 이상이면 마지막 문자를 제거한다. 

* 입출력예에서 진한글씨가 출력

[입출력예]  
word
3
wod
1
od
10
o
 



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		while(word.length() > 1) {
			int n = sc.nextInt();  // 숫자 입력  (이 인덱스는 1 부터 시작)
			
			if(n >= word.length()) {
				word = word.substring(0, word.length() - 1);
			} else {
				word = word.substring(0, n - 1) + word.substring(n);
			}
			System.out.println(word);
		}
		
		sc.close();
	} // end main()

} // end class
