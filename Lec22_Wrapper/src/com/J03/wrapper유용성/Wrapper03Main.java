package com.J03.wrapper유용성;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 *     
 * 3. Wrapper 는 null 값 표현 가능
 */
public class Wrapper03Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object [] obj = new Object[5];
		
		obj[0] = Method1(new Wrapper03Main());
		obj[1] = Method1(new A());
		obj[2] = Method1(new A2());
		obj[3] = Method1(new B());		
		obj[4] = Method1(123);  // primitive type 도 받을 수 있다!
					// ↑ Auto-Boxing + Polymorphism(다형성)
		
		// 각각 출력해보면, Wrapper는 자동적으로 Auto-Unboxing 발생
		for(Object elm: obj) {
			System.out.println(elm);
		}

		// ↓ Integer를 리턴 받더라도, 실제 리턴타입이 Object 이면
		// 일단 Integer 로 형변환을 해서 Auto-Unboxing이 발생되게 해야 한다 
		int num = (Integer)Method1(200) * 3;   // 이경우 (int) 로 바로 형변환 해도 된다.
		System.out.println(num);

		System.out.println("\n프로그램 종료");
	} // end main
	
	public static Object Method1(Object arg) { return arg; }

} // end class

class A{}
class A2 extends A{}
class B{}
