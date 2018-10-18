package com.hibernate.venky;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("Prady", "Patil", "pt@gmail.com");
			System.out.println("Student with name: " + student.getFirst_name()+ " created");
			session.beginTransaction();
			System.out.println("Transaction has started...saving the student");
			session.save(student);
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			System.out.println("Student saved successfully");
			
			//getting the student
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student new_student = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			System.out.println("Student retrived: " + new_student.toString());
		} catch(Exception e) {
			System.out.println("Exception Occured in reading the student");
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
