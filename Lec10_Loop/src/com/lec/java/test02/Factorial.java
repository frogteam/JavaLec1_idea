package com.lec.java.test02;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		int result=1;
		System.out.println("정수를 입력해 주세요");
		num = sc.nextInt();
		for(int i=num;i>=1;i--){
			result=result*i;
		}//end of for(i)
		
		System.out.println(num + "!" + " = " + result);
		
		sc.close();
	}//end of main
}//end of class
