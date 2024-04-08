package com.lec.java.j16_01_Polymorphism;

public class HybridCar extends Car {
	private int electricity;

	public int getElectricity() {
		return electricity;
	}
	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("--- HybridCar 정보 ---");
		System.out.println("speed: " + getSpeed());
		System.out.println("oil: " + getOil());
		System.out.println("electricity: " + electricity);
	} // end displayInfo()

	// static 은 인스턴스와 독립적이다.  따라서 상속되지도 않고 오버라이딩 대상도 아니다.
	// '타입'으로 식별 및 접근 가능  => ex) 클래스이름.static변수
	public static final String NAME = "HYBRID_CAR";
	
} // end class HybridCar








