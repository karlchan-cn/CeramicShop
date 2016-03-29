/**
 * 
 */
package cn.com.grocery.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author karl
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/app-context.xml" })
@Transactional(value = "false")
public class BaseTest {
	@Test
	public void testSetup() {
		System.out.println("test");
	}

}
