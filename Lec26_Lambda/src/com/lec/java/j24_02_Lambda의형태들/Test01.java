package com.lec.java.j24_02_Lambda의형태들;

@FunctionalInterface
interface Test01 {
	// 매개변수도 없고, 리턴값도 없는 추상메소드
	public abstract void testPrint();
	
} // end interface Test01


class Test01Imple implements Test01 {

	@Override
	public void testPrint() {
		System.out.println("안녕하세요~~~");
		
	} // end testPrint()
	
} // end class Test01Imple








