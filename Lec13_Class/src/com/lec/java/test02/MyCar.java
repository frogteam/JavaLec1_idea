package com.lec.java.test02;

public class MyCar {
	int speed;

	public void display() {
		System.out.println("지금 속도는 : " + speed);
	}

	public void SpeedUp() {
		speed += 10;
		System.out.println(speed);
	}

	public void SpeedDown() {
		System.out.println(speed);
	}
}// end of class
