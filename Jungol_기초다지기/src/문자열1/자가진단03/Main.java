package 문자열1.자가진단03;
/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=232&sca=10e0
문자열을 “Hong Gil Dong”으로 초기화 한 후 3번부터 6번까지의 문자를 차례로 출력하시오.

[입력예]

[출력예]
g Gi
 */
public class Main {

	public static void main(String[] args) {
		String str = "Hong Gil Dong";
		
		System.out.println(str.substring(3, 6 + 1));
		
	} // end main()

} // end class
