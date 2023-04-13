package com.lec.java.j17_10_BuilderPattern;
/* Builder Pattern
 * 
 * 객체를 생성하는 방식 3가지
 * 
 * 1 점층적 생성자 방식
 * 
 * 2 자바빈 패턴 방식
 *    JavaBean : getter & setter 제공되는 객체
 * 
 * 3 Builder Pattern  
 * 		객체를 생성할 때 많이 사용하는 패턴
 * 		생성자에 매개변수가 많다면 빌더를 고려하자!
 * 		static inner class 사용하여 구현
 */

// https://johngrib.github.io/wiki/builder-pattern/#%EB%B9%8C%EB%8D%94-%ED%8C%A8%ED%84%B4effective-java-%EC%8A%A4%ED%83%80%EC%9D%BC

public class BuilderPatternMain {

	public static void main(String[] args) {
		// 1. 점층적 생성자 방식의 단점
		// 생성자 호출 코드만으로는 각 인자의 의미를 알기 어렵다.
		Member1 john = new Member1("aaa");
		Member1 susan = new Member1("aaa", "bbb");
		Member1 kelly = new Member1("aaa", "bbb", "ccc");

		// 2. 자바빈 패턴 방식
		// 1회 호출로 객체 생성이 끝나지 않고 setter로 계속 덮어쓰기한다.
		Nutrition2 cocaCola = new Nutrition2();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbonhydrate(27);
		
		// 3. Builder 패턴 사용
		Nutrition3.Builder builder = new Nutrition3.Builder(240, 8);
		builder.calories(100);
		builder.sodium(35);
		builder.carbohydrate(27);
		Nutrition3 pepsiCola = builder.build();
		
		// 다음과 같이 체이닝 하여 주로 사용한다 ★
		// 각 줄마다 builder를 타이핑하지 않아도 되어 편리하다.
		Nutrition3 sprite = new Nutrition3.Builder(240, 8)    // 필수값 입력
		    .calories(100)
		    .sodium(35)
		    .carbohydrate(27)
		    .build();           // build() 가 객체를 생성해 돌려준다.
		
	} // end main()
 
} // end class

// 점층적 생성