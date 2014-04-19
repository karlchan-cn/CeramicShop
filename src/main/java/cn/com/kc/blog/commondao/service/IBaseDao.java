/**
 * 
 */
package cn.com.kc.blog.commondao.service;

import java.io.Serializable;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;

/**
 * @author chenjinlong2
 * 
 */
public interface IBaseDao<M extends Serializable, PK extends Serializable> {
Serializable save(M model);

void delete(M model);

void update(M model);

M get(PK pk);

/**
 * 
 * @param queryString
 * @param isUnique
 * @param parameter
 * @return
 */
Long getTotalEntityNumberBySQL(final String queryString, final Boolean isUnique, final Object... parameter);

/**
 * query paged entity data by HQL
 * 
 * @param pageRequest
 *            page request
 * @param queryHQL
 *            hql
 * @param totalNumberHQL
 * @param parameters
 * @return
 */
Page<M> getPagedEntityListByHQL(final PageRequest pageRequest, final String queryHQL,
				final Long totalNumber, final Object... parameters);

/**
 * get page value,contained by list of entity(if your hql query's syntax likes
 * this:from Type type, the content would be list of object.else if just
 * requesting specified properties,it returns list of array)So the dao class
 * extending BaseDaoImpl has to override this method to change the content
 * property of page into list containing actual kind of entity.
 * 
 * @param pageRequest
 *            page request contain page number and page size from client
 * @param parameters
 *            hql parameters
 * @return page object.
 */
public Page<M> getBasePagedEntityData(final PageRequest pageRequest, final Object... parameters);

}
