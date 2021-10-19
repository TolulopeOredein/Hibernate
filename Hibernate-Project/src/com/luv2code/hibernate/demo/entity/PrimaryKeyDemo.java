package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	
public static void main(String args []) {
	
	// Create Session factory
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// Create session
	Session session = factory.getCurrentSession();
	
	try {
	
		//create a student object
		System.out.println(" Creating a new Student Object");
		
		Student tempStudent1 = new Student ("Paul", " Scot", "scot@yahoo.com");
		Student tempStudent2 = new Student ("Pearl", " Kate", "kate@gmail.com");
		Student tempStudent3 = new Student ("Sand", " Fame", "paulrichard@hotmail.com");
		Student tempStudent4 = new Student ("Gold", " Joyce", "joyce@gmail.com");
		Student tempStudent5 = new Student ("Fish", " Kettle", "kettled@gmail.com");
		Student tempStudent6 = new Student ("Mountain", "Wayne", "wayne@gmail.com");
		Student tempStudent7 = new Student ("Silas", " Richard", "richard@gmail.com");
		
		// start a transaction
		session.beginTransaction();
		// save the student object
		System.out.println("Saving a student");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);
		session.save(tempStudent4);
		session.save(tempStudent5);
		session.save(tempStudent6);
		session.save(tempStudent7);
		
		// commit the transaction
		session.getTransaction().commit();
		
	}
	
	finally {
		
		factory.close();
	}
	
}
}

