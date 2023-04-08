package com.lec.java.inner07;

/* Anonymous inner class(익명 내부 클래스):
 * 	이름이 없는 local inner class
 * 	이름이 없기 때문에 생성자로 만들 수가 없습니다.
 * 	클래스의 정의와 동시에 인스턴스를 생성합니다.
 * 
 * 익명 내부 클래스:
 * 	인스턴스 생성과 동시에 이름없는 클래스가 정의됨.
 * 
 * 	new 인터페이스() { 익명 클래스 내부 작성 };
 * 	new 부모클래스() { 익명 클래스 내부 작성 };
 * 
 * 익명 내부 클래스 (Anonymous Inner class) 는
 * 인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
 *  상속 받은 (이름없는) 클래스의 인스턴스를 생성.
 *  - 멤버 변수/ 메소드 선언
 *  - 메소드 오버라이딩 
 *  
 *  익명클래스는 기본적으로 local inner class 이기에
 *  동일 scope 의 지역변수를 사용할때는
 *  그 지역변수는 effective final 이어야 한다
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		
		Person p = new Person("QWERTY");
		MyReadable r = p.createInstance(20);
		r.readInfo();  // 주인공은 readInfo()  메소드다.  이 메소드가 정의 되어 공급받은 거다.
		

		//------------------------------------------------
		System.out.println();
		MyReadable r2 = new MyReadable() {
			int a = 10;   // 익명클래스에서 멤버변수 추가
			
			@Override
			public void readInfo() {
				System.out.println("readInfo()");
				System.out.println("a = " + a);
				 
			}
		};
		r2.readInfo();
		
		// 익명클래스라서 toString() 보아도 클래스 이름은 안보인다
		System.out.println(r2);  // com.lec.java.inner07.Anonymous01Main$1@69222c14
		
		int n = 12; // effective final 은 사용 가능
		new MyReadable() {
			int a = 200;  // 익명클래스에 추가할 멤버변수 추가 가능!

			@Override
			public void readInfo() {
				System.out.println(a + 100 + n);
			}			
		}.readInfo();
		
		//------------------------------------------------
		System.out.println();
		System.out.println(new MyClass().methodA(30));
		System.out.println(new MyClass() {
			int d = 400;

			@Override
			int methodA(int c) {
				return a + b + c + d;
			}
			
		}.methodA(30));
		
		int k = 300;
//		k = 150;   // 익명클래스는 기본적으로 local inner class 이기에
				// 동일 scope 의 지역변수를 사용할때는
				// 그 지역변수는 effective final 이어야 한다
		int result = new MyAbstract() {

			@Override
			int methodA(int a) {
				return a + n + d + k;
			}
			
		}.methodA(100);
		System.out.println("result = " + result);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


// 익명 내부 클래스 (Anonymous Inner class) 는
// 인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
// 상속 받은 (이름없는) 클래스의 인스턴스를 생성.
// 	- 멤버 변수/ 메소드 선언
// 	- 메소드 오버라이딩 

abstract class MyAbstract{
	int n = 10;
	int d = 2;
	
	abstract int methodA(int a);
} // end class

class MyClass {
	int a = 10;
	int b = 20;
	
	int methodA(int c) {
		return a + b + c;
	}
} // end class

















