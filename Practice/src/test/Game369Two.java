package test;

import java.util.Scanner;

public class Game369Two {

	public static void main(String[] args) {
		System.out.println("----369게임----");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("369 범위 입력 : ");

		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			if (i >= 10 && i % 10 == 0)
				System.out.println();
			if (((i + 1) - 3) % 10 == 0 || ((i + 1) - 6) % 10 == 0 || ((i + 1) - 6) % 10 == 0
					|| ((i + 1) - 9) % 10 == 0) {

				System.out.print("* ");
			} else if ((i + 1) / 10 == 3 || (i + 1) / 10 == 6 || (i + 1) / 10 == 9) {
				System.out.print("* ");

			} else {
				System.out.print(i + 1 + " ");
			}
			System.out.print("\t");

			sc.close();
		}

	} // end main

} // end class
