package com.lec.java.test01;

public class Multiplication {
	public static void main(String[] args) {
		for(int i=2;i<10;i++){
			System.out.println(i + "단");
			for(int j=1;j<9;j++){
				System.out.println(i + " * " + j + " = " + i * j);
				
			}//end of for(j)
			
			System.out.println( );
		}//end of for(i)
	}//end of main
}//end of class