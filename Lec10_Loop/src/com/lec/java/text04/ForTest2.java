package com.lec.java.text04;

public class ForTest2 {

	public static void main(String[] args) {
		int[] arr1 = {10, 20, 30, 40, 50};
		
		for(int a : arr1){
			a += 2;
			System.out.print(a + ", ");
		}//end for

		
//		for(int i=0; i < arr1.length; i++){
//			arr1[i] += 2;
//			System.out.print(arr1[i] + ", ");
//		} // end for 
		
		
		
		System.out.println("====");// 배열 값 출력
		for(int i=0; i < arr1.length; i++){
			System.out.print(arr1[i] + ", ");
		} // end for 
		
		
		
	}

}
