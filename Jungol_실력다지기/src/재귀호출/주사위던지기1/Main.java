package 재귀호출.주사위던지기1;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=449&sca=2070
1169 : 주사위 던지기1

주사위를 던진 횟수 N과 출력형식 M을 입력 받아서 M의 값에 따라 각각 아래와 같이 출력하는 프로그램을 작성하시오.

M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우

* 중복의 예
1 1 2 와 중복 : 1 2 1, 2 1 1
1 2 3 과 중복 : 1 3 2, 2 1 3, 2 3 1, 3 1 2

[입력형식]
첫 줄에 주사위를 던진 횟수 N(2≤N≤5)과 출력모양 M(1≤M≤3)이 들어온다.

[출력형식]
주사위를 던진 횟수 N에 대한 출력모양을 출력한다.
작은 숫자부터 출력한다.

[입력예]
3 1

[출력예]
1 1 1
1 1 2
1 1 3
1 1 4
1 1 5
1 1 6
1 2 1
…
6 6 6


[입력예2]
3 2

[출력예2]
1 1 1
1 1 2
…
1 1 6
1 2 2
…
5 6 6
6 6 6

[입력예3]
3 3

[출력예3]
1 2 3
1 2 4
1 2 5
1 2 6
1 3 2
1 3 4
…
6 5 3
6 5 4
*/

public class Main {
	static int N; //N번
	static int M; //M 출력
	static int [] number = new int[5]; // N번 던져 나온 숫자 저장(2≤N≤5)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		switch(M)
		{
		case 1:
			dice1(1);
			break;
		case 2:
			dice2(1, 1);
			break;
		case 3:
			dice3(1);
			break;
		}
		
		sc.close();
	} // end main
	

	//주사위를 N번던지는 모든 경우의 수를 출력
	public static void dice1(int throwCount) 
	{	
		// throwCount 를 넘어서면 지금까지 저장된 내용들 출력 (종료조건)
		if (throwCount > N) 
		{
			for (int i = 1; i < throwCount; i++) 
			{
				System.out.print(number[i - 1] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= 6; i++) 
		{
			number[throwCount - 1] = i;
			dice1(throwCount + 1);	// 재귀호출
		}
	} // end dice()


	//주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
	public static void dice2(int startNum, int throwCount) {
		// throwCount 를 넘어서면 지금까지 저장된 내용들 출력 (종료조건)
		if (throwCount > N)
		{
			for (int i = 1; i < throwCount; i++)
			{
				System.out.print(number[i - 1] + " ");
			}
			System.out.println();
			return;
		}


		//중복이 되지 않으려면 i번째가 결정 됐을 때 
		// i+1번째는 i번째가 선택한 수부터 선택을 해야 중복이 이루어 지지 않는다.
		for (int i = startNum; i <= 6; i++) 
		{
			number[throwCount - 1] = i;
			dice2(i, throwCount + 1);  // 재귀호출
		}
	} // end dice2()

	//주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
	public static void dice3(int throwCount) 
	{
		// throwCount 를 넘어서면 지금까지 저장된 내용들 출력 (종료조건)
		if (throwCount > N) 
		{
			for (int i = 1; i < throwCount; i++) 
			{
				System.out.print(number[i - 1] + " ");
			}
			System.out.println();
			return;
		}

		boolean isDuplicate;
		for (int i = 1; i <= 6; i++)
		{
			isDuplicate = false;
			// 직전 던진 주사위 값들과 비교하여
			for (int j = 0; j < throwCount - 1; j++)
			{
				if (number[j] == i)  // 중복되어있다면
				{
					isDuplicate = true;
					break;
				}
			}

			if (isDuplicate)
			{
				continue;   // 중복되어 있다면 다음 i 값으로..
			}
			// 앞의 숫자들과 비료
			number[throwCount - 1] = i;
			dice3(throwCount + 1);	// 재귀호출
		}
	} // end dice3()	
	
	
} // end class
