package practice.prime1;

import java.util.Scanner;

/*
 양의 정수를 입력 받고,  입력받은 숫자가 소수이면 “true” 아니면 “false” 를 출력하세요
[입력예]                     [출력예]  
4							false
[입력예]						[출력예]
7							true
 */
public class PrimeNumber1 {
	public static void main(String[] args) {
		System.out.println("소수 판별");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i;
		for(i = 2; i < n; i++) {
			if(n % i == 0) {
				break;
			}
		}
		sc.close();
		
		if(i == n) 
			System.out.println("true");
		else
			System.out.println("false");
	}
}
