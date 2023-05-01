package practice.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

//각 단어의 빈도수를 담을 클래스
class WordFreq implements Comparable<WordFreq>{

	String word;  // 발생단어
	int		freq;  // 빈도수
	
	public WordFreq(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordFreq o) {
		if(o.freq < this.freq) return -1;
		if(o.freq > this.freq) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return word + ":" + freq + "개";
	}
} // end WordFreq

class FreqDesc implements Comparator<WordFreq>{

	@Override
	public int compare(WordFreq o1, WordFreq o2) {
		if(o2.freq < o1.freq) return -1;
		if(o2.freq > o1.freq) return 1;
		return 0;
	}
}

public class AliceInWonderland {

	public static void main(String[] args) {		
		System.out.println("실습: 단어 발생 빈도");
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		// 발생빈도 방법1 : split, StringTokenizer
		String [] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		
		for(String w : words) {
			// 구두점 제거
			StringTokenizer tok = new StringTokenizer(w, ",.\"\'`!?;:-()");
			while(tok.hasMoreTokens()) {
				String word = tok.nextToken().toLowerCase();  // 대소문자 구분 없이

				if(word.length() > 1) {   // 2글자 이상 단어만 만 카운트						
					// 카운트
					Integer e = hmap.get(word);
					if(e == null)  // 기존에 해당 key값이 없었다면 (즉, 첫 등장이면)
						hmap.put(word, 1);  // 첫 등장, 등장 회수 1
					else
						hmap.put(word, e + 1);  // 기존 등장개수 +1 증가
				}
			} // end while
		} // end for
		
		// 발생빈도 방법2 : 정규표현식을 사용한다면 아래와 같이도 가능.
		hmap = new HashMap<String, Integer>();
		Matcher wordMatcher = Pattern.compile("[a-zA-Z]{2,}").matcher(C.ALICE30.toLowerCase());
		
		while(wordMatcher.find()) {
			String word = wordMatcher.group();
			
			Integer occur = hmap.get(word);
			
			if(occur == null) {
				hmap.put(word, 1);
			}else {
				hmap.put(word, occur + 1);			
			} // end if
		}// end while
		
		
		// 결과 출력
//		for(Map.Entry e : hmap.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue() + "개");
//		}
		
		
		
		
		LinkedList<WordFreq> list = new LinkedList<WordFreq>();
		
		// 결과 출력
		for(Map.Entry e : hmap.entrySet()) {
			list.add(new WordFreq((String)e.getKey(), (Integer)e.getValue()));
		}
		
		System.out.println("최다 빈도 순 출력 (내림차순) Comparable 사용");
		// 최다 발생 빈도순으로 정렬출력
		// 값 출력, 상위 20개만
		Collections.sort(list);   // WordFreq 가 이미 Comparable 을 구현했기 때문에 sort() 에서 동작 가능
		int i = 0;
		for(WordFreq e : list) {
			System.out.print(i + 1 + " ");
			System.out.println(e);
			i++;
			if(i == 20) break;
		}
		
		System.out.println();
		System.out.println("최다 빈도순 출력(내림차순) Comparator 사용");
		Collections.sort(list, new FreqDesc());
		i = 0;
		for(WordFreq e : list) {
			System.out.print(i + 1 + " ");
			System.out.println(e);
			i++;
			if(i == 20) break;
		}
		
		System.out.println();
		System.out.println("최다 빈도순 출력(오름차순) Comparator 익명클래스 사용 ");
		Collections.sort(list, new Comparator<WordFreq>() {

			@Override
			public int compare(WordFreq o1, WordFreq o2) {
				if(o2.freq > o1.freq) return -1;
				if(o2.freq < o1.freq) return 1;
				return 0;
			}
		});

		i = 0;
		for(WordFreq e : list) {
			System.out.print(i + 1 + " ");
			System.out.println(e);
			i++;
			if(i == 20) break;
		}

		System.out.println();
		System.out.println("단어순 출력(내림차순) Comparator lambda 사용 ");
		Collections.sort(list, (o1, o2) -> {
			return o2.word.compareTo(o1.word);
		});

		i = 0;
		for(WordFreq e : list) {
			System.out.print(i + 1 + " ");
			System.out.println(e);
			i++;
			if(i == 20) break;
		}

		System.out.println();
		System.out.println("단어순 출력(오름차순) Comparator lambda 사용 ");
		Collections.sort(list, (o1, o2) -> {
			return -(o2.word.compareTo(o1.word));
		});

		System.out.println(Arrays.toString(Arrays.copyOfRange(list.toArray(new WordFreq[list.size()]), 0, 10)));
		

		//----------------------------------------------------
		// Map.Entry 와 Comparator<> 사용하는 방법도 있다.
		// comparator이용해서 정렬
		System.out.println();
		System.out.println("단어순 출력(오름차순) Map.Entry + Comparator 사용 ");
		
		List<Map.Entry<String, Integer>> list2 = new LinkedList<>(hmap.entrySet());

		Collections.sort(list2, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> num1, Map.Entry<String, Integer> num2) {
				int comparision = (num1.getValue() - num2.getValue()) * -1;
				return comparision == 0 ? num1.getKey().compareTo(num2.getKey()) : comparision;
			}
		});

		// 순서 그대로 저장!
		Map<String, Integer> arrayMap = new LinkedHashMap<>();
		for (Iterator<Map.Entry<String, Integer>> iter1 = list2.iterator(); iter1.hasNext();) {
			Map.Entry<String, Integer> entry = iter1.next();
			arrayMap.put(entry.getKey(), entry.getValue());
		}

		//예시처럼 출력
		Set<Map.Entry<String, Integer>> entries = arrayMap.entrySet();
		for(Map.Entry<String, Integer> e : arrayMap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue() + "개");
		}
		
		
		System.out.println("\n프로그램 종료");		
	} // end main()

} // end class













