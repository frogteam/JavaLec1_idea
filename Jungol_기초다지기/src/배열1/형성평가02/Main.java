package 배열1.형성평가02;

import java.util.Scanner;

/*
배열1 - 형성평가2 

5개의 정수를 입력받은 후 첫 번째 세 번째 다섯 번째 입력받은 정수의 합을 출력하는 프로그램을 작성하시오.
   
  
[입력예]
15 20 33 10 9

[출력예]
57
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] num = new int[5];
		for(int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(num[0] + num[2] + num[4]);
		sc.close();
	} // end main()
} // end class
