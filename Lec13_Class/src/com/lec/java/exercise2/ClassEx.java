package com.lec.java.exercise2;

public class ClassEx {

	public static void main(String[] args) {
		
		int [] score = { 98, 72, 32, 45, 59, 98 };
		
		ScoreBoard sBoard = new ScoreBoard(score);
		
		System.out.println("총점: " + sBoard.calcTotal());
		System.out.println("평균: " + sBoard.calcAverage());
		System.out.println("등급 :" + sBoard.calcGrade());
		

	} // end main
} // end class
