package com.lec.java.j13_02_constructor;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		// 클래스이름 변수이름 = new 생성자();
		Circle c1 = new Circle();
		Circle c2 = new Circle(3);

		//System.out.println(c1);  // 인스턴스를 직접 출력해보면?
		//System.out.println(c1.toString());
		
		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레: " + perimeter);
		perimeter = c2.calcPerimeter();
		System.out.println("c2의 둘레: " + perimeter);
		
		double area = c1.calcArea();
		System.out.println("c1의 넓이: " + area);
		area = c2.calcArea();
		System.out.println("c2의 넓이: " + area);
		
		System.out.println();
		System.out.println("==================");
		Rectangle r1 = new Rectangle();
		perimeter = r1.calcPerimeter();
		System.out.println("사각형1의 둘레: " + perimeter);
		area = r1.calcArea();
		System.out.println("사각형1의 넓이: " + area);
		
		Rectangle r2 = new Rectangle(2, 3);
		perimeter = r2.calcPerimeter();
		System.out.println("사각형2의 둘레: " + perimeter);
		area = r2.calcArea();
		System.out.println("사각형2의 넓이: " + area);

		
		System.out.println();
		System.out.println("==================");
		Triangle t = new Triangle(3, 5);
		area = t.calcArea();
		System.out.println("삼각형 넓이: " + area);
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










