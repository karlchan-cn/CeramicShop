/**
 * 
 */
package cn.com.grocery.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author karl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/app-context.xml" })
@Transactional(value = "hibernateTransactionManager")
@Rollback(value = true)
public class BaseTest extends TransactionalTestExecutionListener {
}
