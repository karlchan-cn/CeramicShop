/**
 * 
 */
package cn.com.grocery.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author karl
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:config/app-context.xml" } )
public class BaseTest extends TransactionalTestExecutionListener {}
