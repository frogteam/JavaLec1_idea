package 배열2.자가진단01;

import java.util.Scanner;

/*
564 : 배열2 - 자가진단1 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=201&sca=10a0

[문제]
영문 대문자를 입력받다가 대문자 이외의 문자가 입력되면 그 때까지 1번 이상 입력된 각 문자의 개수를 사전 순으로 출력하는 프로그램을 작성하시오.


[입력예]
A B C F F F B Z !

[출력예]
A : 1개
B : 2개
C : 1개
F : 3개
Z : 1개
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 주어진 문제의 촛점은 '개수' 다.
		int [] arrCount = new int['Z' - 'A' + 1];  // 알파벳 갯수만큼의 배열 생성
		char ch;

		while(true){
			ch = sc.next().charAt(0);
			
			if(ch < 'A' || ch > 'Z')  // 대문자 외에 입력되면 중단 
				break;
			
			arrCount[ch - 'A']++;   // 해당 알파벳 카운터 증가
		}
		
		// 1번 이상 입력된 알바펫의 개수 출력
		for(int i = 0; i < arrCount.length; i++){
			if(arrCount[i] > 0){
				System.out.println( (char)('A' + i) + " : " + arrCount[i]);
			}
		}
		
		sc.close();

	} // end main()
} // end class
