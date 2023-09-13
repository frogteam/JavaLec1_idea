package com.lec.java.j03_06_formatted;

/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수로 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/
public class PrintFormatMain {

	public static void main(String[] args) {
		System.out.println("서식화된 출력 : printf(), String.format()");
		
		double pi = Math.PI;
		System.out.println(pi);
		
		// printf : print with format
		// printf("서식문자열", 값1, 값2....)
		// 서식문자열 안에 %로 시작하는 서식문자들..
		System.out.printf("원주율 %f\n", pi); // %f : 기본 실수 출력 (소숫점 6자리까지)
		System.out.printf("원주율 %.2f\n", pi); // %.2f : 실수 출력 (소숫점 2자리까지)
		
		
		// format specifier (서식 지정자)
		//  %d  :  십진수 정수로 출력
		//  %f  :  실수 출력
		//  %s  :  문자열 출력
		//  %c  :  '문자하나' 출력
		//  %x  :  16진수 정수로 출력
		//  %%  :  % 출력
		
		int age = 10;
		short grade = 3;
		
		System.out.printf("제 나이는 %d살입니다. 학년은 %d학년입니다\n", age, grade);
		
		
		// 소숫점 이하 제한
		double height = 182.3;		
		System.out.printf("저는 %d살입니다. 키는 %fcm입니다\n", age, height);
		System.out.printf("저는 %d살입니다. 키는 %.1fcm입니다\n", age, height);
		
		System.out.printf("%d, %x, %c\n", 65, 65, 65);  //65, 41, A
		
		// 출력폭 지정, 좌우 정렬
		System.out.printf("|%d|%d|%d|\n",100,200,300);
		System.out.printf("|%5d|%5d|%5d|\n",100,200,300);      // 폭5칸,우측 정렬(기본)
		System.out.printf("|%-5d|%-5d|%-5d|\n",100,200,300);   // 좌측 정렬
		System.out.printf("|%6.1f|\n", height);  // 총 6자리, 소숫점이하 1자리
		
		// 출력폭 지정은 다른 서식지정자에도 적용 가능
		System.out.printf("제 이름은 [%10s] 입니다 혈액형은 %c형입니다\n", "김기덕", 'B');  // String, char
		
		// % 출력
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격률은 %.1f%%입니다\n", rate * 100);
		
		// 숫자에 패딩 가능
		System.out.printf("|%05d|%05d|%05d|\n",100,200,300);  // - 는 적용 안됨.		

		// format 문자열을 따로 설정해서 사용가능
		String fmt = "주소: %s, 우편번호[%05d]";
		System.out.printf(fmt + "\n", "서울", 12345);
		System.out.printf(fmt + "\n", "광주", 44);
		System.out.printf(fmt + "\n", "대구", 776);
		
		
		System.out.println();
		
		// String.format()
		// 기본적으로 printf() 와 사용법은 동일함
		// 단, 화면에 출력하는게 아니라, 결과를 문자열(String) 으로 만들어서 리턴
		
		String.format("합격률은 %.1f%%입니다", rate);  // 어떠한 결과도 안나타남.
		String result = String.format("합격률은 %.1f%%입니다", rate);
		System.out.println(result);
		
		
		
		// 서식을 동적으로 변화시킬수도 있다.
		int width = 10;
		System.out.printf("%d 칸에 출력합 [%" + width + "d]\n", width, 123456);


		//---------------------------------------------
		// Text Block 으로 포맷팅 가능. (Java15 이상)
		String textBlock = """
        {
            "title": %s,
            "author": %s,
            "id": %d
        }
        """.formatted("hi", "김자까", 2);

		System.out.println(textBlock);
		
	} // end main

} // end class
