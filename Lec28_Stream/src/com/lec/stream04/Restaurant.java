package com.lec.stream04;


public class Restaurant {

    private final String name;
    private String address;
    private Long id;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getInformation() {
        return name + " in " + address;
    }
}
