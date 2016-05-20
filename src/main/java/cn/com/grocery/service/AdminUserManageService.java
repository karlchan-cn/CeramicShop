/**
 * 
 */
package cn.com.grocery.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.grocery.common.Pager;
import cn.com.grocery.dao.impl.mysql.AdminUserDao;
import cn.com.grocery.domain.AdminUser;

/**
 * @author karl
 *
 */
@Service
public class AdminUserManageService {

	@Autowired
	private AdminUserDao userDao;

	@SuppressWarnings( "unchecked" )
	public List<AdminUser> listUser( Pager pager ) {
		List<AdminUser> users = new ArrayList<AdminUser>();
		pager.setCount( userDao.getTotalCount( AdminUser.class, new HashMap<String, Object>() ) );
		users = ( List<AdminUser> )userDao.getListWithPager( pager, new HashMap<String, Object>() );
		return users;
	}

}
