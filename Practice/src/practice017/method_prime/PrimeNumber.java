package practice017.method_prime;

import java.util.Scanner;

/*
 	다음 메소드들을 작성해보세요
	①  
	method name: isPrime(int)
	return : boolean 값  (소수이면 true, 아니면 false)
	arguments : int n
	
	②
	method name: selectPrime(int)
	return : void
	arguments : int n
	기능:  1 부터 매개변수 n 까지의 수중에서 소수 인것만 출력  
	
	③
	method name: selectPrime(int[])
	return : void
	arguments : int[] arr
	기능:  매개변수로 주어진 배열에서  소수 인것만 출력  
	
	
 */
public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("실습: 소수");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(isPrime(n)) {
			System.out.println(n + " 은 소수입니다");
		}else {
			System.out.println(n + " 은 소수가 아닙니다");
		}
		
		// 출력예시
		selectPrime(10);		// 1 ~ 10 사이의 수중에서 소수인것만 출력
								// 결과: 2, 3, 5, 7
		
		selectPrime(new int[] {13, 4, 5, 17, 3});  // 주어진 1차원 배열에서 소수인것만 출력
													// 결과 13, 5, 17, 3
		sc.close();
	} // end main()
	
	public static boolean isPrime(int num) {
		if (num < 2) // 1이하의 숫자는 소수가 아님
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) // 소수가 아닌경우
				return false;
		} // end for
		return true;
	}// end isPrime()
	
	
	public static void selectPrime(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (isPrime(arr[i]))
				System.out.println(arr[i] + " ");
		} // end for
	}// end selectPrime()

	
	public static void selectPrime(int n) {
		int[] cnt = new int[n];
		for(int i = 0; i<cnt.length;i++) {
			cnt[i]=i+1;
		}
		selectPrime(cnt);
	}//입력받은 수만큼의 배열을 생성해서 수를 대입

} // end class
