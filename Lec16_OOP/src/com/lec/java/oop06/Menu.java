package com.lec.java.oop06;

// 인터페이스의 쓰임 1: 프로그램에 필요한 상수들만 정의해서 사용
// 인터페이스에 선언되는 모든 멤버 변수는 항상 public static final임.
// public static final은 생략 가능.
// public: 모든 클래스에서 직접 사용(접근)이 가능
// static: 인스턴스를 생성하지 않고 사용 가능
// final: 초기화가 된 이후에는 변경 불가능

public interface Menu {
	public static final int MENU_QUIT = 0;
	public static final int MENU_INSERT = 1;
	public static final int MENU_SEARCH = 2;
	public static final int MENU_UPDATE = 3;
	public static final int MENU_DELETE = 4;
	
	public static final String STR_QUIT = "프로그램을 종료합니다...";
	public static final String STR_INSERT = "입력 메뉴";
	public static final String STR_SEARCH = "검색 메뉴";
	public static final String STR_UPDATE = "수정 메뉴";
	public static final String STR_DELETE = "삭제 메뉴";
	public static final String STR_ERROR = "잘못 입력했습니다.";
	
} // end interface Menu










