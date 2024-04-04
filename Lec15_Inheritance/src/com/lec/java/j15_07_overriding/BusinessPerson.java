package com.lec.java.j15_07_overriding;

public class BusinessPerson extends Person {

	// 멤버 변수
	private String company;

	// getter & setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	// 메소드 재정의(Overriding)
	// 부모 클래스에 있는 메소드를 다시 정의하는 것.
	// 부모 클래스에 있는 메소드와 매개변수 리스트가 동일해야 함
	// 부모 클래스에 있는 메소드와 접근권한 수식어가 동일할 필요는 없지만,
	// 접근권한의 범위가 축소될 수는 없다.
	// 즉, 접근권한은 같거나 더 넓은 수식어를 사용해야 함.
	@Override
	//void showInfo() { // 에러 접근권한범위가 더 좁아질수는 없다.
	protected void showInfo() {  // OK  동일한 접근권한 
//	public void showInfo() {  //  OK  더 넓은 접근권한
		super.showInfo();
		System.out.println("회사: " + company);
	} // end showInfo()
	
	
	// 메소드 중복정의(Overloading)
	// 1. 매개변수의 타입이 다르거나
	// 2. 매개변수의 개수가 다를 때
	// 3. 매개변수의 순서를 달리하여
	// 같은 이름으로 (다른 기능을 하는) 메소드를 중복 정의하는 것
	public void showInfo(int id) {
		System.out.println("id: " + id);
		System.out.println("이름: " + getName());
		System.out.println("회사: " + company);
	}
	
//	@Override
//	public void whoAreYou() {
//		// TODO Auto-generated method stub
//		super.whoAreYou();
//	}

	// Object 의 메소드들도 오버라이딩 가능!!\
	@Override
	public String toString() {
		return "BusinessPerson:" + getName() + " " + getCompany();
	}

	// IntelliJ 에서 Override 코드 작성 방법들
	// 1. 메소드 이름 타이핑하면서 자동완성 
	// 2. CTRL + O 누르면 Override 창 뜬다.
	// 3. ALT + INSERT, Override 실행

	
	
	
} // end class BusinessPerson












