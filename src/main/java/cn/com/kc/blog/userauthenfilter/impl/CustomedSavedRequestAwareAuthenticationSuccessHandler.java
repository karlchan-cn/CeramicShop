/**
 * 
 */
package cn.com.kc.blog.userauthenfilter.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @author kchen1
 *
 */
public class CustomedSavedRequestAwareAuthenticationSuccessHandler extends
				SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
