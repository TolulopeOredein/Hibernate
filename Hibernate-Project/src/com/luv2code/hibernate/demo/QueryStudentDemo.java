package com.luv2code.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
@SuppressWarnings("unchecked")
public static void main(String args []) {
	
	// Create Session factory
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// Create session
	Session session = factory.getCurrentSession();
	
	try {
	
		
		// start a transaction
		session.beginTransaction();
		
		// Query the students
		List<Student> theStudents = session.createQuery("from Student").list();
		// Display the Students
		displayStudent(theStudents);
		
		// Query Student: Doe;
		
		
		
		theStudents = session.createQuery("from Student s where s.lastName='Fish'").list();
		
		System.out.println("\n\nStudents who have the last name of Scot");
		
		displayStudent(theStudents);
		
		theStudents = session.createQuery("from Student s where " + "s.email LIKE '%hotmail.com'").getResultList();
		
		displayStudent(theStudents);
		// commit the transaction
		session.getTransaction().commit();
		System.out.println("Done");
		
	}
	
	finally {
		
		factory.close();
	}
	
}

private static void displayStudent(List<Student> theStudents) {
	for(Student tempStudent : theStudents) {
	System.out.println(tempStudent);}
}
}
