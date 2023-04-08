package com.lec.java.oop09;


// 메소드 오버라이딩에서 리턴타입의 다형성 문제:
// 원칙적으로 상속관계에서 메소드 오버라이딩은  리턴타입, 메소드 이름, 매개변수 리스트과 완전히 동일해야 이루어진다.
// 그러나 리턴 타입에 있어서는 다형성의 법칙이 적용되어, 자동 형변환이 발생할수 있다면 이는 허용이 된다.
// 다형성  [ 부모타입 ← 자식타입 리턴 ] 이 가능하다. 

interface A {
	public void doSomething(String thing);
}

class AImpl implements A{
	@Override
	public void doSomething(String thing) {
	}
}

class B {
	public A doIt(){return null;}
	public String execute(){return null;}
}

public class C extends B{
	
	// 아래 두 개의 문장중 하나는 에러가 난다?  과연?
	//public AImpl doIt(){ return null; }
	//public Object execute(){ return null; }
}	
	
	
	// A
	// └ AImpl

	// Object
	// └ String  
	

