package com.lec.java.oop06;

import java.util.Scanner;

public class Interface02Main {

	public static void main(String[] args) {
		System.out.println("인터페이스");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 선택:");
		int menu = sc.nextInt();
		
		// 상수를 사용하면 좀더 코드 관리하기 편해지고 가독성이 좋아진다
		switch (menu) {
		case Menu.MENU_QUIT:
			System.out.println(Menu.STR_QUIT);
			return;
			
		case Menu.MENU_INSERT:
			System.out.println(Menu.STR_INSERT);
			break;
			
		case Menu.MENU_SEARCH:
			System.out.println(Menu.STR_SEARCH);
			break;
			
		case Menu.MENU_UPDATE:
			System.out.println(Menu.STR_UPDATE);
			break;
			
		case Menu.MENU_DELETE:
			System.out.println(Menu.STR_DELETE);
			break;
			
		default:
			System.out.println(Menu.STR_ERROR);
			
		} // end switch

	} // end main()

} // end class Interface02Main










