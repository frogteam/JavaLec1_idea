package com.lec.java.instaceofoperator;

public class InstanceOf {

	// instanceof 연산다
	public static void main(String[] args) {
		InstanceOf Exam = new InstanceOf();
		String str = new String("String");
		
		double d = 3.24d;
		int i = 1;
		long l = 324L;
		float f = 3.14f;
		
		System.out.println(getType(str));
		System.out.println(getType(d));		// 어떻게 Object 매개변수에 double을 넘겨줄수 있었을까?
		System.out.println(getType(i));
		System.out.println(getType(l));
		System.out.println(getType(f));
		
	}
	
	public static String getType(Object obj)
	{
		String str = null;
		
		if(obj instanceof String)
			str = "String object";
		else if (obj instanceof Double)
			str = "Double object";
		else if (obj instanceof Integer)
			str = "Integer object";
		else if (obj instanceof Long)
			str = "Long object";
		else
			str = "Unknown object";
		
		return str;
	}

}
