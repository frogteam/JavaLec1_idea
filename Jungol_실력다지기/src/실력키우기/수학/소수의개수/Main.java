package 실력키우기.수학.소수의개수;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2079&sca=2020
 
2813 : 소수의 개수 

소수(prime number)란 1보다 큰 자연수 중 1과 자기 자신 두 개만을 약수로 갖는 수를 말한다.
자연수 M과 N을 입력받아 M부터 N까지 소수의 개수를 구하여 출력하는 프로그램을 작성하시오.
   
자연수 M과 N이 공백으로 구분되어 주어진다. (1 ≤ M ≤ N ≤  2,000,000)
  
M이상 N이하의 자연수 중 소수가 몇 개인지 구하여 출력한다.
 
[입력단게] 
10 100

[출력]
21
 
 */

/*
 * 힌트
 * 에라토스테네스의 체(Eratosthenes' sieve)
에라토스테네스가 일정 범위까지의 소수를 간단하게 구하기 위해 고안한 방법으로 자연수를 ‘체’로 쳐서 걸러내고 ‘소수’만 골라내는 방법이라고 해서 에라토스테네스의 체라고 한다.


 * 
 */
public class Main {

	public static int[] prime = new int[2000005];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int count = 0;

		eratos(n);

		for (int i = m; i <= n; i++) {
			if (prime[i] == 0)
				count++;
		}

		System.out.println(count);

		sc.close();
	} // end main()

	public static void eratos(int n) {
		int i, j;
		prime[1] = 1;
		for (i = 2; i * i <= n; i++) {
			if (prime[i] == 0) {
				for (j = i * i; j <= n; j += i) { // i의 제곱부터 n까지 i씩 증가
					prime[j] = 1; // i의 배수 제거하기
				}
			}
		}
	}

} // end class
