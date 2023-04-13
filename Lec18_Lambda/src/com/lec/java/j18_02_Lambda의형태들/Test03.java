package com.lec.java.j18_02_Lambda의형태들;

@FunctionalInterface
interface Test03 {
	// 매개변수 있고, 리턴값 있는 추상메소드
	public abstract int max(int n1, int n2);
	
} // end interface Test03


class Test03Imple implements Test03 {
	@Override
	public int max(int n1, int n2) {
		if (n1 > n2) {
			return n1;
		} else {
			return n2;
		}
		
//		return (n1 > n2) ? n1 : n2;
	} // end max()
	
} // end class Test03Imple










