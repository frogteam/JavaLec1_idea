package 문자열2.형성평가01;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=89&sca=10f0

189 : 문자열2 - 형성평가1 

공백을 포함한 문자열을 입력받아 각 단어로 분리하여 문자열 배열에 저장한 후 입력순서의 반대 순서로 출력하는 프로그램을 작성하시오. 문자열의 길이는 100자 이하이다.
   
[입력예]  
C++ Programing jjang!!

[출력예]
jjang!!
Programing
C++
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] words = str.split("\\s+");
		
		for(int i = words.length - 1; i >= 0; i--) {
			System.out.println(words[i]);
		}
		
		
		sc.close();
	} // end main()

} // end class
