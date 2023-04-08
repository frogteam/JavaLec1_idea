package com.lec.java.thread10;

// 동기화 문제가 발생하는 예제
// 은행 잔고에서 100원 / 200원 / 300원 단위로 랜덤으로 인출한다
// 인출후 잔고가 0 보다 작으면 안된다.
// 과연 아래와 같이 두개의 쓰레드가 이를 각각 수행할때 어떠한 결과가 나오겠는가?
//  ** 실행할때마다 다른 결과가 나오니,  여러번 실행하면서 결과 체크

public class Thread10Main {
	
	
	
	public static void main(String args[]) {
		System.out.println("동기화 문제: 은행인출/잔고 문제 ");
		
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	} // end main()
} // end class

class Account {
	int balance = 1000;

	public void withdraw(int money){
		if(balance >= money) {
			// 결과를 보기 위해 1000ms 만큼 sleep
			try { Thread.sleep(1000);} catch(Exception e) {} 
			balance -= money;
		}
	} // withdraw
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
		} // end while
	} // run()
} // end class












