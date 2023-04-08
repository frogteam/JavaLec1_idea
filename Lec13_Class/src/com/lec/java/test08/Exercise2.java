package com.lec.java.test08;

public class Exercise2 {
	private String name;
	private String id;
	private String secretnumber;
	private int money;
	private char gender;
	
	public Exercise2(){
		
	}//디폴트 생성자

	public Exercise2(String name, String id, String secretnumber, int money, char gender) {
		super();
		this.name = name;
		this.id = id;
		this.secretnumber = secretnumber;
		this.money = money;
		this.gender = gender;
	}//매개 변수가 있는 생성자

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecretnumber() {
		return secretnumber;
	}

	public void setSecretnumber(String secretnumber) {
		this.secretnumber = secretnumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void displayInfo(){
		System.out.println("=== 쇼핑몰 회원정보 ===");
		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + secretnumber);
		System.out.println("구매금액 : " + money);
		System.out.println("남녀여부 : " + gender);
	}
}//end of class
