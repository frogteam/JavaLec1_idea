package 함수2.자가진단05;

import java.util.Arrays;
import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=220&sca=10c0

583 : 함수2 - 자가진단5 

세 개의 실수를 입력받아 
가장 큰 수를 올림한 정수를 출력하고
가장 작은 수를 내림한 정수를 출력한 후 
남은 수를 반올림한 정수를 출력하는 프로그램을 작성하시오.
입력되는 실수는 -1000이상 1000이하이다.
   
  
[입력예] 
3.45 51.48 -100.1

[출력예]
52 -101 3
 
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double [] arr = new double[3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}
		result(arr);
		
		sc.close();
	} // end main()
	
	public static void result(double[] arr) {
		Arrays.sort(arr);
		System.out.print((int)Math.ceil(arr[2]) + " " + (int)Math.floor(arr[0]) + " " + (int)Math.round(arr[1]));
	}

} // end class
