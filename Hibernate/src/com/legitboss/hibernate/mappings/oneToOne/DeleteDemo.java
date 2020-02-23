package com.legitboss.hibernate.mappings.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		//Step 1:Creating SessionFactory Object
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Create/Save using Session
		try{		
			//Begin Transaction
			session.beginTransaction();
			
			//Query the Database to get the instructor
			int deleteId = 2;
			Instructor instructor = session.get(Instructor.class, deleteId);
			
			//Delete the Instructor Object which in turn deletes the Instructor Detail Object using Cascading
			if(null!=instructor) {
				session.delete(instructor);
			}
			
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
