package temp08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int a;
        float sum = 0;
        int cnt = 0;

        while (true) {
            a = sc.nextInt();
            if (a > 100) {
                System.out.printf("sum : %.0f\n",sum);
                System.out.printf("avg : %.1f",(sum / cnt));
                break;
            } else {
                sum = sum + a;
                cnt++;

            }
        }

        sc.close();
    }
}