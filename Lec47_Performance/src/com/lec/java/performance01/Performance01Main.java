package com.lec.java.performance01;

import java.util.Date;


// JAVA의 실행 성능에 영향을 주는 코딩
// 
public class Performance01Main {

	public static void main(String[] args) {

		// 1. Static 메소드를 사용하여 Garbage Collection 이 발생안하게 하자
		//    객체생성(new) 와 garbage collection 은 실제로 많은 CPU 부하가 걸리게 되는 동작이다
		// 
		//   다음 두가지를 비교

		// 예제 1-1
		{
			String str1 = "55";
			int num1 = new Integer(str1).intValue();		// Integer클래스를 '생성(new)' -> 나중에 garbage collection 이 작동된다
		}
		// 예제 1-2
		{
			String str2 = "55";
			int num2 = Integer.parseInt(str2);				// 생성(new) 하지 않고 static 메소드 사용 -> garbage collection 필요없슴
		}
		

		
		// 2. 임시 Object 생성이 되는 것을 피하여 Garbage Collection 이 발생안하게 하자
		//    append를 위해서 (+) 연산을 사용하는 것을 들 수 있다. 
		//    (+) 연산자를 사용해서 String Object를 append할 경우 
		//    생각보다 훨씬 더 많은 임시 Object가 생성되고, 가비지 컬렉터에 의해 다시 수집된다. 
		//    String Object의 append 연산을 위해서는 StringBuffer 클래스를 사용하자 
		// 
		//   다음 두가지를 비교		
		
		// 예제 2-1
		{
			String str3 = "Hello ";
			str3 = str3 + "World";
			System.out.println(str3);
		}
		 
		// 예제 2-2
		{
			StringBuffer str4 = new StringBuffer();
			str4.append("Hello ");
			str4.append("World");
			System.out.println(str4.toString());
		}
		
		
		// 3. 루프 내에서의 Object 생성을 가급적 피한다
		//   다음 두가지를 비교
		
		// 예제 3-1
		{
			for(int i = 0; i < 1000; i++) {
			    Date a = new Date();
			    //...
			}
		}
		 
		// 예제 3-2
		{
			Date a;
			for(int i = 0; i < 1000; i++) {
			    a = new Date();
			    //...
			    a = null;
			}
		}
		
		
		// 4. Primitive Data Type 을 사용하여 Gargabe Collection 회피
		//    Data, String 등의 클래스중에 int나 long 형으로 표현하여 사용할수 있는 것들은 primitive type으로 사용하자
		//    String 타입등으로 만든 경우 나중에 primitive type 으로 변환할때 (ex: Integer.ParseInt()) 더 시간이 많이 소요된다.
		String num11 = "1234";
		int num12 = 1234;
		
		
		// 5. Object 재사용(메소드를 사용한 Object 초기화) 을 통해 생성과정(new) 의 횟수 최소화
		// 예제5-1)
		{
			StringBuffer sb = new StringBuffer();
			sb.append("Hello");
			System.out.println(sb.toString());
			sb = null;
			 
			sb = new StringBuffer();		// 결국 new 를 두번 호출한다
			sb.append("World");
			System.out.println(sb.toString());
		}
		 
		// 예제5-2)
		{
			StringBuffer sb = new StringBuffer();
			sb.append("Hello");
			System.out.println(sb.toString());
			sb.setLength(0);				// new를 반복 호출할 필요가 없다
			sb.append(" World");
			System.out.println(sb.toString());
		}
		
		
		// 6. FileIo 관련.  --> Lec29 참조

	} // end main()
} // end class



