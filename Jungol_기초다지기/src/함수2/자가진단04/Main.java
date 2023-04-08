package 함수2.자가진단04;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=219&sca=10c0

582 : 함수2 - 자가진단4 

원의 넓이를 입력받아 반지름의 길이를 소수 둘째자리까지 출력하는 프로그램을 작성하시오. 
원의 넓이 = 반지름 * 반지름 * 3.14 식을 이용하시오.

[입력예]
314

[출력예]
10.00
 


 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double area = sc.nextDouble();
		
		double radius = getRadiusFromArea(area);   // 먼저 사용 코드 만들고 메소드 자동 생성 가능
	
		System.out.printf("%.2f", radius);
		
		sc.close();
	} // end main()

	// 매개변수 : area, 원의 넓이  <-- 메소드의 입력값
	// 리턴값 : double,  반지름   <-- 메소드의 출력값(결과값)
	private static double getRadiusFromArea(double area) {
		
		return Math.sqrt(area / 3.14);
	}

} // end class
