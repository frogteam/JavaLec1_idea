package 문자열2.형성평가02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=90&sca=10f0

190 : 문자열2 - 형성평가2 

"flower" "rose" "lily" "daffodil" "azalea" 5개의 단어를 초기화한 후 
한 개의 문자를 입력받아서 입력받은 문자가 두 번째나 세 번째에 포함된 단어를 모두 출력하고 
마지막 줄에 출력한 단어의 개수를 출력하는 프로그램을 작성하시오.
 해당되는 단어가 없으면 "0"만 첫 줄에 출력한다.
   
[입력]
l

[출력예]
flower
lily
2
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] arr = {"flower", "rose", "lily", "daffodil", "azalea"};
		char ch = sc.next().charAt(0);
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if( (arr[i].length() >= 1 && arr[i].charAt(1) == ch) || (arr[i].length() >= 2 && arr[i].charAt(2) == ch)){
				count++;
				System.out.println(arr[i]);
			}
		}
		System.out.println(count);
		sc.close();
	} //end main
} // end class
