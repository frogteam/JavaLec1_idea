package 배열1.형성평가05;


/*
배열1 - 형성평가5 

6명의 몸무게를 입력받아 몸무게의 평균을 출력하는 프로그램을 작성하시오. 
출력은 반올림하여 소수 첫째자리까지로 한다.

[입력예]
23.2 39.6 66.4 50.0 45.6 48.0

[출력예]
45.5
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double [] weight = new double[6];
		double sum = 0.0;
		for (int i = 0; i < weight.length; i++) {
			weight[i] = sc.nextDouble();
			sum += weight[i];
		} // end for
		
		System.out.printf("%.1f", sum / weight.length);
		
		sc.close();
	} // end main()
} // end class
