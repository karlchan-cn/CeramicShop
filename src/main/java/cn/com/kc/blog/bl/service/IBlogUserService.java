/**
 * 
 */
package cn.com.kc.blog.bl.service;

import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogUserService {
/**
 * Bean name;
 */
String BEAN_NAME = IBlogUserService.class.getName();

/**
 * save user
 * 
 * @param user
 *            user to be saved;
 */
void saveUser(final BlogUser user);

/**
 * 
 * @param id
 * @return
 */
BlogUser getUser(final Long id);

/**
 * 
 * @param user
 */
void delUser(final BlogUser user);

/**
 * get user according to the parameter username
 * 
 * @param username
 *            user's name
 * @return specified user
 */
BlogUser getUserByUsername(final String username);

/**
 * update user's password.
 * 
 * @param user
 *            user to be updated.
 * @return numbers about updated entities.
 */
int updateUserPassword(final BlogUser user);

}
