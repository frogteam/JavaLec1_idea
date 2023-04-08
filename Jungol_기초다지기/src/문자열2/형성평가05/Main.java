package 문자열2.형성평가05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=93&sca=10f0

193 : 문자열2 - 형성평가5 

5개의 단어(각 단어는 100자 이하)를 입력받은 후 
문자와 문자열(100자 이하)을 한 개씩 입력받아 
나중에 입력받은 문자나 문자열이 포함된 단어를 모두 출력하는 프로그램을 작성하시오. 
찾는 단어가 없으면 “none”이라고 출력한다.
   
[입력예]  
banana
apple
melon
tomato
pear
n
to

[출력예]
banana
melon
tomato
 
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] arr = new String[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		char ch = sc.next().charAt(0);
		String str = sc.next();
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].indexOf(ch) >= 0 || arr[i].indexOf(str) >= 0) {
				System.out.println(arr[i]);
				count++;
			}
		}
		
		if(count == 0) System.out.println("none");
		
		sc.close();
	} // end main()

} // end class
