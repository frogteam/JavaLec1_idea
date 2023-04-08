package com.lec.java.dp02.factory;

public class AnimalFactory {
    public static Animal create(String animalName){
        if ("소".equals(animalName)) {
            return new Cow();
        }else if ("고양이".equals(animalName)) {
            return new Cat();
        }else if ("개".equals(animalName)) {
            return new Dog();
        }else{
            return null;
        }
    }
}
