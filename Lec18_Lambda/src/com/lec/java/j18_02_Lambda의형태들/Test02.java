package com.lec.java.j18_02_Lambda의형태들;

@FunctionalInterface
interface Test02 {
	// 매개변수 있고, 리턴값 없는 추상메소드
	public abstract void testPrint(int num);
	
} // end interface Test02


class Test02Imple implements Test02 {

	@Override
	public void testPrint(int num) {
		System.out.println("num = " + num);
		
	} // end testPrint()
	
} // end class Test02Imple



