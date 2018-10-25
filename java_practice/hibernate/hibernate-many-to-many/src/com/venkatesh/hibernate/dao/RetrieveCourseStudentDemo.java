package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveCourseStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Review.class)
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Retrieved course:");
			Course temp = session.get(Course.class,5);
			System.out.println(temp);

			System.out.println("Retrieving Students for above course:");
			System.out.println(temp.getStudentList());
			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
