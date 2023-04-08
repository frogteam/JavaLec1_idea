package practice.random;

import java.util.Arrays;
import java.util.Random;

public class RandomGenerator {

	public static void main(String[] args) {
		int [] arr = null;
		arr = randomize(3, 5, 3);
		System.out.println(Arrays.toString(arr));
		arr = randomize(213, 482, 1);
		System.out.println(Arrays.toString(arr));
		arr = randomize(-30, -20, 4);
		System.out.println(Arrays.toString(arr));
		
		arr = randomize(1, 5, 10);   // 1 부터 5까지의 범위인데 중복되지 않는 10개??  그러면 5개만 생성
		System.out.println(Arrays.toString(arr));
		arr = randomize(1, 2, 3);
		System.out.println(Arrays.toString(arr));
		
	} // end main
	
	public static int[] randomize (int startNum, int endNum, int count) {
	
		int big, small;
		if(endNum >= startNum) {
			big = endNum;
			small = startNum;
		} else {
			big = startNum;
			small = endNum;
		}

		// 범위 개수
		int range = big - small + 1;
	
		// 중복된는 것 제외하려면  count 값은  [start ~ end] 사이의 수보다 같거나 작아야 한다
		if(endNum - startNum + 1< count) {
			System.out.println("count 값은 : " + range + " 이하이어야 합니다" );
			count = range;  // count 값 변경!
		}
		
		// count 개수만큼의 배열 생성
		int [] arr = new int[count];
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			// 난수 발생
			arr[i] = rand.nextInt(range) + small;
				
			// 중복되지 않는 난수발생하기 위한 루프
			for(int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;   // 다시 추출하기 위해서
					break;
				}
			} // end for
		} // end for
		
		// 출력하기 버젼
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + ", ");
//		}
//		System.out.println();
		
		return arr;
	} // end randomize()
	
	// ※ 테스트는  randomize(3, 5, 3);

} // end class
