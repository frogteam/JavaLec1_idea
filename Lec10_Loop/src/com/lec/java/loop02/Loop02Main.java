package com.lec.java.loop02;

/* continue;
 * 순환문(for, while, do~while) 안에서 continue   를 만나면
 * continue를 감싸는 가장 가까운 순환문 으로 돌아감
 * 
 * 순환문은 종료하지 않고 . 특정 조건만 스킵!
 */
public class Loop02Main {

	public static void main(String[] args) {
		System.out.println("continue;");
		
		int num = 1;
		while (num <= 10) {
			num++;
			if (num % 2 == 0) {
				continue;
				// continue를 만나게 되면
				// while의 조건 체크하는 곳으로 점프
			} // end if
			
			System.out.println(num);
		} // end while
		
		System.out.println();
		// for문과 continue를 사용해서
		// 1 ~ 10 숫자 중 짝수만 출력
		for (num = 1; num <= 10; num++) {
			if (num % 2 == 1) {
				continue;
			}
			
			System.out.println(num);
		} // end for
		
		
		System.out.println();
		// for 문으로 무한루프 만들기
		// 
		for(int count = 1;;count++){
			if(count > 10) break;
			if(count % 2 == 1) continue;
			System.out.println("안녕하세요..." + count);
		} // end for
		

		System.out.println();
		// 2단은 x 2 부터 출력
		// 3단은 x 3 부터 출력

		int i, j;
		for(i = 2; i <= 9; i++) {
			System.out.println(i+"단");
			for(j = 1; j <= 9; j++) {
				if(i > j) {
					continue;
				}				
				System.out.println(i+"x"+j+"="+i*j);
			}//in for
			System.out.println();
		}//out for

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















