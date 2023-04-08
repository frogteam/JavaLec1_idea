package kakao01;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 
 [입력예1]
5
9 20 28 18 11
30 1 21 17 28
 
 [출력예1]
 [#####, # # #, ### #, #  ##, #####]
 
 
[입력예2]
6
46 33 33 22 31 50
27 56 19 14 14 10
 
[출력예2]
["######", "###  #", "##  ##", " #### ", " #####", "### # "]
 
 
 ★선행★
 bit 연산자
 Integer.toBinaryString();
 String.format();
 */
public class Kakao17_01_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] arr1 = new int[n];
		int [] arr2 = new int[n];
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		
		String [] result = new String[n];
		
		for (int i = 0; i < result.length; i++) {
			// n 자리 포맷으로 우측 정렬
			result[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i])); 
			result[i] = result[i].replace(' ', '0');  // 앞의 빈 자리는 0 으로 채우기
			result[i] = result[i].replace('1', '#').replace('0', ' ');
		}
		
		System.out.println(Arrays.toString(result));
		sc.close();
	} // end main
} // end class

