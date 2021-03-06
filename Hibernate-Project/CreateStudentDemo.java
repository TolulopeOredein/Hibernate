package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
public static void main(String args []) {
	
	// Create Session factory
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// Create session
	Session session = factory.getCurrentSession();
	
	try {
	
		//create a student object
		System.out.println(" Creating a new Student Object");
		
		Student tempStudent = new Student ("Paul", " Richard", "paulrichard@gmail.com");
		// start a transaction
		session.beginTransaction();
		// save the student object
		System.out.println("Saving a student");
		session.save(tempStudent);
		// commit the transaction
		session.getTransaction().commit();
		
	}
	
	finally {
		
		factory.close();
	}
	
}
}
