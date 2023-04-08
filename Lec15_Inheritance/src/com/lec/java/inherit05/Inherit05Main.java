package com.lec.java.inherit05;

import com.lec.java.inherit06.*;
import com.lec.java.inherit06.test.Test04;
// import문에서 *의 의미는 해당 디렉토리 밑에 있는 모든 클래스를 의미함
// 서브 디렉토리에 있는 클래스까지는 import하지는 못함

/* 상속과 접근권한
 * private: 자기 클래스에서만 사용 가능
 * default: 자기 글래스 + 같은 패키지 안에서 사용 가능
 * protected: 자기 글래스 + 같은 패키지 + '상속 클래스'에서 사용 가능 ★
 * public: 어디서나 직접 사용 가능
 */

public class Inherit05Main {

	public static void main(String[] args) {
		System.out.println("상속: 접근 권한(제어)");
		
		System.out.println();
		System.out.println("Test01:");
		Test01 t1 = new Test01();
		t1.showInfo();
		//System.out.println("t1.privateNum = " + t1.privateNum);
		// private 멤버는 다른 클래스에서는 사용 불가
		
		System.out.println(t1.defaultNum);
		// 같은 패키지에 있으므로, default 사용 가능
		
		
		System.out.println();
		// 같은 패키지에 있는 클래스 생성
		// import문 필요 없음
		Test01 t01 = new Test01();
		
		// 다른 패키지에 있는 클래스 생성
		// import문이 반드시 필요
		Test02 t02 = new Test02();
		Test03 t03 = new Test03();
		
		Test04 t04 = new Test04();

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class











