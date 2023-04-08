package practice014.multiarray_cross;

import java.util.Scanner;

/*<array2_b08>
 4행 2열의 배열을 입력받아 가로평균과 세로평균 
 그리고 전체평균을 출력하는 프로그램을 작성하시오. 
 (소수점 이하는 버림 한다.)
 
[입력]
16 27
39 100
19 88
61 20

[출력]
21 69 53 40
33 58
46
 
 
 */
public class MultiArrayCross {
	
	//--------------------------------------------------
	/* 배성은 
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		int[][] num = new int[4][2];
		
		int[] width = new int[4];   //★★
		int[] height = new int[2];	//★★
		int total = 0;				//★★
		
		System.out.println("4행 2열의 array 를 입력하세요.");
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = Scan.nextInt();
			}
		}
		Scan.close();
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				width[i] += num[i][j];   //★★
				height[j] += num[i][j];  //★★
				total += num[i][j];      //★★
			}
		}
		System.out.println(width[0] / 2);
		System.out.println(width[1] / 2);
		System.out.println(width[2] / 2);
		System.out.println(width[3] / 2);

		System.out.println(height[0] / 4);
		System.out.println(height[1] / 4);

		System.out.println(total / 8);

	} // end main()
	end 배성은 */
	
	//--------------------------------------------------
	/* 백록선
	public static void main(String[] args) {
		
		final int ARRAY_COL = 4;
		final int ARRAY_ROW = 2;
		
		int [] colAverage = new int[ARRAY_COL];  //★★
		int [] rowAverage = new int[ARRAY_ROW];	//★★
		int totalAverage = 0;					//★★
		
		int [][] array = new int[ARRAY_COL][ARRAY_ROW];
		
		// 입력
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j ++) {
				System.out.println((i + 1) + "행 " + (j + 1) + "렬의 값을 입력하세요");
				array[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		// 계산
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j ++) {
				totalAverage += array[i][j];	//★★
				colAverage[i] += array[i][j];	//★★
				rowAverage[j] += array[i][j];	//★★
			}
		}
		
		// 출력
		System.out.print("가로 평균 : ");
		for (int i = 0; i< colAverage.length; i++) {
			colAverage[i] /= ARRAY_ROW;
			System.out.print(colAverage[i] + " ");
		}
		System.out.print("\n세로 평균 : ");
		for (int i = 0; i< rowAverage.length; i++) {
			rowAverage[i] /= ARRAY_COL;
			System.out.print(rowAverage[i] + " ");
		}
		System.out.print("\n전체 평균 : ");
		totalAverage = totalAverage / (ARRAY_COL * ARRAY_ROW);
		System.out.println(totalAverage);
		
	}
	end 백록선 */
	
	//--------------------------------------------------
	/* 최용혁
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arrin = new int[4][2];
		double[] ave = new double[4];
		double ave2 = 0;
		int sum = 0, total = 0;
		
		System.out.println("입력하세요 : ");
		for (int i = 0; i < arrin.length; i++) {
			for (int j = 0; j < arrin[i].length; j++) {
				arrin[i][j] = sc.nextInt();
			}
		}//입력부
		
		System.out.println("\n==========================");
		for (int i = 0; i < arrin.length; i++) {
			sum = 0;
			for (int j = 0; j < arrin[i].length; j++) {
				sum += arrin[i][j];
			}
			ave[i] = sum / (double) arrin[i].length;
			System.out.print(ave[i] + " ");
		}//행별 평균
		System.out.println();
		
		
		for (int i = 0; i < arrin[i].length; i++) {
			sum = 0;
			for (int j = 0; j < arrin.length; j++) {
				sum += arrin[j][i];
				total += arrin[j][i];//총평균용 총합
			}
			ave[i] = sum / (double) arrin.length;
			System.out.print(ave[i] + " ");
		}//열별 평균
		System.out.println();
		ave2 = total / (arrin.length + arrin[0].length);//총평균
		System.out.println(ave2);
		sc.close();
	}
	end 최용혁 */
		
} // end class
