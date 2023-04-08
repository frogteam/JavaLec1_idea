package phonebook02.mvc_gui;

public class PhonebookModel {
	// 멤버변수
	private String name;     // 이름
	private String phoneNum; // 전화번호
	private String email;    // 이메일
	
	// 기본생성자(디폴트생성자)
	public PhonebookModel() {
		name = "";
		phoneNum = "";
		email = "";
	}
	
	// 매개변수 생성자
	public PhonebookModel(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	// getter & setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
		
	// 메소드
	// 이름: displayInfo()
	// 리턴타입 : void
	// 매개변수 : X
	// 기능: 멤버변수 값들 출력

	/* 모델 쪽에서 출력하는 일은 더이상 하지 말자 
	 * 사용자와의 접촉접은 View 가 담당하도록 하자 
	 */
/*
	public void displayInfo() {
		System.out.println("----- 전화번호부 정보 -----");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNum);
		System.out.println("이메일: " + email);
	} // end displayInfo()
	*/
	
	@Override
	public String toString() {
		String result = "";
		result += "----- 전화번호부 정보 -----\n";
		result += "이름: " + name + "\n";
		result += "전화번호: " + phoneNum + "\n";
		result += "이메일: " + email + "\n";
		return result;
	} // end toString()

} // end class
