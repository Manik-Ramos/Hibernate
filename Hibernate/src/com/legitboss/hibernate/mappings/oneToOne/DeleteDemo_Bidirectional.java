package com.legitboss.hibernate.mappings.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo_Bidirectional {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Delete using Session
		try{		
			//Begin Transaction
			session.beginTransaction();
			
			//Query the Database to get the instructor
			int deleteId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, deleteId);
			
			System.out.println("Fetched Instructor Detail Object\n"+instructorDetail.toString());
			
			if(null!=instructorDetail) {
				//breaking Bidirectional Relationship between Instructor and Instructor Detail for without Cascade Remove
				instructorDetail.getInstructor().setInstructorDetail(null);

				session.delete(instructorDetail);
				System.out.println("Deleted Successfully");
			}	
			//Commit Transaction
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
