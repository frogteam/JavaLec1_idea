package com.lec.stream04;

import java.util.ArrayList;
import java.util.List;

public class Stream04Main {
	public static void main(String[] args) {
		
		Long id = 1004L;
		
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
        Restaurant restaurant;

        // findFirst()  스트림의 첫번째 데이터 리턴. Optional
        restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
//                .get()
                .orElse(null)
                ;

        System.out.println(restaurant);		
	}
}
