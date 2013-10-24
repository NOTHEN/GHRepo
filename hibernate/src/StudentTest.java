import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zh.hibernate.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		//student.setId(2);
		student.setName("hello");
		student.setAge("1");
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sf.close();

	}
}
