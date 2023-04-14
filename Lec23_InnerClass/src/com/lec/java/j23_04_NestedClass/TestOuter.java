package com.lec.java.j23_04_NestedClass;

public class TestOuter {
	private int value;
	private static int count = 100;
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public static class TestNested {
		
		public void displayInfo() {
			//System.out.println("value = " + value);
			// 컴파일 오류: static 클래스에서는 외부 클래스의
			// static이 아닌 멤버를 사용할 수 없다.
			
			System.out.println("count = " + count);
			// 외부 클래스에 선언된 count 변수는 static이기 때문에
			// static 내부 클래스(중첩 클래스)에서도 사용 가능
			
		} // end displayInfo()
		
		
		// nested class 안의 static 메소드!??
		public static void println() {}
		
	} // end class TestNested
	
	
} // end class TestOuter


// TestOuter: 외부 클래스(outer class, enclosing class)
// TestNested: 중첩 클래스(nested class, static inner class)








