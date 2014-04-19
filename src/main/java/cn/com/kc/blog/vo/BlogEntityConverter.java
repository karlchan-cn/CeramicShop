package cn.com.kc.blog.vo;

import cn.com.kc.blog.pojo.BlogEntity;

public class BlogEntityConverter implements ConverterService<BlogEntity, BlogEntityVO> {

@Override
public void convertPoToVo(BlogEntity po, BlogEntityVO vo) {
	
	vo.setId(po.getId());
	vo.setTitle(po.getTitle());
	vo.setContent(po.getContent());
	//vo.setUser(po.getUser());
	vo.setCreatedate(po.getCreatedate());
	//vo.setImages(po.getImages());

}

@Override
public void convertVoToPo(BlogEntity po, BlogEntityVO vo) {
	// TODO Auto-generated method stub

}

}
