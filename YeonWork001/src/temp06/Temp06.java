package temp06;

import java.util.HashSet;

/*
	equals() 는 두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자
	hashCode() 는 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자 
	http://anster.tistory.com/160
 */


public class Temp06 {

	public static void main(String[] args) {

		
		A a1 = new A();  a1.num = 10; a1.id = "a1";
		A a2 = new A();  a2.num = 10; a2.id = "a2";
		
		System.out.println(a1);  // 주소값.. (정확히는 hash값이다)
		System.out.println(a2);
		// 다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		System.out.println("a1 == a2 ? " + (a1 == a2));				// false 다르다고 나온다.
		System.out.println("a1.equals(a2) = " + (a1.equals(a2)));   //  false 다르다고 나온다.  (도대체 뭘 비교한걸까?)
		
		System.out.println();
		
		HashSet<A> setA = new HashSet<A>();
		setA.add(a1);
		setA.add(a2);
		System.out.println("a1, a2 add() 후 ");
		System.out.println("set개수: " + setA.size());
		for(A obj : setA) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}
		
		System.out.println();
		
		setA.remove(a1);
		System.out.println("a1 삭제후");
		System.out.println("set개수: " + setA.size());
		for(A obj : setA) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}
		
		//------------------------------------------------------------
		
		System.out.println("--------------------------------------");
		B b1 = new B();  b1.num = 11; b1.id = "b1";
		B b2 = new B();  b2.num = 10; b2.id = "b2";
		
		
		System.out.println(b1);
		System.out.println(b2);
		//다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		System.out.println("b1 == b2 ? " + (b1 == b2));

		HashSet<B> setB = new HashSet<B>();
		setB.add(b1);
		setB.add(b2);
		System.out.println("b1, b2 add() 후 ");
		System.out.println("set개수: " + setB.size());
		// 출력 되는 순서에 주목하라!  결국 hash 값 순서대로 출력된다.
		for(B obj : setB) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}
		
		B b3 = new B();  b3.num = 10; b3.id = "b3";
		setB.add(b3);
		System.out.println("b3 추가후");
		for(B obj : setB) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}

		//------------------------------------------------------------
		
		System.out.println("--------------------------------------");
		C c1 = new C();  c1.num = 11; c1.id = "c1";
		C c2 = new C();  c2.num = 11; c2.id = "c2";
		C c3 = new C();  c3.num = 10; c3.id = "c3";
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		//다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		// 비교연산자 == 는 hashCode() equals() 와는 관계 없다.
		System.out.println("c1 == c2 ? " + (c1 == c2));

		HashSet<C> setC = new HashSet<C>();
		setC.add(c1);
		setC.add(c2);
		setC.add(c3);
		System.out.println("c1, c2, c3 add() 후 ");
		// 출력되는 개수에 주목!  c2는 add 되지 않았다!  즉, 같은 지 여부는 equals() 가 사용되었다.
		System.out.println("set개수: " + setC.size());
		// 출력 되는 순서에 주목하라!  결국 hash 값 순서대로 출력된다.
		for(C obj : setC) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}

		
		// 결론!!!!
		// 동일성 여부는 (equals() 로 체크
		// 저장 순서는 hashCode() 로 저장됨.
		
	} // end main()
} // end class


class A{
	int num;
	String id;
} // end class

class B{
	int num;
	String id;
	
	@Override
	public int hashCode() {
		return num % 3;
	}
} // end class

class C{
	int num;
	String id;
	
	@Override
	public boolean equals(Object obj) {
		if(num == ((C)obj).num) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return num % 3;
	}
}



