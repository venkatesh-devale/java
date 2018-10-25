package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class AddMoreCoursesForSupriyaDemo {

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

			Student student = session.get(Student.class, 12);
			System.out.println("Retrieved student:" + student);
			System.out.println(student+"'s courses: "+ student.getCourseList());


			Course c1 = new Course("Rubik's cube");
			Course c2 = new Course("Cricket game development");

			c1.addStudent(student);
			c2.addStudent(student);

			System.out.println("Saving the courses:");
			session.save(c1);
			session.save(c2);
			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
