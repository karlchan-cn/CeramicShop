/**
 * 
 */
package cn.com.kc.blog.common.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.type.descriptor.sql.CharTypeDescriptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.kc.blog.pojo.BlogUser;

/**
 * @author chenjinlong2
 * 
 */
public class CommonUtils {
/**
 * private constructor.
 */
private CommonUtils() {

}

private static final Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

/**
 * get Md5PasswordEncoder
 * 
 * @return
 */
public static Md5PasswordEncoder getMd5PasswordEncoder() {
	return md5PasswordEncoder;
}

/**
 * encode password with the specified salt.
 * 
 * @param rawPassword
 *            raw password
 * @param salt
 *            salt
 * @return encoded password
 */
public static String ecodePasswordBySalt(final String rawPassword, final Object salt) {
	return md5PasswordEncoder.encodePassword(rawPassword, salt);
}

/**
 * 获取request.
 * 
 * @return HttpServletRequest.
 */
public static HttpServletRequest getRequest() {
	return ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
}

/**
 * return the specified ContentType SpringFramework HttpHenaders according to
 * the param contentType
 * 
 * @param contentType
 *            content Type
 * @return HttpHeaders
 */
private static final List<Charset> CHARSET_UTF8 = new ArrayList<Charset>();
static {
	CHARSET_UTF8.add(Charset.forName("UTF-8"));
}

public static HttpHeaders getHttpHeadersByType(String contentType) {
	HttpHeaders responseHeaders = new HttpHeaders();
	if (StringUtils.isBlank(contentType)) {
		contentType = "text/plain";
	}
	String[] ctypeArray = contentType.split("/");
	responseHeaders.setContentType(new MediaType(ctypeArray[0], ctypeArray[1], Charset.forName("UTF-8")));
	responseHeaders.setExpires(0);
	responseHeaders.setCacheControl("no-store");
	responseHeaders.setPragma("no-store");
	return responseHeaders;
}

/**
 * get current user. if
 * 
 * @return
 */
public static BlogUser getCurrentUser() {
	BlogUser user = null;
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	if (principal instanceof UserDetails) {
		String username = ((UserDetails) principal).getUsername();
	} else {
		String username = principal.toString();
	}
	return user;
}
}
