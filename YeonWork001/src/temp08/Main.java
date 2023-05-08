package temp08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lin1 = 0;
        int lin2 = 0;

        Scanner sc = new Scanner(System.in);

        lin1 = sc.nextInt();
        lin2 = sc.nextInt();

        for (int i = 1; i <= lin1; i++){
            for (int j = 1; j<= lin2; j++){
                System.out.print(j*i + " ");
            }
            System.out.println();
        }
    }
}