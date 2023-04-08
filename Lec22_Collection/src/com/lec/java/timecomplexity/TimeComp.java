package com.lec.java.timecomplexity;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/* 시간 복잡도 (Time Complexity)
 * 
 * 자료구조마다 특성이 다르기 때문에 
 * 동일한 기능을 수행해도 걸리는 시간 (이를 시간 복잡도 : Time Complexity 라 한다) 이 다르다
 *  
 *  컬렉션의 자료구조에 대해 이해를 하고 
 *  구현하고자 하는 상황에 따라 잘 선택해야 한다
 *  
 */
public class TimeComp {
	
	static final int SIZE = 5000000;  // 테스트할 데이터 크기
	static Integer[] searchValues = new Integer[4990]; 
	static Integer[] testArray = new Integer[SIZE];
	
	public static void main(String[] args) {

		for(int i = 0; i < testArray.length; i++) {
			testArray[i] = i;
		}
		
		// 0, 1000, 2000, ...  4989000  (4990개 데이터)
		for(int i = 0; i < searchValues.length; i++) {
			searchValues[i] = i * 1000;
		}
		
		testArrayList();
		testLinkedList();
		// 예상과 달리 LinkedList 는 ArrayList 보다 더 느리다
		// 오직 순차적인 접근만이 가능하기 때문.
		  
		testHashMap();
		
		System.out.println("\n[테스트 종료]");
	} // end main()
	
	
	public static void testArrayList() {
		System.out.println("[ArrayList]");
		ArrayList<Integer> list = new ArrayList<Integer>();
		long start = 0, end = 0;
		
		// 입력
		System.out.print("입력소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : testArray) {   // 5000000 개의 데이터
			list.add(e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 조회/탐색
		System.out.print("탐색소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			list.get(e);   // 걍 index??
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삽입
		System.out.print("삽입소요시간 : ");
		start = System.currentTimeMillis();
		for(int i = 1; i <= searchValues.length; i++) {
			list.add(0, -i);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삭제
		System.out.print("삭제소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			list.remove(e);   // 걍 index??
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	} //end testArrayList()
	
	public static void testLinkedList() {
		System.out.println("[LinkedList]");
		LinkedList<Integer> list = new LinkedList<Integer>();
		long start = 0, end = 0;
		
		// 입력
		System.out.print("입력소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : testArray) {   // 5000000 개의 데이터
			list.add(e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 조회/탐색
		System.out.print("탐색소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			list.get(e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삽입
		System.out.print("삽입소요시간 : ");
		start = System.currentTimeMillis();
		for(int i = 1; i <= searchValues.length; i++) {
			list.add(0, -i);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삭제
		System.out.print("삭제소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			list.remove(e);   // 걍 index??
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	} //end testLinkedList()
	

	public static void testHashMap() {
		System.out.println("[HashMap]");
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		long start = 0, end = 0;
		
		// 입력
		System.out.print("입력소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : testArray) {   // 5000000 개의 데이터
			hmap.put(e, e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 조회/탐색
		System.out.print("탐색소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			hmap.get(e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삽입
		System.out.print("삽입소요시간 : ");
		start = System.currentTimeMillis();
		for(int i = 1; i <= searchValues.length; i++) {
			hmap.put(-i, -i);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
		
		// 삭제
		System.out.print("삭제소요시간 : ");
		start = System.currentTimeMillis();
		for(Integer e : searchValues) {
			hmap.remove(e);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	} //end testHashMap()
	
	
	
	
	
	public static void test() {
		final int SIZE = 10_000_000;
        final List<Integer> arrayList = new ArrayList<>(SIZE);//용량 정하기
        final Set<Integer> hashSet = new HashSet<>(SIZE);
        final int data = 9_000_000;

        //순차 병렬 집계연산
        IntStream.range(0, SIZE).forEach(value -> {
            arrayList.add(value);
            hashSet.add(value);
        });

        Instant start = Instant.now();
        arrayList.contains(data);
        Instant end = Instant.now();
        long elapsedTime = Duration.between(start, end).toMillis();
        System.out.println("array list search time : " + elapsedTime + "초");

        start = Instant.now();
        hashSet.contains(data);
        end = Instant.now();
        elapsedTime = Duration.between(start, end).toMillis();
        System.out.println("hash set search time : " + elapsedTime + "초");

	}

} // end class

/*
[ArrayList]
입력소요시간 : 2404ms
탐색소요시간 : 2ms
삽입소요시간 : 10411ms
삭제소요시간 : 28750ms
[LinkedList]
입력소요시간 : 2205ms
탐색소요시간 : 19453ms
삽입소요시간 : 1ms
삭제소요시간 : 55409ms
[HashMap]
입력소요시간 : 730ms
탐색소요시간 : 4ms
삽입소요시간 : 0ms
삭제소요시간 : 4ms
*/





