package com.lec.java.j16_01_Polymorphism;
/*
 	다형성  ( Polymorphism )
 	하나의 이름의 클래스나 메소드가 '여러 가지 형태의 동작을 하는 능력'
 	
 	클래스의 다형성:
	 	한 타입의 참조변수로 여러타입의 객체를 참조 가능.
	 	조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조가능한것
	 	이를 업캐스팅(upcasting)이라 한다  -> 자식 클래스의 객체가 부모 클래스 타입으로 형변환 되는 것
 	
 	메소드의 다형성:
 		메소드 오버로딩, 메소드 오버라이딩

 */
public class Polymorphism01Main {

	public static void main(String[] args) {
		System.out.println("다형성(Polymorphism)");

		A aaa = new A();
		B bbb = new B();
		//aaa = bbb;   // 타입이 달라요!!!!

		System.out.println();
		
		// v1, c1, h1 의 타입은 다르다
		// 각각의 타입에 맞는 인스턴스 생성한뒤 대입 (참조하게 했다)
		Vehicle v1 = new Vehicle();
		Car c1 = new Car();
		HybridCar h1 = new HybridCar();
		
		// 각각의 타입에 오버라이딩 된 메소드가 동작함
		v1.displayInfo();
		c1.displayInfo();
		h1.displayInfo();
		
		System.out.println();
		

		// Vehicle 은 Car, HybridCar 의 조상클래스
		Vehicle car1 = new Car();  // 조상 <- 자손 (가능)
		// 자동차(Car)는 탈것(Vehicle)이다.   Car IS-A Vehicle
		
		Vehicle car2 = new HybridCar();  // 조상 <- 자손 (가능)
		// 하이브리드 자동차(HybridCar)는 탈것(Vehicle)이다.   HybridCar IS-A Vehicle
		
		Car car3 = new HybridCar();
		// 하이브리드 자동차(HybridCar)는 자동차(Car)이다.   HybridCar IS-A Car
		
		// car1~car3 변수 타입에 관계없이
		// '인스턴스'의 오버라이딩 된 메소드가 '알아서' 동작한다
		car1.displayInfo();
		car2.displayInfo();
		car3.displayInfo();
		//HybridCar car7 = new Vehicle();   // 자손 <- 조상 (불가)

		//------------------------------------------------------
		// '타입'으로 식별 및 접근 가능  => ex) 클래스이름.static변수
		System.out.println();
		System.out.println(car1.NAME);  // car1 의 '타입' 이 Vehicle 이니까 => Vehicle.NAME
		System.out.println(car2.NAME);  // car2 의 '타입' 이 Vehicle 이니까 => Vehicle.NAME
		System.out.println(car3.NAME);  // car3 의 '타입' 이 Car 이니까 => Car.NAME

		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class

class A{}
class B{}































