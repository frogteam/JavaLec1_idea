package 문자열2.자가진단01;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=239&sca=10f0
 
 602 : 문자열2 - 자가진단1 

5개의 단어를 입력받아 모든 단어를 입력받은 역순으로 출력하는 프로그램을 작성하시오. 
각 단어의 길이는 30이하이다.
   
[입력예]
dog
cat
chick
calf
goat

[출력예]
goat
calf
chick
cat
dog
 

 
 */

public class Main {

	public static void main(String[] args) {
		String [] arr = new String[5];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine();
		}
		
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		
		sc.close();
		
	} // end main()

} // end class
