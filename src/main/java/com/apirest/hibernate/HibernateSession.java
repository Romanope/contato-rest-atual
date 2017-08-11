package com.apirest.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {	

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void close() {
		getSessionFactory().close();
	}
}
