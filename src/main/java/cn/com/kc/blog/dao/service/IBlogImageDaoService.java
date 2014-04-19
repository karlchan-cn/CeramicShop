/**
 * 
 */
package cn.com.kc.blog.dao.service;

import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.commondao.service.IBaseDao;
import cn.com.kc.blog.pojo.BlogImage;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogImageDaoService extends IBaseDao<BlogImage, Long> {
/**
 * Bean name;
 */
String BEAN_NAME = IBlogImageDaoService.class.getName();

Page<BlogImage> getPaginatedImagesData(final PageRequest pageRequest, final Object... parameters);
}
