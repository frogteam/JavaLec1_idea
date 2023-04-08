package com.lec.java.nullstring;

public class NullStringCompare {
	
	// 스트링을 비교해야 하는 경우가 많이 발생한다
	// 특히 매개변수로 스트링변수를 받은 경우 반드시 사전에 null 인지 체크하지 않으면
	// null pointer exception을 발생시킨다.
	// exception을 발생시키지 않는 팁 하나
	
	public static void main(String[] args) {
		String str = null;
		
		
		if(str.equals("test"))
			System.out.println("OK");

		
		if("test".equals(str))
			System.out.println("OK");
	}
}
