/**
 * 
 */
package cn.com.grocery.test.dao.impl.mysql;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.grocery.dao.impl.mysql.BaseDao;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.test.BaseTest;

/**
 * @author karl
 *
 */
public class BaseDaoTester extends BaseTest {
	@Autowired
	private BaseDao baseDao;

	@Test
	public void test() {
		AdminUser user = new AdminUser();
		user.setUserName("test12");
		user.setPassword("123");
		user.setDsiplayName("display3");
		user.setEmail("test@email.com");
		user.setGroupId(1l);
		baseDao.save(user);
		System.out.println(user.getId());
	}
}
