package com.lec.java.inner09;

/* 이벤트 중심의 프로그래밍 & 리스너 (Listener) 
 *   이벤트 중심의 프로그래밍 (웹, 앱, GUI 환경 등..) 에선
 *   특정 '객체' 에  특정 '이벤트' 가 발생하면 어떠한 '동작'을 수행하도록 프로그래밍 한다.
 *   
 *   ex)
 *   	'A버튼 객체' 는 '클릭' (이벤트)가 발생하면 '~~동작' 을 수행
 *   	'B버튼 객체' 는 '더블클릭' (이벤트)가 발생하면 '~~동작' 을 수행
 *   
 *   
 *   이때 '객체' 는  API 제공사 측에서 제공하는 코드이고, 공통적인 기본 동작은 수행하나
 *   이 API 를 사용하는 사용자(개발자) 들이 추가해야 하는 코드를 위해
 *   API 제공사에서 인터페이스 등으로 제공받게 된다. 
 */

//
public class Anonymous09Main {
	public static void main(String[] args) {
		System.out.println("익명 클래스 응용 : Listener");
		
		Button btnOk = new Button("OK");
		Button btnCancel = new Button("CANCEL");
		btnOk.actionClick();
		btnCancel.actionClick();
		
		System.out.println();
		// 리스너 장착: 익명클래스
		btnOk.setOnClickListener(new MyButtonListener());
		btnOk.actionClick();
		
		// 리스너 장착: 익명클래스
		btnOk.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("버튼 클릭하면 수행하는 동작 2");
			}
		});		
		btnOk.actionClick();
		
		// 리스너 장착 : Lambda-Expression 사용 가능
		btnOk.setOnClickListener(()->{
			System.out.println("버튼 클릭하면 수행하는 동작 3");
		});
		btnOk.actionClick();
		
		
		// 연습
		// 더블클릭
		btnOk.setOnDblClickListener(new Button.OnDblClickListener() {
			
			@Override
			public void onDblClick() {
				System.out.println("더블클릭하면 수행하는 코드들");
				
			}
		});
		
		btnOk.actionDblClick();
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
	
} //end class

//별도의 리스너 클래스 작성
class MyButtonListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("버튼 클릭하면 수행하는 코드 1");
	}
}
