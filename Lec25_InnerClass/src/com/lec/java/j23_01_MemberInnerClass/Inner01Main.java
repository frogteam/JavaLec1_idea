package com.lec.java.j23_01_MemberInnerClass;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");
		
		// 외부 클래스의 인스턴스 생성
		TestOuter out = new TestOuter(100);
		
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		//      [외부클래스 인스턴스].new 내부클래스 생성자();
		TestOuter.TestInner in = out.new TestInner(111);
		in.printOuterValue();
		in.printInnerValue();
		
		// 하나의 외부 클래스 인스턴스를 이용해서
		// 멤버 내부 클래스의 인스턴스는 여러개를 생성할 수 있다.

		// TODO
		// out 으로부터 TestInner 객체들을 만들어 보세요
		// 이름은 in2, in3 ...
		// 각각에 대해 printInnerValue(), printOuterValue()
		// 결과 확인해보세요
		System.out.println();
		TestOuter.TestInner in2 = out.new TestInner(123);
		in2.printOuterValue();
		in2.printInnerValue();
		
		System.out.println();
		TestOuter.TestInner in3 = out.new TestInner(125);
		in3.printOuterValue();
		in3.printInnerValue();
		
		
		System.out.println();
		
		// TODO
		// 새로운 외부 클래스 인스턴스 생성
		// out2 외부 클래스 인스턴스 생성
		//  out2 로부터 in4, in5 라는 이름으로 내부 클래스 객체 만드세요.

		TestOuter out2 = new TestOuter(200);
		TestOuter.TestInner in4 = out2.new TestInner(201);
		in4.printOuterValue();
		in4.printInnerValue();
		
		TestOuter.TestInner in5 = out2.new TestInner(202);
		in5.printOuterValue();
		in5.printInnerValue();

		TestOuter.TestInner in6 = out2.createInner(303);
		in6.printOuterValue();
		in6.printInnerValue();

		// ※ Map.Entry<K,V>

		// 다음과 같이 한번에 outer/inner 생성 가능
		TestOuter.TestInner in7 = new TestOuter(30).new TestInner(330);
		in7.printOuterValue();
		in7.printInnerValue();
		
	} // end main()

} // end class Inner01Main

















