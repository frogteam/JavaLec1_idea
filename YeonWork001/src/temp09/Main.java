package temp09;

// https://school.programmers.co.kr/learn/courses/30/lessons/340202?language=java
public class Main {
    public static void main(String[] args) {
        int number[]={10, -10, 10, -10, 10, -10, 10, -10, 10, -10};
        int storage = 500;
        int total=0;

        for (int i = 0; i < number.length; i++) {
            double percentage = number[i] / 100.0;
            double using = (storage * percentage);  // 사용량증감.

            storage = storage + (int)using;

            System.out.println("사용량증감: " + using + ", 월별물사용량: " + storage);
            total += storage;
            System.out.println("total: " + total);
            System.out.println();
        }

        if (total>5141){
            System.out.println("0");

        }
        else if(total< 5141){
            System.out.println("-1");
        }


    }


}
