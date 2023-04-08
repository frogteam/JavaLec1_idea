package 배열1.형성평가01;


/*
150 : 배열1 - 형성평가1 
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=50&sca=1090

[문제]
10개의 문자를 입력받아 마지막으로 입력받은 문자부터 첫 번째 입력받은 문자까지 차례로 출력하는 프로그램을 작성하시오.


[입력예]
A E C X Y Z c b z e

[출력예]
e z b c Z Y X C E A
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] alphabet = new char[10];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = sc.next().charAt(0);
		}
		for (int i = alphabet.length - 1; i >= 0 ; i--) {
			System.out.print(alphabet[i] + " ");
		}
		System.out.println();
	}
}
