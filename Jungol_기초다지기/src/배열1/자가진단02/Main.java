package 배열1.자가진단02;
/*
556 : 배열1 - 자가진단2 

정수 10 개를 저장할 수 있는 배열을 만들어서 1 부터 10 까지를 대입하고 차례대로 출력하는 프로그램을 작성하시오.
   
1 2 3 4 5 6 7 8 9 10
 

 */
public class Main {

	public static void main(String[] args) {
		int [] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i + 1 < arr.length) System.out.print(" ");
		}
		
	}

}
