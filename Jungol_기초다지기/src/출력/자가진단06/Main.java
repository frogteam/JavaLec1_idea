package 출력.자가진단06;
/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=143&sca=1010

506 : 출력 - 자가진단6 

다음과 같이 출력되는 프로그램을 작성하라.
   
[출력예] 
My height
170
My weight
68.600000
 
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("My height");
		System.out.println("170");
		System.out.println("My weight");
		double d = 68.6;
		System.out.printf("%.6f", d);
	}
}
