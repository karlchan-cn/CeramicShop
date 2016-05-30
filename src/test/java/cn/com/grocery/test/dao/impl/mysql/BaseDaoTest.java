/**
 * 
 */
package cn.com.grocery.test.dao.impl.mysql;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.collections.Maps;

import cn.com.grocery.dao.impl.mysql.BaseDao;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.test.BaseTest;
import junit.framework.Assert;

/**
 * @author karl
 *
 */

public class BaseDaoTest extends BaseTest {
	@Autowired
	private BaseDao baseDao;

	@Test
	public void testCount() {
		Map<String, Object> params = Maps.newHashMap();
		params.put("userName", "admin");
		Assert.assertEquals(baseDao.getTotalCount(AdminUser.class, params, " where userName = :userName "), 1);
	}

	@Test
	public void test() {
		AdminUser user = new AdminUser();
		user.setUserName("test");
		user.setPassword("123");
		user.setDisplayName("display2");
		user.setEmail("test@email.com");
		user.setGroupId(1l);
		baseDao.save(user);
		System.out.println(user.getId());
	}
}
