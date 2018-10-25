package com.venkatesh.hibernate.dao;


import com.venkatesh.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudentDemo {

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

			Course newCourse = new Course("Networking 101");
            System.out.println("Saving new Course:");

            session.save(newCourse);

			Student newStudent1 = new Student("kausy", "patkar", "k@gmail.com");
            Student newStudent2 = new Student("vaishu", "shingare", "s@gmail.com");
            Student newStudent3 = new Student("supriya", "shelar", "v@gmail.com");

            newCourse.addStudent(newStudent1);
            newCourse.addStudent(newStudent2);
            newCourse.addStudent(newStudent3);

            System.out.println("saving students");
            session.save(newStudent1);
            session.save(newStudent2);
            session.save(newStudent3);

			session.getTransaction().commit();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
