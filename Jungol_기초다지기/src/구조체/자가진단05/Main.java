package 구조체.자가진단05;

import java.util.Scanner;

/*
617 : 구조체 - 자가진단5 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=254&sca=10g0

[문제]
5명의 이름과 키를 입력받아 키가 가장 작은 사람의 이름과 키를 출력하는 프로그램을 작성하시오.


[입력예]
박지성 175
이승엽 180
추신수 185
최홍만 193
박주영 188

[출력예]
박지성 175
*/
public class Main {

	static Person [] arrPerson = new Person[5];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arrPerson.length; i++){
			String name = sc.next();
			double height = Double.parseDouble(sc.next());
			arrPerson[i] = new Person(name, height);
		} // end for
		
		double min = arrPerson[0].getHeight();
		int minIndex = 0;
		
		for(int i = 1; i < arrPerson.length; i++){
			if(min > arrPerson[i].getHeight()){
				min = arrPerson[i].getHeight();
				minIndex = i;
			} // end if
		} // end for
		
		System.out.println(arrPerson[minIndex].getName() + " " + arrPerson[minIndex].getHeight());
		
		sc.close();
	} // end main()
} // end class

class Person {
	private String name;
	private double height;
	
	public Person(){}
	public Person(String name, double height){
		this.name = name;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
} // end class
