package practice.matrixproduct;

public class MatrixProduct {

	// 두개의 2차원 배열(행렬:matrix) 를 곱하는 메소드   
	// 1. 배열곱을 할수 있는지 확인해야 한다.
	// 2. 배열곱을 한 결과를 담을 배열을 생성하여 리턴해야 한다. 
	
	public static void main(String[] args) {
		// 두개의 행렬 준비
		int [][] matrix1 = {
				{ 1, 2 },
				{ 3, 4 },
				{ 5, 6 }
		};
		int [][] matrix2 = {
				{ 1, 3 },
				{ 2, 4 }
		};
		
		int [][] product = matrixProduct(matrix1, matrix2);
		
		for(int[] row : product){
			for(int col : row){
				System.out.print(col + " ");
			} // end for
			System.out.println();
		} // end for		
	} // end main()
	
	public static int[][] matrixProduct(int[][] matrix1, int[][] matrix2){
		
		return null;
	} // end matrixProduct()

} // end class
