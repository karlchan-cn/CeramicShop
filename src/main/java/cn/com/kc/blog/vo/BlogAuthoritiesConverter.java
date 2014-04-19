package cn.com.kc.blog.vo;

import cn.com.kc.blog.pojo.BlogAuthorities;

public class BlogAuthoritiesConverter implements ConverterService<BlogAuthorities, BlogAuthoritiesVO> {

@Override
public void convertPoToVo(BlogAuthorities po, BlogAuthoritiesVO vo) {
	vo.setId(po.getId());
	vo.setAuthority(po.getAuthority());

}

@Override
public void convertVoToPo(BlogAuthorities po, BlogAuthoritiesVO vo) {
	// TODO Auto-generated method stub

}

}
