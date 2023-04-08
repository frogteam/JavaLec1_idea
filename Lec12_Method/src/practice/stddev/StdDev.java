package practice.stddev;

import java.util.Arrays;
import java.util.Random;

//81 76 81 55 36
public class StdDev {

	// TODO
	// 임의정수 5개로 초기화한 정수로
	// 평균, 분산, 표준편차 구하기

	public static void main(String[] args) {

		double avg = 0;   // 평균		
		double var = 0;   // 분산 (variance)
		double stdDev = 0;   // 표준편차 (standard deviation)

		// 걍 주어지는 버젼
		int[] arr = {81, 76, 81, 55, 36};
		
		// 랜덤 생성되는 버젼
//		Random rand = new Random();
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = rand.nextInt(100) + 1;  // 1 ~ 100
//		} // end for
		
		// 입력받는 버젼
//		int[] arr = new int[len];
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sc.nextInt();
//			sum += arr[i];  // 입력받으면서 합산 수하기 
//		}
//		sc.close();

		// 평균 구하기
		avg = calcAvg(arr);
		
		// 분산 구하기
		var = calcVariance(arr);
		
		// 표준편차 구하기
		stdDev = calcStdDev(arr);
		
		// 결과 출력
		System.out.println(Arrays.toString(arr).
						replace(", ", " ").
						replace("[", "").
						replace("]", ""));
		System.out.println("평균 : " + avg);
		System.out.println("분산 : " + var);
		System.out.println("표준편차: " + stdDev);
	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int [] arr) {
		double sum = 0.0;
		// 합계 구하기
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		} // end for
		
		return sum / arr.length;

	} // end calcAvg
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int [] arr) {
		double var = 0.0;   // 분산 (variance)
		double avg = calcAvg(arr);  // 평균
		for (int i = 0; i < arr.length; i++) {
			var += Math.pow(arr[i] - avg, 2);
		}
		return var /= arr.length;
	} // end calcVariance
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int [] arr) {
		return Math.sqrt(calcVariance(arr));
	} // end calcStdDev

} // end class
