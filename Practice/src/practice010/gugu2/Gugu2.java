package practice010.gugu2;

import java.util.Scanner;

/*
 * 구글드라이브
 * https://docs.google.com/presentation/d/15Y8O9KkO5sSf8aoco4xEuTXGsnAHmVxN0T5vKp7bdvQ/edit#slide=id.g6697c6f9e_0_1
 */
public class Gugu2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("시작단");
		int startDan = in.nextInt();
		System.out.println("끝단");
		int endDan = in.nextInt();
		System.out.println("시작 피승수");
		int startMul = in.nextInt();
		System.out.println("끝 피승수");
		int endMul = in.nextInt();
		System.out.println("출력할 열의수 ");
		int maxCol = in.nextInt();

		for (int dan = startDan; dan <= endDan; dan += maxCol) {
			for (int mul = startMul; mul <= endMul; mul++) {
				for(int col = 0; col < maxCol; col++) {
					if ((dan + col) > endDan)
						break;
					System.out.print((dan + col) + " x " + mul + " = " + (dan + col) * mul + "\t");
				}
				System.out.println();  // 각 행 출력후 라인변경
			}
			System.out.println(); // 각 row 출력후 라인변경
		} // end for
		
	}// end main
} // end class
