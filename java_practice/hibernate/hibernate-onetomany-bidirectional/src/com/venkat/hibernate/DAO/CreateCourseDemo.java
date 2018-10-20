package com.venkat.hibernate.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venkat.hibernate.model.entity.Course;
import com.venkat.hibernate.model.entity.Instructor;
import com.venkat.hibernate.model.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
			Instructor instructor = session.get(Instructor.class, 5);
			
			System.out.println(instructor);
			Course c1 = new Course("Enterprise Distributed System");
			Course c2 = new Course("Enterprise Application Development");
			Course c3 = new Course("Enterprise Software Overview");
			
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
//			
			instructor.add(c1);
			instructor.add(c2);
			instructor.add(c3);
//			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			session.getTransaction().commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
