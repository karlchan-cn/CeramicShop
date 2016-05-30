package cn.com.grocery.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.grocery.common.Pager;
import cn.com.grocery.domain.AdminUser;
import cn.com.grocery.test.BaseTest;
import junit.framework.Assert;

public class AdminUserManageServiceTest extends BaseTest {

	@Autowired
	AdminUserManageService service;

	@Test
	public void listUser() {
		Pager pager = new Pager();
		pager.setHql("from AdminUser where userName = :userName and password = :password");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", "admin");
		param.put("password", "admin");
		System.out.println(service.listUser(pager, param).size());
	}

	@Test
	public void saveUser() {
		AdminUser user = new AdminUser();
		user.setIcon("icon");
		user.setPassword(service.securePassword("test"));
		user.setUserName("test");
		user.setDisplayName("test");
		service.saveUser(user);
	}

	@Test
	public void testSecurePassword() {
		String pwd = "admin";
		System.out.println(service.securePassword(pwd));
		Assert.assertTrue(StringUtils.equals(service.securePassword(pwd), service.securePassword(pwd)));
	}

}
