package com.hibernate.venky;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Instructor;
import com.hibernate.venky.model.entity.InstructorDetail;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Instructor.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			//returns null entity if not found
			Instructor instructor = session.get(Instructor.class, 2);
			
			if(instructor != null) {
				session.delete(instructor);
				session.getTransaction().commit();
				System.out.println("Instructor removed succcessfully");
			} else {
				System.out.println("Instructor was not found to delete");
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
