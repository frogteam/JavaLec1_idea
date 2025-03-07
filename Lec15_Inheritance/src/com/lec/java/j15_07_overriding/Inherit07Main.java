package com.lec.java.j15_07_overriding;

/* 메소드 재정의(Overriding)
 * '상속'관계에서 '부모 클래스에 있던 메소드'를 '재정의'하는 것.
 *  부모 클래스에 있는 메소드와 매개변수 리스트가 동일해야 함 (signature 가 동일해야 한다)
 *
 *  부모 클래스에 있는 메소드와 '접근권한 수식어'가 동일할 필요는 없지만,
 *  접근권한의 범위가 축소될 수는 없다.
 *  즉, 접근권한은 같거나 더 넓은 수식어를 사용해야 함.
 *
 *  '부모측 리턴타입을 상속받은 리턴타입'으로 리턴 하는 오버라이딩 가능.
 *  (Java5 부터 등장. covariant-return type)
 *
 *    ! 메소드 오버로딩(Overloading)과 혼돈하지 말자!
 *    
 * final 메소드 : 더이상 오버라이딩 불가
 * final 클래스 : 더이상 상속 불가 
 */
public class Inherit07Main {

	public static void main(String[] args) {
		System.out.println("상속: Method Overriding(재정의)");
		
		System.out.println();
		// Person 클래스의 인스턴스 생성
		Person p1 = new Person();
		p1.setName("abc");
		p1.showInfo();
		
		
		System.out.println();
		// BusinessPerson 클래스의 인스턴스를 생성
		BusinessPerson p2 = new BusinessPerson();
		p2.setName("도라에몽"); // 부모 클래스인 Person에 있는 setName()을 사용
		p2.setCompany("(주)진구네");
		p2.showInfo(); // 메소드 overriding
		
		System.out.println();
		p2.showInfo(1); // 메소드 overloading
		
		// toSting() 결과. 이또한 overriding 가능
		System.out.println(p2);   
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class




















