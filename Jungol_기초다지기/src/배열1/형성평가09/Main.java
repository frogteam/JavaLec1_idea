package 배열1.형성평가09;


/*
배열1 - 형성평가9 

100개 이하의 정수를 입력받다가 0 이 입력되면 0 을 제외하고 
그 때까지 입력 받은 개수를 출력한 후 입력받은 정수를 차례로 출력하되 
그 수가 홀수이면 2배한 값을, 짝수인 경우에는 2로 나눈 몫을 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
8 10 5 15 100 0

[출력예]
5
4 5 10 30 50
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] num = new int[100];

		int i;
		for (i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(num[i] == 0) break;
		} // end for
		
		System.out.println(i);
		for (int j = 0; j < i; j++) {
			if(num[j] % 2 == 1) {
				System.out.print(num[j] * 2 + " ");
			}else {
				System.out.print(num[j] / 2 + " ");
			} // end if
		} // end for
		System.out.println();
		sc.close();
	} // end main()
} // end class
