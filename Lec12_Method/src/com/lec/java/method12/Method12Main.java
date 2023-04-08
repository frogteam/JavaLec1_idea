package com.lec.java.method12;

/*  가변인자 (가변매개변수,가변인수) Variable arguments
   Java 5.0 부터 등장
     매개변수(argument, 인자)의 개수를 가변적으로 조정하는 기술
     ** 가변인자 기술이 없던 시절에는 '컬렉션' 사용.

     컴파일러에서 가변인자를 아래와 같이 변환해준다.
  
   1) 매개변수를 배열로 변환해준다
        원본 : public static void display(String... args)
        컴파일러 변환 후 : public static void display(String args[])
  
   2) 메소드 호출시 인자들을 이용해서 배열로 만들어 준다
        원본 : VarArgsMain.display("Hello", "World", "Korea");
        컴파일러 변환 후 : VarArgsMain.display(new String[] {"Hello", "World", "Korea" })
*/

public class Method12Main {

	public static void main(String[] args) {
		System.out.println("가변인자 (가변매개변수,가변인수) Variable arguments");
		
		Method12Main obj = new Method12Main();
		
		obj.display();		// 가변인자는 매개변수가 0개도 가능. 
		obj.display("Hello");
		obj.display("Hello", "Java" );
		obj.display("Hello", "Java", "Language" );
		
		// 가변인자 앞에 다른 매개변수 가능
		obj.display(2016, "year", "I", "am", "Programmer");
		
		// 다양한 타입의 매개변수 가능
		obj.sum1(10, 20, 30, 40);
		
		obj.listObj(100, "Java", "C", obj);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	public void display(String... args){
		System.out.println("가변인자의 개수는: " + args.length);
		for(String str : args){
			System.out.println(str);
		}
		System.out.println();
	} // end display()
	
	
	// 가변인자, 앞쪽에 다른 매개변수 가능
	public void display(int n, String name, String... args){
		System.out.println("가변인자의 개수는: " + args.length);
		System.out.println(n + " "+ name);
		display(args);	// 가변인자를 매개변수로 전달 가능.
	} // end display()
	
	// 가변인자 뒤에 다른 매개변수가 오면 안됨 
	//public static void display(String... args, int n){}
	//public static void display(String... args, int... args2){}
	
	// 다양한 타입 가능.
	public void sum1(int... args){
		System.out.println("가변인자의 개수는: " + args.length);
		int result = 0;
		for(int n : args){
			result += n;
		}
		System.out.println("sum() 결과 = " + result + "\n");
	} // end sum()
	
	// Object 타입의 가변인자로 하면 모든 타입들에 대한 가변인자 가능
	//  └ 다형성, Wrapper 	
	public void listObj(Object... args){
		System.out.println("가변인자의 개수는: " + args.length);
		for(Object obj : args){
			System.out.println(obj);
		}
	}  // end sum();
	
	
	
} // end class










