package com.lec.java.j14_05_final;

public class Final01Main {

	// final 필드 변수
	// (주의) final 필드 변수는 반드시 선언과 동시에 초기화 (혹은 생성자에서 초기화) 해야 한다
	final int NUM1 = 1;
	//final int NUM2; // 컴파일 에러: 초기화되지 않아서
	final int NUM3;  // 생성자에서 초기화 가능.
	
	public Final01Main() {
//		NUM1 = 10;  // 이미 선언단계에서 초기화 했으면 생성자 초기화시 에러
		NUM3 = 10;  // 없으면 에러  (생성자에서 에러난다!)
	}
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		// 변수: 값을 변경할 수 있는 저장 공간 
		int num1 = 1;
		num1 = 10;
		
		// 상수: 한번 값이 초기화 되면 더이상 변경할수 없다.
		final int num2 = 1;
		// num2 = 10; 
		// 컴파일 에러: 선언할 때 final로 선언이 돼 있으면 나중에 변경 불가.
		
		final int num3; // final 선언
		num3 = 1; // final 초기화
		//num3 = 12; // 초기화 된 이후에는 값 변경 불가

	} // end main()

} // end class Final01Main










