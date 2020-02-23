package com.legitboss.hibernate.crudOperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.legitboss.hibernate.entity.Student;

public class Read {

	public static void main(String[] args) {
		//Step 1:Creating SessionFactory Object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Step 2: Creating Session Object
		Session session = factory.getCurrentSession();
		
		//Step 3: Read using Session
		try{
			System.out.println("Reading the Student Object using get...");
						
			//Begin Transaction
			session.beginTransaction();
			
			//Reading Object
			Student student = session.get(Student.class, 1);
			
			System.out.println("Obtained Student Result"+student.toString());
			
			System.out.println("Read Successfully");
			System.out.println("*******************************");
			
			System.out.println("Reading Bulk Students using query...");
						
			List<Student>studentList = session.createQuery("from Student").list();
			
			for(Student s:studentList)
				System.out.println("Obtained Student List Result"+s.toString());
			
			System.out.println("Read Successfully");
			
			System.out.println("*******************************");
			
			System.out.println("Reading Single Student using 'where' clause...");
			
			student = (Student) session.createQuery("from Student where email='manik.ramrmkd@gmail.com'");
			
			System.out.println("Obtained Student Result"+student.toString());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
