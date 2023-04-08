package com.lec.java.j13_02_constructor;

public class Triangle {
	// 멤버 변수: double형 base(밑변), height(높이) 선언
	private double base;
	private double height;
	
	// 생성자
	// 1) 디폴트 생성자: 밑변, 높이 출력
	public Triangle() {
		System.out.println("밑변: " + base);
		System.out.println("높이: " + height);
	}
	// 2) 생성자(double b, double h): 멤버변수를 매개변수로 초기화, 출력
	public Triangle(double b, double h) {
		base = b;
		height = h;
		System.out.println("밑변: " + base);
		System.out.println("높이: " + height);
	}
	
	// 메소드
	// calcArea(): 넓이 계산
	public double calcArea() {
		return base * height / 2;
	}
	
	
} // end class Triangle





