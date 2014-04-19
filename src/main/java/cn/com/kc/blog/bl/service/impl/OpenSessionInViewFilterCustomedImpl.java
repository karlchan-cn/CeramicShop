/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

/**
 * @author kchen1
 * 
 */
public class OpenSessionInViewFilterCustomedImpl extends OpenSessionInViewFilter {
/**
 * 须要过滤掉的url设定变量
 */
private static final String EXCLUDE_SUFFIXS_NAME = "excludeSuffixs";
private static final String[] DEFAULT_UN_FILTERED_TYPES = { ".css", ".js", ".jpg", ".jpeg", ".gif", ".ico", ".eot", ".svg", ".ttf", ".woff" };
/**
 * 须要过滤掉的url设定变量数组
 */
private static String[] excludeSuffixs = null;

@Override
protected void initFilterBean() throws ServletException {
	final String excludeEndfixStr = getFilterConfig().getInitParameter(EXCLUDE_SUFFIXS_NAME);
	if (StringUtils.isNotBlank(excludeEndfixStr)) {
		excludeSuffixs = excludeEndfixStr.split(",");
		for (int i = 0; i < excludeSuffixs.length; i++) {
			excludeSuffixs[i] = "." + excludeSuffixs[i];
		}
	} else {
		excludeSuffixs = DEFAULT_UN_FILTERED_TYPES;
	}
}

@Override
protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	String path = request.getServletPath();
	for (String endfix : excludeSuffixs) {
		if (path.endsWith(endfix))
			return true;
	}
	return super.shouldNotFilter(request);
}

}
