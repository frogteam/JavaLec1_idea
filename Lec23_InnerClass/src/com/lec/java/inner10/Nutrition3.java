package com.lec.java.inner10;

/* Builder Pattern
 * 장점
 * 	각 인자가 어떤 의미인지 알기 쉽다.	
 * 	setter 메소드가 없으므로 변경 불가능(immutable) 객체를 만들 수 있다.
 * 	한 번에 객체를 생성하므로 객체 일관성이 깨지지 않는다.
 * 	build() 함수가 잘못된 값이 입력되었는지 검증하게 할 수도 있다.
 */
public class Nutrition3 {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// Required parameters(필수 인자)
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) { // 필수 인자
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this; // 이렇게 하면 . 으로 체인을 이어갈 수 있다.
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		// 마지막으로 build() 로 outer 의 객체를 생성하여 리턴
		public Nutrition3 build() {
			return new Nutrition3(this);
		}
	}

	private Nutrition3(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
} // end class