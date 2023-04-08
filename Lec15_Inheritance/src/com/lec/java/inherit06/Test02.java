package com.lec.java.inherit06;

import com.lec.java.inherit05.Test01;

public class Test02 {
	int num;
	
	public void showInfo() {
		Test01 t = new Test01();
		
		//System.out.println(t.privateNum);
		// private은 다른 클래스에서 사용 불가
		
		//System.out.println(t.defaultNum);
		// Test01과 Test02가 다른 패키지에 있기 때문에
		// default도 사용 불가
		
		//System.out.println(t.protectedNum);
		// Test01과 Test02는 상속 관계에 있지도 않기 때문에
		// protected도 사용 불가
		
		System.out.println(t.publicNum);
		
	} // end showInfo()
	
} // end class Test02












