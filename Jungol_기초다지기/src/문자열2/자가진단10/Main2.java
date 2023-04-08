package 문자열2.자가진단10;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=248&sca=10f0

611 : 문자열2 - 자가진단A 

한 개의 문자열을 입력받아서 첫 줄에는 정수로 변환하여 2배한 값을 출력하고, 
다음 줄에는 실수로 변환한 값을 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.
   
  
[입력예]
50.1*34

[출력예]
100
50.10
 



 */
public class Main2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str, str2, str3;

		StringBuilder sb = new StringBuilder();
		StringBuilder sc = new StringBuilder();

		int su1, len, i;

		double su2;

		str = scan.next();

		len = str.length();

		for (i = 0; i < len; i++) {
			if (str.charAt(i) == '.') {
				break;
			}
			sb.append(str.charAt(i));
		}

		su1 = Integer.parseInt(sb.toString());

		System.out.println(su1 * 2);

		for (i = 0; i < len; i++) {
			if (str.charAt(i) == '.') {
				sc.append(str.charAt(i));
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				sc.append(str.charAt(i));
			} else {
				break;
			}
		}

		su2 = Double.parseDouble(sc.toString());
		System.out.printf("%.2f\n", su2);
	}
}