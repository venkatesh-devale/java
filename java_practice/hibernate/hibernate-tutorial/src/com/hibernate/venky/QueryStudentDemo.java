package com.hibernate.venky;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student s where s.email like '%hub%'").list();
			session.getTransaction().commit();
			System.out.println("Printing out the student:");
			displayStudents(students);
			System.out.println("Done!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student student:students) {
			System.out.println(student);
		}
	}

}
