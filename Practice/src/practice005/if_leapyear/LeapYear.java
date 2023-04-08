package practice005.if_leapyear;

import java.util.Scanner;

/*
400으로 나누어떨어지면 윤년이다.
또는 4로 나누어떨어지고 100으로 나누어떨어지지 않으면 윤년이다.
나머지는 모두 평년이다
(즉.. 1900, 2100년은 윤년이 아니다) 

1.400으로 나누어 떨어졌다
2.4로 나누어 떨어진다 / 100으로는 떨어지지 않는다
*/

public class LeapYear {

	public static void main(String[] args) {
		/*
		 * 년도를 입력받아 윤년(leap year)인지 평년(common year)인지 판단하는 프로그램을 작성하시오.
		 * 
		 * 400으로 나누어떨어지면 윤년이다. 또는 4로 나누어떨어지고 100으로 나누어떨어지지 않으면 윤년이다. 나머지는 모두 평년이다 (즉..
		 * 1900, 2100년은 윤년이 아니다)
		 * 
		 * [입력] 2008 [출력] leap year
		 * 
		 * 
		 */

		double year;

		Scanner sc = new Scanner(System.in);

		System.out.print("년도를 입력하시오");
		year = sc.nextDouble();

		if (year % 400 == 0) {
			System.out.println("윤년 입니다");
		} else if (year % 4 == 0) { 
			if (year % 100 > 0) { 
				System.out.println("윤년 입니다");
			} else { 
				System.out.println("평년 입니다");
			}

		} else { 
			System.out.println("평년 입니다");
		}

		sc.close();
	}
}
