package cn.com.grocery.dao.impl.mysql;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.grocery.common.Pager;

/**
 * 
 * @Title: BaseDao.java
 * @Package tdxy.dao
 * @Description: (baseDao 数据库操作实现类)
 * @author dapeng
 * @date 2014年5月7日 下午5:09:22
 * @version V1.0
 */
@Repository
public class BaseDao {

	/**
	 * Logger
	 */
	private static Logger ILOG = LoggerFactory.getLogger(BaseDao.class);

	/**
	 * Autowired 自动装配 相当于get() set()
	 */
	@Autowired
	@Qualifier(value = "hibernateSessionFactory")
	protected SessionFactory sessionFactory;

	/**
	 * gerCurrentSession 会自动关闭session，使用的是当前的session事务
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * openSession 需要手动关闭session 意思是打开一个新的session
	 * 
	 * @return
	 */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * 根据 id 查询信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object load(Class c, String id) {
		Session session = getSession();
		return session.get(c, id);
	}

	/**
	 * 获取所有信息
	 * 
	 * @param c
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public List getAllList(Class c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();
	}

	/**
	 * 分页查询
	 * 
	 * @param pager
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getListWithPager(Pager pager, Map<String, Object> params) {
		Session session = null;
		List<?> result = null;
		try {
			session = getSession();
			String hql = pager.getHql();// 获取查询语句
			Query query = session.createQuery(hql).setCacheable(true);
			// 设置参数
			query.setProperties(params);
			// 查询具体数据
			int count = query.list().size();
			pager.setCount(count);
			// 设置首页
			if (pager.getIndex() < 1) {
				pager.setIndex(1);
			}
			// 指定从那个对象开始查询，参数的索引位置是从0开始的，
			query.setFirstResult((pager.getIndex() - 1) * pager.getPageSize());
			// 分页时，一次最多产寻的对象数
			query.setMaxResults(pager.getPageCount());
			result = query.list();

		} catch (Exception e) {
			ILOG.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * 获取总数量
	 * 
	 * @param c
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getTotalCount(Class c, Map<String, Object> params, String hqlFilter) {
		Integer count = null;
		try {
			Session session = getSession();
			String hql = "select count(*) from " + c.getName()
					+ StringUtils.defaultString(hqlFilter, StringUtils.EMPTY);
			count = Integer.valueOf(session.createQuery(hql).setProperties(params).uniqueResult().toString());
		} catch (Exception e) {
			ILOG.error("error" + e.getMessage(), e);
		}

		return count != null ? count.intValue() : 0;
	}

	/**
	 * 保存
	 * 
	 * @param bean
	 * 
	 */
	public Serializable save(Object bean) {
		Session session = getSession();
		try {
			return session.save(bean);
			// session.flush();
		} finally {
			// if (session != null) {
			// session.clear();
			// session.close();
			// }
		}
	}

	/**
	 * 更新
	 * 
	 * @param bean
	 * 
	 */
	public void update(Object bean) {
		Session session = getNewSession();
		session.update(bean);
		session.flush();
		session.clear();
		session.close();
	}

	/**
	 * 删除
	 * 
	 * @param bean
	 * 
	 */
	public void delete(Object bean) {
		Session session = getSession();
		session.delete(bean);
		// session.flush();
		// session.clear();
		// session.close();
	}

	/**
	 * 根据ID删除
	 * 
	 * @param c
	 *            类
	 * 
	 * @param id
	 *            ID
	 * 
	 */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String id) {
		Session session = getSession();
		Object obj = session.get(c, id);
		// session.delete(obj);
		// flush();
		// clear();
	}

	/**
	 * 批量删除
	 * 
	 * @param c
	 *            类
	 * 
	 * @param ids
	 *            ID 集合
	 * 
	 */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String[] ids) {
		for (String id : ids) {
			Object obj = getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

}