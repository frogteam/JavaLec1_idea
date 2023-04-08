package com.lec.java.inherit01;

public class SmartTV {
	// 멤버 변수
	// 기존의 BasicTV 에서 만들었었던 멤버들도 그대로 작성하고...
	boolean isPowerOn;
	int channel;
	int volume;
	String ip;    // <- SmartTV에서 새로이 추가될 필드.
	
	// 메소드
	public void displayInfo() {
		// 기존의 BasicTV 에서 만들었었던 코드도 그대로..
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
		System.out.println("IP주소: " + ip);  // SmartTV 에서 추가된 코드
	} // end displayInfo()
	
} // end class SmartTV













