package practice.similarity;

import java.util.Arrays;
import java.util.Scanner;

/*
주어진 '두개'의 '네자리 숫자'는 닮았는가?

1031 <==> 1130   닯았다.
어케 판단

[입력예]
1031 1130

[결과]
true


[입력예]
1131 1130

[결과]
false


 */
public class Similarity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] arr = new int [2][10];
		
		String num1 = sc.nextInt() + "";
		String num2 = sc.nextInt() + "";
				
		for(int i = 0; i < num1.length(); i++) {
			arr[0][Integer.parseInt(num1.substring(i, i + 1))]++;
		}

		for(int i = 0; i < num2.length(); i++) {
			arr[1][Integer.parseInt(num2.substring(i, i + 1))]++;
		}
		
		System.out.println(Arrays.equals(arr[0], arr[1]));
		
		sc.close();
	}
}
