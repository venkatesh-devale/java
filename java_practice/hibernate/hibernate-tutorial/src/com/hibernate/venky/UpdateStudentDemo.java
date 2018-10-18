package com.hibernate.venky;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.venky.model.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 1);
			System.out.println("Got student with firstname: "+ student.getFirst_name());
			student.setFirst_name("Venky");
			session.getTransaction().commit();
			
			System.out.println("Update student to firstname: "+ student.getFirst_name());
			
		} catch(Exception e) {
			System.out.println("Could not update");
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
