import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zh.hibernate.model.Student;

@SuppressWarnings("deprecation")
public class TestHibernate {
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void saveTest() {
		Student student = new Student();
		//student.setId(2);
		student.setName("world");
		student.setAge("111");
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sf.close();

	}
	
	@Test
	public void studentTest() {
		Student student = new Student();
		student.setId(3);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}
	
	@Test
	public void getLoadTest(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student s = (Student)session.load(Student.class, 2);
		s.setAge("1024");
		session.getTransaction().commit();
		System.out.println(s.getName());
		System.out.println(s.getClass());
	}
	
	@Test
	public void updataTest(){
		/*Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student s = (Student)session.load(Student.class, 2);
		session.getTransaction().commit();*/
		Student s = new Student();
		s.setId(2);
		s.setName("love_1023");
		s.setAge("120");
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.update(s);
		session2.getTransaction().commit();
		
		System.out.println(s.getName());
		//System.out.println(s.getClass());
	}
	

}
