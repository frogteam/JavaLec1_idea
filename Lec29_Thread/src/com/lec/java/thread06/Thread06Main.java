package com.lec.java.thread06;

/* sleep() 
 *  지정된 시간 동안 쓰레드 일시 정지
 */

public class Thread06Main {

	public static void main(String[] args) {
		System.out.println("sleep() 메소드\n");
		
		// 두개의 쓰레드를 생성하여 start() 해보고
		// 그중 한개의 쓰레드를 sleep() 해보자.
		
		Thread th1 = new MyThread("One");
		Thread th2 = new MyThread("Two");
		
		th1.start();
		th2.start();
		
		try {
			th1.sleep(5000);		// sleep()은 반드시 try~catch 를 잡아내야 한다
		} catch (InterruptedException e) {
		}
		

		// 과연 th1 이 먼저 종료되었을가?  main 이 먼저 종료되었을까?
		System.out.println(" << main 종료 >>");
		
		
		// 먼저 main 이 끝나고,  5000ms 이후에 th1 이 끝났을까?
		// 그러나 결과는 그 반대.
		// sleep() 는 항상 '현재 실행중인 쓰레드'에 대해 작동
		//  즉 main() 메소드 내에서 th1.sleep 라고 해도, 결국은 main을 실행중인 쓰레드가 sleep를 한다.
		// 그런 이유로 sleep 는 static 으로 선언되어 있으며
		// Thread.sleep() 로 호출하는 것이 바람직하다.
		// 같은이유로 Thread.yield() 도  이과 같이 호출하는게 바람직

	} // end main()

} // end class Thread04Main


// Thread 클래스를 상속받는 클래스 정의
class MyThread extends Thread {
	public MyThread() {}
	public MyThread(String name) {
		setName(name);  // 쓰레드 이름 지정
	}
	
	@Override
	public void run() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + "-" + i);
		} // end for
		System.out.println("<<" + getName() + ">> 종료");
	} // run()
	
} // end class MyThread














