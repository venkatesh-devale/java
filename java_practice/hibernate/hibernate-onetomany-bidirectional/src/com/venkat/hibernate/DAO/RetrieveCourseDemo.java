package com.venkat.hibernate.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.model.entity.Course;
import com.venkat.hibernate.model.entity.Instructor;
import com.venkat.hibernate.model.entity.InstructorDetail;

public class RetrieveCourseDemo {

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
			
			Course course = session.get(Course.class, 1);
			System.out.println("Deleting course: " + course.getTitle());
			session.delete(course);
			session.getTransaction().commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
