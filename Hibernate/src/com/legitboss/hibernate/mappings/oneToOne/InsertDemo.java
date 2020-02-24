package com.legitboss.hibernate.mappings.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.legitboss.hibernate.entity.Student;

public class InsertDemo {

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
			//Create the Instructor & Instructor Detail Object
			System.out.println("***Creating the Objects***");
			
			Instructor instructor = new Instructor("Legit","Boss","legit.boss@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("legitimateChannel", "being Legit");
			
			//Setting Properties
			instructor.setInstructorDetail(instructorDetail);
			
			//Begin Transaction
			session.beginTransaction();
			
			//Save Instructor
			System.out.println("Saving the Instructor & Instructor Detail Objects");
			session.save(instructor);
			
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
