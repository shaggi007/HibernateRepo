/*
 * Created on Mar 21, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;
import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * @author vivek kulkarni
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HibernateUtil {

	
	private static SessionFactory factory;
	static{
		try{
	      factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable th){
			th.printStackTrace();
			System.err.println("Exception in creating session Factory"+th);
		}
	   
	}
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
