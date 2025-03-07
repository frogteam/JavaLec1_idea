package com.lec.java.j15_04_상속과생성자;
/**
 * 상속받은 객체를 생성할때는 반.드.시. 부모객체부터 생성된다!!
 *
 * 상속에서 생성자 호출순서
 *   1. 자식 클래스의 생성자에서 명시적으로 부모 클래스의 생성자가
 *      호출되지 않으면, 자동으로 부모 클래스의 "디폴트 생성자"가 호출됨.
 *
 *   2. 자식 클래스의 생성자에서 명시적으로 부모 클래스의 생성자를 호출하기도 함
 *   	1) super(...) 키워드 사용 -> 부모 클래스의 생성자를 호출
 *   	2) (주의) super는 항상 제일 처음에 호출되어야 함
 *   	3) 부모 클래스에 디폴트 생성자가 없는 경우도 있을 수 있다.
 *   그런 경우에는 다른 생성자를 "반드시 명시적으로 호출"해 줘야만 함.
 */

/*
 *  		
 *	어떤 경우에 상속으로 객체를 설계하나?
 *		 HAS-A 관계 ===>  멤버로 설계
 *					Car, Tire
 * 					Car is-a Tire  (X)
 *					Tire is-a Car (X)
 *					Car has-a Tire (OK)
 *					
 * 		 IS-A 관계 ===>  상속으로 설계  
 *		 			Vehicle is-a Car  (NO)  
 *		 			Car is-a Vehicle  (OK)
 *					HybridCar is-a Car (OK)
 */

public class Inherit04Main {

	public static void main(String[] args) {
		System.out.println("상속과 생성자");
		
		System.out.println();
		// Vehicle 클래스의 인스턴스 생성
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle(100);
		
		
		System.out.println();
		// Car 클래스의 인스턴스 생성
		Car car1 = new Car();
		System.out.println("speed: " + car1.speed);
		System.out.println("oil: " + car1.oil);
		// 실행 결과:
		// 부모 클래스의 생성자(Vehicle())가 먼저 호출되고 나서,
		// 자식 클래스의 생성자(Car())가 호출된다.
		// 부모 클래스의 인스턴스가 생성되고 나서,
		// 자식 클래스의 인스턴스가 생성된다.
		
		System.out.println();
		// HybridCar 클래스의 인스턴스 생성
		HybridCar car2 = new HybridCar();
		
		
		System.out.println();
		// speed가 100인 Vehicle 인스턴스 생성
		Vehicle ve2 = new Vehicle(100);
		
		System.out.println();
		// speed=100, oil=6인 Car 인스턴스 생성
		Car car3 = new Car(100, 6);

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class











