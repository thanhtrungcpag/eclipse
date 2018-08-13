package thanhtrung.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
	try {
		
		// create a student object
		
		System.out.println("crete a student object..........");
		Student student1 = new Student("Tran ", "Thanh Trung", "Trungcpag@gmail.com");
		
		// start a Transaction;
		
		session.beginTransaction();
		
		// save the student object
		System.out.println("Saving the student object");
		System.out.println(student1);
		session.save(student1);
		
		// commit transaction
		
		session.getTransaction().commit();
		// My new code
		
		//find out the student's id: primary key
		System.out.println("Save student. Generated id: " +student1.getId());
		
		// now get a new session and start transaction
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		// Retrieve student based on the id	
		System.out.println("\n Getting student 	with id" +student1.getId());
		
		Student myStudent = session.get(Student.class, student1.getId());
		
		System.out.println("Get complete: "+myStudent);
		//summit the transaction
		session.getTransaction().commit();
		System.out.println("Done!");
		
	}catch (Exception e) {
		System.out.println("Loi");
	}finally {
		
		factory.close();
		
	}
		
	}

}
