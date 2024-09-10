package com.J05.stream연습;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stram05Main {

    public static final String str = "GUEST,MEMBER,ADMIN";
    public static final List<String> list = List.of("GUEST", "MEMBER", "ADMIN");

    public static void main(String[] args) {
        System.out.println("String 을 쪼개어 List 로 만들기");
        {
            List<String> list = Arrays.stream(str.split(","))
                    .toList();

            System.out.println(list);
        }

        System.out.println("List 를 묶어서 String 으로 만들기");
        {
            String str = list.stream().collect(Collectors.joining(","));
            System.out.println(str);
        }
    }
}
