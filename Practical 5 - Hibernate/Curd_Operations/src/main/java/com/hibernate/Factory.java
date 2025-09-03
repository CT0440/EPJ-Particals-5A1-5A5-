package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
	static SessionFactory factory = null;

	public Factory() {
		super();
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
	}
	
	public static SessionFactory getFactory() {
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
}
