package com.lec.java.j16_02_다형성의이점;

/* 다형성의 유용성
	다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
	부모(조상)타입 만으로도 상속된 모~든 자손 타입들을 담을수 있다.
*/

import com.lec.java.j16_01_Polymorphism.*;

public class Polymorphism02Main {

	public static void main(String[] args) {
		System.out.println("다형성의 사용 (유용성)");
		
		// 다형성에 의해서, 자손타입 객체가 조상타입으로 자동 형변환 가능!
		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();
		
		// 다형성의 유용함 1
		// 부모타입으로 모든 자손 타입들을 담을수 있다.
		Vehicle[] cars = new Vehicle[3];
		cars[0] = new Vehicle();
		cars[1] = new Car();
		cars[2] = new HybridCar();
		
		// carㄴ 라는 하나의 이름의 변수로 여러가지 타입의
		// 오버라이딩 된 메소드를 각각 동작시킬수 있다!
		for(var car : cars){
			car.displayInfo();
		}// 우왕! 한가지 타입으로 한꺼번에 처리 가능!!!
		
		// 다형성이 없었다면?  각 타입별로 변수들을 만들고 따로따로 사용해야 하는 왕불편.
		//		Vehicle car1 = new Vehicle();
		//		Car car2 = new Car();
		//		HybridCar car3 = new HybridCar();
		//		car1.displayInfo();		
		//		car2.displayInfo();
		//		car3.displayInfo();

		
		// 다형성의 유용함 2
		// 다형성의 유용함은 매개변수, 혹은 리턴 타입에도 적용된다
		// println의 매개변수로 Object의 참조변수가 넘겨지면,
		// 내부적으로 해당 클래스의 toString() 메소드가 불리게 됨
		System.out.println(car1); // println(Object)  <-- Java 의 모든 객체를 받을수 있다! (다형성!)
		System.out.println(car2);
		System.out.println(car3);
		
		Polymorphism02Main p = new Polymorphism02Main();
		System.out.println(p);
				
		System.out.println();
		
		// 다형성의 유용함 3
		Vehicle car4 = new Vehicle();
		driveCar(car4);
		//driveVehicle(car4);
		
		System.out.println();
		Car car5 = new Car();
		driveCar(car5);
		// driveCar(car5);
		
		System.out.println();
		HybridCar car6 = new HybridCar();
		driveCar(car6);


		// Car IS-A Vehicle
		// HybridCar IS-A Vehicle
		// HybridCar IS-A Car

		// instanceof 연산자
		// 용법: 변수/값 instanceof 클래스
		// 결과: true / false

		System.out.println(car1 instanceof Vehicle);  // Vehicle is-a Vehicle
		System.out.println(car2 instanceof Vehicle);  // Car is-a Vehicle
		System.out.println(car3 instanceof Vehicle);  // HybridCar is-a Vehicle
		System.out.println();
		System.out.println(car1 instanceof Car);
		System.out.println(car2 instanceof Car);
		System.out.println(car3 instanceof Car);
		System.out.println();

		System.out.println(car1 instanceof HybridCar);
		System.out.println(car2 instanceof HybridCar);
		System.out.println(car3 instanceof HybridCar);
		System.out.println();


		System.out.println("\n 프로그램 종료");
	} // end main()
	
	@Override
	public String toString() {
		return "내가 만든 클래스 *^.^*";
	}
	
	public static void driveCar(Vehicle v) {
		v.setSpeed(100);
		v.displayInfo();
	}
	// 다형성으로 인해 아래와 같은 불필요한 메소드 overloading을 줄일 수 있다.
//	public static void driveCar(Vehicle v) {
//	v.setSpeed(100);
//	v.displayInfo();
//}
//	public static void driveCar(Car v) {
//		v.setSpeed(100);
//		v.displayInfo();
//	}
//	public static void driveCar(HybridCar v) {
//		v.setSpeed(100);
//		v.displayInfo();
//	}
	
	

} // end class


/* 코드만 보아도 알아요~
 * A alpha = new B()   ←  A 는 B 의 조상타입
 * R doSomethig(K p1){..}  ← K 는 Z 의 조상타입
 * Y yaho = doSomething(new Z()) ← Y 는 R 의 조상타입
 * 
 */









































