package com.lec.java.mvc01;

// Model 기능을 담당할 클래스
public class MemberModel {
	// 멤버 변수
	private String id;
	private String passwd;
	
	// 생성자
	// 1) 디폴트 생성자
	// 2) Member(String id, String passwd)
	public MemberModel() {}
	public MemberModel(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}
	
	// getters / setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "--- 회원 정보 ---\n";
		result += "아이디: " + id + "\n";
		result += "비밀번호: " + passwd + "\n";
		result += "-----------------\n";
		return result;
	} // end toString()
	
	
} // end class MemberModel






