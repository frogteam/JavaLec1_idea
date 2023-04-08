package com.lec.java.oop07;

public class Interface03Main {

	public static void main(String[] args) {
		System.out.println("인터페이스와 다형성");
		
		System.out.println();
		// 클래스 TestImple의 인스턴스를 생성
		// TestImple 클래스에서 정의된 모든 메소들을 사용 가능 
		TestImple t1 = new TestImple();
		t1.testAAA();
		t1.testBBB();
		
		System.out.println();
		InterfaceAAA t2 = new TestImple();
		t2.testAAA();
		// 인스턴스는 TestImple 타입으로 생성됐지만,
		// 참조변수의 선언이 InterfaceAAA 타입으로 선언됐기 때문에
		// testAAA()만 보이고, testBBB()는 보이지 않는다.
		// 형변환(Casting)을 통해서 InterfaceBBB에 선언된 메소드를 사용 가능
		((TestImple) t2).testBBB();
		
		System.out.println();
		InterfaceBBB t3 = new TestImple();
		t3.testBBB();
		((TestImple) t3).testAAA();

		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class











































