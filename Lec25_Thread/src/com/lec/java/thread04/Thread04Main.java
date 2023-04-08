package com.lec.java.thread04;

/* 쓰레드 우선 순위(priority)
 */
public class Thread04Main {

	public static void main(String[] args) {
		System.out.println("쓰레드 우선 순위(priority)");
		
		new MyThread("One", Thread.MAX_PRIORITY).start();
		new MyThread("Two", Thread.NORM_PRIORITY).start();
		new MyThread("Three", Thread.MIN_PRIORITY).start();

	} // end main()

} // end class Thread04Main


// Thread 클래스를 상속받는 클래스 정의
class MyThread extends Thread {
	private String msg;
	
	public MyThread() {}
	public MyThread(String msg, int priority) {
		this.msg = msg;
		setPriority(priority);
		// setPriority(): Thread 클래스가 가지고 있는 메소드
		// 쓰레드의 우선순위(priority)를 변경하는 기능
		// Thread 클래스에 정의된 우선순위:
		//   MAX_PRIORITY(10), MIN_PRIORITY(1), NORM_PRIORITY(5)
		// 대부분의 시스템(OS)에서는 우선순위가 높은 쓰레드에게만 실행 기회를 부여
		
		// main() 메소드의 priotiry는 5 이다
		// priotiry 는 상대적이다  2 : 1 <=> 10 : 9 
		
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + msg + " : " + getPriority());
		} // end for
		
	} // run()
	
} // end class MyThread















