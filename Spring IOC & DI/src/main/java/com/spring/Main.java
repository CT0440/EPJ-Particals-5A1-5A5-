package com.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring")
public class Main {
    public static void main(String[] args) {
    	
    	// create ioc container
    	ApplicationContext container = new AnnotationConfigApplicationContext(Main.class);

        // loose coupling
        Animal obj = null;

        // object creating at runtime
        obj = (Animal) container.getBean(Cat.class);

        // loose coupling method calling
        if (obj != null) {
            obj.details();
        }
    }
}
