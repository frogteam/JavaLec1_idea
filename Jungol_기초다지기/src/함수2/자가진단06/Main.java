package 함수2.자가진단06;


/*
	http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=221&sca=10c0
	
	584 : 함수2 - 자가진단6 
	
	main() 함수 내에는 숫자를 사용하지 말고 1, 2, 3 세 개의 숫자를 조합하여 가능한 한 모든 합을 출력하는 프로그램을 작성하시오. 
	출력예와 같이 출력하시오.
	   
	1 + 1 = 2
	1 + 2 = 3
	1 + 3 = 4
	2 + 1 = 3
	2 + 2 = 4
	2 + 3 = 5
	3 + 1 = 4
	3 + 2 = 5
	3 + 3 = 6
 
*/

public class Main {

	public static void main(String[] args) {

		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				printMul(i, j);
			}
		}

	} // end main()

	public static void printMul(int a, int b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}
	
	
} // end class
