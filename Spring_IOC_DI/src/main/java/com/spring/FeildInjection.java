package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeildInjection {
	// to achieve dependency injection we required instance variables;
	// feild injection : The object is injected directly into the instance variable.
	@Autowired
	Animal feild_injection;
}
