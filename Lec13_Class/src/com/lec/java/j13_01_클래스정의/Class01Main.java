package com.lec.java.j13_01_클래스정의;

/**
 *  클래스 정의 및 사용
 *
 *  우리가 만든 클래스를 사용하려면,
 * 	그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
 *
 * 	구문
 * 		클래스이름 변수이름 = new 생성자();
 * 		생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
 *
 *  new 로 생성하는 instance 들은
 *  	지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
 *  	특별히 초기화를 할 값들이 지정되어 있지 않을 때는
 *  	각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
 *  		boolean -> false, 숫자타입(int, double, ...) -> 0
 *  		String, 참조 타입(클래스) -> null
 *
 *  지역변수: 메소드 안에서 선언된 변수
 *  	지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
 */
public class Class01Main {

	public static void main(String[] args) {
		System.out.println("클래스 생성 & 사용");
		
		
		// 우리가 만든 클래스를 사용하려면,
		// 그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
		// 구문
		//    클래스이름 변수이름 = new 생성자();
		// 생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
		
		int num = 1;
		int[] arr = new int[5];
		
		MyTV tv1 = new MyTV();
		tv1.displayStatus();
				
		// new 로 생성하는 instance 들은
		// 지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
		// 특별히 초기화를 할 값들이 지정되어 있지 않을 때는
		// 각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
		// boolean -> false, 숫자타입(int, double, ...) -> 0
		// String, 참조 타입(클래스) -> null
		
		// 지역변수: 메소드 안에서 선언된 변수
		// 지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
		
		// tv1 변수는 main() 메소드의 지역변수이며, 레퍼런스타입 변수다
		// 따라서 스택 메모리 영역에 위치하며, 담고 있는 값은 인스턴스의 주소값이다.
		System.out.println(tv1);
		
		// TV를 켜보자...
		tv1.powerOnOff();
		
		// 볼륨 조정
		tv1.volumeUp();
		tv1.volumeDown();
		
		// 채널 조정
		tv1.channelUp();
		tv1.channelDown();
		
		// TV를 꺼보자...
		tv1.powerOnOff();
		
		
		// 일반적으로 
		// 멤버변수(필드)는 private 으로 설정. 
		// 멤버메소드는 public 으로 설정.

		// private의 경우 외부 클래스에서 직접적으로 사용 불가.
		// public 의 경우 외부 클래스에서 사용 가능
//		tv1.channel = 15;
//		tv1.volume = 32;
//		tv1.isPowerOn = true;
//		
		System.out.println();
		tv1.displayStatus();
		
		System.out.println();
		MyTV tv2 = new MyTV();  // 새로운 MyTV 인스턴스 생성
		tv2.powerOnOff();
		tv2.channelUp();
		tv2.volumeUp();
		tv2.volumeUp();

		System.out.println("tv1:" + tv1);
		System.out.println("tv2:" + tv2);
		// tv1 과 tv2 는 동일 타입이긴 하나 , 서로 다른 인스턴스다 => 주소값 다르다 => 서로 다른 인스턴스를 참조(reference) 한다.
		System.out.println("tv1 == tv2 : " + (tv1 == tv2));

		tv1 = tv2;		// 어떻게 되나
		tv1.displayStatus();
		tv1.powerOnOff();
		tv2.displayStatus();	// tv1 과 tv2는 같은 인스턴스를 레퍼런싱 하고 있다.
		
		System.out.println("tv1 과 tv2 는 같은 인스턴스를 참조(reference)하고 있다");
		System.out.println("tv1:" + tv1);
		System.out.println("tv2:" + tv2);
		
		System.out.print(" == 비교 결과: ");
		if(tv1 == tv2) 
			System.out.println("같은 참조");
		else 
			System.out.println("다른 참조");
		
		
		Class01Main c1 = new Class01Main();
//		sayHello();
		
		c1.sayHello();

		System.out.println("\n프로그램 종료");
	} // end main()
	
	public void sayHello() {
		System.out.println("hello");
	}
	
} // end class










