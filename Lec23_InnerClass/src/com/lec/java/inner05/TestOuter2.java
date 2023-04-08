package com.lec.java.inner05;

public class TestOuter2 {
	 
	//TestOuter 클래스의 멤버 변수
	private int num = 100; // ① 
	
	// TestOuter 클래스의 멤버 메소드
	public void localMethod() {
		// 메소드 localMethod()의 지역 변수
		int num = 200; // ② 
		
		// 메소드 testLocal() 내부에서 정의된 Local inner class
		class TestLocal {
			// 지역 클래스 TestLocal의 멤버 변수
			private int num = 300; // ③
			
			// 지역 클래스 TestLocal의 멤버 메소드
			public void showNumbers() {
				
				int num = 400; // ④
				
				// TODO
				// ①, ②, ③, ④  출력 가능?
				
				// 외부 클래스의 멤버 변수 출력
				System.out.println("① num = " + TestOuter2.this.num);
				
				// 메소드의 지역 변수 출력
				System.out.println("② num = " + num);  // 불가
								
				// 로컬 내부 클래스(자기 자신)의 멤버 변수 출력
				System.out.println("③ num = " + this.num);
				
				// showNumbers() 지역변수
				System.out.println("④ num = " + num);
				
			} // end showNumbers()			
			
		} // end class TestLocal
		
		TestLocal local = new TestLocal();
		local.showNumbers();
		
	} // end localMethod()
	

} // end class TestOuter













