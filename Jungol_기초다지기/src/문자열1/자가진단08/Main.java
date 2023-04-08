package 문자열1.자가진단08;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=237&sca=10e0
공백을 포함한 100글자 이하의 문자열을 입력받아 문장을 이루는 단어의 개수를 출력하는 프로그램을 작성하시오.

[입력예]
My name is Kimchulsoo

[출력예]
4

hint: Java   split() 사용
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] words = str.split(" ");
		System.out.println(words.length);
		sc.close();
	} // end main()

} // end class
