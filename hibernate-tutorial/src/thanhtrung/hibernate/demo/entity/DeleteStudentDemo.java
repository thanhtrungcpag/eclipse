package thanhtrung.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
	try {
		
		Session session = factory.getCurrentSession();
		// start session
		
		session.beginTransaction();
//		
//		// create a student object
//		
//		Student myStudent = session.get(Student.class, 1);
//		
//		// commit transaction
//		
//		System.out.println(myStudent);
//		
//		// delete a student
//		
		System.out.println("\nDelete Student");
//		
//		session.delete(myStudent);
		
		session.createQuery("delete from Student where id=4").executeUpdate();
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
	}catch (Exception e) {
		System.out.println("Error");
	}finally {
		
		factory.close();
		
	}
		
	}

}
