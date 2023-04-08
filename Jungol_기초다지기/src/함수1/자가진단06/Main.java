package 함수1.자가진단06;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=213&sca=10b0

	
정수의 연산식을 입력받아 연산을 위한 
함수를 호출하여 4칙연산(+ - * /)의 연산결과를 출력하는 프로그램을 작성하시오.
 
('/'의 경우는 정수 부분만 출력하고 4칙연산 이외의 연산 결과는 0으로 한다.)
단 if~ else if~ else 문으로 작성하세요.
   
  
[입력예] 
10 + 20

[출력예]
10 + 20 = 30


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		String op = sc.next();
		int num2 = sc.nextInt();
		
		System.out.println(num1 + " " + op + " " + num2 + " = " + calculate(num1, op, num2));
		
		sc.close();
	} // end main()
	
	public static int calculate(int num1, String op, int num2) {
		int result = 0;
		switch(op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default:
			result = 0;
		}
		return result;
	}

} // end class
