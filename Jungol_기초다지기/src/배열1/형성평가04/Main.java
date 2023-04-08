package 배열1.형성평가04;


/*
배열1 - 형성평가4 

100개의 정수를 입력받을 수 있는 배열을 선언한 후 정수를 차례로 입력 받다가 
-1이 입력되면 입력을 중단하고 -1을 제외한 마지막 세 개의 정수를 출력하는 프로그램을 작성하시오. 
(입력받은 정수가 -1을 제외하고 3개 미만일 경우에는 -1을 제외하고 입력받은 정수를 모두 출력한다.)
   
  
[입력예] 
30 20 10 60 80 -1

[출력예]
10 60 80

*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[100];
		int n; 
		for (n = 0; n < arr.length; n++) {
			arr[n] = sc.nextInt();
			if(arr[n] == -1) break;
		} // end for
		
		int startIndex = (n - 3 >= 0)? n - 3: 0;  
		for(int i = startIndex; i < n; i++) {
			System.out.print(arr[i] + " ");
		} // end for
		System.out.println();
		sc.close();
	} // end main()
} // end class
