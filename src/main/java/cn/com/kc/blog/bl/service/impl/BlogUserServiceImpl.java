/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.persistence.Inheritance;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.com.kc.blog.bl.service.IBlogUserService;
import cn.com.kc.blog.common.util.CommonUtils;
import cn.com.kc.blog.controller.service.impl.RolesListConst;
import cn.com.kc.blog.dao.service.IBlogUserDaoService;
import cn.com.kc.blog.pojo.BlogAuthorities;
import cn.com.kc.blog.pojo.BlogUser;
import cn.com.kc.blog.vo.BlogUserVO;

/**
 * @author chenjinlong2
 * 
 */
@Service("cn.com.kc.blog.bl.service.IBlogUserService")
public class BlogUserServiceImpl implements IBlogUserService {

/** Logger available to subclasses */
protected final Log logger = LogFactory.getLog(getClass());
/**
 * dao
 */
private IBlogUserDaoService userDao;

@Resource(name = "cn.com.kc.blog.dao.service.IBlogUserDaoService")
public void setUserDao(final IBlogUserDaoService newUserDao) {
	this.userDao = newUserDao;
}

/**
 * {@inheritDoc}
 */
public void saveUser(final BlogUser user) {
	/**
	 * use spring md5password encoder to encode password with the salt username.
	 */
	user.setPassword(CommonUtils.ecodePasswordBySalt(user.getPassword(), user.getUserName()));
	BlogAuthorities authorities = new BlogAuthorities();
	authorities.setUser(user);
	authorities.setAuthority(RolesListConst.ROLE_USER);
	user.getAuthorities().add(authorities);
	user.setEnabled(true);
	user.setCreateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
	this.userDao.save(user);
}

/**
 * 
 * @param id
 * @return
 */
public BlogUser getUser(final Long id) {
	return this.userDao.get(id);
}

/**
 * 
 * @param user
 */
public void delUser(final BlogUser user) {
	this.userDao.delete(user);
}

/**
 * {@inheritDoc}
 */
public BlogUser getUserByUsername(String username) {
	BlogUser user = userDao.getUserByUsername(username);
	return user;
}

/**
 * {@inheritDoc}
 */
public int updateUserPassword(final BlogUser user) {
	try {
		return userDao.updateUserPassword(user.getUserName(),
						CommonUtils.ecodePasswordBySalt(user.getPassword(), user.getUserName()));
	} catch (Exception e) {
		logger.error(e.getMessage());
		throw new RuntimeException(e);
	}
}
}
