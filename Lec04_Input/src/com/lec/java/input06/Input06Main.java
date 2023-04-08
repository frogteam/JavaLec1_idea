package com.lec.java.input06;

import javax.swing.JOptionPane;

public class Input06Main {

	public static void main(String[] args) {
		System.out.println("JOptionPane 사용 ");
		
        String name;
        name = JOptionPane.showInputDialog("이름이 뭐에요");  // String 으로 리턴
        System.out.println("입력하신 이름은: " + name );
                
	} // end main()
} // end class
