/**
 * 
 */
package cn.com.kc.blog.vo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resources;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import cn.com.kc.blog.pojo.BlogAuthorities;
import cn.com.kc.blog.pojo.BlogComments;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author kchen1
 * 
 */
@Service(value = "cn.com.kc.blog.vo.BlogUserConverter")
public class BlogUserConverter implements ConverterService<BlogUser, BlogUserVO> {

@Override
public void convertPoToVo(BlogUser po, BlogUserVO vo) {
	try {
		BeanUtils.copyProperties(vo, po);
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	// this.shallowConverPoToVo(po, vo);
	// Set<BlogComments> comments = po.getComments();
	// Set<BlogEntity> entities = po.getEntities();
	// List<BlogAuthorities> authorities = po.getAuthorities();
}

/**
 * 
 */
public void shallowConverPoToVo(BlogUser po, BlogUserVO vo) {
	po.setId(vo.getId());
	po.setAddress(vo.getAddress());
	po.setCreateTime(vo.getCreateTime());
	po.setEmail(vo.getEmail());
	po.setEnabled(vo.getEnabled());
	po.setPassword(vo.getPassword());
	po.setPhoneNumber(vo.getPhoneNumber());
	po.setShowName(vo.getShowName());
	po.setUserName(vo.getUserName());
	po.setValidateCode(vo.getValidateCode());
}

/**
 * 
 */
public void shallowConverVOToPo(BlogUser po, BlogUserVO vo) {
	vo.setId(po.getId());
	vo.setAddress(po.getAddress());
	vo.setCreateTime(po.getCreateTime());
	vo.setEmail(po.getEmail());
	vo.setEnabled(po.getEnabled());
	vo.setPassword(po.getPassword());
	vo.setPhoneNumber(po.getPhoneNumber());
	vo.setShowName(po.getShowName());
	vo.setUserName(po.getUserName());
	vo.setValidateCode(po.getValidateCode());
}

@Override
public void convertVoToPo(BlogUser po, BlogUserVO vo) {
	// TODO Auto-generated method stub

}

}
