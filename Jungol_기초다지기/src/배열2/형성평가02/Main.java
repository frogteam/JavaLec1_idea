package 배열2.형성평가02;

import java.util.Scanner;

/*
161 : 배열2 - 형성평가2 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=61&sca=10a0

[문제]
학생들의 점수를 입력을 받다가 0이 입력되면 그 때까지 입력받은 점수를 10점 단위로 구분하여 점수대별 학생 수를 출력하는 프로그램을 작성하시오. (1명도 없는 점수는 출력하지 않는다.)학생은 최대 100명이하이다.


[입력예]
63 80 95 100 46 64 88 0


[출력예]
100 : 1 person
90 : 1 person
80 : 2 person
60 : 2 person
40 : 1 person
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 주어진 문제의 촛점은 '개수' 다.
		int [] arrCount = new int[11];  // 0점 이상 ~ 100점 이상   (11단계)
		int score;

		while(true){
			score = sc.nextInt();
			
			if(score <= 0 || score > 100)  // 0이하, 100이상이면 종료  
				break;
			
			arrCount[score / 10]++;   // 해당 알파벳 카운터 증가
		}
		
		// 1번 이상 입력된 개수 출력
		for(int i = arrCount.length - 1; i >= 0; i--){
			if(arrCount[i] > 0){
				System.out.println( i*10 + " : " + arrCount[i] + " person");
			}
		}
		
		sc.close();

	} // end main()
} // end class
