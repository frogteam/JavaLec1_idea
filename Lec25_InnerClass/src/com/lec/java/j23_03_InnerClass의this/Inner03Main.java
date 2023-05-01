package com.lec.java.j23_03_InnerClass의this;

public class Inner03Main {

	public static void main(String[] args) {
		System.out.println("외부/내부 클래스의 this");
		
		// TODO
		// out 라는 이름의 TestOuter 객체 생성
		// in1, in2 라는 TestInner 객체 새성
		// printValue() 호출해서 확인

		TestOuter out = new TestOuter(100);  // 1.
		TestOuter.TestInner in1 = out.new TestInner(111); // 2.
		in1.printValue(10);  // 3.
		
		System.out.println();
		TestOuter.TestInner in2 = new TestOuter(200).new TestInner(222);
		in2.printValue(20);
		
		System.out.println();
		// in3 인스턴스는 in1과 외부 클래스의 인스턴스를 공유
		TestOuter.TestInner in3 = out.new TestInner(333);
		in3.printValue(30);
		
		// in4 인스턴스는 in2와 별개의 외부 클래스 인스턴스를 통해서 생성된 것임.
		TestOuter.TestInner in4 = new TestOuter(211).new TestInner(444);
		in4.printValue(40);

	} // end main()

} // end class Inner03Main

















