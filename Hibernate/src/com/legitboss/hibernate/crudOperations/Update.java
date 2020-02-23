package com.legitboss.hibernate.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.legitboss.hibernate.entity.Student;

public class Update {

	public static void main(String[] args) {
		//Step 1:Creating SessionFactory Object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Update using Session
		try{
	
			//Begin Transaction
			session.beginTransaction();

			System.out.println("Reading the Student");
			
			//Reading Object
			Student student = session.get(Student.class, 2);
			
			System.out.println("Updating the Student using setters...");
			student.setFirstName("Legitimate");
			
			//Updating Transaction
			session.update(student);
			
			System.out.println("Updated Successfully using setters");
			
			System.out.println("Updating the Student using query...");
			session.createQuery("update Student set firstName='Headweight' where id=3").executeUpdate();
			
			System.out.println("Updated Successfully using query");
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Updated Successfully");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
