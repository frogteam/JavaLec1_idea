package com.lec.java.j16_01_Polymorphism;

public class Vehicle {
	private int speed;

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void displayInfo() {
		System.out.println("--- Vehicle 정보 ---");
		System.out.println("speed: " + speed);
	}

	// static 은 인스턴스와 독립적이다.  따라서 상속되지도 않고 오버라이딩 대상도 아니다.
	// '타입'으로 식별 및 접근 가능  => ex) 클래스이름.static변수
	public static final String NAME = "VEHICLE";
	
} // end class Vehicle








