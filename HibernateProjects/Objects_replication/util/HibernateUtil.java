/*
 * Created on Mar 21, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
/**
 * @author vivek kulkarni
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HibernateUtil {

	private static SessionFactory factory_vivek;
	private static SessionFactory factory_system;
	static{
		try{
	      factory_vivek = new Configuration().configure(new File("hibernate.vivek.cfg.xml")).buildSessionFactory();
		}catch(Throwable th){
			th.printStackTrace();
			System.err.println("Exception in creating session Factory"+th);
		}
	}
		static{
			try{
		      factory_system = new Configuration().configure("hibernate.system.cfg.xml").buildSessionFactory();
			}catch(Throwable th){
				th.printStackTrace();
				System.err.println("Exception in creating session Factory"+th);
			}
	}
	public static SessionFactory getSessionFactory(String factory_name){
		if(factory_name.equals("vivek"))
		    return factory_vivek;
		return factory_system;
			
	}
}
