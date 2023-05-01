package com.lec.java.thread05;

/* join() 
	 지정한 시간 동은 쓰레드가 실행되도록 둔다.
	 지정한 시간이 지나거나, 작업이 종료되면 (쓰레드가 종료되면)  join()을 호출한 쓰레드로 돌아와 실행을 한다
	 특정 쓰레드가 종료한 시점을 기다릴 필요가 있을때  사용
*/

public class Thread05Main {

	public static void main(String[] args) {
		System.out.println("join() 메소드\n");
		
		Thread th1 = new MyThread("One");
		Thread th2 = new MyThread("Two");
		
		th1.start();
		th2.start();
		
		
//		try {
//			th1.join();		// 현재 스레드인 메인스레드는 th1 스레드가 끝날때까지 기다려 준다.
//			th2.join();		// join()은 반드시 try~catch 를 잡아내야 한다
//		} catch (InterruptedException e) {
//		}
		
		System.out.println("-- join()을 안했다면 이 라인은 언제 실행 될까요? --");
		System.out.println("\n");
		
		
		
		// 응용: 두개의 쓰레드를 순차적으로 진행시키고 싶을 경우는?		
		// th1 이 먼저 종료된뒤에 th2 가 실행되게 하는 법
//		th1 = new MyThread("One");
//		th2 = new MyThread("Two");
//		
//		th1.start();
//		try {
//			th1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		th2.start();

		
		// 
		
		

	} // end main()

} // end class


// Thread 클래스를 상속받는 클래스 정의
class MyThread extends Thread {
	public MyThread() {}
	public MyThread(String name) {
		setName(name);  // 쓰레드 이름 지정
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + "-" + i);
		} // end for
		System.out.println("<<" + getName() + ">> 종료");
	} // run()
	
} // end class MyThread















