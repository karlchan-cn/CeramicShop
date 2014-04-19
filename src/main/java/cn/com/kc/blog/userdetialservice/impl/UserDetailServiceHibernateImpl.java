/**
 * 
 */
package cn.com.kc.blog.userdetialservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.sql.DataSource;

import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Component;

import cn.com.kc.blog.bl.service.IBlogUserService;
import cn.com.kc.blog.common.util.BlogMessageSourceHelper;
import cn.com.kc.blog.common.util.CommonUtils;
import cn.com.kc.blog.pojo.BlogAuthorities;
import cn.com.kc.blog.pojo.BlogUser;
import cn.com.kc.blog.userauthenfilter.impl.CustomedAuthenticateConst;
import cn.com.kc.blog.vo.BlogAuthoritiesVO;
import cn.com.kc.blog.vo.BlogUserVO;

/**
 * @author kchen1
 * 
 */
@Component(value = "cn.com.kc.blog.userdetialservice.impl.UserDetailServiceHibernateImpl")
public class UserDetailServiceHibernateImpl implements UserDetailsService {
/**
 * 
 */
@Resource(name = "cn.com.kc.blog.common.util.BlogMessageSourceHelper")
protected BlogMessageSourceHelper blogMessageSourceHelper;

/** Logger available to subclasses */
protected final Log logger = LogFactory.getLog(getClass());
/**
 * 
 */
private IBlogUserService userService;

public IBlogUserService getUserService() {
	return userService;
}

@Resource(name = "cn.com.kc.blog.bl.service.IBlogUserService")
public void setUserService(final IBlogUserService newUserService) {
	this.userService = newUserService;
}

/*
 * (non-Javadoc)
 * 
 * @see org.springframework.security.core.userdetails.UserDetailsService#
 * loadUserByUsername(java.lang.String)
 */
@Override
public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	final BlogUser user = userService.getUserByUsername(username);
	if (user == null) {
		throw new AuthenticationServiceException(
						blogMessageSourceHelper.getAccessor().getMessage(
										"AbstractUserDetailsAuthenticationProvider.usernamenonexist"));
	}
	// save current user for use.
	final List<BlogAuthorities> authorities = user.getAuthorities();
	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	for (BlogAuthorities authority : authorities) {
		grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
	}
	CommonUtils.getRequest().getSession().setAttribute(CustomedAuthenticateConst.CONST_BLOG_USER_ATTRIBUTE, user);
	return new User(user.getUserName(), user.getPassword(), user.getEnabled(),
					true, true, true, grantedAuthorities);
}
}
