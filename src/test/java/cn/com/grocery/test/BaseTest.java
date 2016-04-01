/**
 * 
 */
package cn.com.grocery.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author karl
 *
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/app-context.xml" })
@Rollback(value = true)
@Transactional(value = "hibernateTransactionManager")
public class BaseTest extends TransactionalTestExecutionListener{
}
