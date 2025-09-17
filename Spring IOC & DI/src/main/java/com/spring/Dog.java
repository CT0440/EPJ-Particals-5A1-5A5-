package com.spring;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    
    String name;
    String color;

    Dog() {
        this.name = "chintu bhai";
        this.color = "brown";
    }

    public void sound() {
        System.out.println("Dog is start sounding");
    };

    public void details() {
        System.out.println(name + " : " + color);
    };
}