package 배열1.형성평가07;


/*
배열1 - 형성평가7 

세 자리 이하의 정수를 차례로 입력 받다가 999가 입력되면 프로그램을 종료하고 
그 때까지 입력된 최대값과 최소값을 출력하는 프로그램을 작성하시오.입력받는 정수는 100개 이하이다.
   
  
[입력예]
45 19 123 58 10 -55 16 -1 999

[출력예]
max : 123 
min : -55
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] num = new int[100];
		int i;
		for (i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(num[i] == 999) break;
		}// end for
		
		int min = num[0];
		int max = num[0];
		for (int j = 1; j < i; j++) {
			if(min > num[j]) min = num[j];
			if(max < num[j]) max = num[j];
		} // end for
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		sc.close();
	} // end main()
} // end class
