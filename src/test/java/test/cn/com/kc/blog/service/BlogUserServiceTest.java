/**
 * 
 */
package test.cn.com.kc.blog.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import cn.com.kc.blog.bl.service.IBlogUserService;
import cn.com.kc.blog.bl.service.impl.BlogUserServiceImpl;
import cn.com.kc.blog.controller.service.impl.BlogUserController;
import cn.com.kc.blog.controller.service.impl.RolesListConst;
import cn.com.kc.blog.pojo.BlogUser;
import cn.com.kc.blog.userdetialservice.impl.UserDetailServiceHibernateImpl;

/**
 * @author chenjinlong2
 * 
 */
public class BlogUserServiceTest extends BootTester {
private BlogUserController getController() {
	return (BlogUserController) context
					.getBean(BlogUserController.class.getName());
}

private IBlogUserService getUserService() {
	return (IBlogUserService) context
					.getBean(IBlogUserService.class.getName());
}

private UserDetailsService getUserDetailServiceImpl() {
	return (UserDetailsService) context
					.getBean(UserDetailServiceHibernateImpl.class.getName());
}

public void saveSystemAdmin() {
	final BlogUser blogUser = new BlogUser();
	try {
		blogUser.setUserName("admin");
		blogUser.setPassword("admin");
		final BlogUserController blogUserController = getController();
		final BindingResult bindingResult = new BeanPropertyBindingResult(
						blogUser, RolesListConst.ROLE_USER);
		blogUserController.saveUser(blogUser, bindingResult);
	} catch (Exception e) {
		//e.printStackTrace();
	}
	Assert.assertNotNull("could not save default admin", blogUser.getId());

}


public void testLoadUserByName() {
	UserDetails user = null;
	try {
		UserDetailsService userDetailsService = getUserDetailServiceImpl();
		user = userDetailsService.loadUserByUsername("admin");
	} catch (Exception e) {
		e.printStackTrace();
	}
	Assert.assertNotNull(user);
}


public void testUpdateUserPassword() {
	IBlogUserService userService = getUserService();
	final BlogUser user = new BlogUser();
	int updateRet = 0;
	try {
		user.setUserName("KarlChan");
		user.setPassword("test");
		updateRet = userService.updateUserPassword(user);
	} catch (Exception e) {
		e.printStackTrace();
	}

	Assert.assertSame(1, updateRet);
}

}
