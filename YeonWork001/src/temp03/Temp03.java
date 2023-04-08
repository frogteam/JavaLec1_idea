package temp03;

import java.util.Arrays;


enum Rainbow {

    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);

 

    private final int value;

    Rainbow(int value) { this.value = value; }

    public int getValue() { return value; }

}
	
public class Temp03 {
    public static void main(String[] args) {

//        Rainbow[] arr = Rainbow.values();
//
//        for (Rainbow rb : arr) {
//
//            System.out.println(rb);
//
//        }
    	
//    	int n = 10 + 20;
//    	
//    	byte b = 10 + 20;
//    	byte b1 = 40;
//    	byte b2 = b + b1;
    	
    	// 산술연산의 결과 타입?
    	// 피연산자 중 double 이 있으면 double로 변환
    	// 	피연산자 중  이 있으면 double로 변환
    	
    	int a, b;
    	a = 20;

    	a = -(1);
    	//a = (-)1;
    	
    	b = a = 40;
    	System.out.println(a = 30);
    	
    	

    }

}
