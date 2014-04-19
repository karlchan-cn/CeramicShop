/**
 * 
 */
package cn.com.kc.blog.dao.service;

import java.util.List;

import cn.com.kc.blog.commondao.service.IBaseDao;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogEntityDaoService extends IBaseDao<BlogEntity, Long> {
	/**
	 * Bean name;
	 */
	String BEAN_NAME = IBlogEntityDaoService.class.getName();

	/**
	 * save new entity to specified user
	 * 
	 * @param user
	 *            user
	 * @param entity
	 *            entity to be saved;
	 */
	void saveNewEntity(final BlogUser user, final BlogEntity entity);

	/**
	 * get user's temporery entity.
	 * 
	 * @param user
	 *            current user
	 * @return entity list;
	 */
	List<Object[]> getTempEntity(final BlogUser user);

	/**
	 * update the entity title,content,isTemp,saveTime,visible,commentable
	 * 
	 * @param entity
	 */
	void updateEntityByHQL(final BlogEntity entity);
}
