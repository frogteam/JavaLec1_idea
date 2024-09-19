package com.lec.java.j13_03_getter_setter;

// boolean 타입의 getter, setter 는
// 네이밍이 살짝 다르다.

// ※ 참고: boilerplate code
// 컴퓨터 프로그래밍에서 보일러플레이트 또는 보일러플레이트 코드라고 부르는 것은
// 최소한의 변경으로 여러곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드를 말한다.
// 참고: https://charlezz.medium.com/%EB%B3%B4%EC%9D%BC%EB%9F%AC%ED%94%8C%EB%A0%88%EC%9D%B4%ED%8A%B8-%EC%BD%94%EB%93%9C%EB%9E%80-boilerplate-code-83009a8d3297
public class Numeric{
	private char ch;
	private byte operator;
	private int operand1;
	private int operand2;
	
	// IntelliJ 의  generator 를 사용하면 손쉽게 자동 코드 생성
	// ALT + INSERT : 생성자, getter, setter 등..
	
	public Numeric() {
		super();
	}

	public Numeric(char ch, byte operator, int operand1, int operand2) {
		super();
		this.ch = ch;
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public byte getOperator() {
		return operator;
	}
	public void setOperator(byte operator) {
		this.operator = operator;
	}
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	public int getOperand2() {
		return operand2;
	}
	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
	


	

}
