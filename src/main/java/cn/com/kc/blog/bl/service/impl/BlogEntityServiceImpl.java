/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.kc.blog.bl.service.IBlogEntityService;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.dao.service.IBlogEntityDaoService;
import cn.com.kc.blog.dao.service.IBlogUserDaoService;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogImage;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
@Service("cn.com.kc.blog.bl.service.IBlogEntityService")
public class BlogEntityServiceImpl implements IBlogEntityService {
	/**
	 * 
	 */
	private IBlogEntityDaoService entityDao;
	/**
	 * 
	 */
	private IBlogUserDaoService userDao;

	@Resource(name = "cn.com.kc.blog.dao.service.IBlogUserDaoService")
	public void setUserDao(IBlogUserDaoService userDao) {
		this.userDao = userDao;
	}

	@Resource(name = "cn.com.kc.blog.dao.service.IBlogEntityDaoService")
	public void setEntityDao(final IBlogEntityDaoService newDAO) {
		this.entityDao = newDAO;
	}

	public Serializable saveEntity(final BlogUser user, final BlogEntity entity) {
		entity.setUser(user);
		entityDao.save(entity);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public BlogEntity getTempEntity(BlogUser user) {
		final List<Object[]> list = this.entityDao.getTempEntity(user);
		BlogEntity entity;
		entity = new BlogEntity();
		if (list.size() != 0) {
			Object[] firstRow = (Object[]) list.get(0);
			entity.setId((Long) firstRow[0]);
			entity.setTitle((String) firstRow[1]);
			entity.setContent((String) firstRow[2]);
			entity.setCreatedate((Timestamp) firstRow[3]);
			entity.setReadprivate((String) firstRow[4]);
			entity.setCommentable((Boolean) firstRow[5]);
			entity.setIsTemp(true);
			List<BlogImage> imageList = new ArrayList<BlogImage>();
			entity.setImages(imageList);
			for (Iterator<Object[]> iterator = list.iterator(); iterator
					.hasNext();) {
				Object[] objects = iterator.next();
				if ((Long) objects[6] != null) {
					BlogImage image = new BlogImage();
					image.setId((Long) objects[6]);
					image.setName((String) objects[7]);
					image.setDescription((String) objects[8]);
					image.setPosition((String) objects[9]);
					imageList.add(image);
					image.setEntity(entity);
				}
			}
		}
		return entity;
	}

	@Override
	public void updateEntity(BlogEntity entity, BlogUser user) {
		entityDao.updateEntityByHQL(entity);
		System.out.println("");
	}

	@Override
	public void updatePublished(final BlogEntity entity) {
		entityDao.updateEntityByHQL(entity);
	}

	@Override
	public BlogEntity getEntityById(final Long entityId) {
		return entityDao.get(entityId);
	}

	@Override
	public boolean delEntity(BlogEntity blogEntity) {
		entityDao.delete(blogEntity);
		return true;
	}

	@Override
	public Page<BlogEntity> getBasePagedEntityDataByParam(
			PageRequest pageRequest, Object... parameters) {
		return entityDao.getBasePagedEntityData(pageRequest, parameters);
	}

	@Override
	public BlogEntity getEntityAndImagesById(final Long entityId) {
		final BlogEntity entity = getEntityById(entityId);
		entity.getImages();
		return entity;
	}
}
