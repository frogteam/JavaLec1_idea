package practice.gugu2;

import java.util.Scanner;

public class Gugu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("시작단");
        int startDan = sc.nextInt();
        System.out.println("끝단");
        int endDan = sc.nextInt();
        System.out.println("시작 피승수");
        int startMul = sc.nextInt();
        System.out.println("끝 피승수");
        int endMul = sc.nextInt();
        System.out.println("출력할 열의수 ");
        int maxCol = sc.nextInt();

        for (int dan = startDan; dan <= endDan; dan += maxCol) {
            for (int mul = startMul; mul <= endMul; mul++) {
                for(int col = 0; col < maxCol; col++) {
                    if ((dan + col) > endDan)
                        break;
                    System.out.print((dan + col) + " x " + mul + " = " + (dan + col) * mul + "\t");
                }
                System.out.println();  // 각 행 출력후 라인변경
            }
            System.out.println(); // 각 row 출력후 라인변경
        } // end for

        sc.close();
    } // end main
} // end class






















