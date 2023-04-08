package practice.jessecookie;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 	Jesse's cookie 문제
 	PriorityQueue + Comparator 사용
 	
 	원본: https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 	
 	[입력예]
	6 7
	1 2 3 9 10 12
	
	[출력예]
	2
	
	--설명--
 */
public class Cookie {

	public static void main(String[] args) {

		Cookie c = new Cookie();
		
		int [] cookies = {2, 1, 10, 12, 9, 3};
		
		//{2, 1, 10, 12, 9, 3}
		//{1, 2, 3, 9, 10, 12}
		
		int result = c.Jesse_Cookies(cookies, 7);
		
		System.out.println(result);
	} // end main()

	public int Jesse_Cookies(int[] cookies, int k) {
		// 오름 차순으로 PriorityQueue 설정
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Asc());
		
		for(int cookie : cookies) {
			pq.offer(cookie);
		}
		
		Integer firstCookie, secondCookie;
		int mixcount = 0;
		// 첫번
		while(pq.peek() < k) {   
			if(pq.size() < 2) return -1;
			
			firstCookie = pq.poll();   // 첫번째 쿠키
			secondCookie = pq.poll();  // 두번째 쿠키
			
			// mixed cookie
			pq.offer(firstCookie + 2 * secondCookie); // sweetness = 1 x Least sweet cookie + 2 x 2nd least sweet cookie)
			mixcount++;
			
		} // end while
		
		return mixcount;
	} // end Jesse_Cookies()
} // end class

class Asc implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2) return 1;
		if(o1 < o2) return -1;
		return 0;
	}
}

class Desc implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2) return 1;
		if(o1 > o2) return -1;
		return 0;
	}
}
