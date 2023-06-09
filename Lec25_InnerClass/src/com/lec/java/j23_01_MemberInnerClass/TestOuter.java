package com.lec.java.j23_01_MemberInnerClass;

/*
 	Member inner class(멤버 내부 클래스)
 	
	TestOuter 클래스 내부에서 TestInner 클래스를 정의
	TestOuter: 외부 클래스(Outer Class, Enclosing Class)
	TestInner: 멤버 내부 클래스(Member Inner Class)
	1) 멤버 내부 클래스는 외부 클래스의 인스턴스가 생성된 이후에야 
	인스턴스 생성이 가능함.
	2) 멤버 내부 클래스는 외부 클래스의 모든 멤버들(private 포함)을 사용 가능
*/


// 클래스: 멤버 변수들 (+ 생성자들) + 멤버 메소드들 = 데이터 타입
public class TestOuter {
	// 멤버 변수:
	private int outerValue;
	
	// 생성자:
	public TestOuter() {}
	public TestOuter(int outerValue) {
		this.outerValue = outerValue;
	}
	
	// 메소드:
	public int getValue() {
		return outerValue;
	}
	public void setValue(int outerValue) {
		this.outerValue = outerValue;
	}

	
	// Member Inner Class 정의:
	// (수식어) class 클래스이름 { ... }
	public class TestInner {
		// 멤버 변수:
		private int innerValue;
		
		// 생성자:
		public TestInner() {}
		public TestInner(int val) {
			this.innerValue = val;
		}
		
		// 멤버 메소드:
		public void printOuterValue() {
			System.out.println("outerValue = " + outerValue);
			// 멤버 내부 클래스는 외부 클래스의 멤버를 직접 접근 가능
			
		} // end printOuterValue()
		
		public void printInnerValue() {
			System.out.println("innerValue = " + innerValue);
			
		} // end printInnerValue()
		
	} // end class TestInner
	
	
	// 외부 클래스에서 멤버내부클래스 이름 사용가능
	public TestInner createInner(int n){
		TestInner t = new TestInner();
		t.innerValue = n;   // 멤버내부클래스의 private 멤버도 사용 가능
		return t;
	}
	
} // end class TestOuter
















