package com.hibernate.venky;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Instructor;
import com.hibernate.venky.model.entity.InstructorDetail;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Instructor.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Instructor instructor = new Instructor("Venkatesh", "Devale", "vd@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail(
						"http://venky.com",
						"travelling"
					);		
			
			instructor.setInstructor_detail(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Instructor created succcessfully");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
