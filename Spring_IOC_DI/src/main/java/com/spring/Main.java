package com.spring;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
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
        obj = (Animal) container.getBean(Cat.class); // manual depedency injection

        // loose coupling method calling
        if (obj != null) {
            obj.details();
        }
        
        ConstructorInjection c_inj = container.getBean(ConstructorInjection.class);
        SetterInjection s_inj = container.getBean(SetterInjection.class);
        FeildInjection f_inj = container.getBean(FeildInjection.class);
        
        c_inj.constructor_injection.details();
        s_inj.setter_injection.details();
        f_inj.feild_injection.details();
    }
}









