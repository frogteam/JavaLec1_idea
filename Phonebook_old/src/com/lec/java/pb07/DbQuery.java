package com.lec.java.pb07;

// View(PhonebookMain)와 Controller(PhonebookManager) 사이의 인터페이스
public interface DbQuery {
	
	public abstract void insert(String name, String phoneNum, String email);
	public abstract String searchAll();
	public abstract String search(int index);  // ver pb07 에서 추가
	public abstract String update(int index, String name, String phoneNum, String email);
	public abstract void delete(int index);

} // end interface DbQuery

