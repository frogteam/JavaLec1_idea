package 반복제어문2.자가진단07;

/*
547 : 반복제어문2 - 자가진단7 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=184&sca=1070

아래와 같이 출력되는 프로그램을 작성하시오.

[출력예]
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 10
 
 
[hint]    
i와 j값을 둘 다 활용하여 식을 만들어 본다.

 */
public class Main {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print((i + j) + " ");
			}
			System.out.println();
		}

	} // end main()

} // end class
