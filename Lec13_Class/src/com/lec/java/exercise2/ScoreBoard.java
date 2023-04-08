package com.lec.java.exercise2;

public class ScoreBoard {
	private int [] score;
	
	public ScoreBoard(){
	}// 디폴트생성자
	
	public ScoreBoard(int [] score){
		this.score = score;
	}//매개변수가 있는 생성자
	
	
	public int calcTotal(){
		int total = 0;
		for(int i=0; i < score.length; i++){
			total += score[i];
		} // end for
		return total;
	} // end calcTotal
	
	public double calcAverage(){
		return (double)calcTotal() / score.length;	
	}	
	
	public char calcGrade(){
		double avg = calcAverage();
		if(avg>=90){
			return 'A';
		} else if(avg>=80){
			return 'B';
		} else if(avg>=70){
			return 'C';
		} else if(avg>=60){
			return 'D';
		} else {
			return 'F';
		}
	}
} // end class
