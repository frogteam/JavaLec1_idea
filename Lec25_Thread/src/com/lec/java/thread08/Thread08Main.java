package com.lec.java.thread08;
// stop(), suspend(), resume() 은 final 메소드라 오버라이딩 불가. 그리고 deadlock 유발 가능성

// yield, interrupt

public class Thread08Main {

	public static void main(String[] args) {

		System.out.println("쓰레드: yield, interrupt 사용");

		RunImpl th1 = new RunImpl("th1"); // Thread(Runnable target, String
											// name)
		RunImpl th2 = new RunImpl("th2");
		RunImpl th3 = new RunImpl("th3");

		th1.start();
		th2.start();
		th3.start();

		// 일단 위에 까지 실행하면 메인쓰레드 외에 3개의 쓰레드가 생성되어 start 되고, 개별적으로 1000ms 단위로 출력된다.

		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(3000);
			th3.stop();

		} catch (InterruptedException e) {
		} // end try

		// suspend(), resume(), stop() 은 dead-lock 상태에 빠질수 있어서 현재는 depricated 되어
		// 있다.

	} // end main()
} // end class

class RunImpl implements Runnable {

	boolean suspended = false;
	boolean stopped = false;

	Thread th; // 자체적으로 쓰레드 멤버 가짐!

	public RunImpl(String name) {
		th = new Thread(this, name); // Thread(Runnable r, String name) 생성자로 생성
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		int n = 1;

		while (!stopped) {
			if (!suspended) {
				System.out.println(name + ": " + n + "번째");
				n++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				} // end try
			}else{
				Thread.yield();   // suspend 상태가 아니면 yield() !!
				                  // 만약 yield()가 없으면 계속해서 while문으로 소진하고 있을텐데.
								  // 곧바로 yield() 하여 대기열의 다음 쓰레드에게 양보한다.
			}
		} // end while
	} // end run()

	public void suspend() {
		suspended = true;
		th.interrupt(); // interrupt() 에 대한 설명은 아래 주석..
		System.out.println("interrupeted() is suspended()");
	} // end suspend()

	public void resume() {
		suspended = false;
	}

	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println("interrupeted() is stopped()");
	}

	public void start() {
		th.start();
	}

	
	// 위에서  suspend(), stop() 에  interrupt()를 호출하였는데
	// interrupt() 는 InterruptException 을 발생시켜서, 
	// sleep(), join(), wait() 에 의해 '일시정지'인 상태를 쓰레드를 '대기상태'로 전환한다
	// 만약 sleep(), join(), wait() 에 의한 '일시정지' 상태가 아니었다면 아무일도 일어나지 않는다
	
	// 
	
} // end class