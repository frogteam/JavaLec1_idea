package 함수2.자가진단08;

import java.util.Scanner;

/*
586 : 함수2 - 자가진단8 

정수 두 개를 입력받고  계산식을 매크로 함수로 작성하여 
두 수의 차를 제곱한 값과 합을 세제곱한 값을 각각 출력하는 프로그램을 작성하시오. 
(거듭제곱은 '^'로 표시하기로 한다.)
   
  
[입력예] 
5 10

[출력예]
(5 - 10) ^ 2 = 25
(5 + 10) ^ 3 = 3375
 

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		result(n1, n2);
		
		sc.close();
	}
	
	public static void result(int n1, int n2) {
		System.out.println("(" + n1 + " - " + n2 + ") ^ 2 = " + (int)Math.pow((n1 - n2), 2));
		System.out.println("(" + n1 + " + " + n2 + ") ^ 3 = " + (int)Math.pow((n1 + n2), 3));
	}

}
