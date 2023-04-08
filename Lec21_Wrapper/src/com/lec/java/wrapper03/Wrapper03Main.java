package com.lec.java.wrapper03;

import java.util.Scanner;

public class Wrapper03Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("메인 메뉴");
		System.out.println("-------------");
		System.out.println(" [0] 종료");
		System.out.println(" [1] 입력");
		System.out.println("-------------");
		System.out.println("선택:");
	} // end showMenu()
	
	public static void inputData() {
		while(true) {
			try {
				System.out.println("이름 입력:");
				String name = sc.nextLine();
				
				String str;
				System.out.println("국어 점수 입력:");
				str = sc.nextLine();
				int korean = Integer.parseInt(str);
				
				System.out.println("이름: " + name);
				System.out.println("국어: " + korean);
				break;
			} catch (NumberFormatException ex) {
				System.out.println("점수를 잘못 입력했습니다.");
			} // end catch
		}
		
	} // end inputData()
	
	public static void main(String[] args) {
		System.out.println("Wrapper 사용예");
		
		while (true) {
			try {
				showMenu();
				String str = sc.nextLine();
				int menu = Integer.parseInt(str);
				
				switch (menu) {
				case 0:
					System.out.println("\n프로그램을 종료합니다...");
					return;
					
				case 1:
					inputData();
					break;
					
				default:
					System.out.println("잘못 입력했습니다~");
				} // end switch
				
			} catch (NumberFormatException ex) {
				System.out.println("메뉴 선택 오류");
			} // end catch
			
		} // end while

	} // end main()

} // end class









