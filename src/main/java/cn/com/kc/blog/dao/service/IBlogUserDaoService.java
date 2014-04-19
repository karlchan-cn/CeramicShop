/**
 * 
 */
package cn.com.kc.blog.dao.service;

import cn.com.kc.blog.commondao.service.IBaseDao;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogUserDaoService extends IBaseDao<BlogUser, Long> {
/**
 * Bean name;
 */
String BEAN_NAME = IBlogUserDaoService.class.getName();

/**
 * get user according to the parameter username
 * 
 * @param username
 *            user's name
 * @return specified user
 */
BlogUser getUserByUsername(final String username);

/**
 * update user password by user name;
 * 
 * @param userName
 *            user's name
 * @param password
 *            user's password
 * @return row effected.
 */
int updateUserPassword(final String userName, final String password);
}
