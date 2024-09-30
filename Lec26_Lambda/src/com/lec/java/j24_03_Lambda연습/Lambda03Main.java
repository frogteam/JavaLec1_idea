package com.lec.java.j24_03_Lambda연습;

import java.util.*;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
		// 세가지 방법으로 연습
		// 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		// 방법 2) 익명클래스
		// 방법 3) 람다 표현식 lambda expression
		{
			// 인터페이스(추상메소드) 구현 3가지 방법
			System.out.println();
			System.out.println("덧셈");
			//-<덧셈>-----------------------------------------
			// 방법 1) 클래스 implments 인터페이스 + 오버라이딩.
			Operable adder1 = new Adder();
			// 방법 2) 익명클래스
			Operable adder2 = new Operable() {
				@Override
				public double operate(double x, double y) {
					return x + y;
				}
			};
			// 방법 3) 람다표현식
			Operable adder3 = (x, y) -> x + y;
			
			test(10, 20, adder1);
			test(32, 21, adder2);
			test(44, 100, adder3);

			//-<뺄셈>--------------------------------------
			System.out.println();
			System.out.println("뺄셈");
			// 방법1)클래스 implments 인터페이스 + 오버라이딩.
			test(20, 10, new Subtracter());
			
			// 방법2)익명클래스
			test(40, 15, new Operable() {
				@Override
				public double operate(double x, double y) {
					return x - y;
				}
			});
			
			// 방법3)람다표현식
			test(50, 10, ((x, y) -> x - y));

			//-<곱셈>--------------------------------------
			System.out.println();
			System.out.println("곱셈");
			// 방법1)클래스 implments 인터페이스 + 오버라이딩.
			test(2, 4, new Multiplier());
			// 방법2)익명클래스
			test(7, 10, new Operable() {
				@Override
				public double operate(double x, double y) {
					return 7 * 10;
				}
			});
			// 방법3)람다표현식
			test(6, 3, ((x, y) -> x * y));

			//-<나눗셈>--------------------------------------
			System.out.println();
			System.out.println("나눗셈");
			// 방법1)클래스 implments 인터페이스 + 오버라이딩.
			test(10, 2, new Divider());
			
			// 방법2)익명클래스
			test(100, 25, new Operable() {
				@Override
				public double operate(double x, double y) {
					return x / y;
				}
			});
			
			// 방법3)람다표현식
			test(50, 10, ((x, y) -> x / y));
			
			
		}
		
		
		
		
		System.out.println();
		
		TestMath tm01 = new TestMath();
		
		System.out.println();
		System.out.println("[1]");
		
		// 인터페이스를 구현하는 클래스의 인스턴스를 생성해서 사용
		Operable adder = new Adder();
		tm01.test(1.1, 2.2, adder);
		
		Operable sub = new Subtracter();
		tm01.test(1.1, 2.2, sub);
		
		
		System.out.println();
		System.out.println("[2]");
		
		// 익명 클래스 사용
		tm01.test(1.1, 2.2, new Operable() {

			@Override
			public double operate(double x, double y) {
				
				return x + y;
			} // end operate
			
		});
		
		tm01.test(1.1, 2.2, new Operable() {

			@Override
			public double operate(double x, double y) {
				
				return x - y;
			} // end operate
			
		});
		
		
		System.out.println();
		System.out.println("[3]");
		
		// 람다 표현식
		tm01.test(1.1, 2.2, (x, y) -> x + y);
		tm01.test(1.1, 2.2, (x, y) -> x - y);


		System.out.println();
		System.out.println("============================");
		
		System.out.println();
		System.out.println("클래스 인스턴스 사용");
//		MyMath mul = new Multiplier();
		tm01.test(1.1, 2.2, new Multiplier());
		tm01.test(1.1, 2.2, new Divider());
		
		System.out.println();
		System.out.println("익명 클래스 사용");
		tm01.test(1.1, 2.2, new Operable() {
			@Override
			public double operate(double x, double y) {
				
				return x * y;
			} // end operate()
			
		});
		
		tm01.test(1.1, 2.2, new Operable() {
			@Override
			public double operate(double x, double y) {
				
				return x / y;
			} // end operate()
			
		});
		
		System.out.println();
		System.out.println("람다 표현식");
		tm01.test(1.1, 2.2, (x, y) -> x * y);
		tm01.test(1.1, 2.2, (x, y) -> x / y);

		//-----------------------------------------------
		// Comparator<T>
		System.out.println("\nComparator<T>");
		List<Student> list3 = Arrays.asList(
				new Student("Susie", 50),
				new Student("James", 80),
				new Student("Kevin", 30)
		);
		System.out.println(list3);

		// 점수 오름차순
		// 익명클래스 사용
		Collections.sort(list3, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int)(o1.point - o2.point);
			}
		});
		System.out.println(list3);

		// lambda 사용
		// 점수 내림차순
		Collections.sort(list3, (o1, o2) -> (int)(o2.point - o1.point));
		System.out.println(list3);

		// [도전]
		// 이름 오름차순
		Collections.sort(list3, (o1, o2) -> o1.name.compareTo(o2.name));
//		Collections.sort(list3, Comparator.comparing(o -> o.name));   // 이와 같이도 가능.  이미 String 은 Comparable<> 구현체니까 가능
		System.out.println(list3);

		// 이름 내림차순
		Collections.sort(list3, (o1, o2) -> o2.name.compareTo(o1.name));
		System.out.println(list3);

		//----------------------------------------
		System.out.println("-".repeat(20));
		{
			Map<String, Integer> hmap = new HashMap<>();
			//   단어,  횟수
			hmap.put("BBB", 200);
			hmap.put("AAA", 400);
			hmap.put("CCC", 100);
			System.out.println(hmap);

			// 실습 : lambda 활용
			// 1. 횟수 오름차순 출력
			List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());
			System.out.println(list);// [AAA=400, CCC=100, BBB=200]

			Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
			System.out.println(list);

			// 동일한 결과
			Collections.sort(list, Comparator.comparing(e -> e.getValue()));  // Comparable<> 사용
			System.out.println(list);

			// 동일한 결과
			Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
			System.out.println(list);

			// 2. 횟수 내림차순 출력
			Collections.sort(list,(o1, o2) -> (o2.getValue() - o1.getValue()));
			System.out.println(list);

		}

		System.out.println("\n프로그램 종료");
	} // end main()

	public static void test(double x, double y, Operable op) {
		System.out.println("result = " + op.operate(x, y));
	}
	
} // end class


/*  
// ↓ 한 클래스 안에서 수행할 경우

// 덧셈 연산
class Adder implements Operable{
	@Override
	public double operate(double x, double y) {
		return x + y;
	}
}

// 뺄셈 연산
class Subtracter implements Operable{
	@Override
	public double operate(double x, double y) {
		return x - y;
	}
}

// 곱셈 연산
class Multiplier implements Operable{
	@Override
	public double operate(double x, double y) {
		return x * y;
	}
}
 */











