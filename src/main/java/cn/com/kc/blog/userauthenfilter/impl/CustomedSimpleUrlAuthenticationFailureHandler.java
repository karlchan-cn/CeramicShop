/**
 * 
 */
package cn.com.kc.blog.userauthenfilter.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import cn.com.kc.blog.common.util.CommonUtils;

/**
 * @author kchen1
 * 
 */
public class CustomedSimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

@Override
public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
	CommonUtils.getRequest().getSession().removeAttribute(CustomedAuthenticateConst.CONST_BLOG_USER_ATTRIBUTE);
	super.onAuthenticationFailure(request, response, exception);
}

}
