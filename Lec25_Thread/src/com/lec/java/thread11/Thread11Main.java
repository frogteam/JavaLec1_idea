package com.lec.java.thread11;


//synchronized
// 동기화 문제 해결
// synchronized 는 다음 두가지를 대상으로 한다
// 1. 메소드
// 2. 객체


public class Thread11Main {
	public static void main(String args[]) {
		
		System.out.println("동기화 해결: synchronized 사용");
		
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class Account {
	int balance = 1000;

	// 방법 1
	// 메소드에 synchronized를 
	// 단순히 메소드 리턴타입 앞에 synchronized 를 하는 방법
	// 한 쓰레드가 withdraw()를 호출하면 다른 쓰레드는 withdraw()를 호출하더라도 앞선 쓰레드가 withdraw()를 종료할때까지는 '대기상태'가 된다.
	public synchronized void withdraw(int money){   
		if(balance >= money) {
			// 결과를 보기 위해 1000ms 만큼 sleep
			try { Thread.sleep(1000);} catch(Exception e) {} 
			balance -= money;
		}
	} // withdraw
	

	// 방법2
	// 객체에 synchronized를 붙이는 방법
	// 한 쓰레드가 synchronized 블럭에 들어가면 Account 객체 전체에 lock 이 걸려서
	// synchronized 블럭을 벗어날때까지 다른 쓰레드들은 이 객체에 접근할 수 없다.
//	public void withdraw(int money){
//		synchronized(this){
//			if(balance >= money) {
//				// 결과를 보기 위해 1000ms 만큼 sleep
//				try { Thread.sleep(1000);} catch(Exception e) {} 
//				balance -= money;
//			}
//		} // end synchronized
//	} // withdraw	
	
	
} // end class

class MyRunnable implements Runnable {
	Account acc = new Account();	// main() 에서 MyRunnable 객체는 하나만 생성된다.
									// 따라서 acc 도 하나만 생성된다.

	public void run() {
		while(acc.balance > 0) {
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			int prevBalance = acc.balance; 
			acc.withdraw(money);
			System.out.println(Thread.currentThread().getName() + " 인출전:" + prevBalance + "원, " + money + "원 인출후" + " balance:" + acc.balance);
		}
	} // run()
} // end class












