package com.udcode.connfactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ConnFactory {

	private static ConnFactory myFactory;

	private Session session;
	
	public static synchronized ConnFactory getInstance() {
		if (myFactory == null) {
			myFactory = new ConnFactory();
		}
		return myFactory;
	}

	private ConnFactory() {
		
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		session = sf.openSession();
	}
	
	public synchronized Session getSession(){
		return session;
	}
}
