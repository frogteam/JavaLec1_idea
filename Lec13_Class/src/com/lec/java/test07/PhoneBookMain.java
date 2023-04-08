package com.lec.java.test07;

import java.util.Scanner;

public class PhoneBookMain {
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		String name;
		name = sc.nextLine();

		String phonenumber;
		phonenumber = sc.nextLine();

		String email;
		email = sc.nextLine();

		sc.close();
		
		PhoneBookModel phoneBookModel2 = new PhoneBookModel(name,phonenumber,email);
		phoneBookModel2.displayInfo();

	}// end of main
	
}// end of class
