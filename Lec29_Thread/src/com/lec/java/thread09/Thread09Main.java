package com.lec.java.thread09;

// 다음 코드를 수행했을때의 결과를 예상해보자

public class Thread09Main {

	public static void main(String[] args) {
		System.out.println("동기화 문제: instance variable vs local variable");
		
		Data d = new Data();		// Date 인스턴스 생성

		Thread th1 = new MyThread(d);	// 위에 생성한 Date 인스턴스를 매개변수로 쓰레드생성
		Thread th2 = new MyThread(d);
		
		th1.start();
		th2.start();
	} // end main()
} // end class Thread04Main


class Data {
	int instValue = 0;	// 인스턴스 변수
}

class MyThread extends Thread{
	Data d;
	
	public MyThread(){}
	public MyThread(Data d){
		this.d = d;
	}
	
	@Override
	public void run() {
		int localValue = 0;  // 지역변수
		String name = Thread.currentThread().getName();
		
		while(localValue < 3){
			System.out.println(name + " localValue=" + (++localValue));
			System.out.println(name + " instValue=" + (++d.instValue));
			System.out.println();
		} // end while
	} // run()
} // end class MyThread


// 한개의 Data 객체를 두개의 MyThread 가 공유하기 때문에
// Data 의 인스턴스 변수 inseValue 값은 두 쓰레드에서 모두 접근이 가능하다.
// 반면 localValue 는 두 쓰레드 각각의 스택에 생기기 때문에 공유되지 않는다.













