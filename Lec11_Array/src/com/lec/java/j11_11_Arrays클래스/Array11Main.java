package com.lec.java.j11_11_Arrays클래스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java.util.Arrays 클래스
 * 배열을 다루는 유용한 메소드들 제공
 *  Arrays.toString() : 문자열 형태로 리턴
 *  Arrays.copyOf(원본배열, 복사할 length)
 *  Arrays.copyOfRange(원본배열, from, to))
 *  Arrays.fill()  : 배열에 특정 값으로 채우기
 *  Arrys.sort(원본배열) :  오름차순 변경
 *  Arrays.asList() : array -> List 로
 */

public class Array11Main {

    public static void main(String[] args) {
        System.out.println("java.util.Arrays 클래스");
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2;

        // 💚 Arrays.toString() : 문자열 형태로 리턴
        System.out.println("Arrays.toString()");
        System.out.println(Arrays.toString(arr1));


        // 💚 Arrays.copyOf(원본배열, 복사할 length)
        // 배열을 복사하여 새로운 배열생성하여 리턴
        System.out.println("\nArrays.copyOf()");
        arr2 = Arrays.copyOf(arr1, 3);
        arr2[0] = 1000;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr1));  // 원본과는 다른 완전한 복사본 생성된

        arr2 = Arrays.copyOf(arr1, 10);   // length가 원본보다 크면, 나머지 부분은 기본값들로 채워짐
        System.out.println(Arrays.toString(arr2));

        // 💚 Arrays.copyOfRange(원본배열, from, to))
        // from 부터 to 직전까지 복사
        System.out.println("\nArrays.copyOfRange()");
        arr2 = Arrays.copyOfRange(arr1, 0, 2);
        System.out.println(Arrays.toString(arr2));

        arr2 = Arrays.copyOfRange(arr1, 0, 10);   // 넘어가는 부분은 기본값들로 채워짐
        System.out.println(Arrays.toString(arr2));

//		arr2 = Arrays.copyOfRange(arr1, 10, 20);   // 시작index 벗어나면  ArrayIndexOutOfBoundsException
//		System.out.println(Arrays.toString(arr2));

        // 💚 Arrays.fill(배열, val))
        System.out.println("\nArrays.fill()");
        arr2 = new int[4];
        Arrays.fill(arr2, 8);   // 죄다 8로 채움
        System.out.println(Arrays.toString(arr2));


        // 💚 Arrays.sort(원본배열)
        // 오름차순 변경.  원본 배열을 변경시킨다
        // 내림차순은 지원하지 않는다.
        System.out.println("\nArrays.sort()");
        arr2 = new int[]{8, 9, 3, 5, 1, 2};
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));


        // 💚 Arrays.equals(배열1, 배열2)
        // 배열원소를 순서대로 하나하나 비교한 결과  true/false
        System.out.println("\nArrays.equals()");
        int[] arr8 = {10, 20, 30};
        int[] arr9 = {10, 20, 30};
        int[] arr10 = {10, 30, 20};
        System.out.println(arr8 == arr9); // false
        System.out.println(Arrays.equals(arr8, arr9));  // true
        System.out.println(arr8.equals(arr9));  // false.
        System.out.println(Arrays.equals(arr8, arr10));  // false


        // 💚 Arrays.asList()
        // array -> List 로 변경
        Integer[] arr3 = {10, 20, 30};
        List<Integer> list = Arrays.asList(arr3);

    } // end main

} // end class
