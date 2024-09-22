package com.lec.java.j12_07_Math;

import java.util.Random;

/* Math 클래스의 메소드
 */
public class Method07Main {

	public static void main(String[] args) {
		System.out.println("Math 객체의 메소드");

		// Math.random() : 0.0 <=  r < 1.0 사이의 난수 발생(double)
		double r;
		for(int i = 0; i < 10; i++) {
			r = Math.random();    
			System.out.println(r);
		} // end for
		
		System.out.println();
		// double Math.floor(num): num이하의 수 중 가장 큰 정수(바닥)
		// double Math.ceil(num): num이상의 수 중 가장 작은 정수(천장)
		// long Math.round(num): num에서 소수점 사사오입 (반올림)
		
		// 1.2 == 1 < 1.2 < 2 == floor: 1, ceil: 2
		// -1.2 == -2 < -1.2 < -1 == floor: -2, ceil: -1

		/*
				floor   ceil   round
		2.7]   2.0    3.0    3
				floor   ceil   round
		-1.2]  -2.0   -1.0   -1
				floor   ceil   round
		-2.8]  -3.0   -2.0   -3
		*/

		for(var d : new double[]{2.7, -1.2, -2.8}){
			System.out.println("        floor   ceil   round");
			System.out.printf("%5.1f]  %5.1f  %5.1f  %3d\n", d, Math.floor(d), Math.ceil(d), Math.round(d));
		}

		System.out.println(Math.floor(2.7));  // 2.0
		System.out.println(Math.ceil(2.7));   // 3.0
		System.out.println(Math.round(2.7));  // 3
				
		System.out.println(Math.floor(-1.2));
		System.out.println(Math.ceil(-1.2));
		System.out.println(Math.round(-1.2));
		
		System.out.println(Math.floor(-2.8));
		System.out.println(Math.ceil(-2.8));
		System.out.println(Math.round(-2.8));
		
		System.out.println();
		System.out.println("1,2,3 범위중 난수 발생시키기");
		for(int i = 0; i < 5; i++) {			
			double num;
			num = Math.random();	//  0.0 <= num < 1.0
			num = num * 3;			//  0.0 <= num < 3.0
			num = Math.floor(num);  //  0.0  1.0  2.0
			num = num + 1;          //  1.0  2.0  3.0
			System.out.println((int)num);
		}
		
		
		
		// TODO:
		System.out.println("로또: 1 ~ 45 숫자중에서 랜덤으로 6개 출력");
		for(int i = 0; i < 6; i++) {
			double lotto;
			System.out.print((int)(Math.floor(Math.random() * 45) + 1) + " ");
		}
		System.out.println();

		
		//실습  int[] randomize(int start, int end, int count) 메소드 만들어보기

		
		// 참고
		System.out.println();
		System.out.println("Random 객체 사용하여 난수 출력");
		Random rand = new Random();
		for(int i = 0; i < 5; i++) {			
			System.out.print(rand.nextInt(3) + ", ");  // 0 ~ 2 사이 정수 난수 발생
		}
		System.out.println();
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









