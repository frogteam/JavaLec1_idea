package com.lec.java.collection09;

import java.util.Iterator;
import java.util.TreeSet;

/* TreeSet

 Collection<E>
  |__ Set<E>
       |__ HashSet<E>, TreeSet<E>

 TreeSet: 데이터가 정렬된 상태로 저장(오름차순, 내림차순)
 
 	(※ TreeXXX ← 주로 '정렬'에 특화된 자료구조 입니다)
*/
public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 클래스");
		
		// Integer 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		// 데이터 저장 : add()
		tset.add(11);
		tset.add(2);
		tset.add(14);
		tset.add(1);
		tset.add(7);
		tset.add(15);
		tset.add(5);
		tset.add(8);
		
		// 데이터 검색 - Iterator 사용
		// TreeSet인 경우에 iterator() 메소드 오름차순 정렬
		System.out.println("오름차순:");
		Iterator<Integer> iterator = tset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println();
		System.out.println("내림차순:");
		// 내림차순 Iterator : descendingIterator() 사용
		Iterator<Integer> iterator2 = tset.descendingIterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		
		// enhanced for
		System.out.println();
		System.out.println("enhanced for");
		for (Integer num : tset) {
			System.out.println(num);
		}
		
		
//		subSet() 메소드
//		시작 값과 끝 값을 매개변수로 받아, 그것을 범위로, 부분 Set 을 추출합니다. 다음 2가지 오버로딩
//
//		SortedSet<E> subSet(E fromElement, E toElement)
//		시작 포함  ~ 끝 이전(미포함) 까지의 부분집합 반환
//
//		NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
//		시작 (포함여부 선택 가능) ~ 끝 (포함여부 선택 가능) 까지의 부분 집합 반환
//
//		주의해야 할 점은, subSet 메소드의 내부에서, 원본 set 의 데이터들을 복사해서 새로 부분 집합을 구성하는 것이 아니라, 
//		원본 데이터들을 그대로 두고, 원본 set 과 Sub Set 이 같이 바라보고 있는 상태에서, 
//		subSet 은 해당 범위만 바라볼 수 있는 형태로 되어 있다는 것입니다. 
//		이에 따라, subSet 메소드 후에, 원본 Set 이나 sub Set 에 변경이 일어나면 (추가, 삭제 등) 
//		원본 Set, Sub Set 모두 변경이 동시에 일어난다고 보면 됩니다. (단, Sub Set 은 해당 범위만 보여짐)

		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for (int i = 606; i < 613; i++){
			if (i % 2 == 0){
				s.add(i);
			} // end if
		} // end for
		subs = (TreeSet) s.subSet(608, true, 611, true);  // subSet() 메소드  608 (포함) ~  611 (포함) 범위 추출   
		s.add(609);
		System.out.println(s + " " + subs);   // <- 과연 결과는 어떻게 나올까?
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Collection11Main












