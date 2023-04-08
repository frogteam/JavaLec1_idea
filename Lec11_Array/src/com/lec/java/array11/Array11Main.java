package com.lec.java.array11;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("for와 enhanced for의 차이점");
		int[] arr1 = {10, 20, 30, 40, 50};
		
		System.out.println();
		System.out.println("[1] for문");
		// for문 사용해서 배열의 각 원소의 값을 1 증가
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] += 1;
			// arr1[i]++; 동일한 결과
			// arr1[i] = arr[i] + 1; 동일한 결과
		}
		// 값이 바꼈는지 확인
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ", ");
		}
		System.out.println();
		
		
		System.out.println();
		System.out.println("[2] enhanced for 사용");
		int[] arr2 = {10, 20, 30, 40, 50};
		// 배열 각 원소의 값을 1씩 증가
		for (int num : arr2) {
			num += 1;
		}
		// 확인
		for (int num : arr2) {
			System.out.print(num + ", ");
		}
		System.out.println();

		// enhanced for문에서는 배열의 원소를 꺼내서
		// 변수에 복사(저장)해서 사용하는 것입니다.
		// 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
		
	} // end main()

} // end class Array11Main









