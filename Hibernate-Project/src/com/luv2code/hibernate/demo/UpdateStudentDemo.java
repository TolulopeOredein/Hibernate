package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
public static void main(String args []) {
	
	// Create Session factory
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// Create session
	Session session = factory.getCurrentSession();
	
	try {
	     int studentId = 1;
	     // get new session and start transaction
	     session= factory.getCurrentSession();
	     session.beginTransaction();
	     
	     // retrieve student based on the id : primary key
	     System.out.println("\nGetting student with id :" + studentId);
	     Student myStudent = session.get(Student.class, studentId);
	     System.out.println("Updating Student...");
	     myStudent.setFirstName("Scooby");
	     myStudent.setLastName("Taylor");
	  // commit the transaction
			session.getTransaction().commit();
			
	     
	     //NEW CODE
	     session = factory.getCurrentSession();
	     session.beginTransaction();
	     
	     // update email for all students.
	     System.out.println("Updating email for all students...");
	     session.createQuery("update Student set email= 'tolulopeoredein@gmail.com' ").executeUpdate();
	     
	     
		
		// commit the transaction
		session.getTransaction().commit();
		
	}
	
	finally {
		
		factory.close();
	}
	
}
}
