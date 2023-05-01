package com.J03.Generic메소드;

/* Generic메소드
 *   <T, R> R Method (T t)
 *   <타입파라미터..> 리턴타입 메소드명(매개변수) {...}
 */

// 참조: https://futurecreator.github.io/2018/08/12/java-generics/
//      와일드 카드 <?>   
//		upper-bounded <? extends Number>
//		lower-bounded <? super Integer> 
//		generic 사용 <? extends T>
//		generic 인터페이스

public class Generic03Main {

	public static void main(String[] args) {
		System.out.println("Generic 메소드");
		
		// TODO
		
		System.out.println("\n프로그램 종료");

	} // end main()
	
	// ※ 우선 아래 Box<K> 부터 생성
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setData(t);
		return box;
	} // end boxing()
	

} // end class

class Box<K>{
	K data;
	
	public void setData(K data) {
		this.data = data;
	}
}
