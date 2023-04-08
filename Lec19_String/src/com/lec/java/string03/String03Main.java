package com.lec.java.string03;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable 클래스이고,
	 StringBuffer, StringBuilder는 mutable 클래스임


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임
		
		System.out.println("[String: immutable]");
		String str1 = "Hello";
		String str2 = str1;   //! 과연 어떻게 동작할까?
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		
		if (str1 == str2) {
			System.out.println("동일 참조");
		} else {
			System.out.println("다른 참조");
		}
		
		str1 = str1.concat("Java"); // str에 "Java" 추가후
		System.out.println("str1=:" + str1);
		System.out.println("str2=:" + str2);  // <- 과연?
		
		if (str1 == str2) {
			System.out.println("동일 참조");
		} else {
			System.out.println("다른 참조");
		}
		
		
//		과연 위에서 heap에 어떻게 저장되어 있을까?
//
//		[hello]		<- 일단 한번 만들어지면 바뀌어 지지 않는다 즉 string 'immutable'
//		[java]
//		[hellojava]  <- 새로 생긴다
//
//		반면 StringBuffer 는 mutable ! , 즉 바뀌어 질수 있다.   참조 위치가 동일하다.
		
		System.out.println();
		System.out.println("[StringBuffer: mutable]");
		StringBuffer buff1 = new StringBuffer("Hello");
		StringBuffer buff2 = buff1;
		
		System.out.println("buff1=:" + buff1);
		System.out.println("buff2=:" + buff2);
		
		if (buff1 == buff2) {
			System.out.println("동일 참조");
		} else {
			System.out.println("다른 참조");
		}		
		
		buff1.append("Java");    // mutable 객체의 메소드는 동일한 동작이라도 immutable과 이름이 다르게 설계되어 있다
								// String.concat()  vs  StringBuffer.append()
		
		System.out.println("buff1=:" + buff1);
		System.out.println("buff2=:" + buff2);
		
		if (buff1 == buff2) {
			System.out.println("동일 참조");
		} else {
			System.out.println("다른 참조");
		}			
		
		System.out.println();
		buff1.insert(3, "ABCD");
		System.out.println(buff1);
		
		System.out.println();
		System.out.println(buff1.reverse());
		
		System.out.println();
		buff1.reverse();
		buff1.delete(3, 7);   // 인덱스 3~6 까지 삭제 (7은 포함 안됨)
		System.out.println(buff1);

		// StringBuffer:
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		StringBuilder buff3 = new StringBuilder("Hello, Java!");
		System.out.println(buff3);
		buff3.append("abcdefghijklmnopqrstuvwxyz");

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












