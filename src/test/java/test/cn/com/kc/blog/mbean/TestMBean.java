/**
 * 
 */
package test.cn.com.kc.blog.mbean;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

/**
 * @author kchen1
 * 
 */
public class TestMBean extends StandardMBean {

public int getNumber() {
	return 1;

}

protected TestMBean(Class<?> mbeanInterface) throws NotCompliantMBeanException {
	super(mbeanInterface);
}

}
