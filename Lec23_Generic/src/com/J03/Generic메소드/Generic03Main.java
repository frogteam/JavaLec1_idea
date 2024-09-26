package com.J03.Generic메소드;

/* Generic메소드
 *
 *   제네릭 메소드는 메소드의 선언부에 적은 타입 파라미터로
 *    '호출'할때! 타입 파라미터가 정해진다
 *
 *    이를 사용하여 '리턴 타입' 이나 '파라미터 타입'을 정할수 있다.
 *
 *   <타입파라미터..> 리턴타입 메소드명(매개변수) {...}
 *
 *   Ex)
 *    <T, R> R MethodName (T t)
 *
 */


public class Generic03Main {

	public static void main(String[] args) {
		System.out.println("Generic 메소드");

		test1(123); // 호출할때 T 가 결정된다!  123 : class java.lang.Integer
		test1(123.);
		test1(123.f);
		test1("123");

		System.out.println();
		System.out.println(test2(123).getClass());
		System.out.println(test2(123.).getClass());
		System.out.println(test2(123.f).getClass());
		System.out.println(test2("123").getClass());


		Box<String> sBox = boxing("Apple");  // Box<String> 리턴
		System.out.println(sBox.data);
		// ↑ Box<> 는 안된다...

		Box<Integer> nBox = boxing(34); // Box<Integer> 리턴
		System.out.println(nBox.data);

		var fBox = boxing(3.14f);   // Box<Float>
		System.out.println(fBox.data);


		System.out.println("\n프로그램 종료");

	} // end main()

	// static 메소드는 generic 사용 가능.
	public static <T> void  test1(T param){
		System.out.println(param + " : " + param.getClass());
	}

	public static <T> T test2(T param){
		return param;
	}


	// ※ 우선 아래 class Box<K> 부터 생성
	public static <T> Box<T> boxing(T param){
		Box<T> box = new Box<>();
		box.setData(param);
		return box;
	} // end boxing()


} // end class

class Box<K>{
	K data;
	
	public void setData(K data) {
		this.data = data;
	}
}
