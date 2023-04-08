package 반복제어문1.형성평가05;

/*
129 : 반복제어문1 - 형성평가5 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=29&sca=1060

삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고, 
"Continue? "에서 하나의 문자를 입력받아 그 문자가 'Y' 나 'y' 이면 작업을 반복하고 
다른 문자이면 종료하는 프로그램을 작성하시오.

(넓이는 반올림하여 소수 첫째자리까지 출력한다.)​ 
 
[입출력예]
Base = 11
Height = 5
Triangle width = 27.5
Continue? Y
Base = 10
Height = 10
Triangle width = 50.0
Continue? N
 
 
[Hint]
문자를 입력받을 때에는 %c 앞에 공백을 넣어 주어야 엔터, 공백과 같은 구분자를 입력받지 않고 한 개의 문자를 입력받을 수 있다. 
예 : scanf(" %c", &문자변수);
 */


import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int base, height;
      double width;
      
      while(true) {
         System.out.print("Base = ");
         base = sc.nextInt();
         System.out.print("Height = ");
         height = sc.nextInt();
         width = (base * height) / 2.0;
         System.out.printf("Triangle width = %.1f\n", width);
         
         System.out.print("Continue? ");
         char answer = sc.next().charAt(0);
         if((answer != 'y') && (answer != 'Y'))
        	 break;         
      }
      
      sc.close();
   } // ./main()
}






