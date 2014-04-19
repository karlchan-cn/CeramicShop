/**
 * 
 */
package cn.com.kc.blog.bl.service;

import java.io.Serializable;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogEntityService {
/**
 * Bean name;
 */
String BEAN_NAME = IBlogEntityService.class.getName();

/**
 * 保存用户.
 * 
 * @param user
 *            用户.
 * @param entity
 *            日志
 * @return entity to be saved
 */
Serializable saveEntity(final BlogUser user, final BlogEntity entity);

/**
 * 获取缓存
 * 
 * @param userId
 * @return
 */
BlogEntity getTempEntity(final BlogUser user);

/**
 * update bolg entity
 * 
 * @param entity
 *            blog entity to be updated
 * @param user
 *            current log in upser
 */
void updateEntity(final BlogEntity entity, final BlogUser user);

/**
 * update the entity title,content,isTemp,saveTime,visible,commentable
 * 
 * @param entity
 */
void updatePublished(final BlogEntity entity);

/**
 * query the entity with id.
 * 
 * @param entityId
 *            entity to be queried.
 * 
 * @return entity.
 */
BlogEntity getEntityById(final Long entityId);
/**
 * query the entity and its images with id.
 * 
 * @param entityId
 *            entity to be queried.
 * 
 * @return entity.
 */
BlogEntity getEntityAndImagesById(final Long entityId);


/**
 * delete entity
 * 
 * @return consequence.
 */
boolean delEntity(final BlogEntity blogEntity);

/**
 * get data by parameter
 * 
 * @param pageRequest
 *            page request
 * @param parameters
 *            query parameters
 * @return data
 * 
 */
Page<BlogEntity> getBasePagedEntityDataByParam(final PageRequest pageRequest, final Object... parameters);

}
