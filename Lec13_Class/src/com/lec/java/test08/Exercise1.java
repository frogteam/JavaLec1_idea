package com.lec.java.test08;

public class Exercise1 {
	private String date;
	private String name;
	private String title;
	private String text;
	private int number;
	private boolean secret;

	public Exercise1() {

	}// 디폴트생성자

	public Exercise1(String date, String name, String title, String text, int number, boolean secret) {
		this.date = date;
		this.name = name;
		this.title = title;
		this.text = text;
		this.number = number;
		this.secret = secret;
	}// 매개 변수가 있는 생성자

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	public void displayInfo(){
		System.out.println("=게시글 정보=");
		System.out.println("날짜: " + date);
		System.out.println("작성자이름: " + name);
		System.out.println("글제목: " + title);
		System.out.println("글내용: " + text);
		System.out.println("조회수: " + number);
		System.out.println("비밀글 여부" + secret);
	}
}// end of class
