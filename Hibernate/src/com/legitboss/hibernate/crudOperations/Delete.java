package com.legitboss.hibernate.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.legitboss.hibernate.entity.Student;

public class Delete {

	public static void main(String[] args) {
		//Step 1:Creating SessionFactory Object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Update using Session
		try{
	
			//Begin Transaction
			session.beginTransaction();

			System.out.println("Deleting the Student");
			
			//Reading Object
			Student student = session.get(Student.class, 3);
			
			System.out.println("Deleting the Student using setters...");
						
			//Updating Transaction
			session.delete(student);
			
			/*System.out.println("Deleted Successfully");
			
			System.out.println("Deleting the Student using query...");
			session.createQuery("delete from Studen where id=3").executeUpdate();
			
			System.out.println("Deleted Successfully using query");*/
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Deleted Successfully");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
