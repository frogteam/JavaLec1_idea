package com.lec.java.j13_04_this;

/*
  클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

  메소드 체이닝 (method chaining)
	자기자신을 리턴하여, 연이어 메소드
	호출 가능케 하는 메소드 설계
	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/

public class Number {
	// 멤버 변수: 클래스에서 선언된 변수
	private int num = 100;   // 멤버변수 선언시 초깃값 명시 가능
	
	// 생성자
	// 아무런 생성자가 만들어져 있지 않은 경우에는 
	// 디폴트 생성자가 자동으로 만들어 짐.
	public Number() {}
	
	public Number(int num) {
		this.num = num;
		// 매개변수로 받은 num의 값을
		// 클래스의 멤버변수인 num(this.num)에 저장
	}
	
	// 메소드
	public int getNum() {
		return this.num; // return num;
	}
	public void setNum(int x) {
		this.num = x;
	}
	
	
	public Number add(Number x) {
		this.num += x.num; // num = num + x.num;
		return this;  // <-- 메소드 체이닝의 핵심
	}
	
	public Number sub(Number x) {
		this.num -= x.num; // num = num - x.num;
		return this;
	}
	
	// set 해야 할 멤버변수가 많~은 경우
	// setter 들도 메소드 체이닝 하면 편리하다
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;

	public Number setNum1(int num1) {
		this.num1 = num1;
		return this;
	}

	public Number setNum2(int num2) {
		this.num2 = num2;
		return this;
	}
	public Number setNum3(int num3) {
		this.num3 = num3;
		return this;
	}
	public Number setNum4(int num4) {
		this.num4 = num4;
		return this;
	}
	public Number setNum5(int num5) {
		this.num5 = num5;
		return this;
	}
	public Number setNum6(int num6) {
		this.num6 = num6;
		return this;
	}

	
} // end class Number











