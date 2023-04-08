package com.lec.java.exercise1;

public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public int getTotal(){
		return kor + eng + math;
	}
	
	public float getAverage(){
		return (float)(kor + eng + math)/3;
		
	}
	
	
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	String info(){
	 	return name + "," + ban + "," + no + "," + kor + "," + eng + ","
	 			+ math + "," + getTotal() + "," + getAverage();
	}
	
}// end of class
