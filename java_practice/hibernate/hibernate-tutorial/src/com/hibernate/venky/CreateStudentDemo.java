package com.hibernate.venky;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("Venkatesh", "Devale", "devalevenkatesh@gmail.com");
			System.out.println("Student with name: " + student.getFirst_name()+ " created");
			session.beginTransaction();
			System.out.println("Transaction has started...saving the student");
			session.save(student);
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			System.out.println("Student saved successfully");
		} catch(Exception e) {
			System.out.println("Exception Occured in saving student");
			e.printStackTrace();
		} finally {
			
		}

	}

}
