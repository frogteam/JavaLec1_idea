package practice.game369;

public class Game369Main {

	public static void main(String[] args) {
		System.out.println("369 게임");
		
		for (int n = 1; n <= 100; n++) {
			int num1 = n % 10; // 일의 자리 수: n % 10
			int num10 = n / 10; // 십의 자리 수: n / 10
			
			if ((num1 == 3) || (num1 == 6) || (num1 == 9)) {
				// 일의 자리 숫자가 3, 6, 또는 9이면 * 출력
				System.out.print("*" + "\t");
			}
			else if (num10 == 3 || num10 == 6 || num10 == 9) {
				// 십의 자리 숫자가 3, 6, 또는 9이면 * 출력
				System.out.print("*" + "\t");
			}
			else {
				// 나머지 경우는 모두 숫자 그대로 출력
				System.out.print(n + "\t");
			} // end else
			
			
			if (n % 10 == 0) {
				// 10, 20 ,30, ... 일 때는 줄바꿈
				System.out.println();
			} // end if
			
		} // end for
		
		
		
		System.out.println("\n\n369 게임(while문 사용)");
		int n = 1;
		while (n <= 100) {
			int d1 = n % 10; // 일의 자리 숫자
			int d10 = n / 10; // 십의 자리 숫자
			
			if(d1 == 3 || d1 == 6 || d1 == 9 
					|| d10 == 3 || d10 == 6 || d10 == 9) {
				System.out.printf("%4s", "*");
			} else {
				System.out.printf("%4d", n);
			}

			if (n % 10 == 0) {
				System.out.println();
			} // end if
			
			n++;
		} // end while

	} // end main()

} // end class Game369Main








