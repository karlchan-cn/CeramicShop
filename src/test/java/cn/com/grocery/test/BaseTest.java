/**
 * 
 */
package cn.com.grocery.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author karl
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/app-context.xml" })
@Rollback(value = true)
public class BaseTest {
}
