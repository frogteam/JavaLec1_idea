package 함수3.형성평가04;

/*
https://jungol.co.kr/problem/234?cursor=eyJwcm9ibGVtc2V0IjoyLCJmaWVsZCI6MTIsImlkeCI6MTZ9

첫 번째는 1, 두 번째는 2,
세 번째부터는 앞의 두 수의 곱을 100으로 나눈 나머지로 이루어진 수열이 있다.

100 이하의 자연수 N을 입력받아
재귀함수를 이용하여 N번째 값을 출력하는 프로그램을 작성하시오.

[입력]
8

[출력]
92
8
[입력]
81

[출력]
32
 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		arr[0] = 1;  // 첫째 항
		arr[1] = 2;  // 둘때 항
		System.out.println(re(n, arr));
		
		sc.close();
	} // end main()

	public static int re(int n, int[] arr){
		if (n == 1) return 1;
		if (n == 2) return 2;

		// 직전 값 (n-2) 설정
		arr[n-2] = re(n-1, arr);   // 이것이 재귀이어야 한다.
		return arr[n-2] * arr[n-3] % 100;  // 이부분이 재귀이면 곤란하다.
	}

} // end class











