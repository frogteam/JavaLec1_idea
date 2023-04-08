package com.lec.java.j13_06_클래스연습;


// 클래스: 멤버변수 + 메소드 (+ 생성자) => 데이터 타입
public class Score {
	// 멤버 변수
	String name;
	int kor;
	int eng;
	int math;
	
	// 생성자
	//   1) 기능: 멤버변수들을 초기화
	//   2) 이름: 클래스의 이름과 반드시 같아야 함
	//   3) 리턴 타입이 없다.
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Score() {}
	
	// 메소드
	// 이름: displayInfo
	// 리턴: void
	// 매개변수: none
	public void displayInfo() {
		System.out.print(name + " : ");
		System.out.print(kor + " : ");
		System.out.print(eng + " : ");
		System.out.print(math + " : ");
		System.out.println();
	} // end displayInfo()
	
	public int calcTotal() {
		int total = 0;
		total = kor + eng + math;
		
		return total;
	} // end calcTotal()
	
	public double calcAvg() {
		double avg = 0;
		avg = (double)calcTotal() / 3;
		
		return avg;
	} // end calcAvg()
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
	
} // end class Score








