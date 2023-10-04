package com.J14.Collection간변환;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 컬렉션 간의 변환
 * 
 * List, Set --> 배열
 * 배열 <--> List
 * 
 * Map.keySet() --> 배열
 * Map.values() --> 배열
 * 
 * HashMap <--> TreeMap
 * 
 * Map.entrySet().toArray()  <-- k? v?  누가 배열이 되나?
 * 
 */
public class Collection14Main {

	public static void main(String[] args) {

		System.out.println("[Collection to Arrays]");
		// list to array
		int[] arr = {1, 2, 3};
		List<Integer> list;

		System.out.println(Arrays.toString(arr));

		Arrays.asList();
		//Arrays.stream(arr).collect(Collectors.toList());
		System.out.println();

	} // end main()

} // end class
