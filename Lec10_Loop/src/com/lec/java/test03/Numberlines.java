package com.lec.java.test03;

import java.util.Scanner;

public class Numberlines {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("정수를 입력해 주세요");
		num = sc.nextInt();
		for(int i=1;i<=num;i++){
			System.out.print(i);			
			System.out.print(" ");
			
			if(i%10==0){
				System.out.println();
			}//end if 
			
			
			
		}//end of for(i)
	}// end of main
}// end of class
