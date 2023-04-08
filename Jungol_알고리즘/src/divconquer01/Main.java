package divconquer01;

import java.util.Scanner;

/*
 * 분할 정복 : divide & conquer
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=523&sca=30
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		sc.close();
		
		System.out.println("root " + x + " = " + sroot(x));
	}
	
	public static long sroot(long x) {
		long start=1, end=x, ans = 0;
		
		if(x == 0 || x == 1 ) {
			return x;
		}
		
		while(start <= end) {
			long mid = (start + end) / 2;
			System.out.println("start:" + start + " end:" + end + " mid:" + mid);
			if(mid * mid < x) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
			if(mid * mid  == x) {
				return mid;
			}			
		} // end while
		
		return ans;
	}

}















