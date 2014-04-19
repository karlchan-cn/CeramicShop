/**
 * 
 */
package test.cn.com.kc.blog.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import cn.com.kc.blog.pojo.Event;

/**
 * @author chenjinlong2
 * 
 */
public class BootTester {
	private final static Logger log = Logger.getLogger(BootTester.class);
	/**
	 * .
	 */
	protected static ApplicationContext context;
	protected static PlatformTransactionManager jdbcTx;
	protected static JdbcTemplate jdbcTemplate;
	protected static DataSource dataSource;

	@BeforeClass
	public static void initialContext() throws Exception {
		String[] configLocations = new String[] {
				"classpath:applicationContext.xml",
				"classpath:applicationContext-jdbc.xml",
				"classpath:spring-servlet.xml" };
		try {
			context = new ClassPathXmlApplicationContext(configLocations);
			dataSource = (DataSource) context.getBean("dataSource");
			jdbcTx = (PlatformTransactionManager) context
					.getBean("jdbcTxManager");
			jdbcTemplate = new JdbcTemplate(dataSource);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String a = "";
		if(a instanceof String){
			
		}

	}

	@Test
	public void testTransaction() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new RuntimeException();
		}
	}


	public void testHiberSetup() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		final Event event = new Event();
		Calendar calendar = GregorianCalendar.getInstance();
		event.setDate(calendar.getTime());
		event.setTitle("new title");
		session.save(event);
		session.getTransaction().commit();
		session.beginTransaction();
		event.setTitle("test Title");
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		event.setDate(GregorianCalendar.getInstance().getTime());
		session.update(event);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}


	public void testHibernateUpdateDatatchedObject() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event event = new Event();
		event.setId(1622l);
		Calendar calendar = GregorianCalendar.getInstance();
		event.setTitle("");
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		event.setDate(calendar.getTime());
		session.update(event);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}

	@AfterClass
	public static void tearDown() throws Exception {

	}

}
