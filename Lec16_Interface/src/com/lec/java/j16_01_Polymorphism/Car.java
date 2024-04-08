package com.lec.java.j16_01_Polymorphism;

public class Car extends Vehicle {
	private int oil;

	public int getOil() {
		return oil;
	}
	public void setOil(int oil) {
		this.oil = oil;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("--- Car 정보 ---");
		System.out.println("speed: " + getSpeed());
		System.out.println("oil: " + oil);
	}// end displayInfo()

	// static 은 인스턴스와 독립적이다.  따라서 상속되지도 않고 오버라이딩 대상도 아니다.
	// '타입'으로 식별 및 접근 가능  => ex) 클래스이름.static변수
	public static final String NAME = "CAR";
	
} // end class Car











