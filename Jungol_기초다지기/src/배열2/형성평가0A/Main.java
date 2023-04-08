package 배열2.형성평가0A;

import java.util.Scanner;

/*
169 : 배열2 - 형성평가A 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=69&sca=10a0

[문제]
3행 5열의 2차원 문자배열을 선언하고 차례로 대문자를 입력 받은 후 
소문자로 바꾸어서 공백으로 구분하여 출력하는 프로그램을 작성하시오.


[입력예]
A B C D E
F G H I J
K L M N O


[출력예]
a b c d e
f g h i j
k l m n o
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = 3;
		int col = 5;
		
		char [][] arr = new char[row][col];
		char ch;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				ch = sc.next().charAt(0);
				if(ch >= 'A' && ch <= 'Z'){
					ch += 'a' - 'A';   // 대문자 -> 소문자
				} // end if
				arr[i][j] = ch;
			} // end for
		} // end for
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	} // end main()
} // end class
