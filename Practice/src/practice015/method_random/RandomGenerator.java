package practice015.method_random;

/*
 * https://docs.google.com/presentation/d/1t6DbythT-2W8vfsQT3ZTjGadEnwDbFliMozE_-2hn4E/edit
 */
public class RandomGenerator {

	public static void main(String[] args) {

		
		//randomize(10, 21, 3);
		//randomize(213, 482, 1);
		//randomize(-30, 60, 3);
		
		//randomize(1, 2, 3);
		randomize(1, 5, 10);   // <- 관건은 이런거다.  1 부터 5까지의 범위인데 중복되지 않는 10개

	}
	
	public static void randomize(int startNum, int endNum, int count){
		int start = startNum;
		int end = endNum;
		int cnt = count;
		int range;
		int randNum;
		
		if(startNum > endNum){
			start = endNum;
			end = startNum;
		}
		range = end - start + 1;
		
		// 중복되지 않아야 한다
		// 그런데 범위의 정수 개수보다, count 의 개수가 많다면?  출력개수를 한정지어야 한다.
		if(range <= count){
			cnt = range;
		}
		
		int [] arr = new int[cnt];
		for(int i = 0; i < cnt; i ++){
			int j;
			// 중복되면 안된다,  중복되지 않은 난수 발생될때까지 무한반복
			while(true){
				randNum = (int)Math.floor(Math.random() * range) + start;
				for(j = 0; j < i; j++){ // 이전에 
					if(arr[j] == randNum){ // 중복되었다면?  다시 뽑아야 한다
						break;
					}
				}
				if(j == i){  // j == i 라는 뜻읏 중복된것이 없었다는 뜻이니
					break;	// while(true) 탈줄채도 좋다
				}
			} // end while
			
			arr[i] = randNum;
			System.out.print(arr[i]);
			if(i + 1 < cnt){
				System.out.print(", ");
			}

		} // end for
		System.out.println();
		
		// 나중에 Collectoin 들을 배우면 중복되지 않는 방법에 대해 새롭게 배울수 있다.
		
	} // end randomize()

} // end class
