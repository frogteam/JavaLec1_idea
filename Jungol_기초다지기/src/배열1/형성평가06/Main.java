package 배열1.형성평가06;


/*
 * 배열1 - 형성평가6 

6개의 문자배열을 만들고 {'J' 'U' 'N' 'G' 'O' 'L'} 으로 초기화 한 후 
문자 한 개를 입력받아 배열에서의 위치를 출력하는 프로그램을 작성하시오.
첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none" 라는 메시지를 출력하고 끝내는 프로그램을 작성하시오.
   
  
[입력예1]
L

[출력예1]
5
 
 
[입력예2]
B
[출력예2]
none 
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [] arr = {'J', 'U', 'N', 'G', 'O', 'L'};
		
		char ch = sc.next().charAt(0);
		int i;
		for (i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				System.out.println(i);
				break;
			} // end for
		} //end for
		
		if(i == arr.length)
			System.out.println("none");
		
		sc.close();
	} // end main()
} // end class
