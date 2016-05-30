/**
 * 
 */
package cn.com.grocery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
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

	public int count(String filter, Map<String, Object> param) {
		return userDao.getTotalCount(AdminUser.class, param, filter);
	}

	@SuppressWarnings("unchecked")
	public List<AdminUser> listUser(Pager pager, Map<String, Object> param) {
		List<AdminUser> users = new ArrayList<AdminUser>();
		users = (List<AdminUser>) userDao.getListWithPager(pager, param);
		return users;
	}

	public boolean saveUser(AdminUser user) {
		return userDao.save(user) != null;
	}
	
	public String securePassword(String rawPwd){
		rawPwd = StringUtils.trimToEmpty(rawPwd);
		return DigestUtils.md5Hex(rawPwd + rawPwd.hashCode());
	}

}
