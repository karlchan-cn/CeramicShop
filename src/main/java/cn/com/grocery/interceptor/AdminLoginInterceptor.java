/**
 * 
 */
package cn.com.grocery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author karl
 *
 */
public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserSessionManager userSessionManager;
	private static final String CONST_USER_ID_KEY = "user_id";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Long userId = NumberUtils.toLong(String.valueOf(session.getAttribute(CONST_USER_ID_KEY)));
		// if (userId > 0l && userSessionManager.getAdminUser(userId) != null) {
		if (userId > 0l) {
			return true;
		} else {
			// return true;
			// forward to signin page
			response.sendRedirect("/admin/signin?redirect=" + request.getRequestURL());
			//request.getRequestDispatcher("/admin/signin").forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
