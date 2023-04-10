package com.lec.java.j14_01_access;

// 다른 패키지에 있는(다른 디렉토리에 있는) 클래스를 사용하려면
// import를 해 주어야 함
// import 없이 full name 으로도 사용은 가능..
import com.lec.java.j14_02_access.Test02;

/**
 * Modifier (제어자, 수식어, 제한자..)
 *   클래스나  변수, 메소드의 선언부에 붙여주어 부가적인 제어를 하게끔 함
 *
 *   Access modifier (접근제한자)
 *        private, protected, public.
 *
 *   그밖의 modifier 들
 *        final, static, abstract, transient, synchronized, volatile
 */

/**
 * 접근권한 수식어(Access Modifier)  접근제한자
 *  1) 종류: private, (default), protected, public
 *  2) 기능
 *    - 멤버 변수, 멤버메소드에 대한 접근 권한을 제한
 *
 *  3) private: '자기자신'이 선언된 클래스에서만 사용 가능
 *  4) (default): '자기자신' + '같은 패키지'에 있는 클래스들에서는사용 가능
 *  5) protected: '자기자신' + '같은 패키지' + '상속받은 클래스' 에서 사용 가능
 *          다른 패키지의 클래스라도 '상속 받으면' 사용 가능하다
 *  6) public: 어디서든 사용이 가능
 *
 *  사용범위: private < (default) < protected < public
 *
 * ※ 클래스에 붙는 접근제한자는 딱 두가지 입니다
 *  (default) , public
 */

public class Access01Main {

	public static void main(String[] args) {
		System.out.println("접근권한 수식어(Access Modifier)");
		
		// Test01 클래스의 인스턴스를 생성
		// ↑ 같은 패키지내 클래스다
		Test01 t1 = new Test01();
//		t1.privateNum = 10; //private: 자기 자신이 선언된 클래스에서만 직접 사용이 가능
//		t1.defaultNum = 20;  
//		t1.protectedNum = 30;
//		t1.publicNum = 40;

//		t1.privateMethod(); // 에러
//		t1.defaultMethod(); // 에러 다른패키지라 안됨
//		t1.protectedMethod(); // 에러:
//		t1.publicMethod();

		
		// 다른 패키지(com.lec.java.access02)에 있는 클래스
		// 일단 다른 패키지 라면 import 부터 선행되어야 한다
		Test02 t2 = new Test02();
		
		// import 없이 다음과 같이 full name 으로 사용 가능
//		com.lec.java.access02.Test02 t2 = new com.lec.java.access02.Test02();
		
		
//		t2.privateNum = 10;
//		t2.defaultNum = 20;
//		t2.protectedNum = 40;   
//		t2.publicNum = 50;
		
//		t2.privateMethod(); 
//		t2.defaultMethod();
//		t2.protectedMethod();
		t2.publicMethod();
		
	} // end main()

} // end class Access01Main










