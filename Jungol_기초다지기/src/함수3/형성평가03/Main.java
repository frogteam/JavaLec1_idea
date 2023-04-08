package 함수3.형성평가03;

/* 233 : 함수3 - 형성평가3
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=133&sca=10d0
자연수 N과 M을 입력받아서 주사위를 N번 던져서 나온 눈의 합이 M이 나올 수 있는
모든 경우를 출력하는 프로그램을 작성하시오.
단, N은 10 이하의 정수이다.

입력 예]
3 10

출력 예]
1 3 6
1 4 5
1 5 4
1 6 3
2 2 6
2 3 5
…
6 2 2
6 3 1

Hint!
  재귀함수에 레벨(level)과 합계(sum) 두 개의 인수를 전달하여 sum이 M과 같은 경우에만 출력하도록 한다.
  (정의 : void dice(int level int sum) 호출 : dice(level+1 sum+i))

 */

import java.util.Scanner;
public class Main {

	static int N, M;
	static int [] arr = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		dice(0, 0);

		sc.close();
	} // end main()

	public static void dice(int level, int sum){
		if(level == N) return;
		for(int i = 1; i <= 6; i++){
			arr[level] = i;
			if(level + 1 ==  N && sum + i == M){
				for(int j = 0; j < arr.length; j++){
					System.out.print(arr[j] + " ");
				}
				System.out.println();
				break;
			}
			dice(level + 1, sum + i);
		}
	}

} // end class
