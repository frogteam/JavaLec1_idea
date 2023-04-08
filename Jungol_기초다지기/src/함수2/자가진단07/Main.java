package 함수2.자가진단07;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=222&sca=10c0

585 : 함수2 - 자가진단7 

10개의 정수를 입력받아 버블정렬로 내림차순 정렬을 하면서 하나의 단계가 끝날 때마다 그 정렬결과를 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
15 93 26 8 43 10 25 88 75 19

[출력예]
93 26 15 43 10 25 88 75 19 8
93 26 43 15 25 88 75 19 10 8
93 43 26 25 88 75 19 15 10 8
93 43 26 88 75 25 19 15 10 8
93 43 88 75 26 25 19 15 10 8
93 88 75 43 26 25 19 15 10 8
93 88 75 43 26 25 19 15 10 8
93 88 75 43 26 25 19 15 10 8
93 88 75 43 26 25 19 15 10 8
 


 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j = arr.length - 1; j > 0 ; j--) {
			for(int i = 0; i < j; i++) {
				if(arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			showArr(arr);
		}
		
		sc.close();
	}
	
	public static void showArr(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i + 1 < arr.length){
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
