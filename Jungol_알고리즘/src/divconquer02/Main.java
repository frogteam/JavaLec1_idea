package divconquer02;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      //long input = sc.nextLong();
      //long remit = 2;
      //long remit1 = 63;
      //long result = 1;
      //long result1 = result + 1;
      
      final BigInteger ZERO = new BigInteger("0");
      final BigInteger ONE = new BigInteger("1");
      
      BigInteger input = new BigInteger(sc.nextLine());
      BigInteger remit = new BigInteger("2");
      BigInteger remit2 = new BigInteger("63");
      BigInteger result = new BigInteger("1");
      BigInteger result1 = result.add(result);
      

      // 굳이 문제에서 2^63 - 1 의 양의 정수만이라 했으니 패스
      //if(input >= 0 && input < Math.pow(2, 63)-1) {

      /*
      if(input == 0 || input == 1) {
    	  System.out.println(input);
      } else {
         //while(longdata <= input) {  // 필요없슴
    	 while(true) {
            if(result * result <= input && input < result1 * result1) {
               System.out.println(result);
               break;
            } // end if
            result++;
            result1++;
         } // end while
         
      } // end if
      */
      
      if(input.equals(ZERO) || input.equals(ONE)) {
    	  System.out.println(input);
      } else {
    	  while(true) {
    		  System.out.println("result:" + result + " result1:" + result1);
    		  if(result.multiply(result).compareTo(input) <= 0 &&
    				  result1.multiply(result1).compareTo(input) > 0) {
    			  System.out.println(result);
    			  break;
    		  }
    		  result = result.add(ONE);
    		  result1 = result1.add(ONE);
    	  }
      }
      
      
   } // end main
   
   
} // end class
