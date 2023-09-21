package com.lec.java.j13_04_this;
/*
   클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

   메소드 체이닝 (method chaining)
 	자기자신을 리턴하여, 연이어 메소드
 	호출 가능케 하는 메소드 설계
 	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/
public class Class04Main {

	public static void main(String[] args) {
		System.out.println("this & 메소드 체이닝");
		
		// 클래스 타입의 변수 선언, 인스턴스 생성
		// 클래스이름 변수이름 = new 생성자();
		Number n1 = new Number(); // 디폴트 생성자 사용
		System.out.println("n1.num = " + n1.getNum());
		
		// 지역변수: 메소드 안에서 선언된 변수
		int num; // 선언만 하고 초기화하지 않은 지역변수
		//System.out.println("num = " + num); // 컴파일 오류
		// 지역변수는 사용하기 전에 반드시 초기화가 되어야 함.
		// 클래스의 멤버변수(n1.num)는 클래스의 인스턴스가 생성될 때
		// 자동으로 초기화가 됨.
		
		System.out.println();
		Number n2 = new Number(123); // 매개변수가 있는 생성자
		System.out.println("n2.num = " + n2.getNum());
		
		System.out.println();
		System.out.println("메소드 사용");
		System.out.println("n1: " + n1.getNum());
		System.out.println("n2: " + n2.getNum());
		
		System.out.println();
		n1.setNum(100);
		System.out.println("n1: " + n1.getNum());
		n2.setNum(111);
		System.out.println("n2: " + n2.getNum());
		
		System.out.println();
		n1.add(n2);
		System.out.println("n1: " + n1.getNum());
		System.out.println("n2: " + n2.getNum());
		
		System.out.println();
		n1.setNum(10);
		n2.setNum(20);
		Number n3 = new Number(30);
		n1.add(n2).add(n3);  // 메소드 체이닝
		System.out.println("n1.num = " + n1.getNum());
		
		
		System.out.println();
		n1.setNum(10);
		n2.setNum(20);
		n3.setNum(30);
		n1.add(n2).sub(n3); // 메소드 체이닝
		System.out.println("n1.num = " + n1.getNum());
		
		
		// 메소드 체이닝이 유용한 경우.
		// 아래와 같이 다량의 필드를 setter 메소드로 일일이 호출하는것이 번거로울때.. 
		Number n4 = new Number();
		n4.setNum1(10);
		n4.setNum2(20);
		n4.setNum3(30);
		n4.setNum4(40);
		n4.setNum5(50);
		n4.setNum6(60);
		
		// 메소드 체이닝은 한줄로 해결된다..
		n4.setNum1(10).setNum2(20).setNum3(30).setNum4(40).setNum5(50).setNum6(60);

		// 문자열 메소드도 체이닝 되어 있다.
		String str = "Hello";
		str = str.toUpperCase().substring(0, 4).replace("H", "S");
		System.out.println(str);

		System.out.println("프로그램 종료");
	} // end main()

} // end class Class04Main










