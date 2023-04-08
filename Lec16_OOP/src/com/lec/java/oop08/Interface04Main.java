package com.lec.java.oop08;
/* 인터페이스 연습
 * 
 */
public class Interface04Main {

	Unit [] units = new Unit[5];
	
	public static void main(String[] args) {
		System.out.println("인터페이스 연습\n");
		
		Interface04Main app = new Interface04Main();
		app.init();
		app.run();
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public void init() {
		// 초기화
	}
	
	public void run() {
		for (int i = 0; i < units.length; i++) {
			if(units[i] != null) {
				System.out.println(units[i].getName());
				units[i].action();
			}
		}	
	} // end run();

} // end class
