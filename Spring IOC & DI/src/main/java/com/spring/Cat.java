package com.spring;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal{
    String name;
    String color;

    Cat() {
        this.name = "pinky";
        this.color = "white";
    }

    public void sound() {
        System.out.println("Cat is start sounding");
    };

    public void details() {
        System.out.println(name + " : " + color);
    };
}
