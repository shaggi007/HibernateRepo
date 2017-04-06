import java.util.*;
import util.HibernateUtil;
import org.hibernate.*;
public class Test_Composite_key {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction  tx = session.beginTransaction();
		Name name = new Name();
		name.setFirstName("vivek");
		name.setLastName("kulkarni");
		Person person = new Person(name);
		person.setId(name);
		person.setBirthday(new Date());
		
		session.save(person);
		session.flush();
		tx.commit();

	}

}
