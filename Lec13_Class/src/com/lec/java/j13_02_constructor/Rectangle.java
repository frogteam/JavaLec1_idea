package com.lec.java.j13_02_constructor;

public class Rectangle {
	// 멤버변수: double형 width, height 선언
	private double width;
	private double height;
	
	// 생성자
	// 1) 디폴트 생성자: 가로, 세로 길이 출력
	public Rectangle() {
//		width = 100;	// 디폴트 값을 지정해줄수 있다
//		height = 100;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}
	// 2) 생성자(double w, double h): 멤버변수를 매개변수 값으로 초기화, 출력
	public Rectangle(double w, double h) {
		width = w;
		height = h;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}

	public Rectangle(double h){
		this(); // 생성자 위임 (constructor delegation)
			// this 키워드 사용하여, 특정 생성자를 먼저 호출하여 초기화 함
			// 생성자 위임은 생성자 의 '첫 문장' 이어야 한다!
		System.out.println("Rectangle(double) 생성");
		height = h;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}

	// 메소드
	// 1) calcPerimeter: 사각형의 둘레
	public double calcPerimeter() {
		return (width + height) * 2;
	}
	
	// 2) calcArea: 사각형의 넓이
	public double calcArea() {
		return width * height;
	}
	
} // end class Rectangle


// 생성자
// 1) 디폴트 생성자: 가로, 세로 길이 출력
// TODO

// 2) 생성자(double w, double h): 멤버변수를 매개변수 값으로 초기화, 출력
// TODO


// 메소드
// 1) calcPerimeter: 사각형의 둘레
// TODO

// 2) calcArea: 사각형의 넓이
// TODO








