package com.venkat.hibernate.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.model.entity.Course;
import com.venkat.hibernate.model.entity.Instructor;
import com.venkat.hibernate.model.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(Course.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = new Instructor("kaustya", "patkar", "kp@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail(
						"http://kp.com",
						"gamer"
					);		
			
			instructor.setInstructor_detail(instructorDetail);
			
		
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Instructor created succcessfully");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
