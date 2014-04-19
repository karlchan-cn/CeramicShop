/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.kc.blog.bl.service.IBlogImageService;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.dao.service.IBlogImageDaoService;
import cn.com.kc.blog.pojo.BlogImage;

/**
 * @author chenjinlong2
 * 
 */
@Service(value = "cn.com.kc.blog.bl.service.IBlogImageService")
public class BlogImageServiceImpl implements IBlogImageService {

/*
 * (non-Javadoc)
 * 
 * @see cn.com.kc.blog.bl.service.IBlogImageService#saveImage(cn.com.kc.blog.
 * pojo.BlogImage)
 */
@Resource(name = "cn.com.kc.blog.dao.service.IBlogImageDaoService")
private IBlogImageDaoService dao;

public IBlogImageDaoService getDao() {
	return dao;
}

public void setDao(IBlogImageDaoService dao) {
	this.dao = dao;
}

public BlogImage saveImage(BlogImage image) {
	this.dao.save(image);
	return image;
}

public void delImage(Long imageId) {
	final BlogImage blogImage = new BlogImage();
	blogImage.setId(imageId);
	getDao().delete(blogImage);
}

@Override
public Page<BlogImage> getPaginatedImages(final PageRequest pageRequest) {
	return dao.getPaginatedImagesData(pageRequest, new Object[] {});
}

}
