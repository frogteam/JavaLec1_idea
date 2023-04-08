package com.lec.java.j13_06_클래스연습;

// 객체의 배열
public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score [] arrScore = new Score[3];
		
		System.out.println("arrScore =" + arrScore);
		System.out.println("arrScore[0] =" + arrScore[0]); // null
		
		//System.out.println(arrScore[0].calcTotal());
		
		arrScore[0] = new Score("홍길동", 100, 80, 70);
		arrScore[1] = new Score("손오공", 78, 23, 62);
		arrScore[2] = new Score("나루토", 52, 93, 100);
		
		for (int i = 0; i < arrScore.length; i++) {
			arrScore[i].displayInfo();
			System.out.println("총점: " + arrScore[i].calcTotal());
			System.out.println("평균: " + arrScore[i].calcAvg());
		}
		
		System.out.println("----------------------");
		
		Score [] arr = {
			new Score("아이언맨", 10, 20, 33),
			new Score("캡틴", 100, 100, 0),
			new Score("토르", 54, 22, 91)
		};
		
		for(Score score : arr) {
			score.displayInfo();
			System.out.println("총점: " + score.calcTotal());
			System.out.println("평균: " + score.calcAvg());
		}
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










