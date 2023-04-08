package com.lec.java.exception10;

public class Exception10Main {

	public static void main(String[] args) {
		ClassParent parent = new ClassChild();
		
		parent.displayInfo();  // 어떤 displayInfo() 가 호출되나

		try {
			parent.throwException();
		}
		catch (ExceptionChild e) {}
		catch (ExceptionParent e) {}
		
		
		// <- try~catch 로 surround 하면 ExceptionA 를 cath 할까? 
								// ExceptionB 를 catch 할까  ExceptionA를 캐치할까?
		
		
		
		System.out.println("---------------");
		
		ClassChild child = new ClassChild();
		child.displayInfo();   // 어떤 displayInfo() 가 호출되나
		try {
			child.throwException();
		} catch (ExceptionChild e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // 이경우는?

	} // end main()
} // end class Exception10Main


class ExceptionParent extends Exception {}

class ExceptionChild extends ExceptionParent {}

class ClassParent{
	public void throwException() throws ExceptionParent{
		System.out.println("ClassParent.throwException() 호출");
	}
	public void displayInfo(){
		System.out.println("ClassParent.displayInfo() 호출");
	}
} // end ClassParent


class ClassChild extends ClassParent{
	@Override
	public void throwException()  throws ExceptionChild {
		//super.doSomething();  // <- 이건 에러 난다
		System.out.println("ClassChild.throwException() 호출");
	}
	
	@Override
	public void displayInfo() {
		System.out.println("ClassChild.displayInfo() 호출");
	} 
} // end ClassChild