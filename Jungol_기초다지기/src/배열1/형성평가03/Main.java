package 배열1.형성평가03;


/*
배열1 - 형성평가3 

10개의 정수를 입력받아 홀수 번째 입력받은 정수의 합과 
짝수 번째 입력받은 정수의 합을 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
10 20 25 66 83 7 22 90 1 100

[출력예]
odd : 141
even : 283
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] num = new int[10];
		
		int sumEven = 0;
		int sumOdd = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			
			if(i % 2 == 0) {   
				// 홀수번째
				sumOdd += num[i];
			}else {  
				// 짝수번째
				sumEven += num[i];
			}
			
		} // end for
		sc.close();
		
		System.out.println("odd : " + sumOdd);
		System.out.println("even : " + sumEven);
		
	} // end main()
} // end class
