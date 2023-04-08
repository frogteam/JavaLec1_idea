package 배열1.형성평가0A;


/*
배열1 - 형성평가A 

20 이하의 정수 n을 입력받고 n명의 점수를 입력받아 높은 점수부터 차례로 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
5
35 10 35 100 64

[출력예]
100
64
35
35
10
 
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] num = new int[20];
		
		int number = sc.nextInt();
		number = (number <= 20)? number : 20;
		
		for (int i = 0; i < number; i++) {
			num[i] = sc.nextInt();
		} // end for
		
		// 내림차순 정렬 수행
		// 배열 정렬 하기
		// bubble sort
		int temp;
		for(int i = number; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if(num[j] < num[j+1]) { // 내림차순
					temp = num[j]; 
					num[j] = num[j+1];
					num[j+1] = temp;
				} // end if
			} // end for
		} // end for
		
		// 출력
		for (int i = 0; i < number; i++) {
			System.out.println(num[i]);
		} // end for
		
		sc.close();
	} // end main()
} // end class
