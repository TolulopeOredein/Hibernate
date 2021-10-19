

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
public static void main(String args []) {
	
	// Create Session factory
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// Create session
	Session session = factory.getCurrentSession();
	
	try {
	
		//create a student object
		System.out.println(" Creating a new Student Object");
		
		Student tempStudent = new Student ("Teju", "James", "Teju@gmail.com");
		
		// start a transaction
		session.beginTransaction();
		// save the student object
		System.out.println("Saving a student");
		System.out.println(tempStudent );
		session.save(tempStudent);
		// commit the transaction
		session.getTransaction().commit();
		
		//find out Student's id primary key
		
		System.out.println("Saved Student. generated Id:" + tempStudent.getId());
		
		// Get a new Session and start session
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		// Retrieve student based on Id: primary key
		System.out.println("\nGetting student with id:" + tempStudent.getId());
		Student myStudent = session.get(Student.class, tempStudent.getId());
		System.out.println("Get complete:" + myStudent);
		
		//Commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
	}
	
	finally {
		
		factory.close();
	}
	
}
}
