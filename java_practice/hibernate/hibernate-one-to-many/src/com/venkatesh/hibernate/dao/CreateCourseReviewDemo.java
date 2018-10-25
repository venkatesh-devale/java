package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.Course;
import com.venkatesh.hibernate.entity.Instructor;
import com.venkatesh.hibernate.entity.InstructorDetail;
import com.venkatesh.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviewDemo {

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

			Course course = new Course("Software Systems Engineering");


			course.addReview(new Review("This is a great course"));
			course.addReview(new Review("I enjoyed the course"));

			System.out.println("Saving the course");
			session.save(course);
			System.out.println("Course created:"+course);
			System.out.println("All reviews for the course:");
			System.out.println(course.getReviewList());
			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
