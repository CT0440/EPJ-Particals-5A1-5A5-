package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjection {
	
	Animal constructor_injection;

	@Autowired
	public ConstructorInjection(Animal constructor_injection) {
		super();
		this.constructor_injection = constructor_injection;
		System.out.println("Constructor injection is called");
	}
	
	
}
