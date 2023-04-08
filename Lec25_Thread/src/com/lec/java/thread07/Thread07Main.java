package com.lec.java.thread07;
// sleep(): 지정된 시간동안 쓰레드를 '일시정지' 상태.  지정시간후에 바로 시작되는 것이 아니라, '대기상태'에 들어가 줄서서 기다린다.
// supend() : 쓰레드를 '일시정지' 상태가 되게 하고, resume() 으로 다시 '대기상태' 에 들어간다
// resume()
// stop() :

// 
// stop(), suspend(), resume() 은 final 메소드라 오버라이딩 불가.

// 클래스(static) 메소드임.  Thread.yield() 로 호출하는 것이 바람직

public class Thread07Main {

	public static void main(String[] args) {

		System.out.println("쓰레드: suspend, resume, stop 사용");
		System.out.println("과연 th1, th2, th3 각 스레드애서 각각 몇번씩 출력될까?");
		
		RunImpl r = new RunImpl();
		
		Thread th1 = new Thread(r, "th1"); //Thread(Runnable target, String name)
		Thread th2 = new Thread(r, "th2");
		Thread th3 = new Thread(r, "th3");
		
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
		} //end try

		
		// suspend(), resume(), stop() 은 dead-lock 상태에 빠질수 있어서 현재는 depricated 되어 있다.
		
	} // end main()
} // end class

class RunImpl implements Runnable{

	@Override
	public void run() {
		int n = 1;
		while(true){
			System.out.println(Thread.currentThread().getName()+ ": " + n + "번째");
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		} // end while
	} // end run()
	
} // end class