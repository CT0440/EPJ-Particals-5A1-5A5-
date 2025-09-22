package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjection {

	Animal setter_injection;

	// setter injection : the object is injected into the java class file using setter method ( lazy injection )
	@Autowired
	public void setSetter_injection(Animal setter_injection) {
		this.setter_injection = setter_injection;
		System.out.println("Setter injection is called");
	}
}
