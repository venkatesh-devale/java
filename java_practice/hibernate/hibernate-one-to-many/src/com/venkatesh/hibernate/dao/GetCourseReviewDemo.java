package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.Course;
import com.venkatesh.hibernate.entity.Instructor;
import com.venkatesh.hibernate.entity.InstructorDetail;
import com.venkatesh.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseReviewDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(InstructorDetail.class)
											.addAnnotatedClass(Instructor.class)
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Review.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();

			Course c = session.get(Course.class, 4);

			System.out.println("Retrieved course is : " + c);

			System.out.println("Retrieving the reviews: " + c.getReviewList());

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
