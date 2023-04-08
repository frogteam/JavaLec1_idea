package com.lec.java.oop08;

public class Marine implements Unit {

	String name;	
	String action;
	
	public Marine(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}


}
