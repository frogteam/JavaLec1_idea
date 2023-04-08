package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;
/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
*/
public class MaxWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 최대 단어 개수를 가진 '문자열'과  그 '단어개수'를 담을 변수 선언 
		String maxWordSentence = null;
		int maxWordCount = 0;
		
		String line = sc.nextLine().trim();  // 문자열 입력
		
		StringTokenizer token = new StringTokenizer(line, ".?!"); // 문장 추출
		while(token.hasMoreTokens()) {
			String sentence = token.nextToken().trim(); // 좌우 공백 제거
			String [] words = sentence.split("\\s+");  // 문장 내 '단어' 추출
			if(words.length > maxWordCount) {   // 단어의 개수체크
				maxWordSentence = sentence;     // 최대 단어 개수 문장 추출 
				maxWordCount = words.length;
			} // end if
		} // end while
		
		if(maxWordSentence != null) {
			System.out.println(maxWordCount + "개");
			System.out.println(maxWordSentence);
		} // end if
		
		sc.close();
	} // end main
} // end class
