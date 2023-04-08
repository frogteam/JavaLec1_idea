package com.lec.java.object03;

import java.util.HashSet;

/*
	equals() 는 두 객체의 내용이 같은지, 동등성(equality, equivalent) 를 비교하는 연산자
	hashCode() 는 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자 
	http://anster.tistory.com/160
	
	
	<hashCode() 와 관련된 규약>
	1.equals() 로 비교시 두개의 오브젝트가 같다면, hashCode() 값도 같아야 한다. 
	2.equals() 로 비교시 false 라면, hashCode() 값은 다를수도, 같을수도 있다. 
	  그러나 성능을 위해서는 hashCode() 값이 다른것이 낫다. 
	  그래야 해싱 알고리즘으로 Set 에 해당 오브젝트가 존재하는지 아닌지 빠르게 검색할 수 있다. 
	3.hashCode() 값이 같다고 해서, eqauls() 가 true 를 리턴하는 것은 아니다. 
	  해싱 알고리즘 자체의 문제로, 같은 해시값이 나올 수 있다. 
	
	
	<equals() 와 관련된 규약>
	1.Reflexive : Object must be equal to itself.  
					(반사관계 자기 객체 자신과는 equal 해야 한다) 
	2.Symmetric : if a.equals(b) is true then b.equals(a) must be true.
	 				(대칭관계 성립되어야 함,  즉 a = b 이면 b = a 이어야 함)
	3.Transitive : if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true.
	 				(추이관계 성립되어야 함,  a = b b = c 이면  c = a 도 성립되어야 함)
	4.Consistent : multiple invocation of equals() method must result same value until any of properties are modified. 
					So if two objects are equals in Java they will remain equals until any of there property is modified.
					(객체가 변하지 않는한 equals() 를 아무리 여러본 호출해도 변하면 안된다)
	5.Null comparison : comparing any object to null must be false and should not result in NullPointerException. 
					For example a.equals(null) must be false, passing unknown object, which could be null, to equals in Java is is actually a Java coding best practice to avoid NullPointerException in Java.
					(null 과 비교하는 건 반드시 null 을 리턴해야 하고 NullPointerException을 발생시키면 안된다)
 */


public class Object03Hash {

	public static void main(String[] args) {

		
		A a1 = new A();  a1.num = 10; a1.id = "a1";
		A a2 = new A();  a2.num = 10; a2.id = "a2";
		
		System.out.println(a1);  // 주소값.. (정확히는 hash값이다)   출력되는 값은 toString() 의 결과물
		System.out.println(a2);
		
		System.out.println("a1.hashCode(): " + a1.hashCode());
		System.out.println("a2.hashCode(): " + a2.hashCode());
		
		// 다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		System.out.println("a1 == a2 ? " + (a1 == a2));				// false 다르다고 나온다.
		System.out.println("a1.equals(a2) = " + (a1.equals(a2)));   //  false 다르다고 나온다.  (도대체 뭘 비교한걸까?)
		
		System.out.println("-------------------------------------");
		
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
		
		
		System.out.println();
		System.out.println("- hashCode() 적용 --------------------------------");
		
		
		B b1 = new B();  b1.num = 11; b1.id = "b1";
		B b2 = new B();  b2.num = 10; b2.id = "b2";
		// 여기서 hashCode() 를 추가하고 아래 결과들을 보자
		
		System.out.println(b1);  // 주소값이 아니라, hashCode() 값임을 알수 있다.
		System.out.println(b2);
		//다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		System.out.println("b1 == b2 ? " + (b1 == b2));
		System.out.println("b1.equals(b2) = " + (b1.equals(b2)));   //  false 다르다고 나온다.  (도대체 뭘 비교한걸까?)

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
		// 동일한 hash값 을 가진 객체가 그대로 추가됨을 알수 있다.  (도대체 HashSet에서 '같다' 는 것은 무엇으로 체크하는가?)
		for(B obj : setB) {
			System.out.println(obj.id + " " + obj.num + " " + Integer.toHexString(obj.hashCode()));
		}

		//------------------------------------------------------------
		System.out.println();
		System.out.println("- hashCode() + equals() 적용 ----------------------------------");
		
		C c1 = new C();  c1.num = 11; c1.id = "c1";
		C c2 = new C();  c2.num = 11; c2.id = "c2";
		C c3 = new C();  c3.num = 10; c3.id = "c3";
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		//다르다.. 비록 a1.num, a2.num 값이 같아도 결국 다르다.  왜냐하면? 주소값이니까.
		// 비교연산자 == 는 hashCode() equals() 와는 관계 없다.
		System.out.println("c1 == c2 ? " + (c1 == c2));
		System.out.println("c1.equals(c2) = " + (c1.equals(c2)));   //  true 가 나온다 

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
		// 동일성 여부는 equals() 로 체크
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
	
	
	// equals() 동일성(equality)를 확인하기 위한 함수.
	@Override
	public boolean equals(Object obj) {
		
		// null 체크는 꼭 해주자.
		if(obj == null) {
			return false;
		}
		
		// 동일 객체인지도 확인해야 한다
		if(this.getClass() != obj.getClass()) {    // Object 의 getClass() 는 Class<> 객체 리턴.
			return false;
		}
		
		C that = (C)obj;
		
		// 
		if(this.num == that.num) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return num % 3;
	}
}



