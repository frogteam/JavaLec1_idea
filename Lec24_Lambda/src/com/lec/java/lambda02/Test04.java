package com.lec.java.lambda02;

@FunctionalInterface
interface Test04 {
	public abstract int myStrLen(String str);
	
} // end interface Test04


class Test04Imple implements Test04 {
	@Override
	public int myStrLen(String str) {

		return str.length();
	} // end myStrLen
	
} // end class Test04Imple