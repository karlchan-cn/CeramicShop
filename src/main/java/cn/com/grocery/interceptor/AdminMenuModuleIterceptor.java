/**
 * 
 */
package cn.com.grocery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author karl
 *
 */
public class AdminMenuModuleIterceptor extends HandlerInterceptorAdapter {
	/**
	 * 
	 */
	private static final Logger ILOG = LoggerFactory.getLogger(AdminMenuModuleIterceptor.class);
	/**
	 * 
	 */
	private static final String CONST_REQ_PARAM_ADMIN_MENU_MODULE = "admin_request_menu_module";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String moduleName = "default";
		if (uri.indexOf("admin/console/user") > 0) {
			moduleName = "user";
		}
		request.setAttribute(CONST_REQ_PARAM_ADMIN_MENU_MODULE, moduleName);
		return super.preHandle(request, response, handler);
	}

}
