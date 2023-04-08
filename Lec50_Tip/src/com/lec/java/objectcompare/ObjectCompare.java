package com.lec.java.objectcompare;

public class ObjectCompare {

	
	// 객체가 서로 같은지 비교하는 방법 3가지
	// 1. '==' 연산자
	//    ex) obj1 == obj2
	//    JVM 메모리에 있는 메모리 주소가 같은지 체크
	// 2. equals() 메소드
	//    ex) obj1.equals(obj2)
	//    obj1 과 obj2 의 데이터 값이 같으면 true
	//    이는 오버라이딩 하여 재정의 가능하다
	// 3. instanceof 연산자
	//    ex) obj instanceof [클래스이름]
	//    주로 상속과 다형성 상황에서 체크할때 사용
	
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		
		if(str1 == str2)
			System.out.println("str1 == str2 같습니다");
		if(str1 == str3)
			System.out.println("str1 == str3 같습니다");
		if(str1.equals(str3))
			System.out.println("str1.equals(str3) 같습니다");
		if(str1.hashCode() == str3.hashCode() )
			System.out.println("str1.hashCode() == str3.hashCode()  같습니다");
		if(System.identityHashCode(str1) == System.identityHashCode(str3))
			System.out.println("System.identityHashCode(str1) == System.identityHashCode(str3)  같습니다");
		
	}

}
