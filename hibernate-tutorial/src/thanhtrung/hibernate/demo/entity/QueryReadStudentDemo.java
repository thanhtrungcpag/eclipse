package thanhtrung.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
	try {
		

		// start a Transaction;
		
		session.beginTransaction();
		
		// Query List 
		
		List<Student> myListStudent = 
				session.createQuery("from Student").list();
		
		// display student in Query
		
		displayList(myListStudent);
		
		// commit transaction
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
	}catch (Exception e) {
		System.out.println("Loi");
	}finally {
		
		factory.close();
		
	}
		
	}

	private static void displayList(List<Student> myListStudent) {
		for(Student tempStudent: myListStudent) {
			System.out.println(tempStudent);
		}
	}

}
