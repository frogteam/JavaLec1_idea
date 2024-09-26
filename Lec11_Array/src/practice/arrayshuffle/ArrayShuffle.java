package practice.arrayshuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 초간단 배열 섞기

public class ArrayShuffle {
	public static void main(String[] args) {
		String str = """
				김민혁
				김범순
				노경민
				박동신
				박준우
				신창영
				윤가희
				이경원
				이동희
				이석
				이유나
				장준영
				정문선
				최시후
				현지윤
				황예은
				""";
		String [] arr = str.split("\\s+");
		
		List<String> list = Arrays.asList(arr);  // 배열 --> List 로 변환
		Collections.shuffle(list);   // shuffle() 무작위로 섞기
		
// 상위 n개만 뽑을 경우 (즉 무착위로 n개만 뽑는경우)		
//		int n = 4;
//		list = list.subList(0, n);   

		//arr = (String[])list.toArray();  //  List --> 배열 로 변환
//		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(list.stream().collect(Collectors.joining("\t")));


		{ // JAVA QUIZ
			// 1조
//			shuffle("현지윤 이동희 윤가희 이경원", 1);
//			shuffle("B58 A14 D21 C06 B04", 1);

			// 2조
//			shuffle("신창영 황예은 이석 김범순", 1);
//			shuffle("A52 A09 D04 C03 A31", 1);

			// 3조
//			shuffle("박준우 최시후 이유나 장준영", 1);
//			shuffle("A47 B20 D26 C59 A08", 1);

			// 4조
//			shuffle("노경민 박동신 김민혁 정문선", 1);
//			shuffle("B41 A18 D28 C13 C14", 1);
		}
	} // end main()

	// 메소드로 준비
	public static void shuffle(String str){
		String[] arr = str.trim().split("\\s+");
		List<String> list = Arrays.asList(arr);  // 배열 --> List 로 변환
		Collections.shuffle(list);   // shuffle() 무작위로 섞기
		System.out.println(list.stream().collect(Collectors.joining("\t")));
	}

	public static void shuffle(String str, int top){
		String[] arr = str.trim().split("\\s+");
		List<String> list = Arrays.asList(arr);  // 배열 --> List 로 변환
		Collections.shuffle(list);   // shuffle() 무작위로 섞기
		list = list.subList(0, top);
		System.out.println(list.stream().collect(Collectors.joining("\t")));
	}
}
