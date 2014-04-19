/**
 * 
 */
package cn.com.kc.blog.dao.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.commondao.service.impl.BaseDaoImpl;
import cn.com.kc.blog.dao.service.IBlogEntityDaoService;
import cn.com.kc.blog.dao.service.IBlogUserDaoService;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
@Repository("cn.com.kc.blog.dao.service.IBlogEntityDaoService")
public class BlogEntityDaoImpl extends BaseDaoImpl<BlogEntity, Long> implements
		IBlogEntityDaoService {
	public static final String CONST_HQL_LOAD_TEMP_ENTITY = "select entity.id,entity.title,entity.content,entity.createdate,"
			+ " entity.readprivate,entity.commentable,image.id,image.name,image.description,image.position "
			+ " from BlogEntity entity left join entity.images as image "
			+ " where entity.isTemp = true and entity.user = ?";
	public static final String CONST_HQL_PUBLISH_ENTITY = "update BlogEntity e set e.title = :title,e.content = :content,"
			+ "e.createdate = :createdate,e.readprivate =:readprivate,"
			+ "e.commentable = :commentable,e.isTemp = :isTemp where e.id =:id";
	/**
 * 
 */
	public static final String CONST_HQL_GET_ALL_ENTITY_COUNT = " select count(entity.id) from BlogEntity entity";
	/**
 * 
 */
	public static final String CONST_HQL_GET_LISTEDENTITY_INFO = " select entity.title,entity.content,entity.createdate,"
			+ " user.id from BlogEntity entity inner join entity.user as user "
			+ " where user.id = ?";
	public static final String CONST_FIELD_ID = "id";
	public static final String CONST_FIELD_TITLE = "title";
	public static final String CONST_FIELD_CONTENT = "content";
	public static final String CONST_FIELD_CREATEDATE = "createdate";
	public static final String CONST_FIELD_READPRIVATE = "readprivate";
	public static final String CONST_FIELD_COMMENTABLE = "commentable";
	public static final String CONST_FIELD_ISTEMP = "isTemp";

	private IBlogUserDaoService userDao;

	@Resource(name = "cn.com.kc.blog.dao.service.IBlogUserDaoService")
	public void setUserDao(final IBlogUserDaoService newDao) {
		this.userDao = newDao;
	}

	public void saveNewEntity(final BlogUser user, final BlogEntity entity) {
		entity.setUser(user);
		this.save(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getTempEntity(final BlogUser user) {
		final Session session = getCurrentSession();
		final Query query = session.createQuery(CONST_HQL_LOAD_TEMP_ENTITY);
		query.setEntity(0, user);
		List<Object[]> list = query.list();
		return list;
	}

	@Override
	public void updateEntityByHQL(final BlogEntity entity) {
		getCurrentSession().createQuery(CONST_HQL_PUBLISH_ENTITY)
				.setLong(CONST_FIELD_ID, entity.getId())
				.setString(CONST_FIELD_TITLE, entity.getTitle())
				.setString(CONST_FIELD_CONTENT, entity.getContent())
				.setString(CONST_FIELD_READPRIVATE, entity.getReadprivate())
				.setTimestamp(CONST_FIELD_CREATEDATE, entity.getCreatedate())
				.setBoolean(CONST_FIELD_COMMENTABLE, entity.getCommentable())
				.setBoolean(CONST_FIELD_ISTEMP, entity.getIsTemp())
				.executeUpdate();

	}

	@Override
	public Page<BlogEntity> getBasePagedEntityData(PageRequest pageRequest,
			Object... parameters) {
		Page<BlogEntity> page = super.getBasePagedEntityData(pageRequest,
				parameters);
		final List<?> content = page.getContent();
		List<BlogEntity> entitiesList = new ArrayList<BlogEntity>();
		BlogEntity entity = null;
		BlogUser user = null;
		for (Iterator<?> iterator = content.iterator(); iterator.hasNext();) {
			Object[] value = (Object[]) iterator.next();
			entity = new BlogEntity();
			user = new BlogUser();
			entity.setTitle(String.valueOf(value[0]));
			entity.setContent(String.valueOf(value[1]));
			entity.setCreatedate((Timestamp) value[2]);
			user.setId((Long) value[3]);
			entitiesList.add(entity);
			entity.setUser(user);
		}
		page.setContent(entitiesList);
		return page;
	}

	@Override
	public String getBaseTotalQueryHQL() {
		return CONST_HQL_GET_ALL_ENTITY_COUNT;
	}

	@Override
	public String getBasetoalListQueryHQL() {
		return CONST_HQL_GET_LISTEDENTITY_INFO;
	}

	@Override
	public String getBasetoalListQueryHQL(List<String> filterColumn,
			List<String> sortColumns) {
		// TODO Auto-generated method stub
		return null;
	}

}
