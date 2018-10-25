package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.Course;
import com.venkatesh.hibernate.entity.Instructor;
import com.venkatesh.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			
			Course course = session.get(Course.class, 2);

			System.out.println("Course Details: " + course);
			session.getTransaction().commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
