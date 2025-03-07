package com.lec.java.j12_01_메소드정의;

/* 메소드 (Method):
  		반복되는 코드, 내용, 재사용해야할 코드들을 한 뭉치로 묶어서
 		따로 메소드로 만들은 다음(정의) 이를 필요할때마다 사용(호출)한다. 
 		
 		※ 자바는 '함수(function)' 가 따로 없습니다
 		  그러나 교육하면서 편의상, 혼용하여 말하겠습니다.
 		
	 메소드 정의:
	 	메소드는 main 메소드 바깥에서!!, class 안에서 정의!!

	 메소드 정의구문:
		수식어     리턴타입     메소드이름 (매개변수, ...) { ...본체... }
	    modifier return_type  method_name(parameter, ...) { ...body... }
	
		수식어(modifier) : public, static, private, ... (생략 가능)
	   
		매개변수 (parameter) : 메소드 호출시 넘겨주는 값.

				parameter (매개변수) - 호출받는 쪽에서 받아내는 값.
				argument (인자)  - 호출하는 측에서 전달하는 값

		리턴타입 (return type) : 메소드 종료후 호출한 쪽에 돌려주는 값
			void, int, double, String ...
			(리턴타입 void의 의미는 되돌려주는 값(return 값)이 없다는 의미)
	
	메소드 signature 란?:
		메소드 이름 + 매개변수 리스트 (매개변수 타입, 순서, 개수)
			sayAge(int)
			sayHello3(String, int)
			
*/

public class Method01Main {
	
	public static void main(String[] args) {
		System.out.println("메소드(함수) Method(Function)");
		
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 성쌤입니다.");
		
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 조은이입니다.");

		System.out.println();
		System.out.println("메소드 호출(사용)");
		sayAnthem();  // sayAnthem 메소드 호출
		
		// 메소드 sayHello(String) 호출 (method call, method invoke)
		sayHello("정예경");
		sayHello("김진후");
//		sayHello();  // 에러
//		sayHello(123);  // 에러


		System.out.println();
		// 메소드 sayAge() 호출
		sayAge(16);
		sayAge(20);
		
		System.out.println();
		// 메소드 sayHello2() 호출
		sayHello2("성쌤", 20);
		sayHello2("기석", 27);
		// sayHello2(34, 77);   // 에러다, 매개변수 불일치   not applicable for the arguments
		
		System.out.println();
		// 메소드 sayHello3() 호출
		sayHello3("성연철", 20);
		
		System.out.println("\\n프로그램 종료");
	} // end main()

	public static void sayAnthem(){
		System.out.println("""
    			동해물과 백두산이
    			마르고 닳도록
    			하느님이 보우하사
    			우리나라 만세""");
	}

	//   메소드이름: sayHello
	//   매개변수: name (매개변수가 필요없는 경우에는 생략 가능)
	// 메소드 위에 아래와 같이 javadoc 타입 주석 달수 있다.
	/**
	 * 메소드이름: sayHello
	 * 주어진 이름을 출력합니다
	 * @param name  이름
	 */
	public static void sayHello(String name) {
		System.out.println("안녕하세요.");
		System.out.println("제 이름은 " + name + " 입니다.");
	} // end sayHello()
	
	// 메소드 이름: sayAge
	// 매개변수: int 타입의 age
	// 리턴타입: void(리턴값이 없다)
	public static void sayAge(int age) {
		System.out.println("Hi~");
		System.out.println("제 나이는 " + age + "입니다.");
	} // end sayAge()
	
	// 메소드 이름: sayHello2
	// 매개변수:
	//   1) String name
	//   2) int age
	// 리턴타입: void
	public static void sayHello2(String name, int age) {
		System.out.println("안녕!");
		System.out.println("내 이름은 " + name + " 입니다");
		System.out.println("내 나이는 " + age + "살 입니다");
	} // end sayHello2()
	
	// 메소드 이름: sayHello3
	// 리턴타입: void
	// 매개변수:
	//   1) String name
	//   2) int age
	
	/**
	 * JavaDoc
	 * 매개변수]
	 * @param name : 이름
	 * @param age : 나이
	 * 이름과 나이를 출력합니다
	 * 리턴값 : void
	 */
	public static void sayHello3(String name, int age) {
		sayHello(name); // sayHello3 가 sayHello 를 호출
		sayAge(age); // sayHello3 가 sayAge 를 호출
	} // end sayHello3()

} // end class

/*
 * IntelliJ 단축키 : 메소드 이름위에서 (호출, 정의)
 *     CTRL + B : Declaration or Usage
 *  ALT + F7 : Find Usage
 *  ALT + ↑, ALT + ↓ : 메소드 단위 커서 이동
 *  CTRL + SHIFT + ↑, CTRL + SHIFT + ↓ : 메소드 이동
 *  CTRL + P : parameter info
 *
 * 디버깅 :
 *   step into : 현재 디버깅 위치의 메소드 호출 내부 코드 진입
 *   step out (step return) : 현재 디버깅 진행중인 메소드 return 까지 진행후 호출한 측으로 돌아감
 *   resume : 다음 breakpoint 까지 쭈욱 진행
 */









