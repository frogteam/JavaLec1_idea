package practice.prime2;

import java.util.Scanner;

public class PrimeNumber2 {

	public static void main(String[] args) {
		
		System.out.println("소수 판별");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int count = 0;
		
		// 2 ~ n 까지 체크
		for(int j = 2; j <= n ; j++) {			
			// j가 소수인지 판정
			int i;
			for(i = 2; i < j; i++) {
				if(j % i == 0) {
					break;
				}
			}
			
			// 소수 발견하면!
			if(i == j) {
				System.out.print(j + " ");  // 소수 출력해주고
				count++;  // count 증가
			}
		}
		System.out.println();
		System.out.println(count);
		sc.close();


	}

}
