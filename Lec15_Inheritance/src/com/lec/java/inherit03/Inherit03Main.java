package com.lec.java.inherit03;

/* java.lang.Object
 * 	자바의 모든 클래스는 java.lang.Object로부터 상속 받는다.
 *  java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
 *  Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
 */
public class Inherit03Main {

	public static void main(String[] args) {
		System.out.println("상속 연습");
		System.out.println("java.lang.Object");

		
		System.out.println();
		// Person 클래스의 인스턴스 생성
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.whoAmI();
		
		System.out.println();
		// BusinessPerson 클래스의 인스턴스 생성
		BusinessPerson p2 = new BusinessPerson();
		p2.name = "허균";
		p2.whoAmI();
		
		// 자바의 모든 클래스는 java.lang.Object로부터 상속 받는다.
		// java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
		// Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
		System.out.println(p2.toString());  // // toString 은 Object 의 메소드
		System.out.println(p2);  // 내부적으로 toString() 결과를 출력하였더라..

		System.out.println();
		p2.company = "(주)재택";
		p2.showInfo();
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

// IntelliJ 계층도 보기 : 클래스 이름 위에서 cTRL + H









