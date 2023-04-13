package com.lec.java.j17_09_Anonymous응용;

// Button 객체를 개발하여 제공하는 측의 코드
public class Button {

	String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	// 클릭시 수행하는 리스너  제공
	// 리스너 인터페이스 : OnClickListener
	//         - 를릭시 동작 메소드 : onClick();
	// 장착 메소드 : setOnClickListener
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnClickListener {
		void onClick();   // 클릭시 동작, 추상메소드
	}
	// 장착 리스너
	private OnClickListener clickListener = null;  // 타입명 우측에서 CTRL + SPACE 하면 자동으로 변수명 만들어진다.  
	
	// 리스너 장착 메소드
	public Button setOnClickListener(OnClickListener clickListener) {
		this.clickListener = clickListener;
		return this;
	}
	
	//----------------------------------------------
	public void actionClick() {
		System.out.println("--------------------");
		System.out.println(name + " 버튼 클릭!");
		System.out.println("버튼 클릭 동작 공통 처리 동작들A");

		if(clickListener != null) 
			clickListener.onClick();  // 장착된 리스너의 동작 수행
		
		System.out.println("버튼 클릭 동작 공통 처리 동작들B");
		System.out.println("--------------------");
	}
	
	// TODO
	// 더블클릭시 수행하는 리스너를  제공해보세요
	// 리스너 인터페이스 : OnDblClickListener
	//         - 더블를릭시 동작 메소드 : onDblClick();
	// 장착 메소드 : setOnDBlClickListener
	
	//---------------------------------------------------
	// 리스너 인터페이스
	public static interface OnDblClickListener {
		void onDblClick();   // 더블클릭시 동작, 추상메소드
	}
	// 장착 리스너
	private OnDblClickListener dblClickListener = null;  
	
	// 리스너 장착 메소드
	public Button setOnDblClickListener(OnDblClickListener dblClickListener) {
		this.dblClickListener = dblClickListener;
		return this;
	}
	
	//----------------------------------------------
	public void actionDblClick() {
		System.out.println("--------------------");
		System.out.println(name + " 버튼 더블 클릭!");
		System.out.println("버튼 더블클릭 동작 공통 처리 동작들A");
		
		if(dblClickListener != null) 
			dblClickListener.onDblClick();  // 장착된 리스너의 동작 수행
		
		System.out.println("버튼 더블클릭 동작 공통 처리 동작들B");
		System.out.println("--------------------");
	}
	
	
	
	
} // end class
