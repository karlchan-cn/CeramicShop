/**
 * 
 */
package cn.com.grocery.test.dao.impl.mysql;

import org.logicalcobwebs.proxool.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

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
		user.setUserName("test");
		user.setPassword("123");
		user.setDsiplayName("displayname");
		user.setEmail("test@email.com");
		baseDao.save(user);
		System.out.println(user.getId());
	}
}
