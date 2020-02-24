package com.legitboss.hibernate.mappings.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo_Bidirectional {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("***Getting the Instructor Detail and Instructor Objects***");
			
			//Begin Transaction
			session.beginTransaction();
			
			int instructorDetailId = 1;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			//Displaying the Instructor Detail
			System.out.println("Instructor Detail Object\n"+instructorDetail.toString());
			
			//Displaying the Instructor
			System.out.println("Instructor Object\n"+instructorDetail.getInstructor());
						
			System.out.println("Fetched Successfully");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
