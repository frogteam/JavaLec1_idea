package 문자열2.형성평가03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=91&sca=10f0

191 : 문자열2 - 형성평가3 

단어를 입력받다가 "0"을 입력받으면 입력을 종료하고 그 때까지 입력받은 단어의 개수를 출력하고 홀수 번째 입력받은 단어를 한 줄에 1개씩 출력하는 프로그램을 작성하시오. 
단어의 개수는 50개를 넘지 않고, 단어의 길이는 100자 이하이다.
   
[입력예]  
keyboard
mouse
monitor
0

[출력예]
3
keyboard
monitor
 

 */
public class Main {

	public static void main(String[] args) {
		String [] arr = new String[50];
		Scanner sc = new Scanner(System.in);
		
		int i;
		for (i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine();
			if(arr[i].equals("0")) break;
		}
		
		System.out.println(i);
		for(int j = 0; j < i; j+=2) {
			System.out.println(arr[j]);
		}
		
		
		sc.close();
	} // end main()

} // end class
