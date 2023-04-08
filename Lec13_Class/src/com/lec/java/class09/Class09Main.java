package com.lec.java.class09;

public class Class09Main {

	// 일단 다음 3개의 메소드 정의
	public static void addInt(int n){
		n = n + 1;
		System.out.println("메소드 add(int) 결과: " + n);
	} // end add()
	
	public static void addArray(int [] array){
		System.out.print("메소드 add(int []) 결과: ");
		for(int i=0; i< array.length; i++){
			array[i] = array[i] + 1;
			System.out.print(array[i] + " ");
		}
		System.out.println();
	} // end add()
	
	public static void addObject(Number numObj){
		numObj.num += 1;
		System.out.println("메소드 add(Number) 결과: " + numObj.num);
	} // end add()
	

	public static void main(String[] args) {

		// Call by Value : 값에 의한 호출
		//   메소드 호출결과 매개변수 원본은 변화가 없다.
		//   자바에선 일반적인 primitive 변수를 매개변수로 주고 받을때
		//   Call by value 가 발생한다.
		
		System.out.println("== Call by Value : 값에 의한 호출 ==");
		int n = 100;
		System.out.println("메소드 add(int) 호출전 원본값: " + n);
		addInt(n);
		System.out.println("메소드 add(int) 호출후 원본값: " + n);
		System.out.println();
		
		// Call by Reference : 참조에 의한 호출
		//   메소드 호출결과 매개변수 원본이 영향을 받는다 (원본값의 변화 발생)
		//   자바에선 일반적인 reference 변수를 주고 받을때
		//   Call by reference 가 발생한다.
		//   자바의  reference 변수들 : 배열, 클래스, enum...

		System.out.println("== Call by Reference : 참조에 의한 호출 ==");
		int [] array = {10, 20, 30, 40, 50};
		System.out.print("메소드 add(int []) 호출전 원본값: ");
		for(int i=0; i< array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		addArray(array);		// 배열이름을 매개변수로 넘김은 Call by Reference 이다
		System.out.print("메소드 add(int []) 호출후 원본값: ");
		for(int i=0; i< array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		Number numObj = new Number();
		numObj.num = 1000;
		System.out.println("메소드 add(Number) 호출전 원본값: " + numObj.num);
		addObject(numObj);
		System.out.println("메소드 add(Number) 호출후 원본값: " + numObj.num);
		System.out.println();
		
		
		// 그러나!
		// 레퍼런스 변수가 아닌 그 '값'을 매개변수로 넘긴 경우는
		// Call by Reference 가 아닌 Call by Value 이다
		System.out.println("== '레퍼런스 변수'가 아닌 '레퍼런스의 값'을 매개변수로 호출한 경우 ==");
		
		System.out.println("메소드 add(int) 호출전 원본값: " + array[0]);
		addInt(array[0]);
		System.out.println("메소드 add(int) 호출후 원본값: " + array[0]);
		System.out.println();
		
		System.out.println("메소드 add(int) 호출전 원본값: " + numObj.num);
		addInt(numObj.num);
		System.out.println("메소드 add(int) 호출후 원본값: " + numObj.num);
		System.out.println();
		
		System.out.println("프로그램 종료");
	} // end main()
	
	

} // end class