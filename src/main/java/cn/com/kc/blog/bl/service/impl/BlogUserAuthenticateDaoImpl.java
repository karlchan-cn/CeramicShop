/**
 * 
 */
package cn.com.kc.blog.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author kchen1
 * 
 */
@Component(value = "cn.com.kc.blog.bl.service.impl.BlogUserAuthenticateDaoImpl")
public class BlogUserAuthenticateDaoImpl implements AuthenticationProvider {

/*
 * (non-Javadoc)
 * 
 * @see
 * org.springframework.security.authentication.AuthenticationProvider#authenticate
 * (org.springframework.security.core.Authentication)
 */
@Override
public Authentication authenticate(Authentication arg0) throws AuthenticationException {
	// TODO Auto-generated method stub
	SecurityContextHolder.getContext();
	
	GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	authorities.add(authority);
	Authentication authentication = new UsernamePasswordAuthenticationToken(arg0.getName(), arg0.getPrincipal(),
					authorities);
	return authentication;
}

/*
 * (non-Javadoc)
 * 
 * @see
 * org.springframework.security.authentication.AuthenticationProvider#supports
 * (java.lang.Class)
 */
@Override
public boolean supports(Class<?> arg0) {
	// TODO Auto-generated method stub
	return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(arg0));
	// return false;
}

}
