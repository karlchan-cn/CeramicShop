/**
 * 
 */
package test.cn.com.kc.blog.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @author kchen1
 * 
 */
public class SpringUtilFunctionsTester {
@Test
public void testMD5Ecoder() {
	Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	final String password = "passowrd";
	final String salt = "username";
	final String encPass = encoder.encodePassword(password, salt);
	Assert.assertTrue(encoder.isPasswordValid(encPass, password, salt));
}
}
