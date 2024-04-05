package com.lec.java.j15_07_overriding;

public class Person {
	// 멤버 변수
	private String name;
	
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// 메소드
	protected void showInfo() {
		System.out.println("이름: " + name);
	}
	
	// final 이 메소드 앞에 붙으면
	// 더 이상 오버라이딩 불가!!
	public final void whoAreYou() {
		System.out.println("이름: " + name);
	}
	
	
	// final 메소드 : 더이상 오버라이딩 불가
	// public final void showInfo()  <-- 해보자. 어디에 에러나는가?
	
	// final 클래스 : 더이상 상속 불가 
	// final class Person     <-- 해보자, 어디에 에러나는가?


	//--------------------------------------------------
	// 리턴타입이 자손 타입으로는 오버라이딩 가능
	public Person myPerson(){
		return new Person();
	}

} // end class Person









