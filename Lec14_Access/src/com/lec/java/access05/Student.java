package com.lec.java.access05;

public class Student {
	// 멤버 변수
	private int id;
	private String name;
	private Score score;
	
	// 생성자
	public Student() {}
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	// 메소드
	public void displayInfo() {
		System.out.println();
		System.out.println("----- 학생 정보 -----");
		System.out.println("학번: " + id);
		System.out.println("이름: " + name);
		System.out.println("국어점수: " + score.getKorean());
		System.out.println("영어점수: " + score.getEnglish());
		System.out.println("수학점수: " + score.getMath());
		System.out.println("총점: " + score.calcTotal());
		System.out.println("평균: " + score.calcAvg());
		
	} // end displayStudentInfo()
	
	public void setName(String name) {
		this.name = name;
	}

} // end class Student









