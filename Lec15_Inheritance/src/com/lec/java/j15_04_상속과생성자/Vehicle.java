package com.lec.java.j15_04_상속과생성자;

public class Vehicle {   // IntelliJ 에서 ALT + ENTER 누른뒤 'create subclass'
	// 멤버 변수:
	int speed;
	
	// 생성자
	public Vehicle() {
		System.out.println("Vehicle() 생성");
	}
	public Vehicle(int speed) {
		this.speed = speed;
		System.out.println("Vehicle(int) 생성: speed=" + speed);
	}
	
	
	
} // end class Vehicle









