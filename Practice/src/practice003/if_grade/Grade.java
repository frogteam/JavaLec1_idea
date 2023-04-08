package practice003.if_grade;

import java.util.Scanner;


	/*
	project: Practice
	package: practice003.if_a05
	class: Grade

 	두 개의 실수를 입력받아 
 	모두 4.0 이상이면 "A", 
 	모두 3.0 이상이면 "B", 
 	아니면 "C" 라고 출력하는 프로그램을 작성하시오.
 	
 	[입력예1]		
 	4.3 3.5		
 	
 	[출력예1]
 	8
 	
 	[입력예2]		
 	4.0 2.9		
 	
 	[출력예2]
 	C
 	
 */
public class Grade {

	public static void main(String[] args) {
		double a, b;
		Scanner grade = new Scanner(System.in);
		System.out.print("1번 점수를 입력하세요 : ");	
		a = grade.nextDouble();
		System.out.print("2번 점수를 입력하세요 : ");
		b = grade.nextDouble();
		
		double sum = a + b;
		if(a >= 4.0 && b >= 4.0) {
			System.out.println("당신의 점수는 \"" + sum + "\"" + " \"" + "A\"입니다");
		} else if(a >= 3.0 && b>= 3.0) {
			System.out.println("당신의 점수는 \"" + sum + "\"" + " \"" + "B\"입니다");
		} else {
			System.out.println("당신의 점수는 \"" + sum + "\"" + " \"" + "C\"입니다");
		}//end if-else
				
		grade.close();
	}//end main
}//end class
