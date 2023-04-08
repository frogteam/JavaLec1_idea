package com.lec.java.access05;

public class Score {
	// 멤버 변수
	private int korean;
	private int english;
	private int math;
	
	// 생성자
	public Score() {}
	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// 메소드
	public int calcTotal() {
		
		return korean + english + math;
	} // end calcTotal()
	
	public double calcAvg() {
		
		return (double)calcTotal() / 3;
	} // end calcAvg()
	
	// getter 메소드
	public int getKorean() {
		return korean;
	}
	public int getEnglish() {
		return english;
	}
	public int getMath() {
		return math;
	}
	
} // end class Score












