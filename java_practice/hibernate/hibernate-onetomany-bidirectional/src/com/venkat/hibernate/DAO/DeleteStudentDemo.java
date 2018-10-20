package com.venkat.hibernate.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.model.entity.Instructor;
import com.venkat.hibernate.model.entity.InstructorDetail;

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
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, 4);
			
			Instructor instructor = tempInstructorDetail.getInstructor();
			
			instructor.setInstructor_detail(null);
			
			session.delete(tempInstructorDetail);
			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			//connection leak avoided
			session.close();
			sessionFactory.close();
		}

	}

}
