package practice.variance;

import java.util.Random;

/*

 
 	1 ~ 100 사이의  정수 5개를 저장하는 배열을 임의의 수로 초기화하고 배열이 평균, 분산, 표준편차를 구하라

	평균(average.mean)
	분산(variance)
	표준편차: starndard deviation

*/

public class Variance {

	public static void main(String[] args) {
		int n = 5;
				
//		int [] arr = new int[n];
		int[] arr = {81, 76, 81, 55, 36};
		n = arr.length;
		
		int sum = 0;
		double average;  // 평균
		double variance;  // 분산
		
		for (int i = 0; i < arr.length; i++) {
		//	arr[i] = new Random().nextInt(100) + 1;
			System.out.print(arr[i] + " ");

			sum += arr[i];
		}
		
		System.out.println();
		average = ((double)sum / n);
		System.out.println("평균:" + average);
		
		// 분산 구하기
		double varSum = 0;
		for (int i = 0; i < arr.length; i++) {
			varSum += Math.pow( arr[i] - average , 2);
		}
		
		variance = varSum / n;
		System.out.println("분산:" + variance);
		
		
		System.out.println("표준편차:" + Math.sqrt(variance));

	}

}
