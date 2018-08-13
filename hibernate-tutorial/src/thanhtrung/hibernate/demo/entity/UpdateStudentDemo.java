package thanhtrung.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
	try {
		
		// start session
		
		session.beginTransaction();
		
		// create a student object
		
		Student myStudent = session.get(Student.class, 1);
		
		// commit transaction
		
		System.out.println(myStudent);
		
		//myStudent.setLastName("Thanh Hieu");
		
		System.out.println(myStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
	}catch (Exception e) {
		System.out.println("Loi");
	}finally {
		
		factory.close();
		
	}
		
	}

}
