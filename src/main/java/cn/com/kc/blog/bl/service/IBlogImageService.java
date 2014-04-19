/**
 * 
 */
package cn.com.kc.blog.bl.service;

import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.pojo.BlogImage;

/**
 * @author chenjinlong2
 * 
 */
public interface IBlogImageService {
/**
 * Bean name;
 */
String BEAN_NAME = IBlogImageService.class.getName();

BlogImage saveImage(BlogImage image);

void delImage(final Long imageId);

Page<BlogImage> getPaginatedImages(final PageRequest pageRequest);
}
