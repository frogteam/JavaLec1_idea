package com.lec.java.array13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* java.util.Arrays 클래스
     배열을 다루는 유용한 메소드들 제공
		Arrays.toString() : 문자열 형태로 리턴
		Arrays.copyOf(원본배열, 복사할 length)
		Arrays.copyOfRange(원본배열, from, to))
		Arrays.fill()  : 배열에 특정 값으로 채우기
		Arrys.sort(원본배열) :  오름차순 변경
		Arrays.asList() : array -> List 로
		
		
	
 */
public class Array13Main {

	public static void main(String[] args) {
		System.out.println("java.util.Arrays 클래스");
		int[] arr = {10, 20, 30, 40, 50};
		
		// Arrays.toString() : 문자열 형태로 리턴
		System.out.println("Arrays.toString()");
		System.out.println(Arrays.toString(arr));
		
		// Arrays.copyOf(원본배열, 복사할 length)
		// 배열을 복사하여 새로운 배열생성하여 리턴
		System.out.println("\nArrays.copyOf()");
		int[] arr2 = Arrays.copyOf(arr, 3);
		arr2[0] = 1000;
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr));  // 원본과는 다른 완전한 복사본 생성된
		
		int[] arr3 = Arrays.copyOf(arr, 10);   // length가 원본보다 크면, 나머지 부분은 기본값들로 채워짐
		System.out.println(Arrays.toString(arr3));
		
		// Arrays.copyOfRange(원본배열, from, to)) 
		// from 부터 to 직전까지 복사
		System.out.println("\nArrays.copyOfRange()");
		int[] arr4 = Arrays.copyOfRange(arr, 0, 2);
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = Arrays.copyOfRange(arr, 0, 10);   // 넘어가는 부분은 기본값들로 채워짐
		System.out.println(Arrays.toString(arr5));
		
//		int[] arr6 = Arrays.copyOfRange(arr, 10, 20);   // 시작index 벗어나면  ArrayIndexOutOfBoundsException
//		System.out.println(Arrays.toString(arr6));
		
		// Arrays.fill(배열, from, to)) 
		System.out.println("\nArrays.fill()");
		int[] arr6 = new int[4];
		Arrays.fill(arr6, 8);   // 죄다 8로 채움
		System.out.println(Arrays.toString(arr6));
		
		
		// Arrays.sort(원본배열)
		// 오름차순 변경.  원본 배열을 변경시킨다
		// 내림차순은 지원하지 않는다.
		System.out.println("\nArrays.sort()");
		int[] arr7 = {8, 9, 3, 5, 1, 2};
		System.out.println(Arrays.toString(arr7));
		Arrays.sort(arr7);
		System.out.println(Arrays.toString(arr7));

		
		// Arrays.equals(배열1, 배열2)
		// 배열원소를 순서대로 하나하나 비교한 결과  true/false
		System.out.println("\nArrays.equals()");
		int[] arr8 = {10, 20, 30};
		int[] arr9 = {10, 20, 30};
		int[] arr10 = {10, 30, 20};
		System.out.println(Arrays.equals(arr8, arr9));
		System.out.println(Arrays.equals(arr8, arr10));
		
		
		
		// Arrays.asList()
		// array -> List 로 변경
		List<int[]> list = Arrays.asList(arr);
		ArrayList<Integer> listInt = new ArrayList<Integer>(); 
		//Integer[] arr11 = (Integer[])listInt.toArray();  // Exception??
		
		
	
	} // end main

} // end class
