package 문자열2.자가진단09;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=247&sca=10f0

610 : 문자열2 - 자가진단9 

5개의 문자열을 입력받아 문자열 크기(아스키코드) 역순으로 정렬하여 출력하는 프로그램을 작성하시오.
   
[입력예]
Jungol
Korea
information
Monitor
class

[출력예]
information
class
Monitor
Korea
Jungol
 



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] words = new String[5];
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}
		
		//Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
		Arrays.sort(words);
		
//		List<String> list = Arrays.asList(words);
//		Collection.reverse(list);
//		words = list.toArray(new String[words.length]);
		
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.println(words[i]);
		}
		
		sc.close();
	} 

} // end class
