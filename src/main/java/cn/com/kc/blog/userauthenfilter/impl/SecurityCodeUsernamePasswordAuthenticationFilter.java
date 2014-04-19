/**
 * 
 */
package cn.com.kc.blog.userauthenfilter.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.octo.captcha.service.CaptchaService;

/**
 * @author kchen1
 * 
 */
public class SecurityCodeUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
private boolean postOnly = true;
private static final String SUCURITYCODE_VALUE = "securitycode";
private CaptchaService captchaService;

/**
 * 
 * @param captchaService
 */
@Resource(name = "jcaptchaService")
public void setCaptchaService(CaptchaService captchaService) {
	this.captchaService = captchaService;
}

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
	throws AuthenticationException {
	// get seesion id as to validate

	
	final String captchaId = request.getSession().getId();
	final String respSecurityCode = request.getParameter(SUCURITYCODE_VALUE);
	Boolean isSCodeCorrent = Boolean.FALSE;
	isSCodeCorrent = captchaService.validateResponseForID(captchaId, respSecurityCode);
	//validate Security code.
	if (!isSCodeCorrent) {
		throw new AuthenticationServiceException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.invaliatedsecuritycode"));
	}
	if (postOnly && !request.getMethod().equals("POST")) {
		throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
	}

	String username = obtainUsername(request);
	String password = obtainPassword(request);

	if (username == null) {
		username = "";
	}

	if (password == null) {
		password = "";
	}

	username = username.trim();

	UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

	// Allow subclasses to set the "details" property
	setDetails(request, authRequest);

	return this.getAuthenticationManager().authenticate(authRequest);
}

}
