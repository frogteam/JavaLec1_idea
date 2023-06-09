package com.lec.java.j18_07_CustomException;

// 우리가 만드는 예외 클래스
// Exception 또는 RuntimeException 클래스를 상속 받아서 만듬

public class ScoreException extends Exception {

	// 생성자
	public ScoreException() {
		super("점수 입력 오류"); // 부모 클래스의 생성자 호출
		// Exception(String message) 생성자가 호출됨
	}
	
	public ScoreException(String msg) {
		super(msg);
	}
	
} // end class ScoreException




