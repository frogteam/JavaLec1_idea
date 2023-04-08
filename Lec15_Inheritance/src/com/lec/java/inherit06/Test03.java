package com.lec.java.inherit06;

import com.lec.java.inherit05.Test01;

// private < (default) < protected < public

public class Test03 extends Test01 {
	int num;
	
	public void showInfo() {
		//System.out.println("private = " + privateNum);
		// private 다른 클래스에서는 보이지 않는다.
		
		//System.out.println("default = " + defaultNum);
		// Test01과 Test03은 다른 패키지에 있기 때문에
		// default가 보이지 않는다.
		
		System.out.println("protected = " + protectedNum);
		// Test03은 Test01을 상속받고 있기 때문에
		// protected로 선언된 변수/메소드가 보인다.
		
		System.out.println("public = " + publicNum);
		
	} // end showInfo()
	
} // end class Test03










