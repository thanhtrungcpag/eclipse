package thanhtrung.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
	try {
		
		// create a student object
		
		System.out.println("crete a student object..........");
		Student student1 = new Student("Tran", "Thanh Trung", "Trung@gmail.com");
		Student student2 = new Student("Tran", "Thanh Trung", "Trung@gmail.com");
		Student student3 = new Student("Tran", "Thanh Trung", "Trung@gmail.com");
		
		// start a Transaction;
		
		session.beginTransaction();
		
		// save the student object
		System.out.println("Saving the student object");
		session.save(student1);
		session.save(student2);
		session.save(student3);
		// commit transaction
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
	}catch (Exception e) {
		System.out.println("Loi");
	}finally {
		
		factory.close();
		
	}
		
	}

}
