package practice012.array_reverse;

import java.util.Scanner;

/* <array01_a04>
 * 
 100 개의 정수를 저장할 수 있는 배열을 선언하고 
 정수를 차례로 입력받다가 0 이 입력되면 0 을 제외하고 
 그 때까지 입력된 정수를 가장 나중에 입력된 정수부터 
 차례대로 출력하는 프로그램을 작성하시오.

[입력예]
3 5 10 55 0

[출력예]
55 10 5 3
 
 
 */

public class ReverseArray {

	// 류이진 학생 作
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] array = new int[100];
		int i;

		System.out.println("숫자 입력 : ");
		for (i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			if (array[i] == 0)// 100전에 배열에 그만 넣고 싶다면 '0'입력
				break;
		}

		System.out.println("반대로 출력 : ");// 0 빼고 반대로 출력
		for (int j = i - 1; j >= 0; j--) //i==array.length이니까, 0부터 시작할려면 '-1'을 해줘야 됨. 
			System.out.printf(array[j] + " ");

		sc.close();

	}//end main

}
