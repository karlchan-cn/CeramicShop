/**
 * 
 */
package test.cn.com.kc.blog.mbean;

import javax.management.DynamicMBean;
import javax.management.NotCompliantMBeanException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author kchen1
 * 
 */
public class MBeanListener implements ServletContextListener {

@Override
public void contextInitialized(ServletContextEvent sce) {
	try {
		TestMBean tBean = new TestMBean(DynamicMBean.class);
	} catch (NotCompliantMBeanException e) {
		e.printStackTrace();
	}

}

@Override
public void contextDestroyed(ServletContextEvent sce) {

}

}
