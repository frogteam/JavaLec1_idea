package com.J02.Generic클래스;

/* 제네릭 클래스의 타입
 * 	제네릭 클래스에서 사용되는 타입은 
 * 	기본 자료형(primitive type)은 사용될 수 없고,
 * 		Object 타입의 자료형들만 올 수 있음.
 * 		(예) int는 사용할 수 없고, Integer를 사용해야 함
 * 		(예) double은 사용할 수 없고, Double을 사용해야 함
 *
 *   static 필드에는 generic 사용 불가.
 *
 *  관례적으로 자주 사용하는 타입파라미터 명
 * 	<T>	Type
 * 	<E>	Element
 *  <K>	Key
 *  <N>	Number
 *  <V>	Value
 *  <R>	Result
 */
public class Generic02Main {

	public static void main(String[] args) {
		System.out.println("Generic 클래스 2");
	
		System.out.println();
		//Test<int, String> t1;  // 불가
		Test<Integer, String> t1 = 
				new Test<>(123, "Hello, Java!");
		t1.display();
		System.out.println(Test.num); // static

		Test t5 = new Test(10, "hhh");
		
		// TODO
		// 정수값과 실수값을 건네받은 Test<T,U> 객체 생성
		// 적절한 값으로 초기화해서 display() 출력까지 해보세요
		System.out.println();
		Test<Integer, Double> t2 =
				new Test<>(111, 3.14);
		t2.display();

		System.out.println("\n프로그램 종료");
	} // end main

} // end class Collection02Main

class Test<T, U> {
	T item1;
	U item2;

	static int num = 111;
	// static T item3;    // static 필드에는 generic 사용 불가.
	
	public Test(T item1, U item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public void display() {
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
	}
	
} // end class Test








