package 실력키우기.도형만들기.마방진;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1338&sca=2010
 
 2074 : 마방진 

홀수 정사각형의 크기를 입력 받은 후, 가로 세로 대각선의 합이 일정한 마방진을 출력하는 프로그램을 작성하시오.

마방진이란 1부터 N*N까지의 숫자를 한 번씩만 써서 정사각형에 배치하여 가로와 세로, 그리고 대각선의 합이 같도록 하는 것이다.

다음의 순서에 따라 각 위치에 차례대로 값을 넣는다.
1. 첫 번째 숫자인 1을 넣는 위치는 첫 번째 행 가운데이다.
2. 숫자가 N의 배수이면 바로 아래의 행으로 이동하여 다음의 수를 넣고
3. 그렇지 않으면 왼쪽 위로 이동하여 다음의 숫자를 넣는다. 만약 행이 첫 번째를 벗어나면 마지막 행으로 이동하고, 열이 첫 번째를 벗어나면 마지막 열로 이동한다.

 */
public class Main {

	public static int order;     // 마방진의 차수
	public static int [][] arr;   // 2차원 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("마방진의 차수를 입력하세요(홀수 only): ");		
		order = sc.nextInt();
		sc.close();
		
//		if(order % 2 == 0 || order < 1) {
//			System.out.println("홀수양수만 입력해주세요");
//			return;
//		}
		
		arr = new int[order][order];
			
		fill(0, order / 2, 1);
		
		displaySquare();
	} // end main()
	
	/**
	 * 
	 * @param x  :  0 ~ (order - 1)
	 * @param y  :  0 ~ (order - 1)
	 * @param num : 1 ~ (order * order)
	 */
	public static void fill(int x, int y, int num) {
		if(num > order * order) return;   // 범위 벗어나면 종료 (종료조건)
		
		if(x < 0) x = order - 1;
		if(y < 0) y = order - 1;
		
		arr[x][y] = num;
		
//		System.out.println("fill(" + x + ", " + y + ", " + num + " )");
//		displaySquare();
		
		if(num % order == 0)
			fill(x + 1, y, num + 1);
		else
			fill(x - 1, y - 1, num + 1);
		
		
	} // end fill()
	
	
	public static void displaySquare() {
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

} // end class
