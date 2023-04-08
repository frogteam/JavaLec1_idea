package 함수1.형성평가05;


/*
 
 174 : 함수1 - 형성평가5 

제한시간: 1000 ms    메모리제한: 0 MB
해결횟수: 2384 회    시도횟수: 3630 회    

 
 
3명 학생의 3과목 점수를 입력받아 각 과목별  학생별 총점을 출력하는 구조화된 프로그램을 작성하시오.
   
  
입력예: 
50 80 100
96 88 66
100 85 90

출력예:
50 80 100 230
96 88 66 250
100 85 90 275
246 253 256 755
 

 */

import java.util.Scanner;

public class Main {

	public static void showTotal(int[] score) {
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
			sum += score[i];
		} // end for
		System.out.println(sum);
		
	} // end showTotal()
	
	public static void main(String[] args) {
		int numStudent = 3;
		int numSubject = 3;
		int [][] score = new int[numStudent][numSubject];
		int [] total = new int[numSubject];
		
		Scanner sc = new Scanner(System.in);
		
		// 3명의 학생에 대해서 입력
		for(int stu = 0; stu < numStudent; stu ++) {
			for(int subj = 0; subj < numSubject; subj++) {
				score[stu][subj] = sc.nextInt();
				total[subj] += score[stu][subj]; 
			}
		}
		
		for(int stu = 0; stu < numStudent; stu++) {
			showTotal(score[stu]);	
		}
		showTotal(total);
		
		sc.close();
	} // end main()

} // end class
