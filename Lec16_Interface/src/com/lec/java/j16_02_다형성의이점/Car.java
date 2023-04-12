package com.lec.java.j16_02_다형성의이점;

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
	}
	
} // end class Car











