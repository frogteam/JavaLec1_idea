package com.lec.java.j14_08_singleton;

public class Test {
	// 멤버 변수
	private int num;
	
	// singleton 디자인패턴
	// 생성자는 private로 작성
	private Test() {
		num = 100;
	}
	
	// singleton 디자인 패턴
	private static Test instance = null;  // 생성된 instance 를 reference
	public static Test getInstance() {
		if (instance == null) { // 기존에 생성된 인스턴스가 없었다면
			instance = new Test(); // 생성
		}
		return instance;
	} // end getInstance()
	
	

	// 메소드 (getter / setter)
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
} // end class Test














