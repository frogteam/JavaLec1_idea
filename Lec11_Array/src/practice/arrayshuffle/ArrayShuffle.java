package practice.arrayshuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 초간단 배열 섞기

public class ArrayShuffle {
	public static void main(String[] args) {
		String str = "강진\r\n"
				+ "곽기환\r\n"
				+ "권혁찬\r\n"
				+ "김경민\r\n"
				+ "김민수\r\n"
				+ "김민지\r\n"
				+ "김선철\r\n"
				+ "김승민\r\n"
				+ "김영은\r\n"
				+ "김종원\r\n"
				+ "김진섭\r\n"
				+ "김하은\r\n"
				+ "노수빈\r\n"
				+ "박성민\r\n"
				+ "박진우\r\n"
				+ "박해연\r\n"
				+ "배서하\r\n"
				+ "서준원\r\n"
				+ "신동민\r\n"
				+ "신현담\r\n"
				+ "윤솔비\r\n"
				+ "윤은경\r\n"
				+ "이상빈\r\n"
				+ "장윤호\r\n"
				+ "장은총\r\n"
				+ "정요셉\r\n"
				+ "정은수\r\n"
				+ "정재욱\r\n"
				+ "조성훈\r\n"
				+ "최민석\r\n"
				+ "최정민\r\n"
				+ "하병노\r\n"
				+ "홍영기";
		String [] arr = str.split("\\s+");
		
		List<String> list = Arrays.asList(arr);  // 배열 --> List 로 변환
		Collections.shuffle(list);   // shuffle() 무작위로 섞기
		
// 상위 n개만 뽑을 경우 (즉 무착위로 n개만 뽑는경우)		
//		int n = 4;
//		list = list.subList(0, n);   

		//arr = (String[])list.toArray();  //  List --> 배열 로 변환
//		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(list.stream().collect(Collectors.joining("\t")));


	}
}
