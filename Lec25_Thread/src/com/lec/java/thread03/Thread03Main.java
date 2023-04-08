package com.lec.java.thread03;

/* 쓰레드와 익명클래스
 */
public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");
		
		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		new Thread(new MyRunnable()).start();
		
		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("3 x " + i + " = " + (3 * i));
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} // end for
				
			} // end run()
			
		}).start();

	} // end main()

} // end class Thread03Main


class MyRunnable implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("2 x " + i + " = " + (2 * i));
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // end for
		
	} // end run()
	
} // end class MyRunnable

























