package com.lec.java.access03;

import com.lec.java.access04.TestPublic2;

// 다른 패키지의 (default) 클래스는 import할 수 없다.
//import com.lec.java.access04.TestDefault2;


// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		// 1. 같은 패키지에 있는 public 클래스
		// -> 인스턴스 생성 가능
		TestPublic t1 = new TestPublic();
		
		// 2. 같은 패키지에 있는 (default) 클래스
		// -> 인스턴스 생성 가능
		TestDefault t2 = new TestDefault();

		// 3. 다른 패키지에 있는 public 클래스
		// -> 인스턴스 생성 가능
		TestPublic2 t3 = new TestPublic2();
		
		// 4. 다른 패키지에 있는 (default) 클래스
		// -> 인스턴스 생성 불가능
		//  애시당초 import 에서 에러다
		//TestDefault2 t4 = new TestDefault2();

		// 다른 패키지에 있는데, 같은 이름의 클래스가 있다면??
		com.lec.java.access04.TestPublic t11 =
				new com.lec.java.access04.TestPublic();

		
	} // end main()

} // end class Access05Main










