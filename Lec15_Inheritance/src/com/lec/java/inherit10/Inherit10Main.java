package com.lec.java.inherit10;

/*
  final 메소드 
	더이상 오버라이딩 될수 없는 메소드
*/

/*
  메소드 오버라이딩(Overriding), 재정의
  부모 클래스에 있는 메소드를
  자식 클래스에서 리턴 타입, 매개변수 모두 동일하게 유지하면서
  메소드의 본체를 다시 정의하는 것
  접근권한(private, (default), protected, public)도 동일하게 유지하는 것이
  일반적이지만,
  접근 범위를 더 넓게 변경하는 것은 가능. 하지만 좁히는 것은 허용 안됨.
 */
public class Inherit10Main {

	public static void main(String[] args) {
		System.out.println("final 메소드");
		
		// TestSuper 클래스의 인스턴스 생성
		TestSuper t1 = new TestSuper();
		//t1.test1(); // private 메소드는 다른 클래스에서 사용 불가
		t1.test2();
		t1.test3();
		t1.test4();
		
		System.out.println();
		// TestSub 클래스의 인스턴스 생성
		TestSub t2 = new TestSub();
		t2.test2();
		t2.test3();
		t2.test4();

		System.out.println();
		System.out.println("toString() 메소드");
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
	} // end main()

} // end class Inherit10Main


class TestSuper {
	
	@Override
	public String toString() {
		return "TestSuper 인스턴스";
	}
	
	private void test1() {
		System.out.println("부모 private 메소드");
	}
	void test2() {
		System.out.println("부모 default 메소드");
	}
	protected void test3() {
		System.out.println("부모 protected 메소드");
	}
	public void test4() {
		System.out.println("부모 public 메소드");
	}
	
	public final void testFinal() {
		System.out.println("부모 final 메소드");
	}
	
} // end class TestSuper

// private < (default) < protect < public
class TestSub extends TestSuper {
	
	@Override
	public String toString() {
		
		return "TestSub 인스턴스";
	}
	
	@Override
	public void test2() {
		System.out.println("자식클래스 test2");
	}

	@Override
	public void test3() {
		System.out.println("자식클래스 test3");
	}
	
	@Override
	public void test4() {
		System.out.println("자식클래스 test4");
	}
	
	//public final void testFinal() { }
	// 부모 클래스에서 final로 선언된 메소드는
	// 자식 클래스에서 override(재정의)할 수 없다.
	
} // end class TestSub













