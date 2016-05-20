package cn.com.grocery.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.grocery.common.Pager;
import cn.com.grocery.test.BaseTest;

public class AdminUserManageServiceTest extends BaseTest {

	@Autowired
	AdminUserManageService service;

	@Test
	public void listUser() {
		service.listUser( new Pager() );
	}
}
