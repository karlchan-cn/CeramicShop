/**
 * 
 */
package cn.com.kc.blog.dao.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.kc.blog.common.util.DataTableUtility;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;
import cn.com.kc.blog.commondao.service.impl.BaseDaoImpl;
import cn.com.kc.blog.dao.service.IBlogImageDaoService;
import cn.com.kc.blog.pojo.BlogEntity;
import cn.com.kc.blog.pojo.BlogImage;
import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
@Repository(value = "cn.com.kc.blog.dao.service.IBlogImageDaoService")
public class BlogImageDaoImpl extends BaseDaoImpl<BlogImage, Long> implements
				IBlogImageDaoService {

public static final String CONST_HQL_GET_ALL_IMAGE_COUNT = " select count(image.id) from BlogImage image";
public static final String CONST_HQL_GET_LISTEDIMAGE_INFO = " select image.id,image.name,image.position,image.createDate,image.description,"
															+ "image.state,image.replacement from BlogImage image";
/**
 * STRING CONSTANCE-image dot.
 */
private static final String CONST_IMAGE_DOT = "image.";
/**
 * STRING CONSTANCE-ORDER BY;
 */
private static final String CONST_ORDER_BU = " order by ";
/**
 * STRING CONSTANCE-SPACE;
 */
private static final String CONST_SPACE = " ";
/**
 * STRING CONSTANCE-COMMA;
 */
private static final String CONST_COMMA = ",";

@Override
public String getBaseTotalQueryHQL() {
	return CONST_HQL_GET_ALL_IMAGE_COUNT;
}

@Override
public String getBasetoalListQueryHQL(final List<String> filterColumn, final List<String>  sortColumns) {
	int length;
	StringBuffer hqlSB = new StringBuffer();
	hqlSB.append(CONST_HQL_GET_LISTEDIMAGE_INFO);
	if ((length = sortColumns.size()) > 0) {
		hqlSB.append(CONST_ORDER_BU);
		String[] sortStrs;
		for(int i = 0; i < length;i++){
			sortStrs = sortColumns.get(i).split(DataTableUtility.CONST_PARANAME_SEPERATOR_AT);
			hqlSB.append(CONST_IMAGE_DOT).append(sortStrs[0]).append(CONST_SPACE).append(sortStrs[1]).append(CONST_COMMA);
		}
		hqlSB.deleteCharAt(hqlSB.length()-1);
	}
	return hqlSB.toString();
}

@Override
public Page<BlogImage> getPaginatedImagesData(PageRequest pageRequest, Object... parameters) {
	final Page<BlogImage> page = super.getBasePagedEntityData(pageRequest,
					parameters);
	final List<?> content = page.getContent();
	List<BlogImage> entitiesList = new ArrayList<BlogImage>();
	BlogImage image = null;
	for (Iterator<?> iterator = content.iterator(); iterator.hasNext();) {
		Object[] value = (Object[]) iterator.next();
		image = new BlogImage();
		image.setId((Long) value[0]);
		image.setName((String) value[1]);
		image.setPosition((String) value[2]);
		image.setCreateDate((Timestamp) value[3]);
		// image.setShowName((String) value[4]);
		image.setDescription((String) value[4]);
		image.setState((String) value[5]);
		image.setReplacement((String) value[6]);
		entitiesList.add(image);
	}
	page.setContent(entitiesList);
	return page;
}

}
