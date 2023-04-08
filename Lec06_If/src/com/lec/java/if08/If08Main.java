package com.lec.java.if08;

/* 실수값은 정밀도(precision) 의 문제가 있기 때문에
 * 산술계산 결과값 등의 '같은값 여부' 비교는 하지 말자 
 */
public class If08Main {

	public static void main(String[] args) {
		System.out.println("실수 비교 연산 주의");

		// 실수값은 정밀도(precision) 의 문제가 있기 때문에
		// 산술계산 결과값 등의 '같은값 여부' 비교는 하지 말자 
		
		float f1 = 0.1f * 0.1f;
		float f2 = 0.01f;
		
//		double d1 = 3.1415926535;
//		double d2 = 3.1415926535;
		
//		float f1 = 3.141592f * 10.0f / 2.0f;
//		float f2 = 3.141592f * 5.0f;
		
		System.out.println("== 를 사용하는 경우");
		if(f1 == f2){
			System.out.println(f1 + " 과 " + f2 + " 는 같습니다");
		}else{  
			// 결과 : 0.010000001 과 0.01 는 다릅니다 
			System.out.println(f1 + " 과 " + f2 + " 는 다릅니다");
		}
		System.out.println();
		
		
		// 실수 값이 산술적으로 같은지 여부를 확인할때는 
		// Double.compare(double, double) 
		// Float.compare(float, float) 
		// 를 사용합니다.
		// 같을 경우 0 을 리턴
		
		
		
		System.out.println("compare() 를 사용하는 경우는?");
		if(Float.compare(f1, f2) == 0){
			System.out.println(f1 + " 과 " + f2 + " 는 같습니다");
		}else{
			System.out.println(f1 + " 과 " + f2 + " 는 다릅니다");
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
