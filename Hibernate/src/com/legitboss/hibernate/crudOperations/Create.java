package com.legitboss.hibernate.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.legitboss.hibernate.entity.Student;

public class Create {

	public static void main(String[] args) {
		
		//Step 1:Creating SessionFactory Object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Create/Save using Session
		try{
			//Create the Student Object
			System.out.println("Create the Student Object...");
			Student student = new Student("Legit","Boss","legitboss@gmail.com");
			
			//Begin Transaction
			session.beginTransaction();
			
			System.out.println("Saving the Student");
			//Save Transaction
			session.save(student);
			
			//Commit Transaction
			session.getTransaction().commit();
			System.out.println("Saved Successfully");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
